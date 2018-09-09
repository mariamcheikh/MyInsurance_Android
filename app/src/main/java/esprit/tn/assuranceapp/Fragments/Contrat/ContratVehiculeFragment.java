package esprit.tn.assuranceapp.Fragments.Contrat;


import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
public class ContratVehiculeFragment extends Fragment {
     String  immatriculation;
    String ncin = "07206840";
    private ProgressDialog progressDialog;
    String  Marques,Modeles,CVs,immatriculation1s,immatriculation2s,dateCirculations,numSeries;

    RadioGroup radioGroupe;
    RadioButton Diesel,Essence,GPL;
    EditText Marque,Modele,CV,immatriculation1,immatriculation2,dateCirculation,numSerie;
    Button bouttonVehicule;
    DatePickerDialog.OnDateSetListener DateCirculation;
    Calendar calendar = Calendar.getInstance();


    public ContratVehiculeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_contrat_vehicule, container, false);


    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        radioGroupe= view.findViewById(R.id.radioGroupe);
        Diesel= view.findViewById(R.id.Diesel);
        Essence= view.findViewById(R.id.Essence);
        GPL= view.findViewById(R.id.GPL);
        Marque= view.findViewById(R.id.Marque);
        Modele= view.findViewById(R.id.Modele);
        CV= view.findViewById(R.id.CV);
        immatriculation1= view.findViewById(R.id.immatriculation1);

        immatriculation2= view.findViewById(R.id.immatriculation2);
        dateCirculation= view.findViewById(R.id.dateCirculation);
        numSerie= view.findViewById(R.id.numSerie);
        bouttonVehicule = view.findViewById(R.id.bouttonVehicule);

        progressDialog = new ProgressDialog(getContext());

        dateCirculation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                DatePickerDialog dpDialog = new DatePickerDialog(getActivity(), ContratVehiculeFragment.this.DateCirculation, calendar
                        .get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH));
                DatePicker datePicker = dpDialog.getDatePicker();

                Calendar calendar = Calendar.getInstance();//get the current day
                datePicker.setMaxDate(calendar.getTimeInMillis());//set the current day as the max date
                dpDialog.show();
            }
        });


        DateCirculation = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, monthOfYear);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                delivrerCirculation();

            }
        };


