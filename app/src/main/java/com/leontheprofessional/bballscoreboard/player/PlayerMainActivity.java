package com.leontheprofessional.bballscoreboard.player;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
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

    private Spinner positionSpinner;
    private Button btnConfirm;
    private ContentValues playerContentValue;
    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private EditText heightEditText;
    private EditText weightEditText;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_main_activity);
        Log.v(LOG_TAG, "onCreate() executed");

        playerContentValue = new ContentValues();

        firstNameEditText = (EditText) findViewById(R.id.et_first_name_player_main_activity);
        lastNameEditText = (EditText) findViewById(R.id.et_last_name_player_main_activity);
        heightEditText = (EditText) findViewById(R.id.et_height_player_main_activity);
        weightEditText = (EditText) findViewById(R.id.et_weight_player_main_activity);

        final String[] playerPosition = getResources().getStringArray(R.array.player_position);
        positionSpinner = (Spinner) findViewById(R.id.spinner_player_position);
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.player_position, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        positionSpinner.setAdapter(spinnerAdapter);
        positionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                playerContentValue.put(DatabaseContract.PlayerTable.COLUMN_POSITION, playerPosition[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                playerContentValue.put(DatabaseContract.PlayerTable.COLUMN_POSITION, playerPosition[0]);
            }
        });

        btnConfirm = (Button) findViewById(R.id.btn_confirm_player_main_activity);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = firstNameEditText.getText().toString();
                String lastName = lastNameEditText.getText().toString();
                String height = heightEditText.getText().toString();
                String weight = weightEditText.getText().toString();

                playerContentValue.put(DatabaseContract.PlayerTable.COLUMN_PLAYER_FIRST_NAME, firstName);
                playerContentValue.put(DatabaseContract.PlayerTable.COLUMN_PLAYER_LAST_NAME, lastName);
                playerContentValue.put(DatabaseContract.PlayerTable.COLUMN_PLAYER_HEIGHT, height);
                playerContentValue.put(DatabaseContract.PlayerTable.COLUMN_PLAYER_WEIGHT, weight);
                String dateTimeStamp = (DateFormat.format("yyyy-MM-dd hh:mm:ss", new java.util.Date()).toString());
                playerContentValue.put(DatabaseContract.COLUMN_TIMESTAMP, dateTimeStamp);

                Uri uri = getContentResolver().insert(DatabaseContract.PlayerTable.CONTENT_URI_PLAYERS, playerContentValue);
            }
        });
    }
}
