package esprit.tn.assuranceapp.Fragments.Contrat;


import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.android.volley.request.StringRequest;
import com.android.volley.toolbox.Volley;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import esprit.tn.assuranceapp.Activities.Contrat.ContratActivity;
import esprit.tn.assuranceapp.Constants;
import esprit.tn.assuranceapp.R;
import esprit.tn.assuranceapp.UserAccueil;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContratPermisFragment extends Fragment {

    String ncin = "07204062";
    String DelivrancePermiss, PermisTxt2s, PermisTxt1s;
    EditText DelivrancePermis, PermisTxt2, PermisTxt1;
    Button bouttonPermis;
    private ProgressDialog progressDialog;
    DatePickerDialog.OnDateSetListener delivrerPermis;
    Calendar calendar = Calendar.getInstance();

    public ContratPermisFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contrat_permis, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        PermisTxt1 = view.findViewById(R.id.PermisTxt1);
        PermisTxt2 = view.findViewById(R.id.PermisTxt2);
        DelivrancePermis = view.findViewById(R.id.DelivrancePermis);
        bouttonPermis = view.findViewById(R.id.bouttonPermis);
        progressDialog = new ProgressDialog(getContext());
        bouttonPermis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DelivrancePermiss = DelivrancePermis.getText().toString();
                PermisTxt2s = PermisTxt2.getText().toString();
                PermisTxt1s = PermisTxt1.getText().toString();


                if (DelivrancePermis(DelivrancePermiss) && (validatPermisTxt2s(PermisTxt2s)) && (validatPermisTxt1s(PermisTxt1s))) {

                    registerInfo();


                }
           }
        });

        //  ((ContratActivity)getActivity()).replaceFragment(new ContratPermisFragment());


        DelivrancePermis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                DatePickerDialog dpDialog =   new DatePickerDialog(getActivity(), ContratPermisFragment.this.delivrerPermis, calendar
                        .get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH));
                DatePicker datePicker = dpDialog.getDatePicker();

                Calendar calendar = Calendar.getInstance();//get the current day
                datePicker.setMaxDate(calendar.getTimeInMillis());//set the current day as the max date
                dpDialog.show();
            }
        });


        delivrerPermis = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, monthOfYear);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                delivrerPermis();

            }
        };


    }


    private void registerInfo() {

        final String permis1 = PermisTxt1.getText().toString().replaceAll("'", "\\\\'").trim();
        final String permis2 = PermisTxt2.getText().toString().replaceAll("'", "\\\\'").trim();
        final String delivrerpermis = DelivrancePermis.getText().toString().trim();

        progressDialog.setMessage("Add Licence Information  ...");
        progressDialog.show();


        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.URL_CONTRAT_INSERT_PERMIS, response ->  {

                progressDialog.dismiss();
                Toast.makeText(getActivity(), " Licence Successfully Added", Toast.LENGTH_LONG).show();
                ((UserAccueil)getActivity()).replaceFragment(new ContratVehiculeFragment());
            //((UserAccueil)getActivity()).replaceFragment(new ContratVehiculeFragment());
                //((ContratActivity) getActivity()).replaceFragment();


        },
                error ->
                { progressDialog.hide();
                    Toast.makeText(getActivity(), error.toString(), Toast.LENGTH_LONG).show();}) {
            @Override
            protected Map<String, String> getParams() {
                // Creating Map String Params.
                Map<String, String> params = new HashMap<String, String>();
                params.put("ncin", UserAccueil.CONNECTED_USER_CIN);
               // params.put("ncin", ncin);
                params.put("datep", delivrerpermis);
                String permis = permis1 + permis2;
                params.put("num", permis);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);

    }

    private void delivrerPermis() {
        String myFormat = "MM/dd/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat);
        DelivrancePermis.setText(sdf.format(calendar.getTime()));
    }


    private boolean validatPermisTxt2s(String string) {
        if (string.equals("")) {
            Toast.makeText(getActivity(), " the field Licence1 cannot be empty", Toast.LENGTH_LONG).show();
            // Toast.makeText(Constat1Fragment.this, "Ce Champs cannot be empty", Toast.LENGTH_LONG).show();
            // lieu.setText("Ce Champs cannot be empty ");
            return false;
        } else if (string.length() !=2) {
            Toast.makeText(getActivity(), " 2 Characters needed for the field Licence1", Toast.LENGTH_LONG).show();
            // lieu.setText("Maximum 50 Characters");
            return false;
        }
        // til_username.setErrorEnabled(false);
        return true;
    }

    private boolean validatPermisTxt1s(String string) {
        if (string.equals("")) {
            Toast.makeText(getActivity(), "the field Licence2 cannot be empty", Toast.LENGTH_LONG).show();
            // Toast.makeText(Constat1Fragment.this, "Ce Champs cannot be empty", Toast.LENGTH_LONG).show();
            // lieu.setText("Ce Champs cannot be empty ");
            return false;
        } else if (string.length() !=4) {
            Toast.makeText(getActivity(), " 4 Characters needed for the field Licence2", Toast.LENGTH_LONG).show();
            // lieu.setText("Maximum 50 Characters");
            return false;
        }
        return true;
    }

    private boolean DelivrancePermis(String string) {
        if (string.equals("")) {
            Toast.makeText(getActivity(), " the field Date of issue cannot be empty", Toast.LENGTH_LONG).show();
            // Toast.makeText(Constat1Fragment.this, "Ce Champs cannot be empty", Toast.LENGTH_LONG).show();
            // lieu.setText("Ce Champs cannot be empty ");
            return false;
        } else if (string.length() > 15) {
            Toast.makeText(getActivity(), "Maximum 15 Characters for the field Date of issue ", Toast.LENGTH_LONG).show();
            // lieu.setText("Maximum 50 Characters");
            return false;
        } else if (string.length() < 5) {
            Toast.makeText(getActivity(), "Minimum 5 Characters for the field Date of issue ", Toast.LENGTH_LONG).show();
            //lieu.setText("Minimum 5 Characters");
            return false;
        }
        // til_username.setErrorEnabled(false);
        return true;

    }
}