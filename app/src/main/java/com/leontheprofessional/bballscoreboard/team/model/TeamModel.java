package com.leontheprofessional.bballscoreboard.team.model;

import android.content.ContentValues;
import android.content.Context;

import com.leontheprofessional.bballscoreboard.database.DatabaseContract;

import java.util.ArrayList;

/**
 * Created by LeonthePro7 on 9/25/2016.
 */

public class TeamModel {

    public String teamName;
    public String teamUUID;
    public String playerUUID;
    public long timeStamp;

    public TeamModel(String teamName, String teamUUID, String playerUUID) {
        this.teamName = teamName;
        this.teamUUID = teamUUID;
        this.playerUUID = playerUUID;
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

    public void setTeamUUID(String teamUUID) {
        this.teamUUID = teamUUID;
    }

    public String getPlayerUUID() {
        return playerUUID;
    }

    public void setPlayerUUID(String playerUUID) {
        this.playerUUID = playerUUID;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void insertATeamIntoDB(Context context, TeamModel teamModel) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseContract.TeamTable.COLUMN_TEAM_UUID, teamModel.getTeamUUID());
        contentValues.put(DatabaseContract.TeamTable.COLUMN_TEAM_NAME, teamModel.getTeamName());
        contentValues.put(DatabaseContract.TeamTable.COLUMN_TEAM_PROFILE_CREATED_TIMESTAMP, timeStamp.getTeamUUID());


    }

    public void buildATeam(Context context, ArrayList<TeamModel> teams) {

    }

    public ArrayList<TeamModel> getAllTeams() {

    }
}
