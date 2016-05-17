package com.leontheprofessional.bballscoreboard.scoreboard;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import com.leontheprofessional.bballscoreboard.Helper.CommonConstants;
import com.leontheprofessional.bballscoreboard.R;

public class ScoreBoardMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scoreboard_activity_main);

        /*
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ScoreBoardMainFragment scoreBoardMainFragment = new ScoreBoardMainFragment();
        fragmentTransaction.replace(R.id.scoreboard_activity_main_container, scoreBoardMainFragment);
        fragmentTransaction.commit();
        */

        final TabLayout tabLayout = (TabLayout) findViewById(R.id.scoreboard_activity_main_tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("1"));
        tabLayout.addTab(tabLayout.newTab().setText("2"));
        tabLayout.addTab(tabLayout.newTab().setText("3"));
        tabLayout.addTab(tabLayout.newTab().setText("4"));
        tabLayout.addTab(tabLayout.newTab().setText("5"));
        tabLayout.addTab(tabLayout.newTab().setText("6"));
        tabLayout.addTab(tabLayout.newTab().setText("7"));
        tabLayout.addTab(tabLayout.newTab().setText("8"));
        tabLayout.addTab(tabLayout.newTab().setText("9"));
        tabLayout.addTab(tabLayout.newTab().setText("10"));
        tabLayout.addTab(tabLayout.newTab().setText("11"));
        tabLayout.addTab(tabLayout.newTab().setText("12"));
        tabLayout.addTab(tabLayout.newTab().setText("13"));
        tabLayout.addTab(tabLayout.newTab().setText("14"));
        tabLayout.addTab(tabLayout.newTab().setText("15"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.scoreboard_activity_main_viewpager);
        final FragmentPagerAdapter viewPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                // todo: update with the original data for the fragment that is going to be inflated
                ScoreBoardMainFragment scoreBoardMainFragment = new ScoreBoardMainFragment();
                Bundle bundle = new Bundle();
                bundle.putInt(CommonConstants.JERSEY_NUMBER_IDENTIFIER, position);
                scoreBoardMainFragment.setArguments(bundle);
                return scoreBoardMainFragment;
            }

            @Override
            public int getCount() {
                return tabLayout.getTabCount();
            }
        };

        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
