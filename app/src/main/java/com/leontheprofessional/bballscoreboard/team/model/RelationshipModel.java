package com.leontheprofessional.bballscoreboard.team.model;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.util.Log;

import com.leontheprofessional.bballscoreboard.database.DatabaseContract;
import com.leontheprofessional.bballscoreboard.player.model.PlayerModel;

import java.util.ArrayList;

/**
 * Created by LeonthePro7 on 9/25/2016.
 */

public class RelationshipModel {
    private static final String LOG_TAG = RelationshipModel.class.getSimpleName();

    private TeamModel team;
    private ArrayList<PlayerModel> players;
    private long relationshipCreatedTimeStamp;


    public RelationshipModel(TeamModel team, ArrayList<PlayerModel> players) {
        this.team = team;
        this.players = players;
        this.relationshipCreatedTimeStamp = System.currentTimeMillis();
    }

    public TeamModel getTeam() {
        return team;
    }

    public String getTeamUUID() {
        return team.getTeamUUID();
    }

    public void setTeam(TeamModel team) {
        this.team = team;
    }

    public ArrayList<PlayerModel> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<PlayerModel> players) {
        this.players = players;
    }

    public long getRelationshipCreatedTimeStamp() {
        return relationshipCreatedTimeStamp;
    }

    public static void buildUpATeam(Context context, TeamModel teamModel, ArrayList<PlayerModel> players) {

        RelationshipModel relationshipModel = new RelationshipModel(teamModel, players);
        for (int i = 0; i < players.size(); i++) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(DatabaseContract.RelationshipTableTeamsPlayers.COLUMN_TEAM_UUID, relationshipModel.getTeamUUID());
            contentValues.put(DatabaseContract.RelationshipTableTeamsPlayers.COLUMN_PLAYER_UUID, players.get(i).getPlayerUUID());
            contentValues.put(DatabaseContract.RelationshipTableTeamsPlayers.COLUMN_RELATIONSHIP_CREATED_TIMESTAMP, relationshipModel.getRelationshipCreatedTimeStamp());
            Uri uri = context.getContentResolver().insert(DatabaseContract.RelationshipTableTeamsPlayers.CONTENT_URI_RELATIONSHIPS, contentValues);
            Log.v(LOG_TAG, "buildUpATeam: " + uri.toString());
        }
    }

    public static void addNewPlayersToTeam(Context context, TeamModel teamModel, ArrayList<PlayerModel> players) {
        RelationshipModel relationshipModel = new RelationshipModel(teamModel, players);
        for (int i = 0; i < players.size(); i++) {
            ContentValues contentValue = new ContentValues();
            contentValue.put(DatabaseContract.RelationshipTableTeamsPlayers.COLUMN_TEAM_UUID, teamModel.getTeamUUID());
            contentValue.put(DatabaseContract.RelationshipTableTeamsPlayers.COLUMN_PLAYER_UUID, players.get(i).getPlayerUUID());
            contentValue.put(DatabaseContract.RelationshipTableTeamsPlayers.COLUMN_RELATIONSHIP_CREATED_TIMESTAMP, relationshipModel.getRelationshipCreatedTimeStamp());

            Uri uri = context.getContentResolver().insert(DatabaseContract.RelationshipTableTeamsPlayers.CONTENT_URI_RELATIONSHIPS, contentValue);
            Log.v(LOG_TAG, "addNewPlayersToTeam: " + uri.toString());
        }
    }
}
