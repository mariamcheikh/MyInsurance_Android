package esprit.tn.assuranceapp.Fragments.Constat;


import android.app.DatePickerDialog;
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
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import esprit.tn.assuranceapp.Activities.Constat.ConstatActivity;
import esprit.tn.assuranceapp.R;
import esprit.tn.assuranceapp.UserAccueil;


/**
 * A simple {@link Fragment} subclass.
 */
public class ConstatVoitureAFragment extends Fragment {


    String vehiculeassures,contratassures,agences,attestationdus,attestationaus,nomConducteurs,prenomConducteurs,addresseConducteurs,permisConducteurs,
            permisdelivres,nomassures,prenomasures,addresseassures,telassures,marquevoitures,immatriculations,senssuiviss,venantdes,allantas,degatapparentss,
            observationss;


    Button btnnextBA,retour;
    EditText vehiculeassureA,contratassureA,agenceA,attestationduA,attestationauA,nomConducteurA,prenomConducteurA,addresseConducteurA,permisConducteurA,
            permisdelivreA,nomassureA,prenomasureA,addresseassureA,telassureA,marquevoitureA,immatriculationA,senssuivisA,venantdeA,allantaA,degatapparentsA,
            observationsA;


    Calendar calendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener dateattestationauA,dateattestationduA,permisdelivreleA;
    public ConstatVoitureAFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_constat_voiture_a, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        vehiculeassureA = view.findViewById(R.id.vehiculeassureA);
        contratassureA = view.findViewById(R.id.contratassureA);
        agenceA = view.findViewById(R.id.agenceA);
        attestationduA = view.findViewById(R.id.attestationduA);
        attestationauA = view.findViewById(R.id.attestationauA);
        nomConducteurA = view.findViewById(R.id.nomConducteurA);
        prenomConducteurA = view.findViewById(R.id.prenomConducteurA);
        addresseConducteurA = view.findViewById(R.id.addresseConducteurA);
        permisConducteurA = view.findViewById(R.id.permisConducteurA);
        permisdelivreA = view.findViewById(R.id.permisdelivreA);
        nomassureA = view.findViewById(R.id.nomassureA);
        prenomasureA = view.findViewById(R.id.prenomasureA);
        addresseassureA = view.findViewById(R.id.addresseassureA);
        telassureA = view.findViewById(R.id.telassureA);
        marquevoitureA = view.findViewById(R.id.marquevoitureA);
        immatriculationA = view.findViewById(R.id.immatriculationA);
        senssuivisA = view.findViewById(R.id.senssuivisA);
        venantdeA = view.findViewById(R.id.venantdeA);
        allantaA = view.findViewById(R.id.allantaA);
        degatapparentsA = view.findViewById(R.id.degatapparentsA);
        observationsA = view.findViewById(R.id.observationsA);
        btnnextBA = view.findViewById(R.id.btnnextBA);
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
             //////////////////////////////////////
            final String stationnement = bundle.getString("stationnement");
            final String quiterstationnement = bundle.getString("quiterstationnement");
            final String prenantstationnement = bundle.getString("prenantstationnement");
            final String sortantParking = bundle.getString("sortantParking");
            final  String engagerparking = bundle.getString("engagerparking");
            final  String arretcirculation = bundle.getString("arretcirculation");
            final String frottement = bundle.getString("frottement");
            final String heurtaitarriere = bundle.getString("heurtaitarriere");
            final String roulermemesens = bundle.getString("roulermemesens");
            final String changementfile = bundle.getString("changementfile");
            final  String doublait = bundle.getString("doublait");
            final  String viraitdroite = bundle.getString("viraitdroite");
            final String viraitgauche = bundle.getString("viraitgauche");
            final String reculait = bundle.getString("reculait");
            final String chausse = bundle.getString("chausse");
            final String carrefour = bundle.getString("carrefour");
            final  String priorite = bundle.getString("priorite");
             ///////////////////////////////////////////////////

