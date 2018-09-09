package esprit.tn.assuranceapp;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import devlight.io.library.ntb.NavigationTabBar;

public class HorizontalNtbActivity extends Activity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_ntb);
        initUI();
    }

    private void initUI() {
        final ViewPager viewPager = (ViewPager) findViewById(R.id.vp_horizontal_ntb);
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return 5;
            }

            @Override
            public boolean isViewFromObject(final View view, final Object object) {
                return view.equals(object);
            }

            @Override
            public void destroyItem(final View container, final int position, final Object object) {
                ((ViewPager) container).removeView((View) object);
            }

            @Override
            public Object instantiateItem(final ViewGroup container, final int position) {
                View view = LayoutInflater.from(
                        getBaseContext()).inflate(R.layout.item_vp, null, false);

                Toast.makeText(getApplicationContext(),"instantiateItem pos ="+position,Toast.LENGTH_LONG).show();

                /*FragmentTransaction transaction = getFragmentManager().beginTransaction();
                if(position == 0){
                    transaction.replace(R.id.my_container, new Fragment1());
                    transaction.addToBackStack("a");
                    transaction.commit();
                }else {
                    if (position == 1) {
                        transaction.replace(R.id.my_container, new DepannageActivity());
                        transaction.addToBackStack("b");
                        transaction.commit();
                    } else {
                        if (position == 2) {
                            transaction.replace(R.id.my_container, new Fragment2());
                            transaction.addToBackStack("c");
                            transaction.commit();
                        } else {
                            if (position == 3) {
                                transaction.replace(R.id.my_container, new ProfileActivity());
                                transaction.addToBackStack("d");
                                transaction.commit();
                            }else{
                                if (position == 4) {
                                    transaction.replace(R.id.my_container, new Fragment2());
                                    transaction.addToBackStack("d");
                                    transaction.commit();
                                }else{
                                    transaction.replace(R.id.my_container, new Fragment2());
                                    transaction.addToBackStack("d");
                                    transaction.commit();
                                }
                            }
                        }
                    }
                }*/

                final TextView txtPage = (TextView) view.findViewById(R.id.txt_vp_item_page);
                txtPage.setText(String.format("Page #%d", position));

                container.addView(view);
                return view;
            }
        });

        final String[] colors = getResources().getStringArray(R.array.default_preview);

        final NavigationTabBar navigationTabBar = (NavigationTabBar) findViewById(R.id.ntb_horizontal);
        final ArrayList<NavigationTabBar.Model> models = new ArrayList<>();
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_first),
                        Color.parseColor(colors[0]))
                        .selectedIcon(getResources().getDrawable(R.drawable.ic_sixth))
                        .title("Tresorie")
                        .badgeTitle("NTB")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_second),
                        Color.parseColor(colors[1]))
//                        .selectedIcon(getResources().getDrawable(R.drawable.ic_eighth))
                        .title("Vehicules")
                        .badgeTitle("with")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_third),
                        Color.parseColor(colors[2]))
                        .selectedIcon(getResources().getDrawable(R.drawable.ic_seventh))
                        .title("E-Constat")
                        .badgeTitle("state")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_fourth),
                        Color.parseColor(colors[3]))
//                        .selectedIcon(getResources().getDrawable(R.drawable.ic_eighth))
                        .title("SOS")
                        .badgeTitle("icon")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.profile),
                        Color.parseColor(colors[4]))
                        .selectedIcon(getResources().getDrawable(R.drawable.profile))
                        .title("Profil")
                        .badgeTitle("777")
                        .build()
        );

        navigationTabBar.setModels(models);
        navigationTabBar.setViewPager(viewPager, 0);
        navigationTabBar.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {
                //Toast.makeText(getApplicationContext(),"Actual position= "+positionOffset,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageSelected(final int position) {
                navigationTabBar.getModels().get(position).hideBadge();
                Toast.makeText(getApplicationContext(),"onPageSelected possition= "+position,Toast.LENGTH_LONG).show();

                //FragmentTransaction transaction = getFragmentManager().beginTransaction();
                //Toast.makeText(getApplicationContext(),"Actual position= "+position,Toast.LENGTH_SHORT).show();

                /*
                if(position == 0){
                    transaction.replace(R.id.my_container, new Fragment1());
                    transaction.addToBackStack("a");
                    transaction.commit();
                }else {
                    if (position == 1) {
                        transaction.replace(R.id.my_container, new DepannageActivity());
                        transaction.addToBackStack("b");
                        transaction.commit();
                    } else {
                        if (position == 2) {
                            transaction.replace(R.id.my_container, new Fragment2());
                            transaction.addToBackStack("c");
                            transaction.commit();
                        } else {
                            if (position == 3) {
                                transaction.replace(R.id.my_container, new ProfileActivity());
                                transaction.addToBackStack("d");
                                transaction.commit();
                            }else{
                                if (position == 4) {
                                    transaction.replace(R.id.my_container, new ProfileActivity());
                                    transaction.addToBackStack("d");
                                    transaction.commit();
                                }
                            }
                        }
                    }
                }*/


            }

            @Override
            public void onPageScrollStateChanged(final int state) {
                Toast.makeText(getApplicationContext(),"onPageScrollStateChanged = "+state,Toast.LENGTH_LONG).show();
            }
        });

        navigationTabBar.postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < navigationTabBar.getModels().size(); i++) {
                    final NavigationTabBar.Model model = navigationTabBar.getModels().get(i);
                    navigationTabBar.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //model.showBadge();
                        }
                    }, i * 100);
                }
            }
        }, 500);
    }
}
