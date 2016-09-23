package com.leontheprofessional.bballscoreboard.team;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.leontheprofessional.bballscoreboard.R;
import com.leontheprofessional.bballscoreboard.helpers.CommonConstants;

/**
 * This fragment will list all players/members of the selected team
 */
public class TeamDetailsActivity extends AppCompatActivity {

    private String teamUUID;
    private FloatingActionButton fab;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.team_detail_activity);
        teamUUID = getIntent().getStringExtra(CommonConstants.TEAM_UUID_IDENTIFIER);

        fab = (FloatingActionButton)findViewById(R.id.fab_add_players);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
