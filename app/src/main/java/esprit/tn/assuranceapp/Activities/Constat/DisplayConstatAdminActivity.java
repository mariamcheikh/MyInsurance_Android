package esprit.tn.assuranceapp.Activities.Constat;

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

import esprit.tn.assuranceapp.Adapters.Constat.ConstatAdminAdapter;
import esprit.tn.assuranceapp.Constants;
import esprit.tn.assuranceapp.Models.Constat;
import esprit.tn.assuranceapp.R;

public class DisplayConstatAdminActivity extends AppCompatActivity {


    List<Constat> constatList;

    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_constat_admin);

        //getting the recyclerview from xml
        recyclerView =(RecyclerView) findViewById(R.id.recylcerView);
      recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        constatList = new ArrayList<>();
        loadConstats();
    }

    private void loadConstats() {

        /*
        * Creating a String Request
        * The request type is GET defined by first parameter
        * The URL is defined in the second parameter
        * Then we have a Response Listener and a Error Listener
        * In response listener we will get the JSON response as a String
        * */
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Constants.URL_DISPLAY_CONSTAT_ADMIN,
                response -> {
                    try {
                        //converting the string to json array object
                        JSONArray array = new JSONArray(response);

                        //traversing through all the object
                        for (int i = 0; i < array.length(); i++) {
                         //getting product object from json array
                            JSONObject constat = array.getJSONObject(i);

                            //adding the product to product list
                            constatList.add(new Constat(
                                    constat.getString("date"),
                                    constat.getString("lieu"),
                                    constat.getString("nomConducteur"),
                                    constat.getString("prenomConducteur"),
                                    constat.getString("marquevoiture"),
                                    constat.getString("immatriculation"),
                                    constat.getString("nomConducteurA"),
                                    constat.getString("prenomConducteurA"),
                                    constat.getString("marquevoitureA"),
                                 constat.getString("immatriculationA")
                            ));
                        }

                        //creating adapter object and setting it to recyclerview
                        ConstatAdminAdapter adapter = new ConstatAdminAdapter(DisplayConstatAdminActivity.this, constatList);
                        recyclerView.setAdapter(adapter);
                    } catch (JSONException e) {
                        e.printStackTrace();
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
