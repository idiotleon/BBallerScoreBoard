package com.leontheprofessional.bballscoreboard.database;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;
import android.util.Log;

public final class DatabaseContract {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "scoreboard.db";
    public static final String COMMA_SEPARATOR = ", ";
    public static final String TYPE_INTEGER = " INTEGER";
    public static final String TYPE_TEXT = " TEXT";
    public static final String TYPE_BLOB = " BLOB";
    // Todo: change it to real DateTimeType
    public static final String TYPE_DATETIME = " TEXT";
    public static final String COLUMN_TIMESTAMP = "datetimestamp";

    // All data of all players in a game
    public static final String AUTHORITY = "com.leontheprofessional.bballscoreboard";


    // To prevent someone from accidentally instantiating the contract class
    // have an empty constructor
    private DatabaseContract() {
    }

    // todo: This is the very simple table, very inefficient. Improvement will be made later on
    public static abstract class PerformanceTable implements BaseColumns {
        public static final int SHOT_MADE = 1;
        public static final int SHOT_MISS = 2;
        public static final int STEAL_MADE = 1;
        public static final int REB_GOT = 1;
        public static final int FAUL_COMMITTED = 1;
        public static final int TURNOVER_MADE = 1;
        public static final int BLOCK_MADE = 1;

        public static final String URL_PERFORMANCE = "content://" + AUTHORITY + "/performance/";
        public static final String URL_PERFORMANCE_PT2_MADE = "pt2made/";
        public static final String URL_PERFORMANCE_PT2_MISSED = "pt2missed/";
        public static final String URL_PERFORMANCE_PT3_MADE = "pt3made/";
        public static final String URL_PERFORMANCE_PT3_MISSED = "pt3missed/";
        public static final String URL_PERFORMANCE_PT1_MADE = "pt1made/";
        public static final String URL_PERFORMANCE_PT1_MISSED = "pt1missed/";
        public static final String URL_PERFORMANCE_STEAL = "steal/";
        public static final String URL_PERFORMANCE_OFF_REB = "offreb/";
        public static final String URL_PERFORMANCE_DEF_REB = "defreb/";
        public static final String URL_PERFORMANCE_FAUL = "faul/";
        public static final String URL_PERFORMANCE_TURNOVER = "turnover/";
        public static final String URL_PERFORMANCE_BLOCK = "block/";

        public static final String TABLE_NAME = "performance_table";
        public static final String COLUMN_JERSEY_NUMBER = "jersey_number";
        public static final String COLUMN_PT_3 = "pt_3";
        public static final String COLUMN_PT_2 = "pt_2";
        public static final String COLUMN_PT_1 = "pt_1";
        public static final String COLUMN_STEAL = "steal";
        public static final String COLUMN_OFF_REB = "offensive_reb";
        public static final String COLUMN_DEF_REB = "defensive_reb";
        public static final String COLUMN_FAUL = "faul";
        public static final String COLUMN_TURNOVER = "turnover";
        public static final String COLUMN_BLOCK = "block";

        public static final String URL_PERFORMANCES = "content://" + AUTHORITY + "/performances";
        public static final Uri CONTENT_URI_PERFORMANCES = Uri.parse(URL_PERFORMANCES);
        public static final String[] projectionForAllPerformanceTable = {
                COLUMN_JERSEY_NUMBER,
                COLUMN_PT_3,
                COLUMN_PT_2,
                COLUMN_PT_1,
                COLUMN_STEAL,
                COLUMN_OFF_REB,
                COLUMN_DEF_REB,
                COLUMN_FAUL,
                COLUMN_TURNOVER,
                COLUMN_BLOCK,
                COLUMN_TIMESTAMP
        };

        public static final String PERFORMANCE_CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE +
                "vnd." + AUTHORITY + ".performances";
        public static final String PERFORMANCE_CONTENT_ITEM_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE +
                "vnd." + AUTHORITY + ".performance";

        public static final String PERFORMANCE_TABLE_CREATION = "CREATE TABLE " +
                TABLE_NAME + " (" +
                "_id" + TYPE_INTEGER + " PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_JERSEY_NUMBER + " INTEGER" + COMMA_SEPARATOR +
                COLUMN_PT_3 + TYPE_INTEGER + COMMA_SEPARATOR +
                COLUMN_PT_2 + TYPE_INTEGER + COMMA_SEPARATOR +
                COLUMN_PT_1 + TYPE_INTEGER + COMMA_SEPARATOR +
                COLUMN_STEAL + TYPE_INTEGER + COMMA_SEPARATOR +
                COLUMN_OFF_REB + TYPE_INTEGER + COMMA_SEPARATOR +
                COLUMN_DEF_REB + TYPE_INTEGER + COMMA_SEPARATOR +
                COLUMN_FAUL + TYPE_INTEGER + COMMA_SEPARATOR +
                COLUMN_TURNOVER + TYPE_INTEGER + COMMA_SEPARATOR +
                COLUMN_BLOCK + TYPE_INTEGER + COMMA_SEPARATOR +
                COLUMN_TIMESTAMP + TYPE_DATETIME + ")";

