package com.leontheprofessional.bballscoreboard.player.model;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import com.leontheprofessional.bballscoreboard.database.DatabaseContract;
import com.leontheprofessional.bballscoreboard.team.model.TeamModel;

import java.util.ArrayList;

/**
 * Created by LeonthePro7 on 9/25/2016.
 */

public class PlayerModel {

    public String playerUUID;
    public String playerFirstName;
    public String playerLastName;
    public String playerPositions;
    public double playerHeight;
    public double playerWeight;
    public int playerJerseyNumber;

    public PlayerModel(String playerUUID) {
        this.playerUUID = playerUUID;
    }

    public PlayerModel(String playerUUID, String playerFirstName, String playerLastName, String playerPositions, double playerHeight, double playerWeight, int playerJerseyNumber) {
        this.playerUUID = playerUUID;
        this.playerFirstName = playerFirstName;
        this.playerLastName = playerLastName;
        this.playerPositions = playerPositions;
        this.playerHeight = playerHeight;
        this.playerWeight = playerWeight;
        this.playerJerseyNumber = playerJerseyNumber;
    }

    public int getPlayerJerseyNumber() {
        return playerJerseyNumber;
    }

    public void setPlayerJerseyNumber(int playerJerseyNumber) {
        this.playerJerseyNumber = playerJerseyNumber;
    }

    public String getPlayerUUID() {
        return playerUUID;
    }

    public void setPlayerUUID(String playerUUID) {
        this.playerUUID = playerUUID;
    }

    public String getPlayerFirstName() {
        return playerFirstName;
    }

    public void setPlayerFirstName(String playerFirstName) {
        this.playerFirstName = playerFirstName;
    }

    public String getPlayerLastName() {
        return playerLastName;
    }

    public void setPlayerLastName(String playerLastName) {
        this.playerLastName = playerLastName;
    }

    public String getPlayerPositions() {
        return playerPositions;
    }

    public void setPlayerPositions(String playerPositions) {
        this.playerPositions = playerPositions;
    }

    public double getPlayerHeight() {
        return playerHeight;
    }

    public void setPlayerHeight(double playerHeight) {
        this.playerHeight = playerHeight;
    }

    public double getPlayerWeight() {
        return playerWeight;
    }

    public void setPlayerWeight(double playerWeight) {
        this.playerWeight = playerWeight;
    }

    public static ArrayList<TeamModel> getAllTeamsForAPlayer(Context context, String playerUUID) {
        ArrayList<TeamModel> teams = new ArrayList<>();
        String urlRelationshipByPlayerUUID = DatabaseContract.RelationshipTableTeamsPlayers.URL_RELATIONSHIP + DatabaseContract.RelationshipTableTeamsPlayers.URL_RELATIONSHIP_BY_PLAYER_UUID + playerUUID;
        Uri uriRelationshipByPlayerUUID = Uri.parse(urlRelationshipByPlayerUUID);
        Cursor teamCursor = context.getContentResolver().query(uriRelationshipByPlayerUUID, null, null, null, null);
        for (teamCursor.moveToNext(); !teamCursor.isAfterLast(); teamCursor.moveToNext()) {
            String teamUUID = teamCursor.getString(teamCursor.getColumnIndexOrThrow(DatabaseContract.RelationshipTableTeamsPlayers.COLUMN_TEAM_UUID));
            TeamModel teamModel = new TeamModel(teamUUID);
            teams.add(teamModel);
        }
        return teams;
    }
}
