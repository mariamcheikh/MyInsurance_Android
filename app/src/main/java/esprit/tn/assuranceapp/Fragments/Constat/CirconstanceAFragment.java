package esprit.tn.assuranceapp.Fragments.Constat;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.request.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import esprit.tn.assuranceapp.Activities.Constat.AccidentImageActivity;
import esprit.tn.assuranceapp.Activities.Constat.ConstatActivity;
import esprit.tn.assuranceapp.Constants;
import esprit.tn.assuranceapp.R;
import esprit.tn.assuranceapp.UserAccueil;

/**
 * A simple {@link Fragment} subclass.
 */
public class CirconstanceAFragment extends Fragment {

    public static String CONSTAT_ID;

  public   String stationnementValueA="Non",quiterstationnementValueA="Non",prenantstationnementValueA="Non",sortantParkingValueA="Non",engagerparkingValueA="Non",arretcirculationValueA="Non",
            frottementValueA="Non",heurtaitarriereValueA="Non",roulermemesensValueA="Non",changementfileValueA="Non",doublaitValueA="Non",viraitdroiteValueA="Non",viraitgaucheValueA="Non",reculaitValueA="Non"
            ,chausseValueA="Non",carrefourValueA="Non",prioriteValueA="Non",user_id="13";


    CheckBox stationnementA,quiterstationnementA,prenantstationnementA,sortantParkingA,engagerparkingA,arretcirculationA,
            frottementA,heurtaitarriereA,roulermemesensA,changementfileA,doublaitA,viraitdroiteA,viraitgaucheA,reculaitA,chausseA,carrefourA,prioriteA
            ;
    Button btnnextAA,retour;
    private ProgressDialog progressDialog;
    public CirconstanceAFragment() {

    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_circonstance_a, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        stationnementA = view.findViewById(R.id.stationnementA);
        quiterstationnementA = view.findViewById(R.id.quiterstationnementA);
        prenantstationnementA = view.findViewById(R.id.prenantstationnementA);
        sortantParkingA = view.findViewById(R.id.sortantParkingA);
        engagerparkingA = view.findViewById(R.id.engagerparkingA);
        arretcirculationA = view.findViewById(R.id.arretcirculationA);
        frottementA = view.findViewById(R.id.frottementA);
        heurtaitarriereA = view.findViewById(R.id.heurtaitarriereA);
        roulermemesensA = view.findViewById(R.id.roulermemesensA);
        changementfileA = view.findViewById(R.id.changementfileA);
        doublaitA = view.findViewById(R.id.doublaitA);
        viraitdroiteA = view.findViewById(R.id.viraitdroiteA);
        viraitgaucheA = view.findViewById(R.id.viraitgaucheA);
        reculaitA = view.findViewById(R.id.reculaitA);
        chausseA = view.findViewById(R.id.chausseA);
        carrefourA = view.findViewById(R.id.carrefourA);
        prioriteA = view.findViewById(R.id.prioriteA);

        btnnextAA = view.findViewById(R.id.btnnextAA);

        retour = view.findViewById(R.id.retour);
        progressDialog = new ProgressDialog(getContext());
        Bundle bundle = getArguments();
        if (bundle!= null) {
            final String date = bundle.getString("date");
             final String heure = bundle.getString("heure");
             final String lieu = bundle.getString("lieu");
             final String blesse = bundle.getString("blesse");
            final String degat = bundle.getString("degat");
            final String temoins = bundle.getString("temoins");
            ////////////////////////////////////////////////
            final String vehiculeassure = bundle.getString("vehiculeassure");
            final String contratassure = bundle.getString("contratassure");
            final  String agence = bundle.getString("agence");
            final String attestationdu = bundle.getString("attestationdu");
            final String attestationau = bundle.getString("attestationau");
            final String nomConducteur = bundle.getString("nomConducteur");
            final String prenomConducteur = bundle.getString("prenomConducteur");
            final String addresseConducteur = bundle.getString("addresseConducteur");
            final   String permisConducteur = bundle.getString("permisConducteur");
            final String permisdelivre = bundle.getString("permisdelivre");
            final String nomassure = bundle.getString("nomassure");
            final String prenomasure = bundle.getString("prenomasure");
            final String addresseassure = bundle.getString("addresseassure");
            final String telassure = bundle.getString("telassure");
            final  String marquevoiture = bundle.getString("marquevoiture");
            final String immatriculation = bundle.getString("immatriculation");
            final  String senssuivis = bundle.getString("senssuivis");
            final  String venantde = bundle.getString("venantde");
            final  String allanta = bundle.getString("allanta");
            final  String degatapparents = bundle.getString("degatapparents");
            final  String observations = bundle.getString("observations");
            ///////////////////////////////////////
            final String stationnement = bundle.getString("stationnement");
            final String quiterstationnement = bundle.getString("quiterstationnement");
            final  String prenantstationnement = bundle.getString("prenantstationnement");
            final String sortantParking = bundle.getString("sortantParking");
            final String engagerparking = bundle.getString("engagerparking");
            final String arretcirculation = bundle.getString("arretcirculation");
            final String frottement = bundle.getString("frottement");
            final  String heurtaitarriere = bundle.getString("heurtaitarriere");
            final String roulermemesens = bundle.getString("roulermemesens");
            final  String changementfile = bundle.getString("changementfile");
            final String doublait = bundle.getString("doublait");
            final  String viraitdroite = bundle.getString("viraitdroite");
            final  String viraitgauche = bundle.getString("viraitgauche");
            final String reculait = bundle.getString("reculait");
            final String chausse = bundle.getString("chausse");
            final  String carrefour = bundle.getString("carrefour");
            final  String priorite = bundle.getString("priorite");
            ///////////////////////////////////////////////////
            final String vehiculeassureA = bundle.getString("vehiculeassureA");
            final String contratassureA = bundle.getString("contratassureA");
            final String agenceA = bundle.getString("agenceA");
            final String attestationduA = bundle.getString("attestationduA");
            final String attestationauA = bundle.getString("attestationauA");
            final String nomConducteurA = bundle.getString("nomConducteurA");
            final String prenomConducteurA = bundle.getString("prenomConducteurA");
            final  String addresseConducteurA = bundle.getString("addresseConducteurA");
            final   String permisConducteurA = bundle.getString("permisConducteurA");
            final    String permisdelivreA = bundle.getString("permisdelivreA");
            final   String nomassureA = bundle.getString("nomassureA");
            final  String prenomasureA = bundle.getString("prenomasureA");
            final String addresseassureA = bundle.getString("addresseassureA");
            final  String telassureA = bundle.getString("telassureA");
            final String marquevoitureA = bundle.getString("marquevoitureA");
            final String immatriculationA = bundle.getString("immatriculationA");
            final String senssuivisA = bundle.getString("senssuivisA");
            final String venantdeA = bundle.getString("venantdeA");
            final String allantaA = bundle.getString("allantaA");
            final  String degatapparentsA = bundle.getString("degatapparentsA");
            final String observationsA = bundle.getString("observationsA");
            ///////////////////////////////////////////////////

            System.out.println(" date:" + date + " heure:" + heure + " lieu" + lieu + " blesse:" + blesse + " degat:" + degat +
                    " temoins:" + temoins +

                    " vehiculeassure:" + vehiculeassure + " contratassure:" + contratassure +
                    " agence" + agence + " attestationdu:" + attestationdu + " attestationau:" + attestationau +
                    " nomConducteur:" + nomConducteur + " prenomConducteur:" + prenomConducteur + " addresseConducteur:"
                    + addresseConducteur + " permisConducteur" + permisConducteur + " permisdelivre:" + permisdelivre
                    + " nomassure:" + nomassure + " prenomasure:" + prenomasure + " addresseassure:" + addresseassure +
                    " telassure:" + telassure + " marquevoiture" + marquevoiture +
                    " immatriculation:" + immatriculation + " senssuivis:" + senssuivis + " venantde:" + venantde +
                    " allanta:" + allanta + " degatapparents:" + degatapparents + " observations" + observations +

                    " stationnement:" + stationnement + " quiterstationnement:" + quiterstationnement +
                    " prenantstationnement" + prenantstationnement + " sortantParking:" + sortantParking + " engagerparking:" + engagerparking +
                    " arretcirculation:" + arretcirculation + " frottement:" + frottement + " heurtaitarriere:" + heurtaitarriere +
                    " roulermemesens" + roulermemesens + " changementfile:" + changementfile + " doublait:" + doublait +
                    " viraitdroite:" + viraitdroite + " viraitgauche:" + viraitgauche + " reculait:"
                    + reculait + " chausse" + chausse + " carrefour:" + carrefour
                    + " priorite:" + priorite +

                    " vehiculeassureA:" + vehiculeassureA + " contratassureA:" + contratassureA +
                    " agenceA" + agenceA + " attestationduA:" + attestationduA + " attestationauA:" + attestationauA +
                    " nomConducteurA:" + nomConducteurA + " prenomConducteurA:" + prenomConducteurA + " addresseConducteurA:"
                    + addresseConducteurA + " permisConducteurA" + permisConducteurA + " permisdelivreA:" + permisdelivreA
                    + " nomassureA:" + nomassureA + " prenomasureA:" + prenomasureA + " addresseassureA:" + addresseassureA +
                    " telassureA:" + telassureA + " marquevoitureA" + marquevoitureA +
                    " immatriculationA:" + immatriculationA + " senssuivisA:" + senssuivisA + " venantdeA:" + venantdeA +
                    " allantaA:" + allantaA + " degatapparentsA:" + degatapparentsA + " observationsA" + observationsA

            );


        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ConstatVoitureAFragment ConstatVoitureAFragment = new ConstatVoitureAFragment();
                Bundle bundle = new Bundle();
                bundle.putString("date", date);
                bundle.putString("heure", heure);
                bundle.putString("lieu", lieu);
                bundle.putString("blesse", blesse);
                bundle.putString("degat", degat);
                bundle.putString("temoins", temoins);
                ///////////////////////////////////////////////////////////////////
                bundle.putString("vehiculeassure", vehiculeassure);
                bundle.putString("contratassure", contratassure);
                bundle.putString("agence", agence);
                bundle.putString("attestationdu", attestationdu);
                bundle.putString("attestationau", attestationau);
                bundle.putString("nomConducteur", nomConducteur);
                bundle.putString("prenomConducteur", prenomConducteur);
                bundle.putString("addresseConducteur", addresseConducteur);
                bundle.putString("permisConducteur", permisConducteur);
                bundle.putString("permisdelivre", permisdelivre);
                bundle.putString("nomassure", nomassure);
                bundle.putString("prenomasure", prenomasure);
                bundle.putString("addresseassure", addresseassure);
                bundle.putString("telassure", telassure);
                bundle.putString("marquevoiture", marquevoiture);
                bundle.putString("immatriculation", immatriculation);
                bundle.putString("senssuivis", senssuivis);
                bundle.putString("venantde", venantde);
                bundle.putString("allanta", allanta);
                bundle.putString("degatapparents", degatapparents);
                bundle.putString("observations", observations);
                /////////////////////////////////////////////////////////////
                bundle.putString("stationnement", stationnement);
                bundle.putString("quiterstationnement", quiterstationnement);
                bundle.putString("prenantstationnement", prenantstationnement);
                bundle.putString("sortantParking", sortantParking);
                bundle.putString("engagerparking", engagerparking);
                bundle.putString("arretcirculation", arretcirculation);
                bundle.putString("frottement", frottement);
                bundle.putString("heurtaitarriere", heurtaitarriere);
                bundle.putString("roulermemesens", roulermemesens);
                bundle.putString("changementfile", changementfile);
                bundle.putString("doublait", doublait);
                bundle.putString("viraitdroite", viraitdroite);
                bundle.putString("viraitgauche", viraitgauche);
                bundle.putString("reculait", reculait);
                bundle.putString("chausse", chausse);
                bundle.putString("carrefour", carrefour);
                bundle.putString("priorite", priorite);
                /////////////////////////////////////////////////////////////

                bundle.putString("vehiculeassureA",vehiculeassureA);
                bundle.putString("contratassureA", contratassureA);
                bundle.putString("agenceA", agenceA);
                bundle.putString("attestationduA", attestationduA);
                bundle.putString("attestationauA", attestationauA);
                bundle.putString("nomConducteurA", nomConducteurA);
                bundle.putString("prenomConducteurA", prenomConducteurA);
                bundle.putString("addresseConducteurA", addresseConducteurA);
                bundle.putString("permisConducteurA", permisConducteurA);
                bundle.putString("permisdelivreA", permisdelivreA);
                bundle.putString("nomassureA", nomassureA);
                bundle.putString("prenomasureA", prenomasureA);
                bundle.putString("addresseassureA", addresseassureA);
                bundle.putString("telassureA", telassureA);
                bundle.putString("marquevoitureA",marquevoitureA);
                bundle.putString("immatriculationA", immatriculationA);
                bundle.putString("senssuivisA", senssuivisA);
                bundle.putString("venantdeA", venantdeA);
                bundle.putString("allantaA", allantaA);
                bundle.putString("degatapparentsA", degatapparentsA);
                bundle.putString("observationsA", observationsA);


                ConstatVoitureAFragment.setArguments(bundle);
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.content,ConstatVoitureAFragment).commit();


                //((ConstatActivity) getActivity()).replaceFragment(new ConstatVoitureAFragment());

            }
        });
        }
            btnnextAA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (v == btnnextAA){

                    AjouterUser();


                }

                Intent i = new Intent(getActivity(), AccidentImageActivity.class);
                startActivity(i);
                ((Activity) getActivity()).overridePendingTransition(0,0);
            }



            });





            stationnementA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean on = ((CheckBox) v).isChecked();
                    if(on)
                    {
                        stationnementValueA="Oui";

                    }
                    else
                    {
                        stationnementValueA="Non";
                    }
                }
            });

            quiterstationnementA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean on = ((CheckBox) v).isChecked();
                    if(on)
                    {
                        quiterstationnementValueA="Oui";

                    }
                    else
                    {
                        quiterstationnementValueA="Non";
                    }
                }
            });
            prenantstationnementA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean on = ((CheckBox) v).isChecked();
                    if(on)
                    {
                        prenantstationnementValueA="Oui";

                    }
                    else
                    {
                        prenantstationnementValueA="Non";
                    }
                }
            });
            sortantParkingA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean on = ((CheckBox) v).isChecked();
                    if(on)
                    {
                        sortantParkingValueA="Oui";

                    }
                    else
                    {
                        sortantParkingValueA="Non";
                    }
                }
            });
            engagerparkingA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean on = ((CheckBox) v).isChecked();
                    if(on)
                    {
                        engagerparkingValueA="Oui";

                    }
                    else
                    {
                        engagerparkingValueA="Non";
                    }
                }
            });
            arretcirculationA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean on = ((CheckBox) v).isChecked();
                    if(on)
                    {
                        arretcirculationValueA="Oui";

                    }
                    else
                    {
                        arretcirculationValueA="Non";
                    }
                }
            });
            frottementA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean on = ((CheckBox) v).isChecked();
                    if(on)
                    {
                        frottementValueA="Oui";

                    }
                    else
                    {
                        frottementValueA="Non";
                    }
                }
            });

            heurtaitarriereA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean on = ((CheckBox) v).isChecked();
                    if(on)
                    {
                        heurtaitarriereValueA="Oui";

                    }
                    else
                    {
                        heurtaitarriereValueA="Non";
                    }
                }
            });
            roulermemesensA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean on = ((CheckBox) v).isChecked();
                    if(on)
                    {
                        roulermemesensValueA="Oui";

                    }
                    else
                    {
                        roulermemesensValueA="Non";
                    }
                }
            });
            changementfileA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean on = ((CheckBox) v).isChecked();
                    if(on)
                    {
                        changementfileValueA="Oui";

                    }
                    else
                    {
                        changementfileValueA="Non";
                    }
                }
            });


            doublaitA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean on = ((CheckBox) v).isChecked();
                    if(on)
                    {
                        doublaitValueA="Oui";

                    }
                    else
                    {
                        doublaitValueA="Non";
                    }
                }
            });

            viraitdroiteA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean on = ((CheckBox) v).isChecked();
                    if(on)
                    {
                        viraitdroiteValueA="Oui";

                    }
                    else
                    {
                        viraitdroiteValueA="Non";
                    }
                }
            });

            viraitgaucheA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean on = ((CheckBox) v).isChecked();
                    if(on)
                    {
                        viraitgaucheValueA="Oui";

                    }
                    else
                    {
                        viraitgaucheValueA="Non";
                    }
                }
            });


            reculaitA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean on = ((CheckBox) v).isChecked();
                    if(on)
                    {
                        reculaitValueA="Oui";

                    }
                    else
                    {
                        reculaitValueA="Non";
                    }
                }
            });

            chausseA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean on = ((CheckBox) v).isChecked();
                    if(on)
                    {
                        chausseValueA="Oui";

                    }
                    else
                    {
                        chausseValueA="Non";
                    }
                }
            });

            carrefourA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean on = ((CheckBox) v).isChecked();
                    if(on)
                    {
                        carrefourValueA="Oui";

                    }
                    else
                    {
                        carrefourValueA="Non";
                    }
                }
            });





            prioriteA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean on = ((CheckBox) v).isChecked();
                    if(on)
                    {
                        prioriteValueA="Oui";

                    }
                    else
                    {
                        prioriteValueA="Non";
                    }
                }
            });

        }

    private void AjouterUser() {
        final String stationnementAA = stationnementValueA;
        final String quiterstationnementAA = quiterstationnementValueA;
        final String prenantstationnementAA = prenantstationnementValueA;
        final String sortantParkingAA = sortantParkingValueA;
        final String engagerparkingAA = engagerparkingValueA;
        final String arretcirculationAA = arretcirculationValueA;
        final String frottementAA = frottementValueA;
        final String heurtaitarriereAA = heurtaitarriereValueA;
        final String roulermemesensAA = roulermemesensValueA;
        final String changementfileAA = changementfileValueA;
        final String doublaitAA = doublaitValueA;
        final String viraitdroiteAA = viraitdroiteValueA;
        final String viraitgaucheAA = viraitgaucheValueA;
        final String reculaitAA = reculaitValueA;
        final String chausseAA = chausseValueA;
        final String carrefourAA = carrefourValueA;
        final String prioriteAA = prioriteValueA;
        progressDialog.setMessage("Ajouter Constat  ...");
        progressDialog.show();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.URL_CONSTAT_INSERT, response -> {
            progressDialog.dismiss();
            System.out.println("la reponse test"+response);
            CONSTAT_ID = response;
            Toast.makeText(getActivity(),"Accident Report Successfully Added",Toast.LENGTH_LONG).show();
        },
                error ->
                {  progressDialog.hide();
                    Toast.makeText(getActivity(),error.toString(),Toast.LENGTH_LONG).show();}
        ){
            @Override
            protected Map<String, String> getParams() {
                Bundle bundle = getArguments();

                    final String date = bundle.getString("date");
                    String heure = bundle.getString("heure");
                    String lieu = bundle.getString("lieu");
                    String blesse = bundle.getString("blesse");
                    String degat = bundle.getString("degat");
                    String temoins = bundle.getString("temoins");
                    ////////////////////////////////////////////////
                    String vehiculeassure = bundle.getString("vehiculeassure");
                    String contratassure = bundle.getString("contratassure");
                    String agence = bundle.getString("agence");
                    String attestationdu = bundle.getString("attestationdu");
                    String attestationau = bundle.getString("attestationau");
                    String nomConducteur = bundle.getString("nomConducteur");
                    String prenomConducteur = bundle.getString("prenomConducteur");
                    String addresseConducteur = bundle.getString("addresseConducteur");
                    String permisConducteur = bundle.getString("permisConducteur");
                    String permisdelivre = bundle.getString("permisdelivre");
                    String nomassure = bundle.getString("nomassure");
                    String prenomasure = bundle.getString("prenomasure");
                    String addresseassure = bundle.getString("addresseassure");
                    String telassure = bundle.getString("telassure");
                    String marquevoiture = bundle.getString("marquevoiture");
                    String immatriculation = bundle.getString("immatriculation");
                    String senssuivis = bundle.getString("senssuivis");
                    String venantde = bundle.getString("venantde");
                    String allanta = bundle.getString("allanta");
                    String degatapparents = bundle.getString("degatapparents");
                    String observations = bundle.getString("observations");
                    ///////////////////////////////////////
                    String stationnement = bundle.getString("stationnement");
                    String quiterstationnement = bundle.getString("quiterstationnement");
                    String prenantstationnement = bundle.getString("prenantstationnement");
                    String sortantParking = bundle.getString("sortantParking");
                    String engagerparking = bundle.getString("engagerparking");
                    String arretcirculation = bundle.getString("arretcirculation");
                    String frottement = bundle.getString("frottement");
                    String heurtaitarriere = bundle.getString("heurtaitarriere");
                    String roulermemesens = bundle.getString("roulermemesens");
                    String changementfile = bundle.getString("changementfile");
                    String doublait = bundle.getString("doublait");
                    String viraitdroite = bundle.getString("viraitdroite");
                    String viraitgauche = bundle.getString("viraitgauche");
                    String reculait = bundle.getString("reculait");
                    String chausse = bundle.getString("chausse");
                    String carrefour = bundle.getString("carrefour");
                    String priorite = bundle.getString("priorite");
                    ///////////////////////////////////////////////////
                    String vehiculeassureA = bundle.getString("vehiculeassureA");
                    String contratassureA = bundle.getString("contratassureA");
                    String agenceA = bundle.getString("agenceA");
                    String attestationduA = bundle.getString("attestationduA");
                    String attestationauA = bundle.getString("attestationauA");
                    String nomConducteurA = bundle.getString("nomConducteurA");
                    String prenomConducteurA = bundle.getString("prenomConducteurA");
                    String addresseConducteurA = bundle.getString("addresseConducteurA");
                    String permisConducteurA = bundle.getString("permisConducteurA");
                    String permisdelivreA = bundle.getString("permisdelivreA");
                    String nomassureA = bundle.getString("nomassureA");
                    String prenomasureA = bundle.getString("prenomasureA");
                    String addresseassureA = bundle.getString("addresseassureA");
                    String telassureA = bundle.getString("telassureA");
                    String marquevoitureA = bundle.getString("marquevoitureA");
                    String immatriculationA = bundle.getString("immatriculationA");
                    String senssuivisA = bundle.getString("senssuivisA");
                    String venantdeA = bundle.getString("venantdeA");
                    String allantaA = bundle.getString("allantaA");
                    String degatapparentsA = bundle.getString("degatapparentsA");
                    String observationsA = bundle.getString("observationsA");
                    ///////////////////////////////////////////////////


                // Creating Map String Params.
                Map<String, String> params = new HashMap<String, String>();
                params.put("date", date);
                params.put("heure", heure);
                params.put("lieu", lieu);
                params.put("blesse", blesse);
                params.put("degat", degat);
                params.put("temoins", temoins);
                params.put("vehiculeassure", vehiculeassure);
                params.put("contratassure", contratassure);
                params.put("agence",agence );
                params.put("attestationdu", attestationdu);
                params.put("attestationau", attestationau);
                params.put("nomConducteur", nomConducteur);
                params.put("prenomConducteur", prenomConducteur);
                params.put("addresseConducteur", addresseConducteur);
                params.put("permisConducteur", permisConducteur);
                params.put("permisdelivre", permisdelivre);
                params.put("nomassure",nomassure );
                params.put("prenomasure", prenomasure);
                params.put("addresseassure", addresseassure);
                params.put("telassure", telassure);
                params.put("marquevoiture", marquevoiture);
                params.put("immatriculation", immatriculation);
                params.put("senssuivis", senssuivis);
                params.put("venantde", venantde);
                params.put("allanta",allanta );
                params.put("degatapparents", degatapparents);
                params.put("observations", observations);
                params.put("stationnement", stationnement);
                params.put("quiterstationnement", quiterstationnement);
                params.put("prenantstationnement", prenantstationnement);
                params.put("sortantParking", sortantParking);
                params.put("engagerparking", engagerparking);
                params.put("arretcirculation",arretcirculation );
                params.put("frottement", frottement);
                params.put("heurtaitarriere", heurtaitarriere);
                params.put("roulermemesens", roulermemesens);
                params.put("changementfile", changementfile);
                params.put("doublait", doublait);
                params.put("viraitdroite", viraitdroite);
                params.put("viraitgauche", viraitgauche);
                params.put("reculait",reculait );
                params.put("chausse", chausse);
                params.put("carrefour", carrefour);
                params.put("priorite", priorite);
                params.put("vehiculeassureA", vehiculeassureA);
                params.put("contratassureA", contratassureA);
                params.put("agenceA", agenceA);
                params.put("attestationduA", attestationduA);
                params.put("attestationauA",attestationauA );
                params.put("nomConducteurA", nomConducteurA);
                params.put("prenomConducteurA", prenomConducteurA);
                params.put("addresseConducteurA", addresseConducteurA);
                params.put("permisConducteurA", permisConducteurA);
                params.put("permisdelivreA", permisdelivreA);
                params.put("nomassureA", nomassureA);
                params.put("prenomasureA", prenomasureA);
                params.put("addresseassureA",addresseassureA );
                params.put("telassureA", telassureA);
                params.put("marquevoitureA", marquevoitureA);
                params.put("immatriculationA", immatriculationA);
                params.put("senssuivisA", senssuivisA);
                params.put("venantdeA", venantdeA);
                params.put("allantaA", allantaA);
                params.put("degatapparentsA", degatapparentsA);
                params.put("observationsA",observationsA );
                params.put("stationnementA", stationnementAA);
                params.put("quiterstationnementA", quiterstationnementAA);
                params.put("prenantstationnementA", prenantstationnementAA);
                params.put("sortantParkingA", sortantParkingAA);
                params.put("engagerparkingA", engagerparkingAA);
                params.put("arretcirculationA",arretcirculationAA );
                params.put("frottementA", frottementAA);
                params.put("heurtaitarriereA", heurtaitarriereAA);
                params.put("roulermemesensA", roulermemesensAA);
                params.put("changementfileA", changementfileAA);
                params.put("doublaitA", doublaitAA);
                params.put("viraitdroiteA", viraitdroiteAA);
                params.put("viraitgaucheA", viraitgaucheAA);
                params.put("reculaitA",reculaitAA );
                params.put("chausseA", chausseAA);
                params.put("carrefourA", carrefourAA);
                params.put("prioriteA", prioriteAA);
                params.put("user_id", String.valueOf(UserAccueil.CONNECTED_USER));
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
    }




}