            System.out.println(" date:"+date+" heure:"+heure+" lieu"+lieu+" blesse:"+blesse+" degat:"+degat+
                    " temoins:"+temoins+" vehiculeassure:"+vehiculeassure+" contratassure:"+contratassure+
                    " agence"+agence+" attestationdu:"+attestationdu+" attestationau:"+attestationau+
                    " nomConducteur:"+nomConducteur+" prenomConducteur:"+prenomConducteur+" addresseConducteur:"
                    +addresseConducteur+" permisConducteur"+permisConducteur+" permisdelivre:"+permisdelivre
                    +" nomassure:"+nomassure+" prenomasure:"+prenomasure+" addresseassure:"+addresseassure+
                    " telassure:"+telassure+" marquevoiture"+marquevoiture+
                    " immatriculation:"+immatriculation+" senssuivis:"+senssuivis+" venantde:"+venantde+
                    " allanta:"+allanta+" degatapparents:"+degatapparents+" observations"+observations+
                    " stationnement:"+stationnement+" quiterstationnement:"+quiterstationnement+
                    " prenantstationnement"+prenantstationnement+" sortantParking:"+sortantParking+" engagerparking:"+engagerparking+
                    " arretcirculation:"+arretcirculation+" frottement:"+frottement+" heurtaitarriere:"+heurtaitarriere+
                    " roulermemesens"+roulermemesens+" changementfile:"+changementfile+" doublait:"+doublait+
                    " viraitdroite:"+viraitdroite+" viraitgauche:"+viraitgauche+" reculait:"
                    +reculait+" chausse"+chausse+" carrefour:"+carrefour
                    +" priorite:"+priorite);


