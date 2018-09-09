package esprit.tn.assuranceapp;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamza FAIZA on 05/01/2018.
 */

public class DashPagerAdapter extends FragmentPagerAdapter {

    public final List<Fragment> fragments = new ArrayList<>();

    public DashPagerAdapter(FragmentManager fm, int NumOfTabs) {

        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    int mNumOfTabs;

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0: {
                return DepannageActivity.newInstance("sdfsdfsdfsdf");
            }
            case 1: {
                return Fragment1.newInstance("adfsdfsfd");
            }

            case 2: {
                return Fragment2.newInstance("adfsdfsfd");
            }
            case 3: {
                return Fragment1.newInstance("abcd");

            }
            default:
                return null;

        }
    }

    public void addFragment(Fragment fragment) {
        fragments.add(fragment);
        notifyDataSetChanged();
    }

    @Override
    public boolean isViewFromObject(final View view, final Object object) {
        return view == object;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
