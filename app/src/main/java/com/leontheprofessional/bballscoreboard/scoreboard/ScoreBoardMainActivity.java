package com.leontheprofessional.bballscoreboard.scoreboard;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.leontheprofessional.bballscoreboard.helpers.CommonConstants;
import com.leontheprofessional.bballscoreboard.R;

public class ScoreBoardMainActivity extends AppCompatActivity {

    private static final String LOG_TAG = ScoreBoardMainActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scoreboard_activity_main);

        final TabLayout tabLayout = (TabLayout) findViewById(R.id.scoreboard_activity_main_tab_layout);

        tabLayout.addTab(tabLayout.newTab().setText("10"));
        tabLayout.addTab(tabLayout.newTab().setText("5"));
        tabLayout.addTab(tabLayout.newTab().setText("14"));
        tabLayout.addTab(tabLayout.newTab().setText("6"));
        tabLayout.addTab(tabLayout.newTab().setText("7"));
        tabLayout.addTab(tabLayout.newTab().setText("21"));
        tabLayout.addTab(tabLayout.newTab().setText("34"));
        tabLayout.addTab(tabLayout.newTab().setText("3"));
        tabLayout.addTab(tabLayout.newTab().setText("23"));
        tabLayout.addTab(tabLayout.newTab().setText("1"));
        tabLayout.addTab(tabLayout.newTab().setText("9"));
        tabLayout.addTab(tabLayout.newTab().setText("13"));
        tabLayout.addTab(tabLayout.newTab().setText("21"));
        tabLayout.addTab(tabLayout.newTab().setText("24"));
        tabLayout.addTab(tabLayout.newTab().setText("30"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.scoreboard_activity_main_viewpager);
        final FragmentPagerAdapter viewPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                // todo: update with the original data for the fragment that is going to be inflated
                ScoreBoardMainFragment scoreBoardMainFragment = new ScoreBoardMainFragment();
                Bundle bundle = new Bundle();
                // todo: Jersey Numbers are not simply (position)
                /*
                TabLayout tabLayout = (TabLayout) findViewById(R.id.scoreboard_activity_main_tab_layout);
                TextView tv = (TextView)(((LinearLayout)((LinearLayout)tabLayout.getChildAt(0)).getChildAt(position)).getChildAt(0));
                String tabTitle = (String)tv.getText();
                int jerseyNumber = Integer.parseInt(tabTitle);
                Log.v(LOG_TAG, "JerseyNumber: " + jerseyNumber);
                */
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
