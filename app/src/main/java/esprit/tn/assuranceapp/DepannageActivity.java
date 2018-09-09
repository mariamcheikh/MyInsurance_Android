package esprit.tn.assuranceapp;

import android.*;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;



public class DepannageActivity extends Fragment {

    Button btnDpng;
    EditText txtPanne;
    TextView erreur;
    String link;
    StringRequest stringRequest;
    RequestQueue requestQueue;
    ProgressDialog progressDialog;
    String token, adminToken;
    String ncin;
    View v;
    Context cxt;
    String longitude, latitude;
    static final int REQUEST_LOCATION = 1;
    LocationManager locationManager;
    //private FusedLocationProviderClient mFusedLocationClient;




    void getLocation() {
        if( ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(getActivity(), new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);

        } else {
            Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

            if (location != null){
                double latti = location.getLatitude();
                double longi = location.getLongitude();
                String lattiString = String.valueOf(latti);
                String longiString = String.valueOf(longi);
                longitude=longiString;
                latitude=lattiString;
                Toast.makeText(getContext(),"longituuude="+longitude,Toast.LENGTH_LONG).show();
            }
        }

    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case REQUEST_LOCATION:
                getLocation();
                break;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_depannage, container, false);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //FirebaseApp.initializeApp(getActivity());
        cxt = getActivity().getApplicationContext();


        v = getView();
        erreur = new TextView(cxt);
        progressDialog = new ProgressDialog(cxt);
        txtPanne = new EditText(cxt);
        txtPanne.setHeight(300);
        txtPanne.setTextColor(Color.BLACK);

        longitude = "";
        latitude = "";
        //getLocation();
        btnDpng=(Button)v.findViewById(R.id.btnDpng);
        btnDpng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ncin=SharedPrefManager.getInstance(cxt).getNcin();
                //ncin="07206840";
                token=FirebaseInstanceId.getInstance().getToken();
                String myUrl=Constants.URL+"registertoken.php?ncin="+ncin+"&tok="+token;
                String m="Token MAJ";
                requestSOS(myUrl,m);
                requestQueue = Volley.newRequestQueue(cxt);
                requestQueue.add(stringRequest);

                AlertDialog.Builder builder1 = new AlertDialog.Builder(getActivity());
                builder1.setMessage("Please describe your issue here:");
                builder1.setCancelable(true);
                builder1.setView(txtPanne);

                builder1.setPositiveButton(
                        "Valider",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                final String descr;
                                //progressDialog.setMessage("Affectation en cours ...");
                                //progressDialog.show();
                                try {
                                    descr = URLEncoder.encode(txtPanne.getText().toString(), "utf-8");
                                    link=Constants.URL+"addDepannage.php?descr1="+descr+"&longit=99.5214&latit=132.7541";
                                    String m="Successful request.";
                                    requestSOS(link,m);
                                    requestQueue = Volley.newRequestQueue(cxt);
                                    requestQueue.add(stringRequest);
                                    txtPanne.setText("");
                                    ((ViewGroup)txtPanne.getParent()).removeView(txtPanne);
                                    dialog.cancel();

                                    try {
                                        adminToken="";
                                        getAdminToken(Constants.URL_GET_ADMIN_TOKEN);
                                        requestQueue = Volley.newRequestQueue(cxt);
                                        requestQueue.add(stringRequest);
                                        adminToken=URLEncoder.encode(adminToken, "utf-8");
                                        //Toast.makeText(cxt,"admin token recupered222"+adminToken,Toast.LENGTH_LONG).show();
                                        String message="you have a new  request";
                                        message=URLEncoder.encode(message, "utf-8");
                                        String myUrl=Constants.URL+"sendpushnotification.php?mess="+message+"&tok="+adminToken;
                                        String m2="Notification sent";
                                        requestSOS(myUrl,m2);
                                        requestQueue = Volley.newRequestQueue(cxt);
                                        requestQueue.add(stringRequest);
                                        //progressDialog.dismiss();
                                    } catch (UnsupportedEncodingException e) {
                                        e.printStackTrace();
                                    }
                                    //progressDialog.dismiss();
                                } catch (UnsupportedEncodingException e) {
                                    e.printStackTrace();
                                }

                            }
                        });

                builder1.setNegativeButton(
                        "Annuler",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                ((ViewGroup)txtPanne.getParent()).removeView(txtPanne);
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();
            }
        });

    }

    void requestSOS(String url, String msg){
        stringRequest = new StringRequest(Request.Method.POST, url,
                response -> {
                    System.out.println(response);
                    Toast.makeText(cxt,""+msg,Toast.LENGTH_SHORT).show();
                },
                error -> {
                    Toast.makeText(cxt,"connection problem",Toast.LENGTH_LONG).show();
                    Log.e("Tag= ","connection error");
                })
        {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<>();
                return params;
            }
        };

    }

    void updateAdminToken(String url){
        stringRequest = new StringRequest(Request.Method.POST, url,
                response -> {
                    System.out.println(response);
                    //Toast.makeText(cxt,"admin maj",Toast.LENGTH_SHORT).show();
                },
                error -> {
                    Toast.makeText(cxt,error.toString(),Toast.LENGTH_LONG).show();
                    Log.e("Tag= ","connection error");
                })
        {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<>();
                return params;
            }
        };

    }

    void getAdminToken(String url){
        stringRequest = new StringRequest(Request.Method.GET, url,
                response -> {
                    System.out.println("admin tok= "+response.toString());
                    adminToken=response;
                    //Toast.makeText(cxt,"admin token recupered11"+response.toString(),Toast.LENGTH_LONG).show();
                },
                error -> {
                    Toast.makeText(cxt,error.toString(),Toast.LENGTH_LONG).show();
                    Log.e("Tag= ","connection error");
                })
        {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<>();
                return params;
            }
        };

    }

    public static DepannageActivity newInstance(String text) {

        Bundle args = new Bundle();
        args.putString("DepannageActivity", text);

        DepannageActivity fragment = new DepannageActivity();
        fragment.setArguments(args);
        return fragment;
    }

}
