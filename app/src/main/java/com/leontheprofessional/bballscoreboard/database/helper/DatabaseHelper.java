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
        // todo: one can see how IMPORTANT unit testing for database is!!!
        Log.v(LOG_TAG, DatabaseContract.PerformanceTable.PERFORMANCE_TABLE_CREATION_QUERY);
        Log.v(LOG_TAG, DatabaseContract.PlayerTable.PLAYER_TABLE_CREATION);
        Log.v(LOG_TAG, DatabaseContract.TeamTable.TEAM_TABLE_CREATION_QUERY);
        Log.v(LOG_TAG, DatabaseContract.Pt3Table.Pt3_TABLE_CREATION_QUERY);
        Log.v(LOG_TAG, DatabaseContract.Pt2Table.Pt2_TABLE_CREATION_QUERY);
        Log.v(LOG_TAG, DatabaseContract.Pt1Table.Pt1_TABLE_CREATION_QUERY);
        Log.v(LOG_TAG, DatabaseContract.StealTable.STEAL_TABLE_CREATION_QUERY);
        Log.v(LOG_TAG, DatabaseContract.BlockTable.BLOCK_TABLE_CREATION_QUERY);
        Log.v(LOG_TAG, DatabaseContract.OffRebTable.OFFREB_TABLE_CREATION_QUERY);
        Log.v(LOG_TAG, DatabaseContract.DefRebTable.DEFREB_TABLE_CREATION_QUERY);
        Log.v(LOG_TAG, DatabaseContract.AssistTable.ASSIST_TABLE_CREATION_QUERY);

        db.execSQL(DatabaseContract.PerformanceTable.PERFORMANCE_TABLE_CREATION_QUERY);
        db.execSQL(DatabaseContract.PlayerTable.PLAYER_TABLE_CREATION);
        db.execSQL(DatabaseContract.TeamTable.TEAM_TABLE_CREATION_QUERY);
        db.execSQL(DatabaseContract.Pt3Table.Pt3_TABLE_CREATION_QUERY);
        db.execSQL(DatabaseContract.Pt2Table.Pt2_TABLE_CREATION_QUERY);
        db.execSQL(DatabaseContract.Pt1Table.Pt1_TABLE_CREATION_QUERY);
        db.execSQL(DatabaseContract.StealTable.STEAL_TABLE_CREATION_QUERY);
        db.execSQL(DatabaseContract.BlockTable.BLOCK_TABLE_CREATION_QUERY);
        db.execSQL(DatabaseContract.OffRebTable.OFFREB_TABLE_CREATION_QUERY);
        db.execSQL(DatabaseContract.DefRebTable.DEFREB_TABLE_CREATION_QUERY);
        db.execSQL(DatabaseContract.AssistTable.ASSIST_TABLE_CREATION_QUERY);
        db.execSQL(DatabaseContract.TurnoverTable.TURNOVER_TABLE_CREATION_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.v(LOG_TAG, DatabaseContract.PerformanceTable.PERFORMANCE_TABLE_DELETION_QUERY);
        Log.v(LOG_TAG, DatabaseContract.PlayerTable.PLAYER_TABLE_DELETION_QUERY);
        Log.v(LOG_TAG, DatabaseContract.TeamTable.TEAM_TABLE_DELETION_QUERY);
        Log.v(LOG_TAG, DatabaseContract.Pt3Table.PT3_TABLE_DELETION_QUERY);
        Log.v(LOG_TAG, DatabaseContract.Pt2Table.PT2_TABLE_DELETION_QUERY);
        Log.v(LOG_TAG, DatabaseContract.Pt1Table.PT1_TABLE_DELETION_QUERY);
        Log.v(LOG_TAG, DatabaseContract.StealTable.STEAL_TABLE_DELETION_QUERY);
        Log.v(LOG_TAG, DatabaseContract.BlockTable.BLOCK_TABLE_DELETION_QUERY);
        Log.v(LOG_TAG, DatabaseContract.OffRebTable.OFFREB_TABLE_DELETION_QUERY);
        Log.v(LOG_TAG, DatabaseContract.DefRebTable.DEFREB_TABLE_DELETION_QUERY);
        Log.v(LOG_TAG, DatabaseContract.AssistTable.ASSIST_TABLE_DELETION_QUERY);
        Log.v(LOG_TAG, DatabaseContract.TurnoverTable.TURNOVER_TABLE_DELETION_QUERY);

        db.execSQL(DatabaseContract.TeamTable.TEAM_TABLE_DELETION_QUERY);
        db.execSQL(DatabaseContract.PlayerTable.PLAYER_TABLE_DELETION_QUERY);
        db.execSQL(DatabaseContract.Pt3Table.PT3_TABLE_DELETION_QUERY);
        db.execSQL(DatabaseContract.Pt2Table.PT2_TABLE_DELETION_QUERY);
        db.execSQL(DatabaseContract.Pt1Table.PT1_TABLE_DELETION_QUERY);
        db.execSQL(DatabaseContract.StealTable.STEAL_TABLE_DELETION_QUERY);
        db.execSQL(DatabaseContract.BlockTable.BLOCK_TABLE_DELETION_QUERY);
        db.execSQL(DatabaseContract.OffRebTable.OFFREB_TABLE_DELETION_QUERY);
        db.execSQL(DatabaseContract.DefRebTable.DEFREB_TABLE_DELETION_QUERY);
        db.execSQL(DatabaseContract.AssistTable.ASSIST_TABLE_DELETION_QUERY);
        db.execSQL(DatabaseContract.TurnoverTable.TURNOVER_TABLE_DELETION_QUERY);
        onCreate(db);
    }
}
