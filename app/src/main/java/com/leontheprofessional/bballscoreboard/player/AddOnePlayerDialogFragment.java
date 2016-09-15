package com.leontheprofessional.bballscoreboard.player;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.leontheprofessional.bballscoreboard.R;
import com.leontheprofessional.bballscoreboard.database.DatabaseContract;

import java.util.UUID;

/**
 * This fragment is a popup window for adding one player
 */
public class AddOnePlayerDialogFragment extends DialogFragment {

    private static final String LOG_TAG = AddOnePlayerDialogFragment.class.getSimpleName();

    private Spinner positionSpinner;
    private Button btnConfirm;
    private Button btnCancel;
    private ContentValues playerContentValue;
    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private EditText heightEditText;
    private EditText weightEditText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        playerContentValue = new ContentValues();
        View view = inflater.inflate(R.layout.player_registration_form, container, false);

        firstNameEditText = (EditText) view.findViewById(R.id.et_first_name_player_main_activity);
        lastNameEditText = (EditText) view.findViewById(R.id.et_last_name_player_main_activity);
        heightEditText = (EditText) view.findViewById(R.id.et_height_player_main_activity);
        weightEditText = (EditText) view.findViewById(R.id.et_weight_player_main_activity);

        final String[] playerPosition = getResources().getStringArray(R.array.player_position);
        positionSpinner = (Spinner) view.findViewById(R.id.spinner_player_position);
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.player_position, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Todo: Set a title for the spinner
//        positionSpinner.setPrompt(getContext().getResources().getString(R.string.player_position));
        positionSpinner.setAdapter(spinnerAdapter);
        positionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                playerContentValue.put(DatabaseContract.PlayerTable.COLUMN_PLAYER_POSITION, playerPosition[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                playerContentValue.put(DatabaseContract.PlayerTable.COLUMN_PLAYER_POSITION, playerPosition[0]);
            }
        });

        btnConfirm = (Button) view.findViewById(R.id.btn_confirm_player_main_activity);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // todo: add null/irregularity checkers
                String firstName = firstNameEditText.getText().toString();
                String lastName = lastNameEditText.getText().toString();
                String height = heightEditText.getText().toString();
                String weight = weightEditText.getText().toString();

                // todo: might be wrong with data types
                playerContentValue.put(DatabaseContract.PlayerTable.COLUMN_PLAYER_UUID, UUID.randomUUID().toString());
                playerContentValue.put(DatabaseContract.PlayerTable.COLUMN_PLAYER_FIRST_NAME, firstName);
                playerContentValue.put(DatabaseContract.PlayerTable.COLUMN_PLAYER_LAST_NAME, lastName);
                playerContentValue.put(DatabaseContract.PlayerTable.COLUMN_PLAYER_HEIGHT, height);
                playerContentValue.put(DatabaseContract.PlayerTable.COLUMN_PLAYER_WEIGHT, weight);
                playerContentValue.put(DatabaseContract.PlayerTable.COLUMN_PLAYER_PROFILE_CREATED_TIMESTAMP, System.currentTimeMillis());

                // Uri uri = getContext().getContentResolver().insert(DatabaseContract.PlayerTable.CONTENT_URI_PLAYERS, playerContentValue);
            }
        });

        btnCancel = (Button) view.findViewById(R.id.btn_cancel_player_main_activity);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        return view;
    }
}
