package esprit.tn.assuranceapp.Activities.Constat;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import esprit.tn.assuranceapp.Fragments.Constat.Constat1Fragment;
import esprit.tn.assuranceapp.Fragments.Contrat.ContratInfoPersoFragment;
import esprit.tn.assuranceapp.R;
import esprit.tn.assuranceapp.SharedPrefManager;
import esprit.tn.assuranceapp.UserAccueil;


public class ConstatActivity extends AppCompatActivity {
public  static  int CONNECTED_USER;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constat);
        setTitle("Accident Report");
        CONNECTED_USER =  SharedPrefManager.getInstance(this).getUserID();
        System.out.println("connecteduser_constat"+CONNECTED_USER);
        replaceFragment(new Constat1Fragment());
    }



    public void replaceFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,fragment).commit();

    }








}
