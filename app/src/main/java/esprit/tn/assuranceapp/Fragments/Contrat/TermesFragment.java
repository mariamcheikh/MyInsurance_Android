package esprit.tn.assuranceapp.Fragments.Contrat;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;

import com.android.volley.error.VolleyError;
import com.android.volley.request.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import esprit.tn.assuranceapp.Activities.Contrat.DisplayContratUserActivity;
import esprit.tn.assuranceapp.Constants;
import esprit.tn.assuranceapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class TermesFragment extends Fragment {
    Button accepter,refuser;
    private ProgressDialog progressDialog;
    public static String immatriculation;
    // public static  String  immatriculation;
    // String immat="184TUN1478";

    public TermesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        if (bundle != null)
            immatriculation = bundle.getString("immatricule");
        System.out.println("immat1"+immatriculation);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_termes, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        accepter = view.findViewById(R.id.AccepterConditions);
        refuser = view.findViewById(R.id.RefuserConditions);
        progressDialog = new ProgressDialog(getContext());


        accepter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(), "You have accepted our terms and conditions ", Toast.LENGTH_LONG).show();
                // Intent i = new Intent(getActivity(), DisplayContratAdminActivity.class);
                Intent i = new Intent(getActivity(), DisplayContratUserActivity.class);
                startActivity(i);
                ((Activity) getActivity()).overridePendingTransition(0,0);

                // startActivity(new Intent(TermesFragment.this, DisplayContratUserActivity.class ));
            }
        });


        refuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SupprimerVehicules();
                Toast.makeText(getActivity(), "You have refused our terms and conditions ", Toast.LENGTH_LONG).show();
                System.out.println("immat2"+immatriculation);
            }
        });
    }



    private void SupprimerVehicules() {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.URL_CONTRAT_REFUSER_CONDITIONS, response -> Toast.makeText(getActivity(),"vous avez refuser nos termes et Conditions ",Toast.LENGTH_LONG).show(),
                error -> Toast.makeText(getActivity(),error.toString(),Toast.LENGTH_LONG).show()){
            @Override
            protected Map<String, String> getParams() {
                // Creating Map String Params.
                Map<String, String> params = new HashMap<String, String>();

                params.put("immat", immatriculation);
                System.out.println("immat3"+immatriculation);

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);


    }
}
