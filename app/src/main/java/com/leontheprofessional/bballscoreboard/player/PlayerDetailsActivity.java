package com.leontheprofessional.bballscoreboard.player;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.leontheprofessional.bballscoreboard.helpers.CommonConstants;

/**
 * Created by LeonthePro7 on 9/21/2016.
 */

public class PlayerDetailsActivity extends AppCompatActivity {

    private static final String LOG_TAG = PlayerDetailsActivity.class.getSimpleName();

    private String playerUUID;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        Log.v(LOG_TAG, "onCreate() executed.");

        playerUUID = getIntent().getStringExtra(CommonConstants.PLAYER_UUID_IDENTIFIER);
        Log.v(LOG_TAG, "playerUUID: " + playerUUID);
    }
}
