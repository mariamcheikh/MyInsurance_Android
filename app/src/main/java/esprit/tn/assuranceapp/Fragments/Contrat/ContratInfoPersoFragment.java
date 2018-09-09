package esprit.tn.assuranceapp.Fragments.Contrat;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;

import com.android.volley.request.StringRequest;
import com.android.volley.toolbox.Volley;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import esprit.tn.assuranceapp.Activities.Contrat.ContratActivity;
import esprit.tn.assuranceapp.Constants;
import esprit.tn.assuranceapp.R;
import esprit.tn.assuranceapp.UserAccueil;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContratInfoPersoFragment extends Fragment {

//String ncin ="a";

 String   professions ,addresses,villes,codepostales;

    Button btnValider;
    EditText profession ,addresse,ville,codepostale;
    private ProgressDialog progressDialog;

    public ContratInfoPersoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onDetach() {
        super.onDetach();

        try {
            Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            childFragmentManager.set(this, null);

        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contrat_info_perso, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        profession = view.findViewById(R.id.professionTxt);
        addresse = view.findViewById(R.id.AdresseTxt);
        ville = view.findViewById(R.id.VilleTxt);
        codepostale = view.findViewById(R.id.CPTxt);
        btnValider = view.findViewById(R.id.bouttonContrat);
        progressDialog = new ProgressDialog(getContext());

        btnValider.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        professions= profession.getText().toString();
                        addresses = addresse.getText().toString();
                        villes = ville.getText().toString();
                        codepostales = codepostale.getText().toString();

                        if (validatprofessions(professions) &&(validataddresses(addresses))&& (validatevilles(villes))&&(validatecodepostales(codepostales))) {
                            registerInfo();
                             }
                       // registerInfo();
                    }
                }
        );
    }


    private void registerInfo() {

        final  String Profession = profession.getText().toString().replaceAll("'", "\\\\'").trim();
        final String Addresse = addresse.getText().toString().replaceAll("'", "\\\\'").trim();
        final String Ville = ville.getText().toString().replaceAll("'", "\\\\'").trim();
        final String CodePostale = codepostale.getText().toString().replaceAll("'", "\\\\'").trim();

        progressDialog.setMessage("Add Personal Information  ...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.URL_CONTRAT_INSERT_INFO_PERSO, response -> {
            progressDialog.dismiss();
            Toast.makeText(getActivity(),"Contract Successfully Added",Toast.LENGTH_LONG).show();
            System.out.println(Profession+Addresse+Ville+CodePostale);


           // getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,fragment).commit();

            //((UserAccueil)getActivity()).replaceFragment(new ContratPermisFragment());
                ((UserAccueil)getActivity()).replaceFragment(new ContratPermisFragment());
        },
                error -> {
                    progressDialog.hide();
                        Toast.makeText(getContext(),error.toString(),Toast.LENGTH_LONG).show();}
        ){
            @Override
            protected Map<String, String> getParams() {
               // Creating Map String Params.
                Map<String, String> params = new HashMap<String, String>();
               params.put("ncin", UserAccueil.CONNECTED_USER_CIN);
                System.out.println("la cin ajouté est "+UserAccueil.CONNECTED_USER_CIN);
              //  params.put("ncin", ncin);
                params.put("profession", Profession);
                params.put("adress", Addresse);
                params.put("city", Ville);
                params.put("postal_code",CodePostale);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
        System.out.println(Profession+Addresse+Ville+CodePostale);
    }


    private boolean validatprofessions(String string) {
        if (string.equals("")) {
            Toast.makeText(getActivity()," The field Profession cannot be empty",Toast.LENGTH_LONG).show();
            // Toast.makeText(Constat1Fragment.this, "Ce Champs cannot be empty", Toast.LENGTH_LONG).show();
            // lieu.setText("Ce Champs cannot be empty ");
            return false;
        } else if (string.length() > 15) {
            Toast.makeText(getActivity(),"Maximum 15 Characters  for the field Profession",Toast.LENGTH_LONG).show();
            // lieu.setText("Maximum 50 Characters");
            return false;
        } else if (string.length() < 5) {
            Toast.makeText(getActivity(),"Minimum 5 Characters for the field Profession",Toast.LENGTH_LONG).show();
            //lieu.setText("Minimum 5 Characters");
            return false;
        }
        // til_username.setErrorEnabled(false);
        return true;
    }
    private boolean validataddresses(String string) {
        if (string.equals("")) {
            Toast.makeText(getActivity()," The field Address cannot be empty",Toast.LENGTH_LONG).show();
            // Toast.makeText(Constat1Fragment.this, "Ce Champs cannot be empty", Toast.LENGTH_LONG).show();
            // lieu.setText("Ce Champs cannot be empty ");
            return false;
        } else if (string.length() > 15) {
            Toast.makeText(getActivity(),"Maximum 15 Characters for the field Address",Toast.LENGTH_LONG).show();
            // lieu.setText("Maximum 50 Characters");
            return false;
        } else if (string.length() < 5) {
            Toast.makeText(getActivity(),"Minimum 5 Characters for the field Address",Toast.LENGTH_LONG).show();
            //lieu.setText("Minimum 5 Characters");
            return false;
        }

        // til_username.setErrorEnabled(false);
        return true;
    }
    private boolean validatevilles(String string) {
        if (string.equals("")) {
            Toast.makeText(getActivity()," The field City cannot be empty",Toast.LENGTH_LONG).show();
            // Toast.makeText(Constat1Fragment.this, "Ce Champs cannot be empty", Toast.LENGTH_LONG).show();
            // lieu.setText("Ce Champs cannot be empty ");
            return false;
        } else if (string.length() > 15) {
            Toast.makeText(getActivity()," Maximum 15 Characters  for the field city",Toast.LENGTH_LONG).show();
            // lieu.setText("Maximum 50 Characters");
            return false;
        } else if (string.length() < 5) {
            Toast.makeText(getActivity(),"Minimum 5 Characters for the field city",Toast.LENGTH_LONG).show();
            //lieu.setText("Minimum 5 Characters");
            return false;
        }
        // til_username.setErrorEnabled(false);
        return true;
    }
    private boolean validatecodepostales(String string) {
        if (string.equals("")) {
            Toast.makeText(getActivity(),"  The field Postal Code cannot be empty",Toast.LENGTH_LONG).show();

            return false;
        } else if (string.length() != 4) {
            Toast.makeText(getActivity(), " 4 Characters  needed for the field Postal Code", Toast.LENGTH_LONG).show();
            // lieu.setText("Maximum 50 Characters");
            return false;
        }
        // til_username.setErrorEnabled(false);
        return true;
    }


}