            dateattestationduA = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, monthOfYear);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                attestationdu();

            }
        };


        dateattestationauA = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, monthOfYear);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                attestationau();
            }
        };

        permisdelivreleA = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, monthOfYear);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                permisdelivrer();

            }
        };


        attestationduA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                DatePickerDialog dpDialog =  new DatePickerDialog(getActivity(), ConstatVoitureAFragment.this.dateattestationduA, calendar
                        .get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH));
                DatePicker datePicker = dpDialog.getDatePicker();

                Calendar calendar = Calendar.getInstance();//get the current day
                datePicker.setMaxDate(calendar.getTimeInMillis());//set the current day as the max date
                dpDialog.show();
            }
        });


        attestationauA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                DatePickerDialog dpDialog =    new DatePickerDialog(getActivity(), ConstatVoitureAFragment.this.dateattestationauA, calendar
                        .get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH));
                DatePicker datePicker = dpDialog.getDatePicker();

                Calendar calendar = Calendar.getInstance();//get the current day
                datePicker.setMaxDate(calendar.getTimeInMillis());//set the current day as the max date
                dpDialog.show();
            }
        });

        permisdelivreA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                DatePickerDialog dpDialog =   new DatePickerDialog(getActivity(), ConstatVoitureAFragment.this.permisdelivreleA, calendar
                        .get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH));
                DatePicker datePicker = dpDialog.getDatePicker();

                Calendar calendar = Calendar.getInstance();//get the current day
                datePicker.setMaxDate(calendar.getTimeInMillis());//set the current day as the max date
                dpDialog.show();
            }
        });



            retour.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CirconstanceBFragment CirconstanceBFragment = new CirconstanceBFragment();
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


                    ////////////////////////////////////////////////////
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
                    bundle.putString("viraitgauche",viraitgauche);
                    bundle.putString("reculait", reculait);
                    bundle.putString("chausse", chausse);
                    bundle.putString("carrefour", carrefour);
                    bundle.putString("priorite", priorite);



                    CirconstanceBFragment.setArguments(bundle);
                    FragmentManager manager = getFragmentManager();
                    manager.beginTransaction().replace(R.id.content,CirconstanceBFragment).commit();

                  //  ((ConstatActivity) getActivity()).replaceFragment(new CirconstanceBFragment());

                }
            });

        btnnextBA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                vehiculeassures= vehiculeassureA.getText().toString();
                contratassures = contratassureA.getText().toString();
                agences = agenceA.getText().toString();
                attestationdus  = attestationduA.getText().toString();

                attestationaus= attestationauA.getText().toString();
                nomConducteurs = nomConducteurA.getText().toString();
                prenomConducteurs = prenomConducteurA.getText().toString();
                addresseConducteurs = addresseConducteurA.getText().toString();

                permisConducteurs= permisConducteurA.getText().toString();
                permisdelivres = permisdelivreA.getText().toString();
                nomassures = nomassureA.getText().toString();
                prenomasures = prenomasureA.getText().toString();

                addresseassures= addresseassureA.getText().toString();
                telassures = telassureA.getText().toString();
                marquevoitures = marquevoitureA.getText().toString();
                immatriculations = immatriculationA.getText().toString();

                senssuiviss= senssuivisA.getText().toString();
                venantdes = venantdeA.getText().toString();
                allantas = allantaA.getText().toString();
                degatapparentss = degatapparentsA.getText().toString();
                observationss = observationsA.getText().toString();





                if (vehiculeassures(vehiculeassures) &&(contratassures(contratassures))&& (agences(agences))&&(attestationdus(attestationdus))&& (attestationaus(attestationaus))&&(nomConducteurs(nomConducteurs))
                        && (prenomConducteurs(prenomConducteurs))&&(addresseConducteurs(addresseConducteurs))&& (permisConducteurs(permisConducteurs))&&(permisdelivres(permisdelivres))&& (nomassures(nomassures))&&(prenomasures(prenomasures))&& (addresseassures(addresseassures))
                        &&(telassures(telassures))&& (marquevoitures(marquevoitures))&&(immatriculations(immatriculations))
                        && (senssuiviss(senssuiviss))&&(venantdes(venantdes))&& (allantas(allantas))&&(degatapparentss(degatapparentss))&& (observationss(observationss))
                        ) {


                    ((UserAccueil) getActivity()).replaceFragment(new CirconstanceAFragment());
                //((UserAccueil)getActivity()).replaceFragment(new ConstatVoitureAFragment());

                    CirconstanceAFragment circonstanceAFragment = new CirconstanceAFragment();
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
                    bundle.putString("vehiculeassureA", vehiculeassureA.getText().toString().replaceAll("'", "\\\\'"));
                    bundle.putString("contratassureA", contratassureA.getText().toString().replaceAll("'", "\\\\'"));
                    bundle.putString("agenceA", agenceA.getText().toString().replaceAll("'", "\\\\'"));
                    bundle.putString("attestationduA", attestationduA.getText().toString().replaceAll("'", "\\\\'"));
                    bundle.putString("attestationauA", attestationauA.getText().toString().replaceAll("'", "\\\\'"));
                    bundle.putString("nomConducteurA", nomConducteurA.getText().toString().replaceAll("'", "\\\\'"));
                    bundle.putString("prenomConducteurA", prenomConducteurA.getText().toString().replaceAll("'", "\\\\'"));
                    bundle.putString("addresseConducteurA", addresseConducteurA.getText().toString().replaceAll("'", "\\\\'"));
                    bundle.putString("permisConducteurA", permisConducteurA.getText().toString().replaceAll("'", "\\\\'"));
                    bundle.putString("permisdelivreA", permisdelivreA.getText().toString().replaceAll("'", "\\\\'"));
                    bundle.putString("nomassureA", nomassureA.getText().toString().replaceAll("'", "\\\\'"));
                    bundle.putString("prenomasureA", prenomasureA.getText().toString().replaceAll("'", "\\\\'"));
                    bundle.putString("addresseassureA", addresseassureA.getText().toString().replaceAll("'", "\\\\'"));
                    bundle.putString("telassureA", telassureA.getText().toString().replaceAll("'", "\\\\'"));
                    bundle.putString("marquevoitureA", marquevoitureA.getText().toString().replaceAll("'", "\\\\'"));
                    bundle.putString("immatriculationA", immatriculationA.getText().toString().replaceAll("'", "\\\\'"));
                    bundle.putString("senssuivisA", senssuivisA.getText().toString().replaceAll("'", "\\\\'"));
                    bundle.putString("venantdeA", venantdeA.getText().toString().replaceAll("'", "\\\\'"));
                    bundle.putString("allantaA", allantaA.getText().toString().replaceAll("'", "\\\\'"));
                    bundle.putString("degatapparentsA", degatapparentsA.getText().toString().replaceAll("'", "\\\\'"));
                    bundle.putString("observationsA", observationsA.getText().toString().replaceAll("'", "\\\\'"));

                    circonstanceAFragment.setArguments(bundle);
                    FragmentManager manager = getFragmentManager();
                    manager.beginTransaction().replace(R.id.content, circonstanceAFragment).commit();

                }

            }
        });

    }
    }
    private void attestationdu() {
        String myFormat = "MM/dd/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat);
        attestationduA.setText(sdf.format(calendar.getTime()));
    }

    private void attestationau() {
        String myFormat = "MM/dd/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat);
        attestationauA.setText(sdf.format(calendar.getTime()));
    }

    private void permisdelivrer() {
        String myFormat = "MM/dd/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat);
        permisdelivreA.setText(sdf.format(calendar.getTime()));
    }


    private boolean vehiculeassures(String string) {
        if (string.equals("")) {
            Toast.makeText(getActivity()," the Field Vehicle insured by cannot be empty",Toast.LENGTH_LONG).show();
            // Toast.makeText(Constat1Fragment.this, "Ce Champs cannot be empty", Toast.LENGTH_LONG).show();
            // lieu.setText("Ce Champs cannot be empty ");
            return false;
        } else if (string.length() > 15) {
            Toast.makeText(getActivity(),"Maximum 15 Characters for the Field Vehicle insured by",Toast.LENGTH_LONG).show();
            // lieu.setText("Maximum 50 Characters");
            return false;
        } else if (string.length() < 5) {
            Toast.makeText(getActivity(),"Minimum 5 Characters for the Field Vehicle insured by",Toast.LENGTH_LONG).show();
            //lieu.setText("Minimum 5 Characters");
            return false;
        }
        // til_username.setErrorEnabled(false);
        return true;
    }


    private boolean contratassures(String string) {
        if (string.equals("")) {
            Toast.makeText(getActivity()," the Field Insurance contract cannot be empty",Toast.LENGTH_LONG).show();
            // Toast.makeText(Constat1Fragment.this, "Ce Champs cannot be empty", Toast.LENGTH_LONG).show();
            // lieu.setText("Ce Champs cannot be empty ");
            return false;
        } else if (string.length() > 15) {
            Toast.makeText(getActivity(),"Maximum 15 Characters for the Field Insurance contract",Toast.LENGTH_LONG).show();
            // lieu.setText("Maximum 50 Characters");
            return false;
        } else if (string.length() < 5) {
            Toast.makeText(getActivity(),"Minimum 5 Characters for the Field Insurance contract ",Toast.LENGTH_LONG).show();
            //lieu.setText("Minimum 5 Characters");
            return false;
        }
        // til_username.setErrorEnabled(false);
        return true;
    }

    private boolean agences(String string) {
        if (string.equals("")) {
            Toast.makeText(getActivity()," the Field Agency cannot be empty",Toast.LENGTH_LONG).show();
            // Toast.makeText(Constat1Fragment.this, "Ce Champs cannot be empty", Toast.LENGTH_LONG).show();
            // lieu.setText("Ce Champs cannot be empty ");
            return false;
        } else if (string.length() > 15) {
            Toast.makeText(getActivity(),"Maximum 15 Characters for the Field Agency",Toast.LENGTH_LONG).show();
            // lieu.setText("Maximum 50 Characters");
            return false;
        } else if (string.length() < 5) {
            Toast.makeText(getActivity(),"Minimum 5 Characters  for the Field Agency",Toast.LENGTH_LONG).show();
            //lieu.setText("Minimum 5 Characters");
            return false;
        }
        // til_username.setErrorEnabled(false);
        return true;
    }

    private boolean attestationdus(String string) {
        if (string.equals("")) {
            Toast.makeText(getActivity()," the Field Certificate valid from cannot be empty",Toast.LENGTH_LONG).show();
            // Toast.makeText(Constat1Fragment.this, "Ce Champs cannot be empty", Toast.LENGTH_LONG).show();
            // lieu.setText("Ce Champs cannot be empty ");
            return false;
        } else if (string.length() > 15) {
            Toast.makeText(getActivity(),"Maximum 15 Characters  for the Field Certificate valid from",Toast.LENGTH_LONG).show();
            // lieu.setText("Maximum 50 Characters");
            return false;
        } else if (string.length() < 5) {
            Toast.makeText(getActivity(),"Minimum 5 Characters for the Field Certificate valid from",Toast.LENGTH_LONG).show();
            //lieu.setText("Minimum 5 Characters");
            return false;
        }
        // til_username.setErrorEnabled(false);
        return true;
    }

    private boolean attestationaus(String string) {
        if (string.equals("")) {
            Toast.makeText(getActivity()," the Field To cannot be empty",Toast.LENGTH_LONG).show();
            // Toast.makeText(Constat1Fragment.this, "Ce Champs cannot be empty", Toast.LENGTH_LONG).show();
            // lieu.setText("Ce Champs cannot be empty ");
            return false;
        } else if (string.length() > 15) {
            Toast.makeText(getActivity(),"Maximum 15 Characters for the Field To",Toast.LENGTH_LONG).show();
            // lieu.setText("Maximum 50 Characters");
            return false;
        } else if (string.length() < 5) {
            Toast.makeText(getActivity(),"Minimum 5 Characters for the Field To",Toast.LENGTH_LONG).show();
            //lieu.setText("Minimum 5 Characters");
            return false;
        }
        // til_username.setErrorEnabled(false);
        return true;
    }

    private boolean nomConducteurs(String string) {
        if (string.equals("")) {
            Toast.makeText(getActivity()," the Field Driver Lastname cannot be empty",Toast.LENGTH_LONG).show();
            // Toast.makeText(Constat1Fragment.this, "Ce Champs cannot be empty", Toast.LENGTH_LONG).show();
            // lieu.setText("Ce Champs cannot be empty ");
            return false;
        } else if (string.length() > 30) {
            Toast.makeText(getActivity(),"Maximum 30 Characters for the Field Driver Lastname",Toast.LENGTH_LONG).show();
            // lieu.setText("Maximum 50 Characters");
            return false;
        } else if (string.length() < 5) {
            Toast.makeText(getActivity(),"Minimum 5 Characters for the Field Driver Lastname",Toast.LENGTH_LONG).show();
            //lieu.setText("Minimum 5 Characters");
            return false;
        }
        // til_username.setErrorEnabled(false);
        return true;
    } private boolean prenomConducteurs(String string) {
        if (string.equals("")) {
            Toast.makeText(getActivity()," the Field Driver Firstname  cannot be empty",Toast.LENGTH_LONG).show();
            // Toast.makeText(Constat1Fragment.this, "Ce Champs cannot be empty", Toast.LENGTH_LONG).show();
            // lieu.setText("Ce Champs cannot be empty ");
            return false;
        } else if (string.length() > 30) {
            Toast.makeText(getActivity(),"Maximum 30 Characters for the Field Driver Firstname",Toast.LENGTH_LONG).show();
            // lieu.setText("Maximum 50 Characters");
            return false;
        } else if (string.length() < 5) {
            Toast.makeText(getActivity(),"Minimum 5 Characters for the Field Driver Firstname",Toast.LENGTH_LONG).show();
            //lieu.setText("Minimum 5 Characters");
            return false;
        }
        // til_username.setErrorEnabled(false);
        return true;
    }
    private boolean addresseConducteurs(String string) {
        if (string.equals("")) {
            Toast.makeText(getActivity(),"the Field Driver address cannot be empty",Toast.LENGTH_LONG).show();
            // Toast.makeText(Constat1Fragment.this, "Ce Champs cannot be empty", Toast.LENGTH_LONG).show();
            // lieu.setText("Ce Champs cannot be empty ");
            return false;
        } else if (string.length() > 40) {
            Toast.makeText(getActivity(),"Maximum 40 Characters for the Field Driver address",Toast.LENGTH_LONG).show();
            // lieu.setText("Maximum 50 Characters");
            return false;
        } else if (string.length() < 5) {
            Toast.makeText(getActivity(),"Minimum 5 Characters for the Field Driver address",Toast.LENGTH_LONG).show();
            //lieu.setText("Minimum 5 Characters");
            return false;
        }
        // til_username.setErrorEnabled(false);
        return true;
    }
    private boolean permisConducteurs(String string) {
        if (string.equals("")) {
            Toast.makeText(getActivity(),"the Field  Driver's license number cannot be empty",Toast.LENGTH_LONG).show();
            // Toast.makeText(Constat1Fragment.this, "Ce Champs cannot be empty", Toast.LENGTH_LONG).show();
            // lieu.setText("Ce Champs cannot be empty ");
            return false;
        } else if (string.length() != 6) {
            Toast.makeText(getActivity(),"6 Characters  needed for the Field Driver's license number ",Toast.LENGTH_LONG).show();
            // lieu.setText("Maximum 50 Characters");
            return false;
        }
        // til_username.setErrorEnabled(false);
        return true;
    }
    private boolean permisdelivres(String string) {
        if (string.equals("")) {
            Toast.makeText(getActivity(),"the Field issued on cannot be empty",Toast.LENGTH_LONG).show();
            // Toast.makeText(Constat1Fragment.this, "Ce Champs cannot be empty", Toast.LENGTH_LONG).show();
            // lieu.setText("Ce Champs cannot be empty ");
            return false;
        } else if (string.length() > 15) {
            Toast.makeText(getActivity(),"Maximum 15 Characters for the Field issued on",Toast.LENGTH_LONG).show();
            // lieu.setText("Maximum 50 Characters");
            return false;
        } else if (string.length() < 5) {
            Toast.makeText(getActivity(),"Minimum 5 Characters for the Field issued on",Toast.LENGTH_LONG).show();
            //lieu.setText("Minimum 5 Characters");
            return false;
        }
        // til_username.setErrorEnabled(false);
        return true;
    }
    private boolean nomassures(String string) {
        if (string.equals("")) {
            Toast.makeText(getActivity(),"the Field lnsured lastname  cannot be empty",Toast.LENGTH_LONG).show();
            // Toast.makeText(Constat1Fragment.this, "Ce Champs cannot be empty", Toast.LENGTH_LONG).show();
            // lieu.setText("Ce Champs cannot be empty ");
            return false;
        } else if (string.length() > 15) {
            Toast.makeText(getActivity(),"Maximum 15 Characters for the Field lnsured lastname",Toast.LENGTH_LONG).show();
            // lieu.setText("Maximum 50 Characters");
            return false;
        } else if (string.length() < 3) {
            Toast.makeText(getActivity(),"Minimum 3 Characters for the Field lnsured lastname",Toast.LENGTH_LONG).show();
            //lieu.setText("Minimum 5 Characters");
            return false;
        }
        // til_username.setErrorEnabled(false);
        return true;
    }

    private boolean prenomasures(String string) {
        if (string.equals("")) {
            Toast.makeText(getActivity(),"the Field lnsured firstname asures cannot be empty",Toast.LENGTH_LONG).show();
            // Toast.makeText(Constat1Fragment.this, "Ce Champs cannot be empty", Toast.LENGTH_LONG).show();
            // lieu.setText("Ce Champs cannot be empty ");
            return false;
        } else if (string.length() > 15) {
            Toast.makeText(getActivity(),"Maximum 15 Characters for the Field lnsured firstname",Toast.LENGTH_LONG).show();
            // lieu.setText("Maximum 50 Characters");
            return false;
        } else if (string.length() < 5) {
            Toast.makeText(getActivity(),"Minimum 5 Characters for the Field lnsured firstname",Toast.LENGTH_LONG).show();
            //lieu.setText("Minimum 5 Characters");
            return false;
        }
        // til_username.setErrorEnabled(false);
        return true;
    }

    private boolean addresseassures(String string) {
        if (string.equals("")) {
            Toast.makeText(getActivity()," the Field lnsured address cannot be empty",Toast.LENGTH_LONG).show();
            // Toast.makeText(Constat1Fragment.this, "Ce Champs cannot be empty", Toast.LENGTH_LONG).show();
            // lieu.setText("Ce Champs cannot be empty ");
            return false;
        } else if (string.length() > 15) {
            Toast.makeText(getActivity(),"Maximum 50 Characters for the Field lnsured address",Toast.LENGTH_LONG).show();
            // lieu.setText("Maximum 50 Characters");
            return false;
        } else if (string.length() < 5) {
            Toast.makeText(getActivity(),"Minimum 5 Characters for the Field lnsured address",Toast.LENGTH_LONG).show();
            //lieu.setText("Minimum 5 Characters");
            return false;
        }
        // til_username.setErrorEnabled(false);
        return true;
    } private boolean telassures(String string) {
        if (string.equals("")) {
            Toast.makeText(getActivity()," the Field lnsured Phone cannot be empty",Toast.LENGTH_LONG).show();
            // Toast.makeText(Constat1Fragment.this, "Ce Champs cannot be empty", Toast.LENGTH_LONG).show();
            // lieu.setText("Ce Champs cannot be empty ");
            return false;
        } else if (string.length() > 12) {
            Toast.makeText(getActivity(),"Maximum 12 Characters for the Field lnsured Phone",Toast.LENGTH_LONG).show();
            // lieu.setText("Maximum 50 Characters");
            return false;
        } else if (string.length() != 8) {
            Toast.makeText(getActivity()," 8 Characters for the Field  lnsured Phone",Toast.LENGTH_LONG).show();
            //lieu.setText("Minimum 5 Characters");
            return false;
        }
        // til_username.setErrorEnabled(false);
        return true;
    }

    private boolean marquevoitures(String string) {
        if (string.equals("")) {
            Toast.makeText(getActivity()," the Field vehicule Brand cannot be empty",Toast.LENGTH_LONG).show();
            // Toast.makeText(Constat1Fragment.this, "Ce Champs cannot be empty", Toast.LENGTH_LONG).show();
            // lieu.setText("Ce Champs cannot be empty ");
            return false;
        } else if (string.length() > 15) {
            Toast.makeText(getActivity(),"Maximum 15 Characters for the Field Brand",Toast.LENGTH_LONG).show();
            // lieu.setText("Maximum 50 Characters");
            return false;
        } else if (string.length() < 5) {
            Toast.makeText(getActivity(),"Minimum 5 Characters for the Field brand",Toast.LENGTH_LONG).show();
            //lieu.setText("Minimum 5 Characters");
            return false;
        }
        // til_username.setErrorEnabled(false);
        return true;
    }

    private boolean immatriculations(String string) {
        if (string.equals("")) {
            Toast.makeText(getActivity(),"the Field  Registration number cannot be empty",Toast.LENGTH_LONG).show();
            // Toast.makeText(Constat1Fragment.this, "Ce Champs cannot be empty", Toast.LENGTH_LONG).show();
            // lieu.setText("Ce Champs cannot be empty ");
            return false;
        } else if (string.length() > 15) {
            Toast.makeText(getActivity(),"Maximum 15 Characters for the Field Registration number",Toast.LENGTH_LONG).show();
            // lieu.setText("Maximum 50 Characters");
            return false;
        } else if (string.length() < 5) {
            Toast.makeText(getActivity(),"Minimum 5 Characters for the Field Registration number",Toast.LENGTH_LONG).show();
            //lieu.setText("Minimum 5 Characters");
            return false;
        }
        // til_username.setErrorEnabled(false);
        return true;
    }

    private boolean senssuiviss(String string) {
        if (string.equals("")) {
            Toast.makeText(getActivity()," the Field Sense followed cannot be empty",Toast.LENGTH_LONG).show();
            // Toast.makeText(Constat1Fragment.this, "Ce Champs cannot be empty", Toast.LENGTH_LONG).show();
            // lieu.setText("Ce Champs cannot be empty ");
            return false;
        } else if (string.length() > 15) {
            Toast.makeText(getActivity(),"Maximum 15 Characters for the Field Sense followed",Toast.LENGTH_LONG).show();
            // lieu.setText("Maximum 50 Chthe Fieldaracters");
            return false;
        } else if (string.length() < 5) {
            Toast.makeText(getActivity(),"Minimum 5 Characters for the Field Sense followed",Toast.LENGTH_LONG).show();
            //lieu.setText("Minimum 5 Characters");
            return false;
        }
        // til_username.setErrorEnabled(false);
        return true;
    }
    private boolean venantdes(String string) {
        if (string.equals("")) {
            Toast.makeText(getActivity(),"the Field coming from cannot be empty",Toast.LENGTH_LONG).show();
            // Toast.makeText(Constat1Fragment.this, "Ce Champs cannot be empty", Toast.LENGTH_LONG).show();
            // lieu.setText("Ce Champs cannot be empty ");
            return false;
        } else if (string.length() > 15) {
            Toast.makeText(getActivity(),"Maximum 15 Characters for the Field coming from",Toast.LENGTH_LONG).show();
            // lieu.setText("Maximum 50 Characters");
            return false;
        } else if (string.length() < 5) {
            Toast.makeText(getActivity(),"Minimum 5 Characters for the Field coming from",Toast.LENGTH_LONG).show();
            //lieu.setText("Minimum 5 Characters");
            return false;
        }
        // til_username.setErrorEnabled(false);
        return true;
    }

    private boolean allantas(String string) {
        if (string.equals("")) {
            Toast.makeText(getActivity()," the Field Going to cannot be empty",Toast.LENGTH_LONG).show();
            // Toast.makeText(Constat1Fragment.this, "Ce Champs cannot be empty", Toast.LENGTH_LONG).show();
            // lieu.setText("Ce Champs cannot be empty ");
            return false;
        } else if (string.length() > 15) {
            Toast.makeText(getActivity(),"Maximum 15 Characters for the Field Going to",Toast.LENGTH_LONG).show();
            // lieu.setText("Maximum 50 Characters");
            return false;
        } else if (string.length() < 5) {
            Toast.makeText(getActivity(),"Minimum 5 Characters for the Field Going to",Toast.LENGTH_LONG).show();
            //lieu.setText("Minimum 5 Characters");
            return false;
        }
        // til_username.setErrorEnabled(false);
        return true;
    }

    private boolean degatapparentss(String string) {
        if (string.equals("")) {
            Toast.makeText(getActivity()," the Field obvious Damage cannot be empty",Toast.LENGTH_LONG).show();
            // Toast.makeText(Constat1Fragment.this, "Ce Champs cannot be empty", Toast.LENGTH_LONG).show();
            // lieu.setText("Ce Champs cannot be empty ");
            return false;
        } else if (string.length() > 50) {
            Toast.makeText(getActivity(),"Maximum 50 Characters for the Field obvious Damage",Toast.LENGTH_LONG).show();
            // lieu.setText("Maximum 50 Characters");
            return false;
        } else if (string.length() < 5) {
            Toast.makeText(getActivity(),"Minimum 5 Characters for the Field obvious Damage",Toast.LENGTH_LONG).show();
            //lieu.setText("Minimum 5 Characters");
            return false;
        }
        // til_username.setErrorEnabled(false);
        return true;
    }

    private boolean observationss(String string) {
        if (string.equals("")) {
            Toast.makeText(getActivity(),"the Field observations cannot be empty",Toast.LENGTH_LONG).show();
            // Toast.makeText(Constat1Fragment.this, "Ce Champs cannot be empty", Toast.LENGTH_LONG).show();
            // lieu.setText("Ce Champs cannot be empty ");
            return false;
        } else if (string.length() > 50) {
            Toast.makeText(getActivity(),"Maximum 50 Characters for the Field observations",Toast.LENGTH_LONG).show();
            // lieu.setText("Maximum 50 Characters");
            return false;
        } else if (string.length() < 5) {
            Toast.makeText(getActivity(),"Minimum 5 Characters for the Field observations",Toast.LENGTH_LONG).show();
            //lieu.setText("Minimum 5 Characters");
            return false;
        }
        // til_username.setErrorEnabled(false);
        return true;
    }
}
