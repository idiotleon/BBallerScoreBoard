package com.leontheprofessional.bballscoreboard.team.model;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

import com.leontheprofessional.bballscoreboard.database.DatabaseContract;
import com.leontheprofessional.bballscoreboard.player.model.PlayerModel;

import java.util.ArrayList;

/**
 * Created by LeonthePro7 on 9/25/2016.
 */

public class TeamModel {
    private static final String LOG_TAG = TeamModel.class.getSimpleName();

    public String teamName;
    public String teamUUID;
    public ArrayList<PlayerModel> players;
    public long timeStamp;

    public TeamModel(String teamUUID) {
        this.teamUUID = teamUUID;
    }

    public TeamModel(String teamName, String teamUUID, ArrayList<PlayerModel> players) {
        this.teamName = teamName;
        this.teamUUID = teamUUID;
        this.players = players;
        this.timeStamp = System.currentTimeMillis();
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamUUID() {
        return teamUUID;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public static void insertATeamIntoDB(Context context, TeamModel teamModel) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseContract.TeamTable.COLUMN_TEAM_UUID, teamModel.getTeamUUID());
        contentValues.put(DatabaseContract.TeamTable.COLUMN_TEAM_NAME, teamModel.getTeamName());
        contentValues.put(DatabaseContract.TeamTable.COLUMN_TEAM_PROFILE_CREATED_TIMESTAMP, teamModel.getTeamUUID());

        Uri uri = context.getContentResolver().insert(DatabaseContract.TeamTable.CONTENT_URI_TEAMS, contentValues);
        Log.v(LOG_TAG, uri.toString());
    }

    public static ArrayList<PlayerModel> getAllPlayersInATeam(Context context, String teamUUID) {
        ArrayList<PlayerModel> players = new ArrayList<>();
        String urlRelationshipByTeamUUID = DatabaseContract.RelationshipTableTeamsPlayers.URL_RELATIONSHIP + DatabaseContract.RelationshipTableTeamsPlayers.URL_RELATIONSHIP_BY_TEAM_UUID + teamUUID;
        Uri uriRelationshipByTeamUUID = Uri.parse(urlRelationshipByTeamUUID);
        Cursor playersCursor = context.getContentResolver().query(uriRelationshipByTeamUUID, null, null, null, null);
        for (playersCursor.moveToFirst(); !playersCursor.isAfterLast(); playersCursor.moveToNext()) {
            String playerUUID = playersCursor.getString(playersCursor.getColumnIndexOrThrow(DatabaseContract.RelationshipTableTeamsPlayers.COLUMN_PLAYER_UUID));
            PlayerModel playerModel = new PlayerModel(playerUUID);
            players.add(playerModel);
        }
        return players;
    }

    public static TeamModel getATeamByTeamUUID(Context context, String teamUUID) {
        String urlTeamByTeamUUID = DatabaseContract.TeamTable.URL_TEAM + DatabaseContract.TeamTable.URL_TEAM_BY_UUID + teamUUID;
        Uri uriTeamByTeamUUID = Uri.parse(urlTeamByTeamUUID);
        Cursor teamCursor = context.getContentResolver().query(uriTeamByTeamUUID, null, null, null, null);
        return cursorToModel(context, teamCursor);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static ArrayList<TeamModel> getAllTeams(Context context) {
        Cursor teamCursor = context.getContentResolver().query(DatabaseContract.TeamTable.CONTENT_URI_TEAMS, null, null, null, null, null);
        ArrayList<TeamModel> allTeams = new ArrayList<>();
        for (teamCursor.moveToFirst(); teamCursor.isAfterLast(); teamCursor.moveToNext()) {
            allTeams.add(cursorToModel(context, teamCursor));
        }
        return allTeams;
    }

    public static TeamModel cursorToModel(Context context, Cursor teamCursor) {
        String teamName = teamCursor.getString(teamCursor.getColumnIndexOrThrow(DatabaseContract.TeamTable.COLUMN_TEAM_NAME));
        String teamUUID = teamCursor.getString(teamCursor.getColumnIndexOrThrow(DatabaseContract.TeamTable.COLUMN_TEAM_UUID));
        ArrayList<PlayerModel> players = getAllPlayersInATeam(context, teamUUID);
        return new TeamModel(teamName, teamUUID, players);
    }
}
