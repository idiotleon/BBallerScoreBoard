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
import android.util.Log;

import com.leontheprofessional.bballscoreboard.database.helper.DatabaseHelper;

public class GeneralContentProvider extends ContentProvider {
    private static final String LOG_TAG = GeneralContentProvider.class.getSimpleName();

    /**
     * ContentProvider for Performance Table
     */
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
    private static final int ASSIST_BY_JERSEY_NUMBER = 14;

    private static final int REVOKE_LAST_PERFORMANCE_RECORD = 19;
    /**
     * ContentProvider for TeamTable
     */
    private static final int TEAMS = 21;
    private static final int TEAM = 22;
    /**
     * ContentProvider entrances for Player_Table
     */
    private static final int PLAYERS = 31;
    private static final int PLAYER_BY_PLAYER_UUID = 32;
    private static final int PLAYER_BY_FIRST_NAME = 33;
    private static final int PLAYER_BY_LAST_NAME = 34;
    private static final int PLAYER_BY_HEIGHT = 35;
    private static final int PLAYER_BY_WEIGHT = 36;
    private static final int PLAYER_BY_POSITION = 37;

    /**
     * ContentProvider entraces for Relationship_Table
     */
    private static final int RELATIONSHIPS = 41;
    private static final int RELATIONSHIP_BY_TEAM_UUID = 42;
    private static final int RELATIONSHIP_BY_PLAYER_UUID = 43;


    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

