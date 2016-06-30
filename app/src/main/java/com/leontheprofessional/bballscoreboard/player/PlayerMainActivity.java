package com.leontheprofessional.bballscoreboard.player;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.leontheprofessional.bballscoreboard.R;
import com.leontheprofessional.bballscoreboard.database.DatabaseContract;

public class PlayerMainActivity extends AppCompatActivity {

    private static final String LOG_TAG = PlayerMainActivity.class.getSimpleName();

    private FloatingActionButton fab;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_main_activity);

        // todo: use PlayersListFragment to list all players registered

        fab = (FloatingActionButton) findViewById(R.id.fab_player_main_activity);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // todo: commit AddOnePlayerFragment for new players registration
                AddOnePlayerFragment addOnePlayerFragment = new AddOnePlayerFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(,addOnePlayerFragment);
                fragmentTransaction.commit();

            }
        });
    }
}