bouttonVehicule.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Marques = Marque.getText().toString();
        Modeles = Modele.getText().toString();
        CVs = CV.getText().toString();
        immatriculation1s = immatriculation1.getText().toString();
        immatriculation2s = immatriculation2.getText().toString();
        dateCirculations = dateCirculation.getText().toString();
        numSeries = numSerie.getText().toString();

        if (DelivranceMarques(Marques) && (validatModeles(Modeles)) && (validatCVs(CVs))&& (validatimmatriculation1s(immatriculation1s)) && (validatimmatriculation2s(immatriculation2s))&& (validatdateCirculations(dateCirculations))&& (validatnumSeries(numSeries))) {


       registerInfo();


}

    }
});


    }


    private void registerInfo() {

        final String energie = ((RadioButton) getView().findViewById(radioGroupe.getCheckedRadioButtonId())).getText().toString();

        final  String marque = Marque.getText().toString().replaceAll("'", "\\\\'").trim();
        final String modele = Modele.getText().toString().replaceAll("'", "\\\\'").trim();
        final String cv = CV.getText().toString().replaceAll("'", "\\\\'").trim();
        final  String Immatriculation1 = immatriculation1.getText().toString().replaceAll("'", "\\\\'").trim();
        final String Immatriculation2 = immatriculation2.getText().toString().replaceAll("'", "\\\\'").trim();
        final String DateCirculation = dateCirculation.getText().toString().replaceAll("'", "\\\\'").trim();
        final String NumSerie = numSerie.getText().toString().replaceAll("'", "\\\\'").trim();

        progressDialog.setMessage("Add Vehicle Information ...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.URL_CONTRAT_INSERT_VEHICULE, response -> {
            progressDialog.dismiss();
            Toast.makeText(getActivity(),"Vehicule Added Successfully",Toast.LENGTH_LONG).show();

            GarantiesFragment togarantiesFragment = new GarantiesFragment();
            Bundle bundle = new Bundle();
            bundle.putString("immatricule", immatriculation);
            System.out.println("immatricule"+immatriculation);
            togarantiesFragment.setArguments(bundle);
            FragmentManager manager = getFragmentManager();
            manager.beginTransaction().replace(R.id.content,togarantiesFragment).commit();
            //((ContratActivity)getActivity()).replaceFragment(togarantiesFragment);
            ((UserAccueil)getActivity()).replaceFragment(new GarantiesFragment());
        },
                error -> {
                    progressDialog.hide();
                    Toast.makeText(getActivity(),error.toString(),Toast.LENGTH_LONG).show();
                    //((ContratActivity)getActivity()).replaceFragment(new GarantiesFragment());
                    ((UserAccueil)getActivity()).replaceFragment(new GarantiesFragment());
                }){
            @Override
            protected Map<String, String> getParams() {
                // Creating Map String Params.
                Map<String, String> params = new HashMap<String, String>();
                params.put("ncin", UserAccueil.CONNECTED_USER_CIN);
               // params.put("ncin", ncin);
                params.put("num",NumSerie);
                params.put("marque", marque);
                params.put("modele",modele);
                 immatriculation = Immatriculation1+"TUN"+Immatriculation2;
                params.put("immat", immatriculation);
                params.put("cv",cv);
                params.put("dcirc",DateCirculation);
                params.put("energie",energie);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);


    }

    private void delivrerCirculation() {
        String myFormat = "MM-dd-yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat);
        dateCirculation.setText(sdf.format(calendar.getTime()));
    }


    private boolean DelivranceMarques(String string) {
        if (string.equals("")) {
            Toast.makeText(getActivity(), " the field brand cannot be empty", Toast.LENGTH_LONG).show();
            // Toast.makeText(Constat1Fragment.this, "Ce Champs cannot be empty", Toast.LENGTH_LONG).show();
            // lieu.setText("Ce Champs cannot be empty ");
            return false;
        } else if (string.length() > 15) {
            Toast.makeText(getActivity(), "Maximum 15 Characters for the field brand", Toast.LENGTH_LONG).show();
            // lieu.setText("Maximum 50 Characters");
            return false;
        } else if (string.length() < 5) {
            Toast.makeText(getActivity(), "Minimum 5 Characters for the field brand", Toast.LENGTH_LONG).show();
            //lieu.setText("Minimum 5 Characters");
            return false;
        }
        // til_username.setErrorEnabled(false);
        return true;
    }

    private boolean validatModeles(String string) {
        if (string.equals("")) {
            Toast.makeText(getActivity(), " the field Model cannot be empty", Toast.LENGTH_LONG).show();
            // Toast.makeText(Constat1Fragment.this, "Ce Champs cannot be empty", Toast.LENGTH_LONG).show();
            // lieu.setText("Ce Champs cannot be empty ");
            return false;
        } else if (string.length() > 15) {
            Toast.makeText(getActivity(), "Maximum 50 Characters for the field Model", Toast.LENGTH_LONG).show();
            // lieu.setText("Maximum 50 Characters");
            return false;
        } else if (string.length() < 5) {
            Toast.makeText(getActivity(), "Minimum 5 Characters for the field Model", Toast.LENGTH_LONG).show();
            //lieu.setText("Minimum 5 Characters");
            return false;
        }
        // til_username.setErrorEnabled(false);
        return true;
    }

    private boolean validatCVs(String string) {
        if (string.equals("")) {
            Toast.makeText(getActivity(), "  Fiscal power car  cannot be empty", Toast.LENGTH_LONG).show();
            // Toast.makeText(Constat1Fragment.this, "Ce Champs cannot be empty", Toast.LENGTH_LONG).show();
            // lieu.setText("Ce Champs cannot be empty ");
            return false;
        } else if (string.length() !=1) {
            Toast.makeText(getActivity(), "One  Character needed for the field Fiscal power car", Toast.LENGTH_LONG).show();
            // lieu.setText("Maximum 50 Characters");
            return false;
        }
        // til_username.setErrorEnabled(false);
        return true;

    }
    private boolean validatimmatriculation1s(String string) {
        if (string.equals("")) {
            Toast.makeText(getActivity(), " the field vehicle registration1 cannot be empty", Toast.LENGTH_LONG).show();
            // Toast.makeText(Constat1Fragment.this, "Ce Champs cannot be empty", Toast.LENGTH_LONG).show();
            // lieu.setText("Ce Champs cannot be empty ");
            return false;
        } else if (string.length() !=3) {
            Toast.makeText(getActivity(), "3 Characters needed  for the field vehicle registration1", Toast.LENGTH_LONG).show();
            // lieu.setText("Maximum 50 Characters");
            return false;
        }
        // til_username.setErrorEnabled(false);
        return true;
    }

    private boolean validatimmatriculation2s(String string) {
        if (string.equals("")) {
            Toast.makeText(getActivity(), " the field vehicle registration2 cannot be empty", Toast.LENGTH_LONG).show();
            // Toast.makeText(Constat1Fragment.this, "Ce Champs cannot be empty", Toast.LENGTH_LONG).show();
            // lieu.setText("Ce Champs cannot be empty ");
            return false;
        } else if (string.length() !=4) {
            Toast.makeText(getActivity(), "4 Character needed for the field vehicle registration2", Toast.LENGTH_LONG).show();
            // lieu.setText("Maximum 50 Characters");
            return false;
        }
        // til_username.setErrorEnabled(false);
        return true;
    }

    private boolean validatdateCirculations(String string) {
        if (string.equals("")) {
            Toast.makeText(getActivity(), " date of Circulation cannot be empty", Toast.LENGTH_LONG).show();
            // Toast.makeText(Constat1Fragment.this, "Ce Champs cannot be empty", Toast.LENGTH_LONG).show();
            // lieu.setText("Ce Champs cannot be empty ");
            return false;
        } else if (string.length() > 15) {
            Toast.makeText(getActivity(), "Maximum 15 Characters for the field date", Toast.LENGTH_LONG).show();
            // lieu.setText("Maximum 50 Characters");
            return false;
        } else if (string.length() < 5) {
            Toast.makeText(getActivity(), "Minimum 5 Characters for the field date", Toast.LENGTH_LONG).show();
            //lieu.setText("Minimum 5 Characters");
            return false;
        }
        // til_username.setErrorEnabled(false);
        return true;

    }
    private boolean validatnumSeries(String string) {
        if (string.equals("")) {
            Toast.makeText(getActivity(), " the field Serial number cannot be empty", Toast.LENGTH_LONG).show();
            // Toast.makeText(Constat1Fragment.this, "Ce Champs cannot be empty", Toast.LENGTH_LONG).show();
            // lieu.setText("Ce Champs cannot be empty ");
            return false;
        } else if (string.length() > 15) {
            Toast.makeText(getActivity(), "Maximum 50 Characters for the field Serial number", Toast.LENGTH_LONG).show();
            // lieu.setText("Maximum 50 Characters");
            return false;
        } else if (string.length() < 5) {
            Toast.makeText(getActivity(), "Minimum 5 Characters  for the field Serial number", Toast.LENGTH_LONG).show();
            //lieu.setText("Minimum 5 Characters");
            return false;
        }
        // til_username.setErrorEnabled(false);
        return true;

    }



}
