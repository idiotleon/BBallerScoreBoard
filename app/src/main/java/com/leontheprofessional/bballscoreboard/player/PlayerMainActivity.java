package com.leontheprofessional.bballscoreboard.player;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.leontheprofessional.bballscoreboard.R;

public class PlayerMainActivity extends AppCompatActivity {

    private static final String LOG_TAG = PlayerMainActivity.class.getSimpleName();

    private FloatingActionButton fab;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_main_activity);

        // todo: use PlayersListFragment to list all players registered
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fl_player_main_activity, PlayersListFragment.newInstance(null));
        fragmentTransaction.commit();

        fab = (FloatingActionButton) findViewById(R.id.fab_player_main_activity);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // todo: commit AddOnePlayerDialogFragment for new players registration
                AddOnePlayerDialogFragment addOnePlayerDialogFragment = new AddOnePlayerDialogFragment();
                addOnePlayerDialogFragment.show(getSupportFragmentManager(), "add_one_player_dialog_fragment");
            }
        });
    }
}
