package com.leontheprofessional.bballscoreboard.database.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.leontheprofessional.bballscoreboard.database.DatabaseContract;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String LOG_TAG = DatabaseHelper.class.getSimpleName();

    public DatabaseHelper(Context context) {
        super(context, DatabaseContract.DATABASE_NAME, null, DatabaseContract.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.v(LOG_TAG, "Table creation command: " + DatabaseContract.PerformanceTable.PERFORMANCE_TABLE_CREATION);
        db.execSQL(DatabaseContract.PerformanceTable.PERFORMANCE_TABLE_CREATION);
        db.execSQL(DatabaseContract.PlayerTable.PLAYER_TABLE_CREATION);
        db.execSQL(DatabaseContract.TeamTable.TEAM_TABLE_CREATION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DatabaseContract.PerformanceTable.PERFORMANCE_TABLE_DELETION);
        db.execSQL(DatabaseContract.TeamTable.TEAM_TABLE_DELETION);
        db.execSQL(DatabaseContract.PlayerTable.PLAYER_TABLE_DELETION);
        onCreate(db);
    }
}