        public static final String PERFORMANCE_TABLE_DELETION = "DROP TABLE IF EXISTS " + TABLE_NAME;

    }

    public static abstract class PlayerTable implements BaseColumns {

        public static final String TABLE_NAME = "player_table";

        public static final String URL_PLAYER = "content://" + AUTHORITY + "/player/";
        public static final String URL_PLAYER_BY_JERSEY_NUMBER = "by_jsersey_number/";
        public static final String URL_PLAYER_BY_FIRST_NAME = "by_first_name/";
        public static final String URL_PLAYER_BY_LAST_NAME = "by_last_name/";
        public static final String URL_PLAYER_BY_HEIGHT = "by_height/";
        public static final String URL_PLAYER_BY_WEIGHT = "by_weight/";
        public static final String URL_PLAYER_BY_POSITION = "by_position/";

        public static final String COLUMN_PLAYER_GENERAL_ID = "_id";
        public static final String COLUMN_PLAYER_UUID = "uuid";
        public static final String COLUMN_PLAYER_FIRST_NAME = "first_name";
        public static final String COLUMN_PLAYER_LAST_NAME = "last_name";
        // todo: enumeration type for sqlite database
        public static final String COLUMN_POSITION = "position";
        public static final String COLUMN_PLAYER_HEIGHT = "player_height";
        public static final String COLUMN_PLAYER_WEIGHT = "player_weight";
        public static final String COLUMN_PLAYER_PROFILE_CREATION_TIMESTAMP = "time_stamp";

        public static final String PLAYER_TABLE_CREATION = "CREATE TABLE " +
                TABLE_NAME + " (" +
                // todo: uuid for players
                COLUMN_PLAYER_GENERAL_ID + TYPE_INTEGER + " PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_PLAYER_UUID + TYPE_BLOB + COMMA_SEPARATOR +
                COLUMN_PLAYER_FIRST_NAME + TYPE_TEXT + COMMA_SEPARATOR +
                COLUMN_PLAYER_LAST_NAME + TYPE_TEXT + COMMA_SEPARATOR +
                COLUMN_POSITION + TYPE_TEXT + COMMA_SEPARATOR +
                COLUMN_PLAYER_HEIGHT + TYPE_INTEGER + COMMA_SEPARATOR +
                COLUMN_PLAYER_WEIGHT + TYPE_INTEGER + COMMA_SEPARATOR +
                COLUMN_PLAYER_PROFILE_CREATION_TIMESTAMP + TYPE_DATETIME + ")";

        public static final String PLAYER_TABLE_DELETION = "DROP TABLE IF EXISTS " + TABLE_NAME;

        public static final String PLAYERS_CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE +
                "vnd." + AUTHORITY + ".players";
        public static final String PLAYER_CONTENT_ITEM_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE +
                "vnd." + AUTHORITY + ".player";

        public static final String URL_PLAYERS = "content://" + AUTHORITY + "/players";
        public static final Uri CONTENT_URI_PLAYERS = Uri.parse(URL_PLAYERS);
        public static final String[] projectionForAllPlayerTable = {
                COLUMN_PLAYER_FIRST_NAME,
                COLUMN_PLAYER_LAST_NAME,
                COLUMN_PLAYER_HEIGHT,
                COLUMN_PLAYER_WEIGHT,
                COLUMN_TIMESTAMP
        };
    }

    public static abstract class TeamTable implements BaseColumns {

        public static final String TABLE_NAME = "team_table";

        public static final String COLUMN_GENERAL_ID = "_id";
        public static final String COLUMN_UUID = "team_uuid";
        public static final String COLUMN_TEAM_NAME = "team_name";
        public static final String COLUMN_PLAYER_JERSEY_NUMBER = "player_jersey_number_team";
        public static final String COLUMN_PLAYER_UUID = "player_uuid_team";
        public static final String COLUMN_TEAM_PROFILE_CREATION_TIMESTAMP = "time_stamp";

