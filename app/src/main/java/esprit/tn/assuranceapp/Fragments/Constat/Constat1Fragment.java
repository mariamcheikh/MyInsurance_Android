package esprit.tn.assuranceapp.Fragments.Constat;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
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
import android.widget.Switch;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import esprit.tn.assuranceapp.Activities.Constat.ConstatActivity;
import esprit.tn.assuranceapp.R;
import esprit.tn.assuranceapp.UserAccueil;


/**
 * A simple {@link Fragment} subclass.
 */
public class Constat1Fragment extends Fragment {

Button btnnext;
    int hour,minute;
    EditText lieu ,temoins,dateTxt,txtheure;
    String blesseon ="Non" ,degaton ="Non";
    String Lieux,Temoins,Dates,Heures;
    Switch blesse,degatmateriel;
    Calendar calendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener date;
    TimePickerDialog.OnTimeSetListener heure;
    public Constat1Fragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_constat1, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtheure = view.findViewById(R.id.heure);
        btnnext= view.findViewById(R.id.next);
        lieu = view.findViewById(R.id.lieu);
        temoins = view.findViewById(R.id.temoins);
        blesse = view.findViewById(R.id.blesse);
        degatmateriel = view.findViewById(R.id.degat);
        dateTxt = view.findViewById(R.id.dateTxt);

        //blesseon = view.findViewById(R.id.blesseon);
       //degaton = view.findViewById(R.id.degaton);





