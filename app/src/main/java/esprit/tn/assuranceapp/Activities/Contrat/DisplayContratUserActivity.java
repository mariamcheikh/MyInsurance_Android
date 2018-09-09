package esprit.tn.assuranceapp.Activities.Contrat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.android.volley.request.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import esprit.tn.assuranceapp.Adapters.Contrat.ContratUserAdapter;
import esprit.tn.assuranceapp.Constants;
import esprit.tn.assuranceapp.Models.Contrat;
import esprit.tn.assuranceapp.R;
import esprit.tn.assuranceapp.SharedPrefManager;

public class DisplayContratUserActivity extends AppCompatActivity {

    //public final int  CONNECTED_USER_CIN = SharedPrefManager.getInstance(this).getUserCIN();
     String CONNECTED_USER_CIN ;

    List<Contrat> contratList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CONNECTED_USER_CIN = SharedPrefManager.getInstance(this).getNcin();
        setContentView(R.layout.activity_display_contrat_user);
        //getting the recyclerview from xml
        recyclerView =(RecyclerView) findViewById(R.id.recylcerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        contratList = new ArrayList<>();
        loadContrats();
    }


    private void loadContrats() {

        /*
        * Creating a String Request
        * The request type is GET defined by first parameter
        * The URL is defined in the second parameter
        * Then we have a Response Listener and a Error Listener
        * In response listener we will get the JSON response as a String
        * */
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Constants.URL_DISPLAY_CONTRAT_USER+CONNECTED_USER_CIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            //converting the string to json array object
                            JSONArray array = new JSONArray(response);

                            //traversing through all the object
                            for (int i = 0; i < array.length(); i++) {
                                //getting product object from json array
                                JSONObject contrat = array.getJSONObject(i);


                                contratList.add(new Contrat(
                                        contrat.getString("serial_num"),
                                        contrat.getString("marque"),
                                        contrat.getString("modele"),
                                        contrat.getString("energie"),
                                        contrat.getInt("cv_fiscaux"),
                                        contrat.getString("immat"),
                                        contrat.getString("date_circul")


                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            ContratUserAdapter adapter = new ContratUserAdapter(DisplayContratUserActivity.this, contratList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                error -> {

                });

        //adding our stringrequest to queue
        // Volley.newRequestQueue(this).add(stringRequest);


        stringRequest.setShouldCache(false);

        RequestQueue queue = Volley.newRequestQueue(this.getApplicationContext());
        queue.add(stringRequest);

    }
}