        public static final String TEAM_TABLE_CREATION = "CREATE TABLE " +
                TABLE_NAME + " (" +
                COLUMN_GENERAL_ID + TYPE_INTEGER + " PRIMARY KEY AUTOINCREMENT" + COMMA_SEPARATOR +
                COLUMN_UUID + TYPE_BLOB + COMMA_SEPARATOR +
                COLUMN_TEAM_NAME + TYPE_TEXT + COMMA_SEPARATOR +
                COLUMN_TEAM_PROFILE_CREATION_TIMESTAMP + TYPE_DATETIME + COMMA_SEPARATOR +
                COLUMN_PLAYER_UUID + TYPE_BLOB + COMMA_SEPARATOR +
                " UNIQUE(" + COLUMN_PLAYER_JERSEY_NUMBER + COMMA_SEPARATOR + COLUMN_PLAYER_UUID + ")" +
                ")";

        public static final String TEAM_TABLE_DELETION = "DROP TABLE IF EXISTS " + TABLE_NAME;

        public static final String TEAM_CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE +
                "vnd." + AUTHORITY + ".teams";
        public static final String TEAM_CONTENT_ITEM_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE +
                "vnd." + AUTHORITY + ".team";

        public static final String URL_TEAMS = "content://" + AUTHORITY + "/teams";
        public static final Uri CONTENT_URI_TEAMS = Uri.parse(URL_TEAMS);
        public static final String[] projectionForAllTeamTable = {
                COLUMN_TEAM_NAME,
                COLUMN_TIMESTAMP
        };
    }

    public static abstract class GameTable implements BaseColumns {

        public static final String TABLE_NAME = "game_table";

        public static final String COLUMN_HOST_TEAM_UUID = "host_game_uuid";
        public static final String COLUMN_GUEST_TEAM_UUID = "guest_game_uuid";
        public static final String COLUMN_GENERAL_ID = "_id";
        public static final String COLUMN_UUID = "game_uuid";
        public static final String COLUMN_STARTING_TIME = "starting_time";
        public static final String COLUMN_END_TIME = "end_time";
        public static final String COLUMN_LOCATION = "location";
    }

    public static abstract class Pt3Table implements BaseColumns {
        public static final String TABLE_NAME = "pt_3_table";
        public static final String COLUMN_TIMESTAMP = "timestamp";
        public static final String Column_PT3_TOTAL = "pt_3_total";
        public static final String COLUMN_DATE = "date";
    }

    public static abstract class Pt2Table implements BaseColumns {
        public static final String TABLE_NAME = "pt_2_table";
        public static final String COLUMN_TIMESTAMP = "timestamp";
        public static final String COLUMN_PT2_TOTAL = "pt_2_total";
        public static final String COLUMN_DATE = "date";
    }

    public static abstract class Pt1Table implements BaseColumns {
        public static final String TABLE_NAME = "pt_1_table";
        public static final String COLUMN_TIMESTAMP = "timestamp";
        public static final String COLUMN_PT3_TOTAL = "pt_1_total";
        public static final String COLUMN_DATE = "date";
    }

    public static abstract class StealTable implements BaseColumns {
        public static final String TABLE_NAME = "steal_table";
        public static final String COLUMN_TIMESTAMP = "timestamp";
        public static final String COLUMN_STEAL_TOTAL = "steal_total";
        public static final String COLUMN_DATE = "date";
    }

    public static abstract class ORebTable implements BaseColumns {
        public static final String TABLE_NAME = "o_reb_table";
        public static final String COLUMN_TIMESTAMP = "timestamp";
        public static final String COLUMN_O_REB_TOTAL = "o_reb_total";
        public static final String COLUMN_DATE = "date";
    }

    public static abstract class DRebTable implements BaseColumns {
        public static final String TABLE_NAME = "d_reb_table";
        public static final String COLUMN_TIMESTAMP = "timestamp";
        public static final String COLUMN_D_REB_TOTAL = "d_reb_total";
        public static final String COLUMN_DATE = "date";
    }

    public static abstract class TurnoverTable implements BaseColumns {
        public static final String TABLE_NAME = "turnover_table";
        public static final String COLUMN_TIMESTAMP = "timestamp";
        public static final String COLUMN_TURNOVER = "turnover_total";
        public static final String COLUMN_DATE = "date";
    }

    public static abstract class BlockTable implements BaseColumns {
        public static final String TABLE_NAME = "block_table";
        public static final String COLUMN_TIMESTAMP = "timestamp";
        public static final String COLUMN_BLOCK_TOTAL = "block_total";
        public static final String COLUMNn_DATE = "timestamp";
    }
}
