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
public class ConstatVoitureBFragment extends Fragment {

String vehiculeassures,contratassures,agences,attestationdus,attestationaus,nomConducteurs,prenomConducteurs,addresseConducteurs,permisConducteurs,
        permisdelivres,nomassures,prenomasures,addresseassures,telassures,marquevoitures,immatriculations,senssuiviss,venantdes,allantas,degatapparentss,
        observationss;


    Button btnnextB,retour;
EditText vehiculeassure,contratassure,agence,attestationdu,attestationau,nomConducteur,prenomConducteur,addresseConducteur,permisConducteur,
        permisdelivre,nomassure,prenomasure,addresseassure,telassure,marquevoiture,immatriculation,senssuivis,venantde,allanta,degatapparents,
        observations;
    Calendar calendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener dateattestationau,dateattestationdu,permisdelivrele;


    public ConstatVoitureBFragment() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_constat_voiture_b, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        vehiculeassure = view.findViewById(R.id.vehiculeassure);
        contratassure = view.findViewById(R.id.contratassure);
        agence = view.findViewById(R.id.agence);
        attestationdu = view.findViewById(R.id.attestationdu);
        attestationau = view.findViewById(R.id.attestationau);
        nomConducteur = view.findViewById(R.id.nomConducteur);
        prenomConducteur = view.findViewById(R.id.prenomConducteur);
        addresseConducteur = view.findViewById(R.id.addresseConducteur);
        permisConducteur = view.findViewById(R.id.permisConducteur);
        permisdelivre = view.findViewById(R.id.permisdelivre);
        nomassure = view.findViewById(R.id.nomassure);
        prenomasure = view.findViewById(R.id.prenomasure);
        addresseassure = view.findViewById(R.id.addresseassure);
        telassure = view.findViewById(R.id.telassure);
        marquevoiture = view.findViewById(R.id.marquevoiture);
        immatriculation = view.findViewById(R.id.immatriculation);
        senssuivis = view.findViewById(R.id.senssuivis);
        venantde = view.findViewById(R.id.venantde);
        allanta = view.findViewById(R.id.allanta);
        degatapparents = view.findViewById(R.id.degatapparents);
        observations = view.findViewById(R.id.observations);
        btnnextB = view.findViewById(R.id.btnnextB);
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

            System.out.println(" date:"+date+" heure:"+heure+" lieu"+lieu+" blesse:"+blesse+" degat:"+degat+" temoins:"+temoins);

