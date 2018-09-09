package esprit.tn.assuranceapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.iid.FirebaseInstanceId;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AffecterDepannageActivity extends AppCompatActivity {

    TimePicker dureeValue;
    ListView listView;
    String link;
    StringRequest stringRequest;
    RequestQueue requestQueue;
    String ncin;
    String token;
    String adminToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affecter_depannage);

        adminToken="";
        adminToken = FirebaseInstanceId.getInstance().getToken();
        updateAdminToken(Constants.URL_ADMIN_TOKEN+"?tok="+adminToken);
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

        dureeValue =new TimePicker(this);
        dureeValue.setIs24HourView(true);

        List<User> users = new ArrayList<User>();
        users=getDrivers(Constants.URL_LISTDRIVERS,"Liste remplie");
        requestQueue = Volley.newRequestQueue(AffecterDepannageActivity.this);
        requestQueue.add(stringRequest);

        UserAdapter userAdapter=new UserAdapter(this,users);

        listView=(ListView)findViewById(R.id.listView);
        listView.setAdapter(userAdapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(AffecterDepannageActivity.this);
                builder1.setMessage("Please enter the arrival time:");
                builder1.setCancelable(true);
                builder1.setView(dureeValue);

                builder1.setPositiveButton(
                        "Affecter",
                        new DialogInterface.OnClickListener() {
                            @RequiresApi(api = Build.VERSION_CODES.M)
                            public void onClick(DialogInterface dialog, int id) {
                                ((ViewGroup) dureeValue.getParent()).removeView(dureeValue);
                                try {
                                    int hour = 0;
                                    int min = 0;

                                    int currentApiVersion = android.os.Build.VERSION.SDK_INT;
                                    if (currentApiVersion > android.os.Build.VERSION_CODES.LOLLIPOP_MR1){
                                        hour = dureeValue.getHour();
                                        min = dureeValue.getMinute();
                                    } else {
                                        hour = dureeValue.getCurrentHour();
                                        min = dureeValue.getCurrentMinute();
                                    }

                                    String duree = URLEncoder.encode(hour+" : "+min, "utf-8");
                                    //Toast.makeText(AffecterDepannageActivity.this,""+duree,Toast.LENGTH_LONG).show();
                                    link=Constants.URL+"affacterDepannage.php?duree="+duree+"&idch=23&idcl=32";
                                    requestTowing(link);
                                    requestQueue = Volley.newRequestQueue(AffecterDepannageActivity.this);
                                    requestQueue.add(stringRequest);

                                    try {
                                        String tok="fUh-4V4Ebp0:APA91bEBmztZYEi0mk7Yg9WwSYAXBg5a4o-01GO82RNwDqTNqSRU-0ozB-Quj91I1TnnJ528sa1sA2KlVFEIMZtM--Mc_oNAe5QZ0xhc3anmeJQLDJ8XwLDOKMZjHCnm4heJ59hA5MQs";
                                        tok=URLEncoder.encode(tok, "utf-8");
                                        String message="A towing is assigned to you. It will come in "+hour+":"+min+" minutes";
                                        message=URLEncoder.encode(message, "utf-8");
                                        String myUrl=Constants.URL+"sendpushnotification.php?mess="+message+"&tok="+tok;
                                        String m2="Notification sent";
                                        majToken(myUrl,m2);
                                        requestQueue = Volley.newRequestQueue(AffecterDepannageActivity.this);
                                        requestQueue.add(stringRequest);
                                    } catch (UnsupportedEncodingException e) {
                                        e.printStackTrace();
                                    }

                                } catch (UnsupportedEncodingException e) {
                                    e.printStackTrace();
                                }
                                dialog.cancel();
                            }
                        });

                builder1.setNegativeButton(
                        "Annuler",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                ((ViewGroup) dureeValue.getParent()).removeView(dureeValue);
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();

                return false;
            }
        });
    }

    void requestTowing(String url){
        stringRequest = new StringRequest(Request.Method.POST, url,
                response -> {
                    System.out.println(response);
                    Toast.makeText(AffecterDepannageActivity.this,"Driver assigned successfully.",Toast.LENGTH_LONG).show();
                },
                error -> {
                    Toast.makeText(AffecterDepannageActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                    Log.e("Tag= ","Connexion error");
                })
        {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<>();
                params.put("duree", "aaa");
                params.put("id1", "123");
                params.put("id2", "321");
                return params;
            }
        };

    }

    void majToken(String url, final String msg){
        stringRequest = new StringRequest(Request.Method.POST, url,
                response -> {
                    System.out.println(response);
                    Toast.makeText(AffecterDepannageActivity.this,""+msg,Toast.LENGTH_SHORT).show();
                },
                error -> {
                    Toast.makeText(AffecterDepannageActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                    Log.e("Tag= ","problème de connexion");
                })
        {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<>();
                params.put("descr1", "aaa");
                params.put("longit", "123");
                params.put("latit", "321");
                return params;
            }
        };

    }

    List<User> getDrivers(String url, final String msg){
        List<User> users=new ArrayList<User>();
        stringRequest = new StringRequest(Request.Method.GET, url,
                response -> {
                    try {
                        JSONObject obj = new JSONObject(response);
                        if (!obj.getBoolean("error")) {
                            JSONArray object = obj.getJSONArray("driver");
                            System.out.println("Driverssss ==>"+object.toString());
                            for(int i=0;i<object.length();i++){
                                String name=((JSONArray)(object.get(i))).getString(1);
                                String lname=((JSONArray)(object.get(i))).getString(2);
                                String phone=(((JSONArray)(object.get(i))).getString(3));
                                String mark=((JSONArray)(object.get(i))).getString(4);
                                String modele=((JSONArray)(object.get(i))).getString(5);
                                String number=((JSONArray)(object.get(i))).getString(6);
                                String ville=((JSONArray)(object.get(i))).getString(7);
                                User user=new User(name,mark,lname,phone,modele,number,ville);
                                //User user=new User(name,"kkk",lname,phone,"kkk","kkk","kkk");
                                users.add(user);
                                System.out.println("user "+i+" ="+user.toString());
                            }
                        } else {
                            // JSONObject object1 = obj.getJSONObject("message");
                            System.out.println("Non");
                            Toast.makeText(getApplicationContext(), "une erreur est survenue. Veuillez réessayer." + obj.getString("message"), Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(getApplicationContext(), "problème de connexion. Veuillez réessayer.", Toast.LENGTH_SHORT).show();
                    }
                },
                error -> {
                    Toast.makeText(AffecterDepannageActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                    Log.e("Tag= ","problème de connexion");
                })
        {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<>();
                params.put("descr1", "aaa");
                params.put("longit", "123");
                params.put("latit", "321");
                return params;
            }
        };
        return users;
    }

    void updateAdminToken(String url){
        stringRequest = new StringRequest(Request.Method.POST, url,
                response -> {
                    System.out.println(response);
                    Toast.makeText(this,"admin maj",Toast.LENGTH_SHORT).show();
                },
                error -> {
                    Toast.makeText(this,error.toString(),Toast.LENGTH_LONG).show();
                    Log.e("Tag= ","problème de connexion");
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

}
