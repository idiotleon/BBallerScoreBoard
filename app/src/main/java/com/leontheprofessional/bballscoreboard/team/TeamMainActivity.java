package com.leontheprofessional.bballscoreboard.team;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.leontheprofessional.bballscoreboard.R;
import com.leontheprofessional.bballscoreboard.player.PlayerMainActivity;

public class TeamMainActivity extends AppCompatActivity {

    private ListView teamMemberListView;
    private FloatingActionButton fab;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.main_activity_team);

        teamMemberListView = (ListView) findViewById(R.id.listview_member_team);

        fab = (FloatingActionButton) findViewById(R.id.fab_team_main_activity);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playerIntent = new Intent(TeamMainActivity.this, PlayerMainActivity.class);
                startActivity(playerIntent);
            }
        });
    }
}
