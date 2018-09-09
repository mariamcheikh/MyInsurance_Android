package esprit.tn.assuranceapp.Fragments.Contrat;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.android.volley.request.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import esprit.tn.assuranceapp.Activities.Contrat.ContratActivity;
import esprit.tn.assuranceapp.Constants;
import esprit.tn.assuranceapp.R;
import esprit.tn.assuranceapp.UserAccueil;

/**
 * A simple {@link Fragment} subclass.
 */
public class GarantiesFragment extends Fragment {

   // String ncin = "07204062";
    String ResposabiliteCivileson = "0", Defenceetrecourson = "0", volon = "0", Incendieon = "0", GOLDon = "0", glaceson = "0",
     securiteconducteuron = "0";
    RadioGroup radioGroupeGaranties;
    RadioButton tousRisque,Dommage;
    Switch ResposabiliteCiviles,Defenceetrecours;
    CheckBox vol,Incendie,GOLD,glaces,securiteconducteur;
    Button bouttonGaranties;
    public static String immatriculation;
    private ProgressDialog progressDialog;

    public GarantiesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        System.out.println("7alitniii");

        /*
        *   Bundle bundle = getArguments();
        if (bundle!= null)
        {
            final String date = bundle.getString("date");
            final String heure = bundle.getString("heure");
            final String lieu = bundle.getString("lieu");
            final String blesse = bundle.getString("blesse");
            final  String degat = bundle.getString("degat");
            final  String temoins = bundle.getString("temoins");*/
        Bundle bundle = getArguments();
        if (bundle != null)
        immatriculation = bundle.getString("immatricule");
        System.out.println("immatricule"+immatriculation);

        //System.out.println("immat: " + immatriculation);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_garanties, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        radioGroupeGaranties = view.findViewById(R.id.radioGroupeGaranties);
            tousRisque = view.findViewById(R.id.tousRisque);
            Dommage = view.findViewById(R.id.Dommage);
            ResposabiliteCiviles = view.findViewById(R.id.ResposabiliteCiviles);
            Defenceetrecours = view.findViewById(R.id.Defenceetrecours);
            vol = view.findViewById(R.id.vol);
            Incendie = view.findViewById(R.id.Incendie);
            GOLD = view.findViewById(R.id.GOLD);
            glaces = view.findViewById(R.id.glaces);
            securiteconducteur = view.findViewById(R.id.securiteconducteur);
            bouttonGaranties = view.findViewById(R.id.bouttonGaranties);
        progressDialog = new ProgressDialog(getContext());


            System.out.println(" immatriculation de la voiture:"+immatriculation);

            ResposabiliteCiviles.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    System.out.println("mariem 21");
                    boolean on = ((Switch) v).isChecked();
                    if (on) {
                        ResposabiliteCivileson = "1";

                    } else {
                        ResposabiliteCivileson = "0";
                    }
                }


            });


            Defenceetrecours.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    boolean on = ((Switch) v).isChecked();
                    if (on) {
                        Defenceetrecourson = "1";

                    } else {
                        Defenceetrecourson = "0";

                    }
                }


            });

            vol.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean on = ((CheckBox) v).isChecked();
                    if (on) {
                        volon = "1";

                    } else {
                        volon = "0";
                    }
                }
            });
            Incendie.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean on = ((CheckBox) v).isChecked();
                    if (on) {
                        Incendieon = "1";

                    } else {
                        Incendieon = "0";
                    }
                }
            });
            GOLD.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean on = ((CheckBox) v).isChecked();
                    if (on) {
                        GOLDon = "1";

                    } else {
                        GOLDon = "0";
                    }
                }
            });
            glaces.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean on = ((CheckBox) v).isChecked();
                    if (on) {
                        glaceson = "1";

                    } else {
                        glaceson = "0";
                    }
                }
            });
            securiteconducteur.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean on = ((CheckBox) v).isChecked();
                    if (on) {
                        securiteconducteuron = "1";

                    } else {
                        securiteconducteuron = "0";
                    }
                }
            });


            view.findViewById(R.id.bouttonGaranties).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    registerInfo();


                }
            });
    }

    private void registerInfo() {

        final String typeassurance = ((RadioButton) getView().findViewById(radioGroupeGaranties.getCheckedRadioButtonId())).getText().toString();
        final  String resp = ResposabiliteCivileson;
        final String defence = Defenceetrecourson;
        final String vol = volon;
        final  String incendie = Incendieon;
        final String gold = GOLDon;
        final String glace = glaceson;
        final String securiteconduct = securiteconducteuron ;

        progressDialog.setMessage("Add Guarantees Information  ...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.URL_CONTRAT_INSERT_GARANTIES, response -> {
            progressDialog.dismiss();
            System.out.println("barcha fazet");
            Toast.makeText(getActivity(),"Warranties Added successfully",Toast.LENGTH_LONG).show();

            TermesFragment totermesFragment = new TermesFragment();
            Bundle bundle = new Bundle();
            bundle.putString("immatricule", immatriculation);
            totermesFragment.setArguments(bundle);
            FragmentManager manager = getFragmentManager();
            manager.beginTransaction().replace(R.id.content,totermesFragment).commit();
            ((UserAccueil)getActivity()).replaceFragment(new TermesFragment());
            //((ContratActivity)getActivity()).replaceFragment(new ContratPermisFragment());

           // ((ContratActivity)getActivity()).replaceFragment(new TermesFragment());


        },
                error -> {
                    progressDialog.hide();
                    System.out.println("errroooooooooooor");
                    Toast.makeText(getActivity(),error.toString(),Toast.LENGTH_LONG).show();
                    ((UserAccueil)getActivity()).replaceFragment(new TermesFragment());
                }){
            @Override
            protected Map<String, String> getParams() {
                // Creating Map String Params.
                Map<String, String> params = new HashMap<String, String>();
                params.put("ncin", UserAccueil.CONNECTED_USER_CIN);;
              // params.put("ncin", ncin);
                params.put("type",typeassurance);
                params.put("resp", resp);
                params.put("defen",defence);
                params.put("vol", vol);
                params.put("incen",  incendie);
                params.put("remor",gold);
                params.put("glace",glace);
                params.put("secur",securiteconduct);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);


    }
}
