package com.leontheprofessional.bballscoreboard.team.selectplayers;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CursorAdapter;

/**
 * Created by LeonthePro7 on 9/22/2016.
 */

public class SelectPlayersLVAdapter extends CursorAdapter {

    public SelectPlayersLVAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return null;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

    }
}
