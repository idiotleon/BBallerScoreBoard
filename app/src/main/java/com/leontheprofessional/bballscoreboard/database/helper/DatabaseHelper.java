package com.leontheprofessional.bballscoreboard.database.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.leontheprofessional.bballscoreboard.database.DatabaseContract;

public class DatabaseHelper extends SQLiteOpenHelper{

    private static final String LOG_TAG = DatabaseHelper.class.getSimpleName();

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DatabaseContract.DATABASE_NAME, null, DatabaseContract.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.v(LOG_TAG, "Table creation command: " + DatabaseContract.TABLE_CREATION);
        db.execSQL(DatabaseContract.TABLE_CREATION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DatabaseContract.TABLE_DELETION);
        onCreate(db);
    }
}
