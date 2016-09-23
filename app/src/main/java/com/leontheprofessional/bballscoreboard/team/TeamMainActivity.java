package com.leontheprofessional.bballscoreboard.team;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.leontheprofessional.bballscoreboard.R;
import com.leontheprofessional.bballscoreboard.helpers.CommonConstants;

/**
 * todo: the first page of TeamActivity should have a list of all teams,
 * todo: whose FAB will lead to adding teams;
 * todo: while click on one of the teams will lead to one specific team,
 * todo: whose FAB will lead to adding players
 */
public class TeamMainActivity extends AppCompatActivity {

    private FloatingActionButton fab;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.team_main_activity);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fl_list_all_teams, TeamsListFragment.newInstance(null));
        fragmentTransaction.commit();

        fab = (FloatingActionButton) findViewById(R.id.fab_team_main_activity);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddOneTeamFragment addOneTeamFragment = new AddOneTeamFragment();
                addOneTeamFragment.show(getSupportFragmentManager(), CommonConstants.ADD_ONE_TEAM_DIALOG_FRAGMENT);
            }
        });
    }
}