               date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, monthOfYear);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateEditText();
            }
        };

        /*heure = new TimePickerDialog.OnTimeSetListener() {

            @Override
            public void onDateSet(TimePicker view, int hour, int minute) {
                // TODO Auto-generated method stub
                calendar.set(Calendar.YEAR, hour);
                calendar.set(Calendar.MONTH, minute);

                updateEditheureText();
            }
        };*/


        dateTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub


                DatePickerDialog dpDialog =   new DatePickerDialog(getActivity(), Constat1Fragment.this.date, calendar
                        .get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH));

                DatePicker datePicker = dpDialog.getDatePicker();

                Calendar calendar = Calendar.getInstance();//get the current day
                datePicker.setMaxDate(calendar.getTimeInMillis());//set the current day as the max date
                dpDialog.show();
            }
        });

        /*dateTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(getActivity(), Constat1Fragment.this.date, calendar
                        .get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });*/



        txtheure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar cal = Calendar.getInstance();
                hour = cal.get(Calendar.HOUR);
                minute = cal.get(Calendar.MINUTE);

                TimePickerDialog timepickerdialog = new TimePickerDialog(getContext(),
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int hour , int minute) {
                                txtheure.setText(hour+":"+minute);
                            }
                        }, hour, minute, true);

                timepickerdialog.show();



            }
        });



        blesse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean on = ((Switch) v).isChecked();
                if(on)
                {
                    blesseon="Oui";

                }
                else
                {
                    blesseon="Non";
                }
            }


        });



        degatmateriel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean on = ((Switch) v).isChecked();
                if(on)
                {
                    degaton="Oui";

                }
                else
                {
                    degaton="Non";

                }
            }


        });


        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Lieux= lieu.getText().toString();
                Temoins = temoins.getText().toString();
                Dates = dateTxt.getText().toString();
                Heures = txtheure.getText().toString();



                if (validatDates(Dates) &&(validatHeures(Heures))&& (validateLieu(Lieux))&&(validateTemoins(Temoins)))
                {
                ((UserAccueil)getActivity()).replaceFragment(new ConstatVoitureBFragment());

        ConstatVoitureBFragment voitureBFragment = new ConstatVoitureBFragment();
        Bundle bundle = new Bundle();
        bundle.putString("date", dateTxt.getText().toString());
        bundle.putString("heure", txtheure.getText().toString());
        bundle.putString("lieu", lieu.getText().toString().replaceAll("'", "\\\\'"));
        bundle.putString("blesse", blesseon);
        bundle.putString("degat", degaton);
        bundle.putString("temoins", temoins.getText().toString().replaceAll("'", "\\\\'"));
        voitureBFragment.setArguments(bundle);
        FragmentManager manager = getFragmentManager();
        manager.beginTransaction().replace(R.id.content,voitureBFragment).commit();

    }
        }
});


    }


    private boolean validateLieu(String string) {
        if (string.equals("")) {
            Toast.makeText(getActivity(),"Place cannot be empty",Toast.LENGTH_LONG).show();
             // Toast.makeText(Constat1Fragment.this, "Ce Champs ne doit pas être vide", Toast.LENGTH_LONG).show();
           // lieu.setText("Ce Champs ne doit pas être vide ");
            return false;
        } else if (string.length() > 15) {
            Toast.makeText(getActivity(),"Maximum 15 Characters for the Field Place",Toast.LENGTH_LONG).show();
           // lieu.setText("Maximum 50 Characters");
            return false;
        } else if (string.length() < 5) {
            Toast.makeText(getActivity(),"Minimum 5 Characters for the Field Place",Toast.LENGTH_LONG).show();
            //lieu.setText("Minimum 5 Characters");
            return false;
        }
        // til_username.setErrorEnabled(false);
        return true;
    }


    private boolean validateTemoins(String string) {
        if (string.equals("")) {
            Toast.makeText(getActivity()," witnesse cannot be empty",Toast.LENGTH_LONG).show();
            // Toast.makeText(Constat1Fragment.this, "Ce Champs ne doit pas être vide", Toast.LENGTH_LONG).show();
            // lieu.setText("Ce Champs ne doit pas être vide ");
            return false;
        } else if (string.length() > 15) {
            Toast.makeText(getActivity(),"Maximum 15 Characters for the Field witnesse",Toast.LENGTH_LONG).show();
            // lieu.setText("Maximum 50 Characters");
            return false;
        } else if (string.length() < 6) {
            Toast.makeText(getActivity(),"Minimum 6 Characters for the Field witnesse ",Toast.LENGTH_LONG).show();
            //lieu.setText("Minimum 5 Characters");
            return false;
        }
        // til_username.setErrorEnabled(false);
        return true;
    }

    private boolean validatDates(String string) {
        if (string.equals("")) {
            Toast.makeText(getActivity()," date cannot be empty",Toast.LENGTH_LONG).show();
            // Toast.makeText(Constat1Fragment.this, "Ce Champs ne doit pas être vide", Toast.LENGTH_LONG).show();
            // lieu.setText("Ce Champs ne doit pas être vide ");
            return false;
        } else if (string.length() > 15) {
            Toast.makeText(getActivity(),"Maximum 15 Characters for the Field date",Toast.LENGTH_LONG).show();
            // lieu.setText("Maximum 50 Characters");
            return false;
        } else if (string.length() < 5) {
            Toast.makeText(getActivity(),"Minimum 5 Characters for the Field date",Toast.LENGTH_LONG).show();
            //lieu.setText("Minimum 5 Characters");
            return false;
        }
        // til_username.setErrorEnabled(false);
        return true;
    }

    private boolean validatHeures(String string) {
        if (string.equals("")) {
            Toast.makeText(getActivity()," hour cannot be empty",Toast.LENGTH_LONG).show();
            // Toast.makeText(Constat1Fragment.this, "Ce Champs ne doit pas être vide", Toast.LENGTH_LONG).show();
            // lieu.setText("Ce Champs ne doit pas être vide ");
            return false;
        } else if (string.length() > 15) {
            Toast.makeText(getActivity(),"Maximum 15 Characters for the Field hour",Toast.LENGTH_LONG).show();
            // lieu.setText("Maximum 50 Characters");
            return false;
        } else if (string.length() < 3) {
            Toast.makeText(getActivity(),"Minimum 3 for the Field hour",Toast.LENGTH_LONG).show();
            //lieu.setText("Minimum 5 Characters");
            return false;
        }
        // til_username.setErrorEnabled(false);
        return true;
    }

    private void updateEditText() {
        String myFormat = "MM/dd/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat);
        dateTxt.setText(sdf.format(calendar.getTime()));
    }


  /*  private void updateEditheureText() {
        String myFormat = "HH/MM";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat);
        txtheure.setText(sdf.format(calendar.getTime()));
    }
*/




}
