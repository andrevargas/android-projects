package br.univali.sisnet.autonomy;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabs;
    private ViewPager viewPager;

    private int[] tabIcons = {
        R.drawable.ic_directions_car_black_24dp,
        R.drawable.ic_local_gas_station_black_24dp
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabs = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        toolbar.setTitleTextColor(Color.WHITE);

        // setSupportActionBar(toolbar);
        setupViewPager(viewPager);

        tabs.setupWithViewPager(viewPager);
        setupTabIcons();

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new AutonomyFragment(), getResources().getString(R.string.autonomy));
        adapter.addFragment(new RefuellingListFragment(), getResources().getString(R.string.refuellings));
        viewPager.setAdapter(adapter);
    }

    private void setupTabIcons() {

        tabs.getTabAt(0).setIcon(tabIcons[0]);
        tabs.getTabAt(0).getIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);

        tabs.getTabAt(1).setIcon(tabIcons[1]);
        tabs.getTabAt(1).getIcon().setColorFilter(Color.parseColor("#0288D1"), PorterDuff.Mode.SRC_IN);

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.parseColor("#0288D1"), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });

    }

}
