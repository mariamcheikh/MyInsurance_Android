package esprit.tn.assuranceapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import esprit.tn.assuranceapp.Activities.ProfileActivityy;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUsername,editTextPassword;
    TextView textViewRegister;
    private Button buttonLogin;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ///
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        ///
        setContentView(R.layout.activity_main);
        //setTitle("Login");
        if(SharedPrefManager.getInstance(this).isLoggedIn()){
            if(SharedPrefManager.getInstance(this).getUserName().equals("hamzaFAIZA")){
                startActivity(new Intent(getApplicationContext(),AdminAccueil1.class));
            }else {
                finish();
                startActivity(new Intent(this, UserAccueil.class));
            }
            return;
        }

        editTextUsername = (EditText)findViewById(R.id.editTextUsername);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonLogin = (Button)findViewById(R.id.buttonLogin);
        textViewRegister = (TextView)findViewById(R.id.textViewRegister);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait ...");

        // progressDialog.show();
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == buttonLogin){
                    UserLogin();
                }

            }
        });


        textViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ( v== textViewRegister){

                    startActivity(new Intent(MainActivity.this,RegisterUser.class ));
                }
            }
        });
    }

    private void UserLogin(){
        final String username = editTextUsername.getText().toString().trim();
        final String password = editTextPassword.getText().toString().trim();

        progressDialog.show();

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                Constants.URL_LOGIN,
                response -> {
                    progressDialog.dismiss();
                    try {
                       JSONObject obj = new JSONObject(response);
                        if (!obj.getBoolean("error")){
                        JSONObject object = obj.getJSONObject("subscriber");
                        SharedPrefManager.getInstance(getApplicationContext()).userLogin(
                                object.getInt("id"),
                                object.getString("username"),
                                object.getString("email"),
                                object.getString("phone"),
                                object.getString("fname"),
                                object.getString("lname"),
                                object.getString("ncin")


                        );
                            if(username.equals("hamzaFAIZA")){
                                startActivity(new Intent(getApplicationContext(),AdminAccueil1.class));
                            }else {
                                startActivity(new Intent(getApplicationContext(),UserAccueil.class));
                            }

                            //finish();
                            //System.out.println("ouiii");
                            Toast.makeText(getApplicationContext(),"User Login Successfull",Toast.LENGTH_LONG).show();

                        }else {
                            // JSONObject object1 = obj.getJSONObject("message");
                            System.out.println("Non");
                            Toast.makeText(getApplicationContext(),"error"+obj.getString("message"),Toast.LENGTH_SHORT).show();

                        }


                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(getApplicationContext(),"catch error",Toast.LENGTH_SHORT).show();
                    }


                },
                error -> {
                    progressDialog.dismiss();

                    Toast.makeText(
                            getApplicationContext(),
                            error.getMessage(),
                            Toast.LENGTH_LONG
                    ).show();
                }
        ){
            @Override
            protected Map<String, String> getParams()  {
                Map<String, String> params = new HashMap<>();
                params.put("username",username);
                params.put("password",password);

                return params;
            }

        };


        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
    }
}
