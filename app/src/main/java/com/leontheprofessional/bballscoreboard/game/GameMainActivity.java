package com.leontheprofessional.bballscoreboard.game;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.leontheprofessional.bballscoreboard.R;

/**
 * Created by LeonthePro7 on 9/25/2016.
 */

// todo: 把常规赛和季后赛安排好 增加按照tournament的赛制的功能 特别是季后赛

public class GameMainActivity extends AppCompatActivity {
    private static final String LOG_TAG = GameMainActivity.class.getSimpleName();

    private FloatingActionButton fab;


    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.game_main_activity);
        fab = (FloatingActionButton) findViewById(R.id.fab_create_a_game);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
