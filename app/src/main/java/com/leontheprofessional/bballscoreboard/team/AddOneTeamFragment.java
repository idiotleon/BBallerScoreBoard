package com.leontheprofessional.bballscoreboard.team;

import android.support.v4.app.Fragment;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.leontheprofessional.bballscoreboard.R;
import com.leontheprofessional.bballscoreboard.database.DatabaseContract;

/**
 * This fragment is a popup window/fragment for adding one team
 */

public class AddOneTeamFragment extends Fragment {

    private static final String LOG_TAG = AddOneTeamFragment.class.getSimpleName();

    private Button btnConfirm;
    private Button btnCancel;
    private ContentValues teamContentValue;

    private EditText teamNameEditText;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_team_fragment, container);

        teamNameEditText = (EditText) view.findViewById(R.id.team_name_edit_text);
        btnConfirm = (Button) view.findViewById(R.id.btn_confirm_add_team_fragment);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String teamName = teamNameEditText.getText().toString();
                if (teamName != "" && teamName != null) {
                    teamContentValue.put(DatabaseContract.TeamTable.COLUMN_TEAM_NAME, teamName);
                } else {
                    teamName = getString(R.string.name_anonymous);
                    teamContentValue.put(DatabaseContract.TeamTable.COLUMN_TEAM_NAME, teamName);
                }
                teamContentValue.put(DatabaseContract.TeamTable.COLUMN_TEAM_PROFILE_CREATED_TIMESTAMP, System.currentTimeMillis());

                Uri uri = getContext().getContentResolver().insert(DatabaseContract.TeamTable.CONTENT_URI_TEAMS, teamContentValue);
                Log.v(LOG_TAG, uri.toString());
            }
        });

        btnCancel = (Button) view.findViewById(R.id.btn_cancel_add_team_fragment);

        return view;
    }
}