    private static final UriMatcher uriMatcher;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        // todo: fetch all infos by player uuid after setting up UUID to performance mechanism
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
        uriMatcher.addURI(DatabaseContract.AUTHORITY, "performance/assist/#", ASSIST_BY_JERSEY_NUMBER);
        uriMatcher.addURI(DatabaseContract.AUTHORITY, "performance/revoke", REVOKE_LAST_PERFORMANCE_RECORD);
        // for TEAM_TABLE
        uriMatcher.addURI(DatabaseContract.AUTHORITY, "teams", TEAMS);
        uriMatcher.addURI(DatabaseContract.AUTHORITY, "team/#", TEAM);
        // for PLAYER_TABLE
        uriMatcher.addURI(DatabaseContract.AUTHORITY, "players", PLAYERS);
        uriMatcher.addURI(DatabaseContract.AUTHORITY, "player/by_player_uuid/#", PLAYER_BY_PLAYER_UUID);
        uriMatcher.addURI(DatabaseContract.AUTHORITY, "player/by_first_name/#", PLAYER_BY_FIRST_NAME);
        uriMatcher.addURI(DatabaseContract.AUTHORITY, "player/by_last_name/#", PLAYER_BY_LAST_NAME);
        uriMatcher.addURI(DatabaseContract.AUTHORITY, "player/by_height/#", PLAYER_BY_HEIGHT);
        uriMatcher.addURI(DatabaseContract.AUTHORITY, "player/by_weight/#", PLAYER_BY_WEIGHT);
        uriMatcher.addURI(DatabaseContract.AUTHORITY, "player/by_position/#", PLAYER_BY_POSITION);
        // for RELATIONSHIP_TABLE
        uriMatcher.addURI(DatabaseContract.AUTHORITY, "relationships", RELATIONSHIPS);
        uriMatcher.addURI(DatabaseContract.AUTHORITY, "relationship/by_team_uuid/#", RELATIONSHIP_BY_TEAM_UUID);
        uriMatcher.addURI(DatabaseContract.AUTHORITY, "relationship/by_player_uuid/#", RELATIONSHIP_BY_PLAYER_UUID);
    }

    @Override
    public boolean onCreate() {
        dbHelper = new DatabaseHelper(getContext());
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

        String groupBy = null;
        String having = null;
        String tableName;
        String[] projectionForAll;

        switch (uriMatcher.match(uri)) {
            case RELATIONSHIPS:
                tableName = DatabaseContract.RelationshipTableTeamsPlayers.TABLE_NAME;
                projectionForAll = DatabaseContract.RelationshipTableTeamsPlayers.projectionForAll;
                sortOrder = DatabaseContract.RelationshipTableTeamsPlayers.COLUMN_RELATIONSHIP_CREATED_TIMESTAMP + " ASC";
                break;
            case RELATIONSHIP_BY_TEAM_UUID:
                tableName = DatabaseContract.RelationshipTableTeamsPlayers.TABLE_NAME;
                projectionForAll = DatabaseContract.RelationshipTableTeamsPlayers.projectionForAll;
                sortOrder = DatabaseContract.RelationshipTableTeamsPlayers.COLUMN_RELATIONSHIP_CREATED_TIMESTAMP + " ASC";
                selection = DatabaseContract.RelationshipTableTeamsPlayers.COLUMN_TEAM_UUID + " = ?";
                selectionArgs[0] = (uri.getLastPathSegment()).toString();
                break;
            case RELATIONSHIP_BY_PLAYER_UUID:
                tableName = DatabaseContract.RelationshipTableTeamsPlayers.TABLE_NAME;
                projectionForAll = DatabaseContract.RelationshipTableTeamsPlayers.projectionForAll;
                sortOrder = DatabaseContract.RelationshipTableTeamsPlayers.COLUMN_RELATIONSHIP_CREATED_TIMESTAMP + " ASC";
                selection = DatabaseContract.RelationshipTableTeamsPlayers.COLUMN_PLAYER_UUID + " = ?";
                selectionArgs[0] = (uri.getLastPathSegment()).toString();
                break;
            case PERFORMANCES:
                // do nothing
                tableName = DatabaseContract.PerformanceTable.TABLE_NAME;
                projectionForAll = DatabaseContract.PerformanceTable.projectionForAll;
                sortOrder = DatabaseContract.PerformanceTable.COLUMN_PERFORMANCE_TABLE_CREATED_TIMESTAMP + " DESC";
                break;
            case PERFORMANCE_BY_JERSEY_NUMBER:
                tableName = DatabaseContract.PerformanceTable.TABLE_NAME;
                projectionForAll = DatabaseContract.PerformanceTable.projectionForAll;
                selection = DatabaseContract.PerformanceTable.COLUMN_JERSEY_NUMBER + " = ?";
                selectionArgs[0] = (uri.getLastPathSegment()).toString();
                sortOrder = DatabaseContract.PerformanceTable.COLUMN_PERFORMANCE_TABLE_CREATED_TIMESTAMP + " DESC";
                break;
            case PT2_MADE_BY_JERSEY_NUMBER:
                tableName = DatabaseContract.PerformanceTable.TABLE_NAME;
                projectionForAll = DatabaseContract.PerformanceTable.projectionForAll;
                selection = DatabaseContract.PerformanceTable.COLUMN_JERSEY_NUMBER + " = ? AND " +
                        DatabaseContract.PerformanceTable.COLUMN_PT_2 + " = ?";
                selectionArgs = new String[2];
                selectionArgs[0] = (uri.getLastPathSegment()).toString();
                selectionArgs[1] = Integer.toString(DatabaseContract.PerformanceTable.SHOT_MADE);
                sortOrder = DatabaseContract.PerformanceTable.COLUMN_PERFORMANCE_TABLE_CREATED_TIMESTAMP + " DESC";
                break;
            case PT2_MISSED_BY_JERSEY_NUMBER:
                tableName = DatabaseContract.PerformanceTable.TABLE_NAME;
                projectionForAll = DatabaseContract.PerformanceTable.projectionForAll;
                selection = DatabaseContract.PerformanceTable.COLUMN_JERSEY_NUMBER + " = ? AND " +
                        DatabaseContract.PerformanceTable.COLUMN_PT_2 + " = ?";
                selectionArgs = new String[2];
                selectionArgs[0] = (uri.getLastPathSegment()).toString();
                selectionArgs[1] = Integer.toString(DatabaseContract.PerformanceTable.SHOT_MISS);
                sortOrder = DatabaseContract.PerformanceTable.COLUMN_PERFORMANCE_TABLE_CREATED_TIMESTAMP + " DESC";
                break;
            case PT3_MADE_BY_JERSEY_NUMBER:
                tableName = DatabaseContract.PerformanceTable.TABLE_NAME;
                projectionForAll = DatabaseContract.PerformanceTable.projectionForAll;
                selection = DatabaseContract.PerformanceTable.COLUMN_JERSEY_NUMBER + " = ? AND " +
                        DatabaseContract.PerformanceTable.COLUMN_PT_3 + " = ?";
                selectionArgs = new String[2];
                selectionArgs[0] = (uri.getLastPathSegment()).toString();
                selectionArgs[1] = Integer.toString(DatabaseContract.PerformanceTable.SHOT_MADE);
                sortOrder = DatabaseContract.PerformanceTable.COLUMN_PERFORMANCE_TABLE_CREATED_TIMESTAMP + " DESC";
                break;
            case PT3_MISSED_BY_JERSEY_NUMBER:
                tableName = DatabaseContract.PerformanceTable.TABLE_NAME;
                projectionForAll = DatabaseContract.PerformanceTable.projectionForAll;
                selection = DatabaseContract.PerformanceTable.COLUMN_JERSEY_NUMBER + " = ? AND " +
                        DatabaseContract.PerformanceTable.COLUMN_PT_3 + " = ?";
                selectionArgs = new String[2];
                selectionArgs[0] = (uri.getLastPathSegment()).toString();
                selectionArgs[1] = Integer.toString(DatabaseContract.PerformanceTable.SHOT_MISS);
                sortOrder = DatabaseContract.PerformanceTable.COLUMN_PERFORMANCE_TABLE_CREATED_TIMESTAMP + " DESC";
                break;
            case PT1_MADE_BY_JERSEY_NUMBER:
                tableName = DatabaseContract.PerformanceTable.TABLE_NAME;
                projectionForAll = DatabaseContract.PerformanceTable.projectionForAll;
                selection = DatabaseContract.PerformanceTable.COLUMN_JERSEY_NUMBER + " = ? AND " +
                        DatabaseContract.PerformanceTable.COLUMN_PT_1 + " = ?";
                selectionArgs = new String[2];
                selectionArgs[0] = (uri.getLastPathSegment()).toString();
                selectionArgs[1] = Integer.toString(DatabaseContract.PerformanceTable.SHOT_MADE);
                sortOrder = DatabaseContract.PerformanceTable.COLUMN_PERFORMANCE_TABLE_CREATED_TIMESTAMP + " DESC";
                break;
            case PT1_MISSED_BY_JERSEY_NUMBER:
                tableName = DatabaseContract.PerformanceTable.TABLE_NAME;
                projectionForAll = DatabaseContract.PerformanceTable.projectionForAll;
                selection = DatabaseContract.PerformanceTable.COLUMN_JERSEY_NUMBER + " = ? AND " +
                        DatabaseContract.PerformanceTable.COLUMN_PT_1 + " = ?";
                selectionArgs = new String[2];
                selectionArgs[0] = (uri.getLastPathSegment()).toString();
                selectionArgs[1] = Integer.toString(DatabaseContract.PerformanceTable.SHOT_MISS);
                sortOrder = DatabaseContract.PerformanceTable.COLUMN_PERFORMANCE_TABLE_CREATED_TIMESTAMP + " DESC";
                break;
            case STEAL_BY_JERSEY_NUMBER:
                tableName = DatabaseContract.PerformanceTable.TABLE_NAME;
                projectionForAll = DatabaseContract.PerformanceTable.projectionForAll;
                selection = DatabaseContract.PerformanceTable.COLUMN_JERSEY_NUMBER + " = ? AND " +
                        DatabaseContract.PerformanceTable.COLUMN_STEAL + " = ?";
                selectionArgs = new String[2];
                selectionArgs[0] = (uri.getLastPathSegment()).toString();
                selectionArgs[1] = Integer.toString(DatabaseContract.PerformanceTable.STEAL_MADE);
                sortOrder = DatabaseContract.PerformanceTable.COLUMN_PERFORMANCE_TABLE_CREATED_TIMESTAMP + " DESC";
                break;
            case OFF_REB_BY_JERSEY_NUMBER:
                tableName = DatabaseContract.PerformanceTable.TABLE_NAME;
                projectionForAll = DatabaseContract.PerformanceTable.projectionForAll;
                selection = DatabaseContract.PerformanceTable.COLUMN_JERSEY_NUMBER + " = ? AND " +
                        DatabaseContract.PerformanceTable.COLUMN_OFF_REB + " = ?";
                selectionArgs = new String[2];
                selectionArgs[0] = (uri.getLastPathSegment()).toString();
                selectionArgs[1] = Integer.toString(DatabaseContract.PerformanceTable.REB_GOT);
                sortOrder = DatabaseContract.PerformanceTable.COLUMN_PERFORMANCE_TABLE_CREATED_TIMESTAMP + " DESC";
                break;
            case DEF_REB_BY_JERSEY_NUMBER:
                tableName = DatabaseContract.PerformanceTable.TABLE_NAME;
                projectionForAll = DatabaseContract.PerformanceTable.projectionForAll;
                selection = DatabaseContract.PerformanceTable.COLUMN_JERSEY_NUMBER + " = ? AND " +
                        DatabaseContract.PerformanceTable.COLUMN_DEF_REB + " = ?";
                selectionArgs = new String[2];
                selectionArgs[0] = (uri.getLastPathSegment()).toString();
                selectionArgs[1] = Integer.toString(DatabaseContract.PerformanceTable.REB_GOT);
                sortOrder = DatabaseContract.PerformanceTable.COLUMN_PERFORMANCE_TABLE_CREATED_TIMESTAMP + " DESC";
                break;
            case FAUL_BY_JERSEY_NUMBER:
                tableName = DatabaseContract.PerformanceTable.TABLE_NAME;
                projectionForAll = DatabaseContract.PerformanceTable.projectionForAll;
                selection = DatabaseContract.PerformanceTable.COLUMN_JERSEY_NUMBER + " = ? AND " +
                        DatabaseContract.PerformanceTable.COLUMN_PERSONAL_FAUL + " = ?";
                selectionArgs = new String[2];
                selectionArgs[0] = (uri.getLastPathSegment()).toString();
                selectionArgs[1] = Integer.toString(DatabaseContract.PerformanceTable.FAUL_COMMITTED);
                sortOrder = DatabaseContract.PerformanceTable.COLUMN_PERFORMANCE_TABLE_CREATED_TIMESTAMP + " DESC";
                break;
            case TURNOVER_BY_JERSEY_NUMBER:
                tableName = DatabaseContract.PerformanceTable.TABLE_NAME;
                projectionForAll = DatabaseContract.PerformanceTable.projectionForAll;
                selection = DatabaseContract.PerformanceTable.COLUMN_JERSEY_NUMBER + " = ? AND " +
                        DatabaseContract.PerformanceTable.COLUMN_TURNOVER + " = ?";
                selectionArgs = new String[2];
                selectionArgs[0] = (uri.getLastPathSegment()).toString();
                selectionArgs[1] = Integer.toString(DatabaseContract.PerformanceTable.TURNOVER_MADE);
                sortOrder = DatabaseContract.PerformanceTable.COLUMN_PERFORMANCE_TABLE_CREATED_TIMESTAMP + " DESC";
                break;
            case BLOCK_BY_JERSEY_NUMBER:
                tableName = DatabaseContract.PerformanceTable.TABLE_NAME;
                projectionForAll = DatabaseContract.PerformanceTable.projectionForAll;
                selection = DatabaseContract.PerformanceTable.COLUMN_JERSEY_NUMBER + " = ? AND " +
                        DatabaseContract.PerformanceTable.COLUMN_BLOCK + " = ?";
                selectionArgs = new String[2];
                selectionArgs[0] = (uri.getLastPathSegment()).toString();
                selectionArgs[1] = Integer.toString(DatabaseContract.PerformanceTable.BLOCK_MADE);
                sortOrder = DatabaseContract.PerformanceTable.COLUMN_PERFORMANCE_TABLE_CREATED_TIMESTAMP + " DESC";
                break;
            case ASSIST_BY_JERSEY_NUMBER:
                tableName = DatabaseContract.PerformanceTable.TABLE_NAME;
                projectionForAll = DatabaseContract.PerformanceTable.projectionForAll;
                selection = DatabaseContract.PerformanceTable.COLUMN_JERSEY_NUMBER + " = ? AND " +
                        DatabaseContract.PerformanceTable.COLUMN_ASSIST + " = ?";
                selectionArgs = new String[2];
                selectionArgs[0] = (uri.getLastPathSegment()).toString();
                selectionArgs[1] = Integer.toString(DatabaseContract.PerformanceTable.ASSIST_MADE);
                sortOrder = DatabaseContract.PerformanceTable.COLUMN_PERFORMANCE_TABLE_CREATED_TIMESTAMP + " DESC";
                break;
            // for team table
            case TEAMS:
                tableName = DatabaseContract.TeamTable.TABLE_NAME;
                projectionForAll = DatabaseContract.TeamTable.projectionForAll;
                selection = null;
                selectionArgs = null;
                sortOrder = DatabaseContract.TeamTable.COLUMN_TEAM_PROFILE_CREATED_TIMESTAMP + " DESC";
                break;
            case TEAM:
                tableName = DatabaseContract.TeamTable.TABLE_NAME;
                projectionForAll = DatabaseContract.TeamTable.projectionForAll;
                selection = DatabaseContract.TeamTable.COLUMN_TEAM_NAME + " = ?";
                selectionArgs[0] = (uri.getLastPathSegment().toString());
                sortOrder = DatabaseContract.TeamTable.COLUMN_TEAM_PROFILE_CREATED_TIMESTAMP + " DESC";
                break;
            // for players table
            case PLAYERS:
                tableName = DatabaseContract.PlayerTable.TABLE_NAME;
                projectionForAll = DatabaseContract.PlayerTable.projectionForAll;
                selection = null;
                selectionArgs = null;
                sortOrder = DatabaseContract.PlayerTable.COLUMN_PLAYER_PROFILE_CREATED_TIMESTAMP + " DESC";
                break;
            case PLAYER_BY_PLAYER_UUID:
                tableName = DatabaseContract.PlayerTable.TABLE_NAME;
                projectionForAll = DatabaseContract.PlayerTable.projectionForAll;
                selection = DatabaseContract.PlayerTable.COLUMN_PLAYER_JERSEY_NUMBER + " = ?";
                // todo: what will happen if number "=" with string, or number`(as string) "=" with string
                selectionArgs[0] = (uri.getLastPathSegment().toString());
                sortOrder = DatabaseContract.PlayerTable.COLUMN_PLAYER_PROFILE_CREATED_TIMESTAMP + " DESC";
                break;
            case PLAYER_BY_FIRST_NAME:
                tableName = DatabaseContract.PlayerTable.TABLE_NAME;
                projectionForAll = DatabaseContract.PlayerTable.projectionForAll;
                selection = DatabaseContract.PlayerTable.COLUMN_PLAYER_FIRST_NAME + " = ?";
                selectionArgs[0] = (uri.getLastPathSegment().toString());
                sortOrder = DatabaseContract.PlayerTable.COLUMN_PLAYER_PROFILE_CREATED_TIMESTAMP + " DESC";
                break;
            case PLAYER_BY_LAST_NAME:
                tableName = DatabaseContract.PlayerTable.TABLE_NAME;
                projectionForAll = DatabaseContract.PlayerTable.projectionForAll;
                selection = DatabaseContract.PlayerTable.COLUMN_PLAYER_LAST_NAME + " = ?";
                selectionArgs[0] = (uri.getLastPathSegment().toString());
                sortOrder = DatabaseContract.PlayerTable.COLUMN_PLAYER_PROFILE_CREATED_TIMESTAMP + " DESC";
                break;
            case PLAYER_BY_HEIGHT:
                tableName = DatabaseContract.PlayerTable.TABLE_NAME;
                projectionForAll = DatabaseContract.PlayerTable.projectionForAll;
                selection = DatabaseContract.PlayerTable.COLUMN_PLAYER_HEIGHT + " > ?";
                selectionArgs[0] = (uri.getLastPathSegment().toString());
                sortOrder = DatabaseContract.PlayerTable.COLUMN_PLAYER_PROFILE_CREATED_TIMESTAMP + " DESC";
                break;
            case PLAYER_BY_WEIGHT:
                tableName = DatabaseContract.PlayerTable.TABLE_NAME;
                projectionForAll = DatabaseContract.PlayerTable.projectionForAll;
                // todo: select a range of weight
                selection = DatabaseContract.PlayerTable.COLUMN_PLAYER_WEIGHT + " > ?";
                selectionArgs[0] = (uri.getLastPathSegment().toString());
                sortOrder = DatabaseContract.PlayerTable.COLUMN_PLAYER_PROFILE_CREATED_TIMESTAMP + " DESC";
                break;
            case PLAYER_BY_POSITION:
                tableName = DatabaseContract.PlayerTable.TABLE_NAME;
                projectionForAll = DatabaseContract.PlayerTable.projectionForAll;
                selection = DatabaseContract.PlayerTable.COLUMN_PLAYER_POSITION + " = ?";
                selectionArgs[0] = (uri.getLastPathSegment().toString());
                sortOrder = DatabaseContract.PlayerTable.COLUMN_PLAYER_PROFILE_CREATED_TIMESTAMP + " DESC";
                break;
            default:
                throw new IllegalArgumentException("Unkown URI " + uri);
        }

        queryBuilder.setTables(tableName);
        Cursor cursor = queryBuilder.query(database,
                projectionForAll,
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
            case TEAMS:
                return DatabaseContract.TeamTable.TEAMS_CONTENT_TYPE;
            case TEAM:
                return DatabaseContract.TeamTable.TEAM_CONTENT_ITEM_TYPE;
            case PLAYERS:
                return DatabaseContract.PlayerTable.PLAYERS_CONTENT_TYPE;
            case PLAYER_BY_PLAYER_UUID:
            case PLAYER_BY_FIRST_NAME:
            case PLAYER_BY_LAST_NAME:
            case PLAYER_BY_HEIGHT:
            case PLAYER_BY_WEIGHT:
            case PLAYER_BY_POSITION:
                return DatabaseContract.PlayerTable.PLAYER_CONTENT_ITEM_TYPE;
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long id = 0L;
        switch (uriMatcher.match(uri)) {
            case PERFORMANCES:
                id = database.insertWithOnConflict(
                        DatabaseContract.PerformanceTable.TABLE_NAME,
                        null,
                        values,
                        SQLiteDatabase.CONFLICT_REPLACE);
                return getUriForId(id, uri);
            case PLAYERS:
                id = database.insertWithOnConflict(
                        DatabaseContract.PlayerTable.TABLE_NAME,
                        null,
                        values,
                        SQLiteDatabase.CONFLICT_REPLACE);
                return getUriForId(id, uri);
            case TEAMS:
                id = database.insertWithOnConflict(
                        DatabaseContract.TeamTable.TABLE_NAME,
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
        switch (uriMatcher.match(uri)) {
            case REVOKE_LAST_PERFORMANCE_RECORD:
/*                selection = "SELECT * FROM " + DatabaseContract.PerformanceTable.TABLE_NAME
                        + " ORDER BY " + DatabaseContract.PerformanceTable.COLUMN_PERFORMANCE_TABLE_CREATED_TIMESTAMP
                        + " LIMIT ?";
                selectionArgs = new String[]{"1"};
                int rowDeleted = getContext().getContentResolver().delete(
                        DatabaseContract.PerformanceTable.CONTENT_URI_REVOKE_LAST_PERFORMANCE_RECORD,
                        selection,
                        selectionArgs);
                Log.v(LOG_TAG, rowDeleted + " rows have been deleted");*/
                String deleteLastRowQuery = "DELETE FROM " + DatabaseContract.PerformanceTable.TABLE_NAME
                        + " WHERE " + DatabaseContract.PerformanceTable.COLUMN_PERFORMANCE_TABLE_CREATED_TIMESTAMP + " IN"
                        + " (SELECT " + DatabaseContract.PerformanceTable.COLUMN_PERFORMANCE_TABLE_CREATED_TIMESTAMP + " FROM " + DatabaseContract.PerformanceTable.TABLE_NAME
                        + " ORDER BY " + DatabaseContract.PerformanceTable.COLUMN_PERFORMANCE_TABLE_CREATED_TIMESTAMP + " DESC"
                        + " LIMIT 1)";
                Log.v(LOG_TAG, "deleteLastRowQuery: " + deleteLastRowQuery);
                database.execSQL(deleteLastRowQuery);
                getContext().getContentResolver().notifyChange(uri, null);
                return 0;
            default:
                throw new IllegalArgumentException("Unkown URI: " + uri);
        }
    }

/*    private void deleteLastRow(String TableName, int JerseyNumber) {
        String deletionQuery = "";
        if (JerseyNumber >= 0) {
            deletionQuery = "SELECT * FROM " + DatabaseContract.PerformanceTable.TABLE_NAME +
                    " ORDER BY " + DatabaseContract.COLUMN_TIMESTAMP +
                    " LIMIT 1";
        }

    }*/

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
