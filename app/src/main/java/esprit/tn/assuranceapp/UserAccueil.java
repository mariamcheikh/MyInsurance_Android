package esprit.tn.assuranceapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.util.Preconditions;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import java.lang.reflect.Field;

import esprit.tn.assuranceapp.Activities.Constat.ConstatActivity;
import esprit.tn.assuranceapp.Activities.Contrat.ContratActivity;
import esprit.tn.assuranceapp.Fragments.Constat.Constat1Fragment;
import esprit.tn.assuranceapp.Fragments.Contrat.ContratInfoPersoFragment;
import esprit.tn.assuranceapp.Fragments.Contrat.ContratPermisFragment;

public class UserAccueil extends AppCompatActivity {
    public  static  String CONNECTED_USER_CIN;
    public  static  int CONNECTED_USER;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            CONNECTED_USER = SharedPrefManager.getInstance(UserAccueil.this).getUserID();
            CONNECTED_USER_CIN = SharedPrefManager.getInstance(UserAccueil.this).getNcin();
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    replaceFragment(new ContratInfoPersoFragment());
                   // startActivity(new Intent(UserAccueil.this,ContratInfoPersoFragment.class));
                   // replaceFragment(new ContratActivity());
                    return true;
                case R.id.navigation_dashboard:
                   // startActivity(new Intent(UserAccueil.this,ConstatActivity.class));
                   replaceFragment(new Constat1Fragment());
                    return true;
                case R.id.navigation_notifications:
                    replaceFragment(new DepannageActivity());
                    return true;
                case R.id.navigation_profile:
                    CONNECTED_USER = SharedPrefManager.getInstance(UserAccueil.this).getUserID();
                    CONNECTED_USER_CIN = SharedPrefManager.getInstance(UserAccueil.this).getNcin();
                    replaceFragment(new ProfileActivity());
                    return true;}
            return false;}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_user_accueil);
        setTitle("Accueil");

        CONNECTED_USER_CIN = SharedPrefManager.getInstance(this).getNcin();
        System.out.println("connecteduser_cin"+CONNECTED_USER_CIN);

        CONNECTED_USER =  SharedPrefManager.getInstance(this).getUserID();
        System.out.println("connecteduser_constat"+CONNECTED_USER);


       // startActivity(new Intent(UserAccueil.this,ContratInfoPersoFragment.class));
       replaceFragment(new ContratInfoPersoFragment());
//        startActivity(new Intent(UserAccueil.this,ContratInfoPersoFragment.class));
      // startActivity(new Intent(UserAccueil.this,ContratActivity.class));
        //replaceFragment(new ContratActivity());
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


    public void replaceFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.content,Fragment.instantiate(UserAccueil.this, fragment.getClass().getName())).commit();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
