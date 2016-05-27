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
import android.support.annotation.Nullable;

import com.leontheprofessional.bballscoreboard.database.helper.DatabaseHelper;

public class GameContentProvider extends ContentProvider {

    private static final int PERFORMANCES = 0;
    private static final int PERFORMANCE_BY_JERSEY_NUMBER = 1;

    private SQLiteDatabase database;

    private static final UriMatcher uriMatcher;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(DatabaseContract.AUTHORITY, "performances", PERFORMANCES);
        uriMatcher.addURI(DatabaseContract.AUTHORITY, "performance/#", PERFORMANCE_BY_JERSEY_NUMBER);
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

        selection = DatabaseContract.PerformanceTable.COLUMN_JERSEY_NUMBER;
        String groupBy = null;
        String having = null;

        switch (uriMatcher.match(DatabaseContract.CONTENT_URI_PERFORMANCE)) {
            case PERFORMANCES:
                // do nothing
                break;
            case PERFORMANCE_BY_JERSEY_NUMBER:
                // queryBuilder.appendWhere(DatabaseContract.PerformanceTable.COLUMN_JERSEY_NUMBER + "=" + uri.getLastPathSegment());
                selectionArgs[0] = (uri.getLastPathSegment()).toString();
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
        }else{
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

    private void deleteLastRow(String TableName, int JerseyNumber){
        String deletionQuery = "";
        if(JerseyNumber >= 0){
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
