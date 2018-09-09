package esprit.tn.assuranceapp;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import esprit.tn.assuranceapp.Activities.Constat.ConstatActivity;
import esprit.tn.assuranceapp.Activities.Contrat.ContratActivity;

public class ProfileActivity extends Fragment {

    public  int  CONNECTED_USER;
    public  String  CONNECTED_USER_CIN;
    TextView textViewUsername,textViewemail,textViewlname,textViewphone,textViewbirthdate,textViewncin,textViewUserfname;;
    Button buttonLogout,BouttonConstat,BouttonContrat;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         CONNECTED_USER = SharedPrefManager.getInstance(getActivity()).getUserID();
        CONNECTED_USER_CIN = SharedPrefManager.getInstance(getActivity()).getNcin();
        return inflater.inflate(R.layout.activity_profile, container, false);

    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_profile);
        //setTitle("Profile");


        if(!SharedPrefManager.getInstance(getActivity().getBaseContext()).isLoggedIn()){
            //finalize();
            //finish();
            startActivity(new Intent(getActivity().getBaseContext(), MainActivity.class));
        }


        textViewUsername = (TextView)getView().findViewById(R.id.textViewUsername);
        textViewemail = (TextView) getView().findViewById(R.id.textViewEmail);
        textViewlname = (TextView)getView().findViewById(R.id.nom);
        textViewUserfname = (TextView) getView().findViewById(R.id.prenom);
        textViewphone = (TextView) getView().findViewById(R.id.phone);
        textViewncin = (TextView) getView().findViewById(R.id.ncin);


        buttonLogout = (Button) getView().findViewById(R.id.buttonLogout);
        BouttonConstat = ( Button) getView().findViewById(R.id.buttonConstat);

        BouttonContrat = ( Button)  getView().findViewById(R.id.bouttonContrat);


        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v==buttonLogout)
                {
                    SharedPrefManager.getInstance(getActivity().getApplicationContext()).logout();
                    //finish();
                    startActivity(new Intent(getActivity().getApplicationContext(),MainActivity.class));
                }

            }
        });


        BouttonConstat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ( v== BouttonConstat){

                    Intent i = new Intent(getActivity().getApplicationContext() , ConstatActivity.class);
                    // Log.i("CONNECTED_USER", CONNECTED_USER);
                    System.out.println("hhhhh"+CONNECTED_USER);
                    i.putExtra("CONNECTED_USER",CONNECTED_USER);
                    startActivity(i);
                    //startActivity(new Intent(getActivity().getApplicationContext(),ConstatActivity.class ));
                }

            }
        });



        BouttonContrat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ( v== BouttonContrat){

                    Intent i = new Intent(getActivity().getApplicationContext() , ContratActivity.class);
                    // Log.i("CONNECTED_USER", CONNECTED_USER);
                    System.out.println("hhhhhcin"+CONNECTED_USER_CIN);
                    i.putExtra("CONNECTED_USER_CIN",CONNECTED_USER_CIN);

                    startActivity(i);

                   // startActivity(new Intent(getActivity().getApplicationContext(),ContratActivity.class ));
                    //((UserAccueil)getActivity()).replaceFragment(new ContratPermisFragment());
                }


            }
        });



        textViewUsername.setText(SharedPrefManager.getInstance(getActivity().getApplicationContext()).getUserName());
        textViewemail.setText(SharedPrefManager.getInstance(getActivity().getApplicationContext()).getUserEmail());
        textViewlname.setText(SharedPrefManager.getInstance(getActivity().getApplicationContext()).getlname());
        textViewphone.setText(SharedPrefManager.getInstance(getActivity().getApplicationContext()).getphone());
        textViewncin.setText(SharedPrefManager.getInstance(getActivity().getApplicationContext()).getNcin());
        textViewUserfname.setText(SharedPrefManager.getInstance(getActivity().getApplicationContext()).getfname());


    }


}
