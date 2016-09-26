package com.leontheprofessional.bballscoreboard.game.model;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.util.Log;

import com.leontheprofessional.bballscoreboard.database.DatabaseContract;

/**
 * Created by LeonthePro7 on 9/25/2016.
 */

public class GameModel {

    private static final String LOG_TAG = GameModel.class.getSimpleName();

    public String gameUUID;
    public CourtModel courtModel;
    public String hostTeamUUID;
    public String guestTeamUUID;
    public long gameTimeStamp;

    public GameModel(String gameUUID, CourtModel courtModel, String hostTeamUUID, String guestTeamUUID) {
        this.gameUUID = gameUUID;
        this.courtModel = courtModel;
        this.hostTeamUUID = hostTeamUUID;
        this.guestTeamUUID = guestTeamUUID;
        this.gameTimeStamp = System.currentTimeMillis();
    }

    public String getGameUUID() {
        return gameUUID;
    }

    public void setGameUUID(String gameUUID) {
        this.gameUUID = gameUUID;
    }

    public CourtModel getCourtModel() {
        return courtModel;
    }

    public void setCourtModel(CourtModel courtModel) {
        this.courtModel = courtModel;
    }

    public String getHostTeamUUID() {
        return hostTeamUUID;
    }

    public void setHostTeamUUID(String hostTeamUUID) {
        this.hostTeamUUID = hostTeamUUID;
    }

    public String getGuestTeamUUID() {
        return guestTeamUUID;
    }

    public void setGuestTeamUUID(String guestTeamUUID) {
        this.guestTeamUUID = guestTeamUUID;
    }

    public long getGameTimeStamp() {
        return gameTimeStamp;
    }

    public static void insertOneGameInfo(Context context, GameModel gameModel) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseContract.GameTable.COLUMN_GAME_UUID, gameModel.getGameUUID());
        contentValues.put(DatabaseContract.GameTable.COLUMN_HOST_TEAM_UUID, gameModel.getHostTeamUUID());
        contentValues.put(DatabaseContract.GameTable.COLUMN_GUEST_TEAM_UUID, gameModel.getGuestTeamUUID());
        contentValues.put(DatabaseContract.GameTable.COLUMN_COURT_NAME, gameModel.getCourtModel().getCourtName());
        contentValues.put(DatabaseContract.GameTable.COLUMN_COURT_LATITUDE, gameModel.getCourtModel().getCourtLatitude());
        contentValues.put(DatabaseContract.GameTable.COLUMN_COURT_LONGITUDE, gameModel.getCourtModel().getCourtLongitude());
        contentValues.put(DatabaseContract.GameTable.COLUMN_COURT_ADDRESS, gameModel.getCourtModel().getCourtAddress());
        contentValues.put(DatabaseContract.GameTable.COLUMN_GAME_TIMESTAMP, gameModel.getGameTimeStamp());
        Uri uri = context.getContentResolver().insert(DatabaseContract.GameTable.CONTENT_URI_GAMES, contentValues);
        Log.v(LOG_TAG, uri.toString());
    }
}
