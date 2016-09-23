package com.leontheprofessional.bballscoreboard.team;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.leontheprofessional.bballscoreboard.R;
import com.leontheprofessional.bballscoreboard.database.DatabaseContract;




public class ListAllTeamsLVAdapter extends CursorAdapter {
    private static final String LOG_TAG = ListAllTeamsLVAdapter.class.getSimpleName();

    public ListAllTeamsLVAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.fragment_item_list_all_teams, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tvTeamName = (TextView) view.findViewById(R.id.tv_item_list_all_teams);
        String teamName = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.TeamTable.COLUMN_TEAM_NAME));
        Log.v(LOG_TAG, "teamName: " + teamName);
        tvTeamName.setText(teamName);
    }
}