        dateattestationdu = new DatePickerDialog.OnDateSetListener() {

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


        dateattestationau = new DatePickerDialog.OnDateSetListener() {

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

        permisdelivrele = new DatePickerDialog.OnDateSetListener() {

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


        attestationdu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                DatePickerDialog dpDialog =    new DatePickerDialog(getActivity(), ConstatVoitureBFragment.this.dateattestationdu, calendar
                        .get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH));

                DatePicker datePicker = dpDialog.getDatePicker();

                Calendar calendar = Calendar.getInstance();//get the current day
                datePicker.setMaxDate(calendar.getTimeInMillis());//set the current day as the max date
                dpDialog.show();
            }
        });

            attestationau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                DatePickerDialog dpDialog =  new DatePickerDialog(getActivity(), ConstatVoitureBFragment.this.dateattestationau, calendar
                        .get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH));
                DatePicker datePicker = dpDialog.getDatePicker();

                Calendar calendar = Calendar.getInstance();//get the current day
                datePicker.setMaxDate(calendar.getTimeInMillis());//set the current day as the max date
                dpDialog.show();
            }
        });

        permisdelivre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                DatePickerDialog dpDialog =     new DatePickerDialog(getActivity(), ConstatVoitureBFragment.this.permisdelivrele, calendar
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



                    Constat1Fragment Constat1Fragment = new Constat1Fragment();
                    Bundle bundle = new Bundle();
                    System.out.println("test retour");
                    bundle.putString("date", date);
                    bundle.putString("heure", heure);
                    bundle.putString("lieu", lieu);
                    bundle.putString("blesse", blesse);
                    bundle.putString("degat", degat);
                    bundle.putString("temoins", temoins);
                    Constat1Fragment.setArguments(bundle);
                    FragmentManager manager = getFragmentManager();
                    manager.beginTransaction().replace(R.id.content,Constat1Fragment).commit();


//                    ((ConstatActivity) getActivity()).replaceFragment(new Constat1Fragment());

                }
            });

            btnnextB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    vehiculeassures= vehiculeassure.getText().toString();
                    contratassures = contratassure.getText().toString();
                    agences = agence.getText().toString();
                    attestationdus  = attestationdu.getText().toString();

                    attestationaus= attestationau.getText().toString();
                    nomConducteurs = nomConducteur.getText().toString();
                    prenomConducteurs = prenomConducteur.getText().toString();
                    addresseConducteurs = addresseConducteur.getText().toString();

                    permisConducteurs= permisConducteur.getText().toString();
                    permisdelivres = permisdelivre.getText().toString();
                    nomassures = nomassure.getText().toString();
                    prenomasures = prenomasure.getText().toString();

                    addresseassures= addresseassure.getText().toString();
                    telassures = telassure.getText().toString();
                    marquevoitures = marquevoiture.getText().toString();
                    immatriculations = immatriculation.getText().toString();

                    senssuiviss= senssuivis.getText().toString();
                    venantdes = venantde.getText().toString();
                    allantas = allanta.getText().toString();
                    degatapparentss = degatapparents.getText().toString();
                    observationss = observations.getText().toString();





                    if (vehiculeassures(vehiculeassures) &&(contratassures(contratassures))&& (agences(agences))&&(attestationdus(attestationdus))&& (attestationaus(attestationaus))&&(nomConducteurs(nomConducteurs))
                            && (prenomConducteurs(prenomConducteurs))&&(addresseConducteurs(addresseConducteurs))&& (permisConducteurs(permisConducteurs))&&(permisdelivres(permisdelivres))&& (nomassures(nomassures))&&(prenomasures(prenomasures))&& (addresseassures(addresseassures))
                            &&(telassures(telassures))&& (marquevoitures(marquevoitures))&&(immatriculations(immatriculations))
                            && (senssuiviss(senssuiviss))&&(venantdes(venantdes))&& (allantas(allantas))&&(degatapparentss(degatapparentss))&& (observationss(observationss))
                            ) {


                        ((UserAccueil) getActivity()).replaceFragment(new CirconstanceBFragment());

                        CirconstanceBFragment circonstancevoitureBFragment = new CirconstanceBFragment();

                        Bundle bundle = new Bundle();
                        bundle.putString("date", date);
                        bundle.putString("heure", heure);
                        bundle.putString("lieu", lieu);
                        bundle.putString("blesse", blesse);
                        bundle.putString("degat", degat);
                        bundle.putString("temoins", temoins);
                        ///////////////////////////////////////////////////////////////////
                        bundle.putString("vehiculeassure", vehiculeassure.getText().toString().replaceAll("'", "\\\\'"));
                        bundle.putString("contratassure", contratassure.getText().toString().replaceAll("'", "\\\\'"));
                        bundle.putString("agence", agence.getText().toString().replaceAll("'", "\\\\'"));
                        bundle.putString("attestationdu", attestationdu.getText().toString().replaceAll("'", "\\\\'"));
                        bundle.putString("attestationau", attestationau.getText().toString().replaceAll("'", "\\\\'"));
                        bundle.putString("nomConducteur", nomConducteur.getText().toString().replaceAll("'", "\\\\'"));
                        bundle.putString("prenomConducteur", prenomConducteur.getText().toString().replaceAll("'", "\\\\'"));
                        bundle.putString("addresseConducteur", addresseConducteur.getText().toString().replaceAll("'", "\\\\'"));
                        bundle.putString("permisConducteur", permisConducteur.getText().toString().replaceAll("'", "\\\\'"));
                        bundle.putString("permisdelivre", permisdelivre.getText().toString().replaceAll("'", "\\\\'"));
                        bundle.putString("nomassure", nomassure.getText().toString().replaceAll("'", "\\\\'"));
                        bundle.putString("prenomasure", prenomasure.getText().toString().replaceAll("'", "\\\\'"));
                        bundle.putString("addresseassure", addresseassure.getText().toString().replaceAll("'", "\\\\'"));
                        bundle.putString("telassure", telassure.getText().toString().replaceAll("'", "\\\\'"));
                        bundle.putString("marquevoiture", marquevoiture.getText().toString().replaceAll("'", "\\\\'"));
                        bundle.putString("immatriculation", immatriculation.getText().toString().replaceAll("'", "\\\\'"));
                        bundle.putString("senssuivis", senssuivis.getText().toString().replaceAll("'", "\\\\'"));
                        bundle.putString("venantde", venantde.getText().toString().replaceAll("'", "\\\\'"));
                        bundle.putString("allanta", allanta.getText().toString().replaceAll("'", "\\\\'"));
                        bundle.putString("degatapparents", degatapparents.getText().toString().replaceAll("'", "\\\\'"));
                        bundle.putString("observations", observations.getText().toString().replaceAll("'", "\\\\'"));

                        circonstancevoitureBFragment.setArguments(bundle);
                        FragmentManager manager = getFragmentManager();
                        manager.beginTransaction().replace(R.id.content, circonstancevoitureBFragment).commit();



                   }


               }
            });

    }

    }




    private void attestationdu() {
        String myFormat = "MM/dd/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat);
        attestationdu.setText(sdf.format(calendar.getTime()));
    }

    private void attestationau() {
        String myFormat = "MM/dd/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat);
        attestationau.setText(sdf.format(calendar.getTime()));
    }

    private void permisdelivrer() {
        String myFormat = "MM/dd/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat);
        permisdelivre.setText(sdf.format(calendar.getTime()));
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
