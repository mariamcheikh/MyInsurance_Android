package esprit.tn.assuranceapp.Activities.Contrat;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Field;

import esprit.tn.assuranceapp.Fragments.Contrat.ContratInfoPersoFragment;
import esprit.tn.assuranceapp.R;
import esprit.tn.assuranceapp.SharedPrefManager;
import esprit.tn.assuranceapp.UserAccueil;


/*
public class ContratActivity extends Fragment {
    public  static  String CONNECTED_USER_CIN;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_contrat, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //setContentView(R.layout.activity_contrat);
        //setTitle("Contrat");
        CONNECTED_USER_CIN = SharedPrefManager.getInstance(getActivity()).getNcin();
        //CONNECTED_USER_CIN =  getIntent().get("CONNECTED_USER_CIN",null);
        System.out.println("connecteduser_cin"+CONNECTED_USER_CIN);
        ((UserAccueil)getActivity()).replaceFragment(new ContratInfoPersoFragment());
        //new UserAccueil().replaceFragment(new ContratInfoPersoFragment());p
    }

    public void replaceFragment(Fragment fragment){
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content,fragment).commit();
    }

}
*/

public class ContratActivity extends AppCompatActivity {
    public  static  String CONNECTED_USER_CIN;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contrat);
        setTitle("Contract");

        CONNECTED_USER_CIN = SharedPrefManager.getInstance(this).getNcin();
        //CONNECTED_USER_CIN = SharedPrefManager.getInstance(this).getNcin();
        System.out.println("connecteduser_cin"+CONNECTED_USER_CIN);
        (this).replaceFragment(new ContratInfoPersoFragment());
        //System.out.println("connecteduser_constat"+CONNECTED_USER_CIN);
        //replaceFragment(new ContratInfoPersoFragment());
    }

    public void replaceFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontratContainer,fragment).commit();

    }








}
