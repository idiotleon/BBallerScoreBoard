package com.leontheprofessional.bballscoreboard.scoreboard;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.leontheprofessional.bballscoreboard.R;

public class ScoreBoardMainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scoreboard_activity_main);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ScoreBoardMainFragment scoreBoardMainFragment = new ScoreBoardMainFragment();
        fragmentTransaction.add(R.id.scoreboard_activity_main, scoreBoardMainFragment);
        fragmentTransaction.commit();
    }
}
