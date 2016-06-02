package com.leontheprofessional.bballscoreboard.database;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.util.Log;

import com.leontheprofessional.bballscoreboard.database.helper.DatabaseHelper;

public class GameContentProvider extends ContentProvider {

    private static final int PERFORMANCES = 0;
    private static final int PERFORMANCE_BY_JERSEY_NUMBER = 1;
    private static final int PT2_MADE_BY_JERSEY_NUMBER = 2;
    private static final int PT2_MISSED_BY_JERSEY_NUMBER = 3;
    private static final int PT3_MADE_BY_JERSEY_NUMBER = 4;
    private static final int PT3_MISSED_BY_JERSEY_NUMBER = 5;
    private static final int PT1_MADE_BY_JERSEY_NUMBER = 6;
    private static final int PT1_MISSED_BY_JERSEY_NUMBER = 7;
    private static final int STEAL_BY_JERSEY_NUMBER = 8;
    private static final int OFF_REB_BY_JERSEY_NUMBER = 9;
    private static final int DEF_REB_BY_JERSEY_NUMBER = 10;
    private static final int FAUL_BY_JERSEY_NUMBER = 11;
    private static final int TURNOVER_BY_JERSEY_NUMBER = 12;
    private static final int BLOCK_BY_JERSEY_NUMBER = 13;

    private SQLiteDatabase database;

