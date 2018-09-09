package esprit.tn.assuranceapp.Activities;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import esprit.tn.assuranceapp.DepannageActivity;
import esprit.tn.assuranceapp.ProfileActivity;
import esprit.tn.assuranceapp.R;

public class ProfileActivityy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_activityy);
        replaceFragment(new ProfileActivity());
    }

    public void replaceFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer2,fragment).commit();

    }

}
