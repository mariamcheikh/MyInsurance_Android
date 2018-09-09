package esprit.tn.assuranceapp.Fragments.Constat;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import esprit.tn.assuranceapp.Activities.Constat.ConstatActivity;
import esprit.tn.assuranceapp.R;
import esprit.tn.assuranceapp.UserAccueil;

/**
 * A simple {@link Fragment} subclass.
 */
public class CirconstanceBFragment extends Fragment {

    String stationnementValue ="Non",quiterstationnementValue="Non",prenantstationnementValue="Non",sortantParkingValue="Non",engagerparkingValue="Non",arretcirculationValue="Non",
            frottementValue="Non",heurtaitarriereValue="Non",roulermemesensValue="Non",changementfileValue="Non",doublaitValue="Non",viraitdroiteValue="Non",viraitgaucheValue="Non",reculaitValue="Non"
            ,chausseValue="Non",carrefourValue="Non",prioriteValue="Non";


CheckBox stationnement,quiterstationnement,prenantstationnement,sortantParking,engagerparking,arretcirculation,
        frottement,heurtaitarriere,roulermemesens,changementfile,doublait,viraitdroite,viraitgauche,reculait,
        chausse,carrefour,priorite;
    Button btnnextA,retour;

    public CirconstanceBFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_circonstance_b, container, false);



    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        stationnement = view.findViewById(R.id.stationnement);
        quiterstationnement = view.findViewById(R.id.quiterstationnement);
        prenantstationnement = view.findViewById(R.id.prenantstationnement);
        sortantParking = view.findViewById(R.id.sortantParking);
        engagerparking = view.findViewById(R.id.engagerparking);
        arretcirculation = view.findViewById(R.id.arretcirculation);
        frottement = view.findViewById(R.id.frottement);
        heurtaitarriere = view.findViewById(R.id.heurtaitarriere);
        roulermemesens = view.findViewById(R.id.roulermemesens);
        changementfile = view.findViewById(R.id.changementfile);
        doublait = view.findViewById(R.id.doublait);
        viraitdroite = view.findViewById(R.id.viraitdroite);
        viraitgauche = view.findViewById(R.id.viraitgauche);
        reculait = view.findViewById(R.id.reculait);
        chausse = view.findViewById(R.id.chausse);
        carrefour = view.findViewById(R.id.carrefour);
        priorite = view.findViewById(R.id.priorite);

        btnnextA = view.findViewById(R.id.btnnextA);
        retour = view.findViewById(R.id.retour);

        Bundle bundle = getArguments();
        if (bundle!= null)
        {
            final String date = bundle.getString("date");
            final String heure = bundle.getString("heure");
            final String lieu = bundle.getString("lieu");
            final String blesse = bundle.getString("blesse");
            final  String degat = bundle.getString("degat");
            final  String temoins = bundle.getString("temoins");

            ////////////////////////////////////////////////

            final String vehiculeassure = bundle.getString("vehiculeassure");
            final String contratassure = bundle.getString("contratassure");
            final String agence = bundle.getString("agence");
            final String attestationdu = bundle.getString("attestationdu");
            final  String attestationau = bundle.getString("attestationau");
            final  String nomConducteur = bundle.getString("nomConducteur");
            final String prenomConducteur = bundle.getString("prenomConducteur");
            final String addresseConducteur = bundle.getString("addresseConducteur");
            final String permisConducteur = bundle.getString("permisConducteur");
            final String permisdelivre = bundle.getString("permisdelivre");
            final  String nomassure = bundle.getString("nomassure");
            final  String prenomasure = bundle.getString("prenomasure");
            final String addresseassure = bundle.getString("addresseassure");
            final String telassure = bundle.getString("telassure");
            final String marquevoiture = bundle.getString("marquevoiture");
            final String immatriculation = bundle.getString("immatriculation");
            final  String senssuivis = bundle.getString("senssuivis");
            final  String venantde = bundle.getString("venantde");
            final String allanta = bundle.getString("allanta");
            final  String degatapparents = bundle.getString("degatapparents");
            final  String observations = bundle.getString("observations");

            /////////////////////////////////////////////////////////////////////////:


System.out.println(" date:"+date+" heure:"+heure+" lieu"+lieu+" blesse:"+blesse+" degat:"+degat+
        " temoins:"+temoins+" vehiculeassure:"+vehiculeassure+" contratassure:"+contratassure+
        " agence"+agence+" attestationdu:"+attestationdu+" attestationau:"+attestationau+
  " nomConducteur:"+nomConducteur+" prenomConducteur:"+prenomConducteur+" addresseConducteur:"
        +addresseConducteur+" permisConducteur"+permisConducteur+" permisdelivre:"+permisdelivre
        +" nomassure:"+nomassure+" prenomasure:"+prenomasure+" addresseassure:"+addresseassure+
        " telassure:"+telassure+" marquevoiture"+marquevoiture+
        " immatriculation:"+immatriculation+" senssuivis:"+senssuivis+" venantde:"+venantde+
        " allanta:"+allanta+" degatapparents:"+degatapparents+" observations"+observations);


            retour.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    ConstatVoitureBFragment voitureBFragment = new ConstatVoitureBFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("date", date);
                    bundle.putString("heure", heure);
                    bundle.putString("lieu", lieu);
                    bundle.putString("blesse", blesse);
                    bundle.putString("degat", degat);
                    bundle.putString("temoins", temoins);
/////////////////////////////////////////////////////////////////////////
                    bundle.putString("vehiculeassure",vehiculeassure);
                    bundle.putString("contratassure", contratassure);
                    bundle.putString("agence", agence);
                    bundle.putString("attestationdu", attestationdu);
                    bundle.putString("attestationau", attestationau);
                    bundle.putString("nomConducteur", nomConducteur);
                    bundle.putString("prenomConducteur",prenomConducteur);
                    bundle.putString("addresseConducteur", addresseConducteur);
                    bundle.putString("permisConducteur", permisConducteur);
                    bundle.putString("permisdelivre", permisdelivre);
                    bundle.putString("nomassure", nomassure);
                    bundle.putString("prenomasure", prenomasure);
                    bundle.putString("addresseassure", addresseassure);
                    bundle.putString("telassure", telassure);
                    bundle.putString("marquevoiture",marquevoiture);
                    bundle.putString("immatriculation", immatriculation);
                    bundle.putString("senssuivis",senssuivis);
                    bundle.putString("venantde", venantde);
                    bundle.putString("allanta", allanta);
                    bundle.putString("degatapparents",degatapparents);
                    bundle.putString("observations", observations);



                    voitureBFragment.setArguments(bundle);
                    FragmentManager manager = getFragmentManager();
                    manager.beginTransaction().replace(R.id.content,voitureBFragment).commit();


                }
            });

        btnnextA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((UserAccueil)getActivity()).replaceFragment(new ConstatVoitureAFragment());

                ConstatVoitureAFragment constatVoitureAFragment = new ConstatVoitureAFragment();
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
                bundle.putString("stationnement", stationnementValue);
                bundle.putString("quiterstationnement", quiterstationnementValue);
                bundle.putString("prenantstationnement", prenantstationnementValue);
                bundle.putString("sortantParking", sortantParkingValue);
                bundle.putString("engagerparking", engagerparkingValue);
                bundle.putString("arretcirculation", arretcirculationValue);
                bundle.putString("frottement", frottementValue);
                bundle.putString("heurtaitarriere", heurtaitarriereValue);
                bundle.putString("roulermemesens", roulermemesensValue);
                bundle.putString("changementfile", changementfileValue);
                bundle.putString("doublait", doublaitValue);
                bundle.putString("viraitdroite", viraitdroiteValue);
                bundle.putString("viraitgauche",viraitgaucheValue);
                bundle.putString("reculait", reculaitValue);
                bundle.putString("chausse", chausseValue);
                bundle.putString("carrefour", carrefourValue);
                bundle.putString("priorite", prioriteValue);

               constatVoitureAFragment.setArguments(bundle);
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.content,constatVoitureAFragment).commit();
            }
        });

            stationnement.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean on = ((CheckBox) v).isChecked();
                    if(on)
                    {
                        stationnementValue="Oui";

                    }
                    else
                    {
                        stationnementValue="Non";
                    }
                }
            });

            quiterstationnement.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean on = ((CheckBox) v).isChecked();
                    if(on)
                    {
                        quiterstationnementValue="Oui";

                    }
                    else
                    {
                        quiterstationnementValue="Non";
                    }
                }
            });
            prenantstationnement.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean on = ((CheckBox) v).isChecked();
                    if(on)
                    {
                        prenantstationnementValue="Oui";

                    }
                    else
                    {
                        prenantstationnementValue="Non";
                    }
                }
            });
            sortantParking.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean on = ((CheckBox) v).isChecked();
                    if(on)
                    {
                        sortantParkingValue="Oui";

                    }
                    else
                    {
                        sortantParkingValue="Non";
                    }
                }
            });
            engagerparking.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean on = ((CheckBox) v).isChecked();
                    if(on)
                    {
                        engagerparkingValue="Oui";

                    }
                    else
                    {
                        engagerparkingValue="Non";
                    }
                }
            });
            arretcirculation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean on = ((CheckBox) v).isChecked();
                    if(on)
                    {
                        arretcirculationValue="Oui";

                    }
                    else
                    {
                        arretcirculationValue="Non";
                    }
                }
            });
            frottement.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean on = ((CheckBox) v).isChecked();
                    if(on)
                    {
                        frottementValue="Oui";

                    }
                    else
                    {
                        frottementValue="Non";
                    }
                }
            });

            heurtaitarriere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean on = ((CheckBox) v).isChecked();
                if(on)
                {
                    heurtaitarriereValue="Oui";

                }
                else
                {
                    heurtaitarriereValue="Non";
                }
            }
        });
            roulermemesens.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean on = ((CheckBox) v).isChecked();
                    if(on)
                    {
                        roulermemesensValue="Oui";

                    }
                    else
                    {
                        roulermemesensValue="Non";
                    }
                }
            });
            changementfile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean on = ((CheckBox) v).isChecked();
                    if(on)
                    {
                        changementfileValue="Oui";

                    }
                    else
                    {
                        changementfileValue="Non";
                    }
                }
            });


            doublait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean on = ((CheckBox) v).isChecked();
                if(on)
                {
                    doublaitValue="Oui";

                }
                else
                {
                    doublaitValue="Non";
                }
            }
        });

            viraitdroite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean on = ((CheckBox) v).isChecked();
                if(on)
                {
                    viraitdroiteValue="Oui";

                }
                else
                {
                    viraitdroiteValue="Non";
                }
            }
        });

            viraitgauche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean on = ((CheckBox) v).isChecked();
                if(on)
                {
                    viraitgaucheValue="Oui";

                }
                else
                {
                    viraitgaucheValue="Non";
                }
            }
        });


            reculait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean on = ((CheckBox) v).isChecked();
                if(on)
                {
                    reculaitValue="Oui";

                }
                else
                {
                    reculaitValue="Non";
                }
            }
        });

            chausse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean on = ((CheckBox) v).isChecked();
                if(on)
                {
                    chausseValue="Oui";

                }
                else
                {
                    chausseValue="Non";
                }
            }
        });

            carrefour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean on = ((CheckBox) v).isChecked();
                if(on)
                {
                    carrefourValue="Oui";

                }
                else
                {
                    carrefourValue="Non";
                }
            }
        });





            priorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean on = ((CheckBox) v).isChecked();
                if(on)
                {
                    prioriteValue="Oui";

                }
                else
                {
                    prioriteValue="Non";
                }
            }
        });




        }

    }
}
