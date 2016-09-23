package com.leontheprofessional.bballscoreboard.player;

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
import com.leontheprofessional.bballscoreboard.team.ListAllTeamsLVAdapter;

/**
 * Created by LeonthePro7 on 9/21/2016.
 */

public class ListAllPlayersLVAdapter extends CursorAdapter {
    private static final String LOG_TAG = ListAllTeamsLVAdapter.class.getSimpleName();

    public ListAllPlayersLVAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.fragment_item_list_all_players, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tvFirstName = (TextView) view.findViewById(R.id.tv_player_first_name_list_players);
        String playerFirstName = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.PlayerTable.COLUMN_PLAYER_FIRST_NAME));
        Log.v(LOG_TAG, "playerFirstName: " + playerFirstName);
        tvFirstName.setText(playerFirstName);

        TextView tvLastName = (TextView) view.findViewById(R.id.tv_player_last_name_list_players);
        String playerLastName = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.PlayerTable.COLUMN_PLAYER_LAST_NAME));
        Log.v(LOG_TAG, "playerLastName: " + playerLastName);
        tvLastName.setText(playerLastName);
    }
}