    private static final UriMatcher uriMatcher;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(DatabaseContract.AUTHORITY, "performances", PERFORMANCES);
        uriMatcher.addURI(DatabaseContract.AUTHORITY, "performance/#", PERFORMANCE_BY_JERSEY_NUMBER);
        uriMatcher.addURI(DatabaseContract.AUTHORITY, "performance/pt2made/#", PT2_MADE_BY_JERSEY_NUMBER);
        uriMatcher.addURI(DatabaseContract.AUTHORITY, "performance/pt2missed/#", PT2_MISSED_BY_JERSEY_NUMBER);
        uriMatcher.addURI(DatabaseContract.AUTHORITY, "performance/pt3made/#", PT3_MADE_BY_JERSEY_NUMBER);
        uriMatcher.addURI(DatabaseContract.AUTHORITY, "performance/pt3missed/#", PT3_MISSED_BY_JERSEY_NUMBER);
        uriMatcher.addURI(DatabaseContract.AUTHORITY, "performance/pt1made/#", PT1_MADE_BY_JERSEY_NUMBER);
        uriMatcher.addURI(DatabaseContract.AUTHORITY, "performance/pt1missed/#", PT1_MISSED_BY_JERSEY_NUMBER);
        uriMatcher.addURI(DatabaseContract.AUTHORITY, "performance/steal/#", STEAL_BY_JERSEY_NUMBER);
        uriMatcher.addURI(DatabaseContract.AUTHORITY, "performance/offreb/#", OFF_REB_BY_JERSEY_NUMBER);
        uriMatcher.addURI(DatabaseContract.AUTHORITY, "performance/defreb/#", DEF_REB_BY_JERSEY_NUMBER);
        uriMatcher.addURI(DatabaseContract.AUTHORITY, "performance/faul/#", FAUL_BY_JERSEY_NUMBER);
        uriMatcher.addURI(DatabaseContract.AUTHORITY, "performance/turnover/#", TURNOVER_BY_JERSEY_NUMBER);
        uriMatcher.addURI(DatabaseContract.AUTHORITY, "performance/block/#", BLOCK_BY_JERSEY_NUMBER);
    }

    @Override
    public boolean onCreate() {
        DatabaseHelper dbHelper = new DatabaseHelper(getContext());
        database = dbHelper.getWritableDatabase();
        return false;
    }

    /*
    * Get all data of a player by his jersey number
    * */
    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();

        queryBuilder.setTables(DatabaseContract.PerformanceTable.TABLE_NAME);
        String groupBy = null;
        String having = null;

        switch (uriMatcher.match(uri)) {
            case PERFORMANCES:
                // do nothing
                break;
            case PERFORMANCE_BY_JERSEY_NUMBER:
                //queryBuilder.appendWhere(DatabaseContract.PerformanceTable.COLUMN_JERSEY_NUMBER + "=" + uri.getLastPathSegment());
                selection = DatabaseContract.PerformanceTable.COLUMN_JERSEY_NUMBER + " = ?";
                selectionArgs[0] = (uri.getLastPathSegment()).toString();
                break;
            case PT2_MADE_BY_JERSEY_NUMBER:
                selection = DatabaseContract.PerformanceTable.COLUMN_JERSEY_NUMBER + " = ? AND " +
                        DatabaseContract.PerformanceTable.COLUMN_PT_2 + " = ?";
                selectionArgs = new String[2];
                selectionArgs[0] = (uri.getLastPathSegment()).toString();
                selectionArgs[1] = Integer.toString(DatabaseContract.PerformanceTable.SHOT_MADE);
                break;
            case PT2_MISSED_BY_JERSEY_NUMBER:
                selection = DatabaseContract.PerformanceTable.COLUMN_JERSEY_NUMBER + " = ? AND " +
                        DatabaseContract.PerformanceTable.COLUMN_PT_2 + " = ?";
                selectionArgs = new String[2];
                selectionArgs[0] = (uri.getLastPathSegment()).toString();
                selectionArgs[1] = Integer.toString(DatabaseContract.PerformanceTable.SHOT_MISS);
                break;
            case PT3_MADE_BY_JERSEY_NUMBER:
                selection = DatabaseContract.PerformanceTable.COLUMN_JERSEY_NUMBER + " = ? AND " +
                        DatabaseContract.PerformanceTable.COLUMN_PT_3 + " = ?";
                selectionArgs = new String[2];
                selectionArgs[0] = (uri.getLastPathSegment()).toString();
                selectionArgs[1] = Integer.toString(DatabaseContract.PerformanceTable.SHOT_MADE);
                break;
            case PT3_MISSED_BY_JERSEY_NUMBER:
                selection = DatabaseContract.PerformanceTable.COLUMN_JERSEY_NUMBER + " = ? AND " +
                        DatabaseContract.PerformanceTable.COLUMN_PT_3 + " = ?";
                selectionArgs = new String[2];
                selectionArgs[0] = (uri.getLastPathSegment()).toString();
                selectionArgs[1] = Integer.toString(DatabaseContract.PerformanceTable.SHOT_MISS);
                break;
            case PT1_MADE_BY_JERSEY_NUMBER:
                selection = DatabaseContract.PerformanceTable.COLUMN_JERSEY_NUMBER + " = ? AND " +
                        DatabaseContract.PerformanceTable.COLUMN_PT_1 + " = ?";
                selectionArgs = new String[2];
                selectionArgs[0] = (uri.getLastPathSegment()).toString();
                selectionArgs[1] = Integer.toString(DatabaseContract.PerformanceTable.SHOT_MADE);
                break;
            case PT1_MISSED_BY_JERSEY_NUMBER:
                selection = DatabaseContract.PerformanceTable.COLUMN_JERSEY_NUMBER + " = ? AND " +
                        DatabaseContract.PerformanceTable.COLUMN_PT_1 + " = ?";
                selectionArgs = new String[2];
                selectionArgs[0] = (uri.getLastPathSegment()).toString();
                selectionArgs[1] = Integer.toString(DatabaseContract.PerformanceTable.SHOT_MISS);
                break;
            case STEAL_BY_JERSEY_NUMBER:
                selection = DatabaseContract.PerformanceTable.COLUMN_JERSEY_NUMBER + " = ? AND " +
                        DatabaseContract.PerformanceTable.COLUMN_STEAL + " = ?";
                selectionArgs = new String[2];
                selectionArgs[0] = (uri.getLastPathSegment()).toString();
                selectionArgs[1] = Integer.toString(DatabaseContract.PerformanceTable.STEAL_MADE);
                break;
            case OFF_REB_BY_JERSEY_NUMBER:
                selection = DatabaseContract.PerformanceTable.COLUMN_JERSEY_NUMBER + " = ? AND " +
                        DatabaseContract.PerformanceTable.COLUMN_OFF_REB + " = ?";
                selectionArgs = new String[2];
                selectionArgs[0] = (uri.getLastPathSegment()).toString();
                selectionArgs[1] = Integer.toString(DatabaseContract.PerformanceTable.REB_GOT);
                break;
            case DEF_REB_BY_JERSEY_NUMBER:
                selection = DatabaseContract.PerformanceTable.COLUMN_JERSEY_NUMBER + " = ? AND " +
                        DatabaseContract.PerformanceTable.COLUMN_DEF_REB + " = ?";
                selectionArgs = new String[2];
                selectionArgs[0] = (uri.getLastPathSegment()).toString();
                selectionArgs[1] = Integer.toString(DatabaseContract.PerformanceTable.REB_GOT);
                break;
            case FAUL_BY_JERSEY_NUMBER:
                selection = DatabaseContract.PerformanceTable.COLUMN_JERSEY_NUMBER + " = ? AND " +
                        DatabaseContract.PerformanceTable.COLUMN_FAUL + " = ?";
                selectionArgs = new String[2];
                selectionArgs[0] = (uri.getLastPathSegment()).toString();
                selectionArgs[1] = Integer.toString(DatabaseContract.PerformanceTable.FAUL_COMMITTED);
                break;
            case TURNOVER_BY_JERSEY_NUMBER:
                selection = DatabaseContract.PerformanceTable.COLUMN_JERSEY_NUMBER + " = ? AND " +
                        DatabaseContract.PerformanceTable.COLUMN_TURNOVER + " = ?";
                selectionArgs = new String[2];
                selectionArgs[0] = (uri.getLastPathSegment()).toString();
                selectionArgs[1] = Integer.toString(DatabaseContract.PerformanceTable.TURNOVER_MADE);
                break;
            case BLOCK_BY_JERSEY_NUMBER:
                selection = DatabaseContract.PerformanceTable.COLUMN_JERSEY_NUMBER + " = ? AND " +
                        DatabaseContract.PerformanceTable.COLUMN_BLOCK + " = ?";
                selectionArgs = new String[2];
                selectionArgs[0] = (uri.getLastPathSegment()).toString();
                selectionArgs[1] = Integer.toString(DatabaseContract.PerformanceTable.BLOCK_MADE);
                break;
            default:
                throw new IllegalArgumentException("Unkown URI " + uri);
        }

        if (sortOrder == null || sortOrder == "") {
            sortOrder = DatabaseContract.PerformanceTable.COLUMN_TIMESTAMP + " DESC";
        }
        Cursor cursor = queryBuilder.query(database,
                DatabaseContract.projectionForAll,
                selection,
                selectionArgs,
                groupBy,
                having,
                sortOrder);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)) {
            case PERFORMANCES:
                return DatabaseContract.PerformanceTable.PERFORMANCE_CONTENT_TYPE;
            case PERFORMANCE_BY_JERSEY_NUMBER:
                return DatabaseContract.PerformanceTable.PERFORMANCE_CONTENT_ITEM_TYPE;
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long id = 0L;
        switch (uriMatcher.match(uri)) {
            case PERFORMANCE_BY_JERSEY_NUMBER:
                id = database.insertWithOnConflict(
                        DatabaseContract.PerformanceTable.TABLE_NAME,
                        null,
                        values,
                        SQLiteDatabase.CONFLICT_REPLACE);
                return getUriForId(id, uri);
            default:
                id = database.insert(
                        DatabaseContract.PerformanceTable.TABLE_NAME,
                        null,
                        values);
                return getUriForId(id, uri);
        }
    }

    private Uri getUriForId(long id, Uri uri) {
        Uri itemUri = ContentUris.withAppendedId(uri, id);
        if (id > 0) {
            getContext().getContentResolver().notifyChange(itemUri, null);
        } else {
            throw new SQLException("Problem with inserting into URI: " + uri);
        }
        return itemUri;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        /*int delCount = 0;
        Cursor cursor;
        switch (uriMatcher.match(uri)){
            case PERFORMANCES:
                // todo: delete the last row of the whole table
                cursor = query(DatabaseContract.CONTENT_URI_PERFORMANCES,


                        )

                delCount = database.delete();
                break;
            case PERFORMANCE_BY_JERSEY_NUMBER:
                // todo: delete the last record of this player

                break;
            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
                return delCount;
        }*/
        return 0;
    }

    private void deleteLastRow(String TableName, int JerseyNumber) {
        String deletionQuery = "";
        if (JerseyNumber >= 0) {
            deletionQuery = "SELECT * FROM " + DatabaseContract.PerformanceTable.TABLE_NAME +
                    " ORDER BY " + DatabaseContract.PerformanceTable.COLUMN_TIMESTAMP +
                    " LIMIT 1";
        }

    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
