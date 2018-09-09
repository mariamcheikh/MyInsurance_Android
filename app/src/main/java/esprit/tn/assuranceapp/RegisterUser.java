package esprit.tn.assuranceapp;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.view.View.OnClickListener;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.iid.FirebaseInstanceId;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import esprit.tn.assuranceapp.Activities.ProfileActivityy;
import esprit.tn.assuranceapp.Fragments.Constat.ConstatVoitureBFragment;
import esprit.tn.assuranceapp.Fragments.Contrat.ContratInfoPersoFragment;
import esprit.tn.assuranceapp.Fragments.Contrat.ContratPermisFragment;

public class RegisterUser extends AppCompatActivity {


    private EditText editTextUsername,editTextPassword,editTextEmail,editTextName,editTextPhone;
    private Button buttonRegister;
    private ProgressDialog progressDialog;
    private TextView textViewLogin;
    Calendar myCalendar = Calendar.getInstance();
    EditText txtDateNaiss;
    DatePickerDialog.OnDateSetListener date;
    EditText txtNcin;
    EditText txtPrenom;
    StringRequest stringRequest;
    RequestQueue requestQueue;



    String   ncin ,prenom,username,password,email,name,phone,naissance;

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        txtDateNaiss.setText(sdf.format(myCalendar.getTime()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        setTitle("Inscription");
//        super.onCreate(savedInstanceState);
       if(SharedPrefManager.getInstance(this).isLoggedIn()){

            //
           //((UserAccueil)getActivity()).replaceFragment(new ProfileActivity());
           startActivity(new Intent(RegisterUser.this,MainActivity.class ));
            //startActivity(new Intent(this, UserAccueil.class));
            return;
       }

        txtDateNaiss = (EditText) findViewById(R.id.txtDateNaiss);
        date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        txtNcin=(EditText) findViewById(R.id.txtNcin);
        txtPrenom=(EditText) findViewById(R.id.txtPrenom);

        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextPhone = (EditText) findViewById(R.id.editTextPhone);


        textViewLogin = (TextView)findViewById(R.id.textViewLogin);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);

        progressDialog = new ProgressDialog(this);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if (v == buttonRegister){

                    ncin = txtNcin.getText().toString();
                    prenom = txtPrenom.getText().toString();
                    username= editTextUsername.getText().toString();
                    password = editTextPassword.getText().toString();
                    email = editTextEmail.getText().toString();
                    name = editTextName.getText().toString();
                    phone = editTextPhone.getText().toString();
                    naissance = txtDateNaiss.getText().toString();


                    //if (validatncin(ncin) &&(validateprenom(prenom))&& (validateusername(username))&&(validatepassword(password))&&
                        //    (validateemail(email))&&(validatename(name))&&(validatephone(phone))&&(validatenaissance(naissance))) {

                    }
                    if (validateusername(username) &&(validatepassword(password))&&
                            (validateemail(email))&&(validatename(name))&&(validateprenom(prenom))&&(validatephone(phone))&&(validatncin(ncin))&&(validatenaissance(naissance))) {
                        RegisterUserr();
                    }


                   // replaceFragment(new ProfileActivity());
                    requestSOS(Constants.URL_CREATE_TOKEN,"token cree");
                  // finish();
                    //((UserAccueil)getActivity()).replaceFragment(new ProfileActivity());
                   // startActivity(new Intent(this, ProfileActivityy.class));
                   // replaceFragment(new ProfileActivity());
                   // (UserAccueil)replaceFragment(new ContratInfoPersoFragment());
                  //  ((ProfileActivityy)getActivity()));
                   // ((ProfileActivityy)getActivity()).replaceFragment(new ProfileActivity());


                   // ((ProfileActivityy)getActivity()).replaceFragment(new ProfileActivity());
                    //replaceFragment(new ProfileActivity());

                    //replaceFragment(new ProfileActivity());
                   // startActivity(new Intent(RegisterUser.this.getApplicationContext(), ProfileActivity.class));
                   // startActivity(new Intent(RegisterUser.this, ProfileActivity.class));
                    requestQueue = Volley.newRequestQueue(getApplicationContext());

                    requestQueue.add(stringRequest);
                }
            }
        );


        textViewLogin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v==textViewLogin){

                startActivity(new Intent(RegisterUser.this,MainActivity.class ));
            }
        }
    });


        txtDateNaiss.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            DatePickerDialog dpDialog =    new DatePickerDialog(RegisterUser.this, date, myCalendar
                    .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH));

            DatePicker datePicker = dpDialog.getDatePicker();

            Calendar calendar = Calendar.getInstance();//get the current day
            datePicker.setMaxDate(calendar.getTimeInMillis());//set the current day as the max date
            dpDialog.show();
        }
    });

}


    private void RegisterUserr(){

        final String email = editTextEmail.getText().toString().trim();
        final String password = editTextPassword.getText().toString().trim();
        final String username = editTextUsername.getText().toString().trim();
        final String name = editTextName.getText().toString().trim();
        final String phone = editTextPhone.getText().toString().trim();
        final String ncin = txtNcin.getText().toString().trim();
        final String prenom = txtPrenom.getText().toString().trim();
        final String dateNaiss = txtDateNaiss.getText().toString().trim();

        progressDialog.setMessage("Account Creation...");
        progressDialog.show();

        stringRequest = new StringRequest(Request.Method.POST,
                Constants.URL_REGISTER_Subscriber, response -> {

            progressDialog.dismiss();

            startActivity(new Intent(RegisterUser.this,MainActivity.class ));

            try {
                JSONObject jsonObject = new JSONObject(response);
                Toast.makeText(getApplicationContext(),jsonObject.getString("message"),Toast.LENGTH_LONG).show();
                editTextEmail.setText("");
                editTextPassword.setText("");
                editTextUsername.setText("");
                editTextName.setText("");
                editTextPhone.setText("");
                txtNcin.setText("");
                txtPrenom.setText("");
                txtDateNaiss.setText("");

            } catch (JSONException e) {
                Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                e.getMessage();
            }

        }, error -> {
            progressDialog.hide();
            Toast.makeText(getApplicationContext(),"Error==> "+error.getMessage(),Toast.LENGTH_LONG).show();
        }){
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("username",username);
                params.put("password",password);
                params.put("email",email);
                params.put("lname",name);
                params.put("phone",phone);
                params.put("ncin",ncin);
                params.put("birthdate",dateNaiss);
                params.put("fname",prenom);
                return params;
            }
        };


        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
    }




    private boolean validatncin(String string) {
        if (string.equals("")) {
            Toast.makeText(this," The field Identity Card Number cannot be empty",Toast.LENGTH_LONG).show();
            // Toast.makeText(Constat1Fragment.this, "Ce Champs cannot be empty", Toast.LENGTH_LONG).show();
            // lieu.setText("Ce Champs cannot be empty ");
            return false;
        } else if (string.length()!=8) {
            Toast.makeText(this,"8 Characters needed for the field Identity Card Number",Toast.LENGTH_LONG).show();
            // lieu.setText("Maximum 50 Characters");
            return false;
        }
        // til_username.setErrorEnabled(false);
        return true;
    }


    private boolean validatenaissance(String string) {
        if (string.equals("")) {
            Toast.makeText(this," The field naissance cannot be empty",Toast.LENGTH_LONG).show();
            // Toast.makeText(Constat1Fragment.this, "Ce Champs cannot be empty", Toast.LENGTH_LONG).show();
            // lieu.setText("Ce Champs cannot be empty ");
            return false;
        }
        // til_username.setErrorEnabled(false);
        return true;
    }


    private boolean validateusername(String string) {
        if (string.equals("")) {
            Toast.makeText(this," The field Username cannot be empty",Toast.LENGTH_LONG).show();
            // Toast.makeText(Constat1Fragment.this, "Ce Champs cannot be empty", Toast.LENGTH_LONG).show();
            // lieu.setText("Ce Champs cannot be empty ");
            return false;
        } else if (string.length() > 50) {
            Toast.makeText(this,"Maximum 50 Characters  for the field Username",Toast.LENGTH_LONG).show();
            // lieu.setText("Maximum 50 Characters");
            return false;
        } else if (string.length() < 3) {
            Toast.makeText(this,"Minimum 3 Characters for the field Username",Toast.LENGTH_LONG).show();
            //lieu.setText("Minimum 5 Characters");
            return false;
        }
        // til_username.setErrorEnabled(false);
        return true;
    }


    private boolean validateprenom(String string) {
        if (string.equals("")) {
            Toast.makeText(this," The field First Name cannot be empty",Toast.LENGTH_LONG).show();
            // Toast.makeText(Constat1Fragment.this, "Ce Champs cannot be empty", Toast.LENGTH_LONG).show();
            // lieu.setText("Ce Champs cannot be empty ");
            return false;
        } else if (string.length() > 50) {
            Toast.makeText(this,"Maximum 50 Characters  for the field First Name",Toast.LENGTH_LONG).show();
            // lieu.setText("Maximum 50 Characters");
            return false;
        } else if (string.length() < 3) {
            Toast.makeText(this,"Minimum 3 Characters for the field First Name",Toast.LENGTH_LONG).show();
            //lieu.setText("Minimum 5 Characters");
            return false;
        }
        // til_username.setErrorEnabled(false);
        return true;
    }

    private boolean validatepassword(String string) {
        if (string.equals("")) {
            Toast.makeText(this," The field Password cannot be empty",Toast.LENGTH_LONG).show();
            // Toast.makeText(Constat1Fragment.this, "Ce Champs cannot be empty", Toast.LENGTH_LONG).show();
            // lieu.setText("Ce Champs cannot be empty ");
            return false;
        }
        // til_username.setErrorEnabled(false);
        return true;
    }

    private boolean validateemail(String string) {
        if (string.equals("")) {
            Toast.makeText(this," The field Email cannot be empty",Toast.LENGTH_LONG).show();
            // Toast.makeText(Constat1Fragment.this, "Ce Champs cannot be empty", Toast.LENGTH_LONG).show();
            // lieu.setText("Ce Champs cannot be empty ");
            return false;
        }
        // til_username.setErrorEnabled(false);
        return true;
    }

    private boolean validatename(String string) {
        if (string.equals("")) {
            Toast.makeText(this," The field Last Name cannot be empty",Toast.LENGTH_LONG).show();
            // Toast.makeText(Constat1Fragment.this, "Ce Champs cannot be empty", Toast.LENGTH_LONG).show();
            // lieu.setText("Ce Champs cannot be empty ");
            return false;
        } else if (string.length() > 50) {
            Toast.makeText(this,"Maximum 50 Characters  for the field Last Name",Toast.LENGTH_LONG).show();
            // lieu.setText("Maximum 50 Characters");
            return false;
        } else if (string.length() < 3) {
            Toast.makeText(this,"Minimum 3 Characters for the field Last Name",Toast.LENGTH_LONG).show();
            //lieu.setText("Minimum 5 Characters");
            return false;
        }
        // til_username.setErrorEnabled(false);
        return true;
    }

    private boolean validatephone(String string) {
        if (string.equals("")) {
            Toast.makeText(this," The field Phone cannot be empty",Toast.LENGTH_LONG).show();
            // Toast.makeText(Constat1Fragment.this, "Ce Champs cannot be empty", Toast.LENGTH_LONG).show();
            // lieu.setText("Ce Champs cannot be empty ");
            return false;
              } else if ((string.length() != 8)) {
            Toast.makeText(this," 8 Characters Needed for the field Phone",Toast.LENGTH_LONG).show();
            //lieu.setText("Minimum 5 Characters");
            return false;
        }
        // til_username.setErrorEnabled(false);
        return true;
    }

    void requestSOS(String url, final String msg){
        final String ncin = txtNcin.getText().toString().trim();
        final String token= FirebaseInstanceId.getInstance().getToken();

        stringRequest = new StringRequest(Request.Method.POST, url,
                response -> {
                    System.out.println(response);

                   // startActivity(new Intent(RegisterUser.this,ProfileActivity.class ));
                   // Toast.makeText(getApplicationContext(),""+msg,Toast.LENGTH_SHORT).show();
                   // replaceFragment(new ProfileActivity());
                },
                error -> {
                    Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG).show();
                    Log.e("Tag= ",error.toString());
                })
        {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<>();
                params.put("ncin", ncin);
                params.put("tok", token);

                return params;
            }
        };

    }






}
