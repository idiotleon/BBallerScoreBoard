package com.leontheprofessional.bballscoreboard.database;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public final class DatabaseContract {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "scoreboard.db";
    public static final String COMMA_SEPARATOR = ", ";
    public static final String TYPE_INTEGER = " INTEGER";
    public static final String TYPE_REAL = " REAL";
    public static final String TYPE_TEXT = " TEXT";
    public static final String TYPE_BLOB = " BLOB";
    // Todo: change it to real DateTimeType
    public static final String TYPE_DATETIME = " INTEGER";
    public static final String DEFAULT_VALUE_ZERO = " DEFAULT 0";

    public static final String PRIMARY_KEY = " PRIMARY KEY ";
    public static final String AUTO_INCREMENT = " AUTOINCREMENT ";

    // All data of all players in a game
    public static final String AUTHORITY = "com.leontheprofessional.bballscoreboard";


    // To prevent someone from accidentally instantiating the contract class
    // have an empty constructor
    private DatabaseContract() {
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

        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_PLAYER_JERSEY_NUMBER = "player_jersey_number";
        public static final String COLUMN_PLAYER_UUID = "player_uuid";
        public static final String COLUMN_PLAYER_FIRST_NAME = "player_first_name";
        public static final String COLUMN_PLAYER_LAST_NAME = "player_last_name";
        // todo: enumeration type for sqlite database
        public static final String COLUMN_PLAYER_POSITION = "player_position";
        public static final String COLUMN_PLAYER_HEIGHT = "player_height";
        public static final String COLUMN_PLAYER_WEIGHT = "player_weight";
        public static final String COLUMN_PLAYER_PROFILE_CREATED_TIMESTAMP = "player_profile_created_time_stamp";
        public static final String COLUMN_PLAYER_BIRTHDAY = "player_birthday";
        public static final String COLUMN_PLAYER_NICKNAME = "player_nickname";
        public static final String COLUMN_PLAYER_ICON_URL = "player_icon_url";
        public static final String COLUMN_PLAYER_CAREER_3PT_MADE = "player_career_3pt_made";
        public static final String COLUMN_PLAYER_CAREER_3PT_MISSED = "player_career_3pt_missed";
        public static final String COLUMN_PLAYER_CAREER_3PT_PERCENTAGE = "player_career_3pt_rate";
        public static final String COLUMN_PLAYER_CAREER_2PT_MADE = "player_career_2pt_made";
        public static final String COLUMN_PLAYER_CAREER_2PT_MISSED = "player_career_2pt_missed";
        public static final String COLUMN_PLAYER_CAREER_2PT_PERCENTAGE = "player_career_2pt_percentage";
        public static final String COLUMN_PLAYER_CAREER_1PT_MADE = "player_career_1pt_made";
        public static final String COLUMN_PLAYER_CAREER_1PT_MISSED = "player_career_1pt_missed";
        public static final String COLUMN_PLAYER_CAREER_1PT_PERCENTAGE = "player_career_1pt_percentage";
        public static final String COLUMN_PLAYER_CAREER_BLOCKS = "player_career_blocks";
        public static final String COLUMN_PLAYER_CAREER_ASSISTS = "player_career_assists";
        public static final String COLUMN_PLAYER_CAREER_STEALS = "player_career_steals";
        public static final String COLUMN_PLAYER_CAREER_TURNOVERS = "player_career_turnovers";
        public static final String COLUMN_PLAYER_CAREER_TOTAL_GAMES_PLAYED = "player_career_total_games_played";
        public static final String COLUMN_PLAYER_CAREER_TOTAL_TEAMS_JOINED = "player_career_total_teams_joined";
        public static final String COLUMN_PLAYER_CAREER_TOTAL_PERSONAL_FUALS = "player_career_total_personal_fauls";
        public static final String COLUMN_PLAYER_CAREER_TOTAL_TECHNICAL_FAULS = "player_career_total_technical_fauls";
        public static final String COLUMN_PLAYER_CAREER_TOTAL_FLAGRANT_FAULS = "player_career_total_flagrant_fauls";

        public static final String PLAYER_TABLE_CREATION = "CREATE TABLE " +
                TABLE_NAME + " (" +
                COLUMN_ID + TYPE_INTEGER + PRIMARY_KEY + AUTO_INCREMENT + COMMA_SEPARATOR +
                // todo: uuid for players
                COLUMN_PLAYER_UUID + TYPE_BLOB + COMMA_SEPARATOR +
                COLUMN_PLAYER_FIRST_NAME + TYPE_TEXT + COMMA_SEPARATOR +
                COLUMN_PLAYER_LAST_NAME + TYPE_TEXT + COMMA_SEPARATOR +
                COLUMN_PLAYER_POSITION + TYPE_INTEGER + COMMA_SEPARATOR +
                COLUMN_PLAYER_HEIGHT + TYPE_INTEGER + COMMA_SEPARATOR +
                COLUMN_PLAYER_WEIGHT + TYPE_INTEGER + COMMA_SEPARATOR +
                COLUMN_PLAYER_PROFILE_CREATED_TIMESTAMP + TYPE_DATETIME + COMMA_SEPARATOR +
                COLUMN_PLAYER_BIRTHDAY + TYPE_DATETIME + COMMA_SEPARATOR +
                COLUMN_PLAYER_NICKNAME + TYPE_TEXT + COMMA_SEPARATOR +
                COLUMN_PLAYER_ICON_URL + TYPE_TEXT + COMMA_SEPARATOR +
                COLUMN_PLAYER_CAREER_3PT_MADE + TYPE_INTEGER + DEFAULT_VALUE_ZERO + COMMA_SEPARATOR +
                COLUMN_PLAYER_CAREER_3PT_MISSED + TYPE_INTEGER + DEFAULT_VALUE_ZERO + COMMA_SEPARATOR +
                COLUMN_PLAYER_CAREER_3PT_PERCENTAGE + TYPE_REAL + DEFAULT_VALUE_ZERO + COMMA_SEPARATOR +
                COLUMN_PLAYER_CAREER_2PT_MADE + TYPE_INTEGER + DEFAULT_VALUE_ZERO + COMMA_SEPARATOR +
                COLUMN_PLAYER_CAREER_2PT_MISSED + TYPE_INTEGER + DEFAULT_VALUE_ZERO + COMMA_SEPARATOR +
                COLUMN_PLAYER_CAREER_2PT_PERCENTAGE + TYPE_REAL + DEFAULT_VALUE_ZERO + COMMA_SEPARATOR +
                COLUMN_PLAYER_CAREER_1PT_MADE + TYPE_INTEGER + DEFAULT_VALUE_ZERO + COMMA_SEPARATOR +
                COLUMN_PLAYER_CAREER_1PT_MISSED + TYPE_INTEGER + DEFAULT_VALUE_ZERO + COMMA_SEPARATOR +
                COLUMN_PLAYER_CAREER_1PT_PERCENTAGE + TYPE_REAL + DEFAULT_VALUE_ZERO + COMMA_SEPARATOR +
                COLUMN_PLAYER_CAREER_BLOCKS + TYPE_INTEGER + DEFAULT_VALUE_ZERO + COMMA_SEPARATOR +
                COLUMN_PLAYER_CAREER_STEALS + TYPE_INTEGER + DEFAULT_VALUE_ZERO + COMMA_SEPARATOR +
                COLUMN_PLAYER_CAREER_ASSISTS + TYPE_INTEGER + DEFAULT_VALUE_ZERO + COMMA_SEPARATOR +
                COLUMN_PLAYER_CAREER_TURNOVERS + TYPE_INTEGER + DEFAULT_VALUE_ZERO + COMMA_SEPARATOR +
                COLUMN_PLAYER_CAREER_TOTAL_GAMES_PLAYED + TYPE_INTEGER + DEFAULT_VALUE_ZERO + COMMA_SEPARATOR +
                COLUMN_PLAYER_CAREER_TOTAL_TEAMS_JOINED + TYPE_INTEGER + DEFAULT_VALUE_ZERO + COMMA_SEPARATOR +
                COLUMN_PLAYER_CAREER_TOTAL_PERSONAL_FUALS + TYPE_INTEGER + DEFAULT_VALUE_ZERO + COMMA_SEPARATOR +
                COLUMN_PLAYER_CAREER_TOTAL_FLAGRANT_FAULS + TYPE_INTEGER + DEFAULT_VALUE_ZERO + COMMA_SEPARATOR +
                COLUMN_PLAYER_CAREER_TOTAL_TECHNICAL_FAULS + TYPE_INTEGER + DEFAULT_VALUE_ZERO +
                ")";

        public static final String PLAYER_TABLE_DELETION_QUERY = "DROP TABLE IF EXISTS " + TABLE_NAME;

        public static final String PLAYERS_CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE +
                "vnd." + AUTHORITY + ".players";
        public static final String PLAYER_CONTENT_ITEM_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE +
                "vnd." + AUTHORITY + ".player";

        public static final String URL_PLAYERS = "content://" + AUTHORITY + "/players";
        public static final Uri CONTENT_URI_PLAYERS = Uri.parse(URL_PLAYERS);

        public static final String[] projectionForAll = {
                COLUMN_ID,
                COLUMN_PLAYER_UUID,
                COLUMN_PLAYER_FIRST_NAME,
                COLUMN_PLAYER_LAST_NAME,
                COLUMN_PLAYER_JERSEY_NUMBER,
                COLUMN_PLAYER_HEIGHT,
                COLUMN_PLAYER_WEIGHT,
                COLUMN_PLAYER_POSITION,
                COLUMN_PLAYER_PROFILE_CREATED_TIMESTAMP,
                COLUMN_PLAYER_BIRTHDAY,
                COLUMN_PLAYER_NICKNAME,
                COLUMN_PLAYER_ICON_URL,
                COLUMN_PLAYER_CAREER_3PT_MADE,
                COLUMN_PLAYER_CAREER_3PT_MISSED,
                COLUMN_PLAYER_CAREER_3PT_PERCENTAGE,
                COLUMN_PLAYER_CAREER_2PT_MADE,
                COLUMN_PLAYER_CAREER_2PT_MISSED,
                COLUMN_PLAYER_CAREER_2PT_PERCENTAGE,
                COLUMN_PLAYER_CAREER_1PT_MADE,
                COLUMN_PLAYER_CAREER_1PT_MISSED,
                COLUMN_PLAYER_CAREER_1PT_PERCENTAGE,
                COLUMN_PLAYER_CAREER_BLOCKS,
                COLUMN_PLAYER_CAREER_ASSISTS,
                COLUMN_PLAYER_CAREER_STEALS,
                COLUMN_PLAYER_CAREER_TURNOVERS,
                COLUMN_PLAYER_CAREER_TOTAL_GAMES_PLAYED,
                COLUMN_PLAYER_CAREER_TOTAL_TEAMS_JOINED,
                COLUMN_PLAYER_CAREER_TOTAL_PERSONAL_FUALS,
                COLUMN_PLAYER_CAREER_TOTAL_TECHNICAL_FAULS,
                COLUMN_PLAYER_CAREER_TOTAL_FLAGRANT_FAULS
        };
    }

    // todo: A table for one team players & A table for all teams registered
    public static abstract class TeamTable implements BaseColumns {

        public static final String TABLE_NAME = "team_table";

        public static final String COLUMN_TEAM_ID = "_id";
        public static final String COLUMN_TEAM_UUID = "team_uuid";
        public static final String COLUMN_TEAM_NAME = "team_name";
        public static final String COLUMN_PLAYER_JERSEY_NUMBER = "player_jersey_number_team";
        public static final String COLUMN_PLAYER_UUID = "player_uuid_team";
        public static final String COLUMN_TEAM_PROFILE_CREATED_TIMESTAMP = "team_created_time_stamp";

        public static final String TEAM_TABLE_CREATION_QUERY = "CREATE TABLE " +
                TABLE_NAME + " (" +
                COLUMN_TEAM_ID + TYPE_INTEGER + " PRIMARY KEY AUTOINCREMENT" + COMMA_SEPARATOR +
                COLUMN_TEAM_UUID + TYPE_BLOB + COMMA_SEPARATOR +
                COLUMN_TEAM_NAME + TYPE_TEXT + COMMA_SEPARATOR +
                COLUMN_TEAM_PROFILE_CREATED_TIMESTAMP + TYPE_DATETIME + COMMA_SEPARATOR +
                COLUMN_PLAYER_UUID + TYPE_BLOB + COMMA_SEPARATOR +
                " UNIQUE(" + COLUMN_PLAYER_JERSEY_NUMBER + COMMA_SEPARATOR + COLUMN_PLAYER_UUID + ")" +
                ")";

        public static final String TEAM_TABLE_DELETION_QUERY = "DROP TABLE IF EXISTS " + TABLE_NAME;

        public static final String TEAMS_CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE +
                "vnd." + AUTHORITY + ".teams";
        public static final String TEAM_CONTENT_ITEM_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE +
                "vnd." + AUTHORITY + ".team";

        public static final String URL_TEAMS = "content://" + AUTHORITY + "/teams";
        public static final Uri CONTENT_URI_TEAMS = Uri.parse(URL_TEAMS);
        public static final String[] projectionForAll = {
                COLUMN_TEAM_ID,
                COLUMN_TEAM_UUID,
                COLUMN_TEAM_NAME,
                COLUMN_TEAM_PROFILE_CREATED_TIMESTAMP
        };
    }

    // Todo: 关于违例的技术统计 violation

    /**
     * COLUMN_PT3_TIMESTAMPE: the timestampe of a 3pt shot made
     * COLUMN_PT3_SHOT: 1 means 3pt being made, 0 means 3pt missed
     */
    public static abstract class Pt3Table implements BaseColumns {
        public static final String TABLE_NAME = "pt_3_table";
        public static final String ID = "_id";
        public static final String PLAYER_UUID = "player_uuid";
        public static final String GAME_UUID = "game_uuid";
        public static final String TEAM_UUID = "team_uuid";
        public static final String COLUMN_PT3_TIMESTAMP = "pt3_timestamp";
        public static final String COLUMN_PT3_SHOT = "pt3_shot";

        public static final String Pt3_TABLE_CREATION_QUERY = "CREATE TABLE " +
                TABLE_NAME + " (" +
                ID + TYPE_INTEGER + PRIMARY_KEY + AUTO_INCREMENT + COMMA_SEPARATOR +
                PLAYER_UUID + TYPE_BLOB + COMMA_SEPARATOR +
                GAME_UUID + TYPE_BLOB + COMMA_SEPARATOR +
                TEAM_UUID + TYPE_BLOB + COMMA_SEPARATOR +
                COLUMN_PT3_SHOT + TYPE_INTEGER + COMMA_SEPARATOR +
                COLUMN_PT3_TIMESTAMP + TYPE_DATETIME +
                ")";
        public static final String PT3_TABLE_DELETION_QUERY = "DROP TABLE IF EXISTS " + TABLE_NAME;

        public static final String PT3S_CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE +
                "vnd." + AUTHORITY + ".pt3s";
        public static final String PT3_CONTENT_ITEM_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE +
                "vnd." + AUTHORITY + ".pt3";

        public static final String URL_PT3S = "content://" + AUTHORITY + "/pt3s";
        public static final Uri CONTENT_URI_PT3S = Uri.parse(URL_PT3S);

        public static final String[] projectionForAll = {
                ID,
                PLAYER_UUID,
                GAME_UUID,
                TEAM_UUID,
                COLUMN_PT3_TIMESTAMP,
                COLUMN_PT3_SHOT
        };
    }

    public static abstract class Pt2Table implements BaseColumns {
        public static final String TABLE_NAME = "pt_2_table";
        public static final String ID = "_id";
        public static final String PLAYER_UUID = "player_uuid";
        public static final String GAME_UUID = "game_uuid";
        public static final String TEAM_UUID = "team_uuid";
        public static final String COLUMN_PT2_TIMESTAMP = "pt2_timestamp";
        public static final String COLUMN_PT2_SHOT = "pt2_shot";

        public static final String Pt2_TABLE_CREATION_QUERY = "CREATE TABLE " +
                TABLE_NAME + " (" +
                ID + TYPE_INTEGER + PRIMARY_KEY + AUTO_INCREMENT + COMMA_SEPARATOR +
                PLAYER_UUID + TYPE_BLOB + COMMA_SEPARATOR +
                GAME_UUID + TYPE_BLOB + COMMA_SEPARATOR +
                TEAM_UUID + TYPE_BLOB + COMMA_SEPARATOR +
                COLUMN_PT2_SHOT + TYPE_INTEGER + COMMA_SEPARATOR +
                COLUMN_PT2_TIMESTAMP + TYPE_DATETIME +
                ")";

        public static final String PT2_TABLE_DELETION_QUERY = "DROP TABLE IF EXISTS " + TABLE_NAME;

        public static final String PT2S_CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE +
                "vnd." + AUTHORITY + ".pt2s";
        public static final String PT2_CONTENT_ITEM_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE +
                "vnd." + AUTHORITY + ".pt2";

        public static final String URL_PT2S = "content://" + AUTHORITY + "/pt2s";
        public static final Uri CONTENT_URI_PT2S = Uri.parse(URL_PT2S);

        public static final String[] projectionForAll = {
                ID,
                PLAYER_UUID,
                GAME_UUID,
                TEAM_UUID,
                COLUMN_PT2_TIMESTAMP,
                COLUMN_PT2_SHOT
        };
    }

    public static abstract class Pt1Table implements BaseColumns {
        public static final String TABLE_NAME = "pt_1_table";
        public static final String ID = "_id";
        public static final String PLAYER_UUID = "player_uuid";
        public static final String GAME_UUID = "game_uuid";
        public static final String TEAM_UUID = "team_uuid";
        public static final String COLUMN_PT1_TIMESTAMP = "pt1_timestamp";
        public static final String COLUMN_PT1_SHOT = "pt1_shot";

        public static final String Pt1_TABLE_CREATION_QUERY = "CREATE TABLE " +
                TABLE_NAME + " (" +
                ID + TYPE_INTEGER + PRIMARY_KEY + AUTO_INCREMENT + COMMA_SEPARATOR +
                PLAYER_UUID + TYPE_BLOB + COMMA_SEPARATOR +
                GAME_UUID + TYPE_BLOB + COMMA_SEPARATOR +
                TEAM_UUID + TYPE_BLOB + COMMA_SEPARATOR +
                COLUMN_PT1_SHOT + TYPE_INTEGER + COMMA_SEPARATOR +
                COLUMN_PT1_TIMESTAMP + TYPE_DATETIME +
                ")";

        public static final String PT1_TABLE_DELETION_QUERY = "DROP TABLE IF EXISTS " + TABLE_NAME;

        public static final String PT1S_CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE +
                "vnd." + AUTHORITY + ".pt1s";
        public static final String PT1_CONTENT_ITEM_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE +
                "vnd." + AUTHORITY + ".pt1";

        public static final String URL_PT1S = "content://" + AUTHORITY + "/pt1s";
        public static final Uri CONTENT_URI_PT1S = Uri.parse(URL_PT1S);

        public static final String[] projectionForAll = {
                ID,
                PLAYER_UUID,
                GAME_UUID,
                TEAM_UUID,
                COLUMN_PT1_TIMESTAMP,
                COLUMN_PT1_SHOT
        };
    }

    public static abstract class StealTable implements BaseColumns {
        public static final String TABLE_NAME = "steal_table";
        public static final String ID = "_id";
        public static final String PLAYER_UUID = "player_uuid";
        public static final String GAME_UUID = "game_uuid";
        public static final String TEAM_UUID = "team_uuid";
        public static final String COLUMN_STEAL_TIMESTAMP = "steal_timestamp";

        public static final String STEAL_TABLE_CREATION_QUERY = "CREATE TABLE " +
                TABLE_NAME + " (" +
                ID + TYPE_INTEGER + PRIMARY_KEY + AUTO_INCREMENT + COMMA_SEPARATOR +
                PLAYER_UUID + TYPE_BLOB + COMMA_SEPARATOR +
                GAME_UUID + TYPE_BLOB + COMMA_SEPARATOR +
                TEAM_UUID + TYPE_BLOB + COMMA_SEPARATOR +
                COLUMN_STEAL_TIMESTAMP + TYPE_DATETIME +
                ")";

        public static final String STEAL_TABLE_DELETION_QUERY = "DROP TABLE IF EXISTS " + TABLE_NAME;

        public static final String STEALS_CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE +
                "vnd." + AUTHORITY + ".steals";
        public static final String STEAL_CONTENT_ITEM_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE +
                "vnd." + AUTHORITY + ".steal";

        public static final String URL_STEALS = "content://" + AUTHORITY + "/steals";
        public static final Uri CONTENT_URI_STEALS = Uri.parse(URL_STEALS);

        public static final String[] projectionForAll = {
                ID,
                PLAYER_UUID,
                GAME_UUID,
                TEAM_UUID,
                COLUMN_STEAL_TIMESTAMP
        };
    }

    public static abstract class BlockTable implements BaseColumns {
        public static final String TABLE_NAME = "block_table";
        public static final String ID = "_id";
        public static final String PLAYER_UUID = "player_uuid";
        public static final String GAME_UUID = "game_uuid";
        public static final String TEAM_UUID = "team_uuid";
        public static final String COLUMN_BLOCK_TIMESTAMP = "block_timestamp";

        public static final String BLOCK_TABLE_CREATION_QUERY = "CREATE TABLE " +
                TABLE_NAME + " (" +
                ID + TYPE_INTEGER + PRIMARY_KEY + AUTO_INCREMENT + COMMA_SEPARATOR +
                PLAYER_UUID + TYPE_BLOB + COMMA_SEPARATOR +
                GAME_UUID + TYPE_BLOB + COMMA_SEPARATOR +
                TEAM_UUID + TYPE_BLOB + COMMA_SEPARATOR +
                COLUMN_BLOCK_TIMESTAMP + TYPE_DATETIME +
                ")";

        public static final String BLOCK_TABLE_DELETION_QUERY = "DROP TABLE IF EXISTS " + TABLE_NAME;

        public static final String BLOCKS_CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE +
                "vnd." + AUTHORITY + ".blocks";
        public static final String BLOCK_CONTENT_ITEM_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE +
                "vnd." + AUTHORITY + ".block";

        public static final String URL_BLOCKS = "content://" + AUTHORITY + "/blocks";
        public static final Uri CONTENT_URI_BLOCKS = Uri.parse(URL_BLOCKS);

        public static final String[] projectionForAll = {
                ID,
                PLAYER_UUID,
                GAME_UUID,
                TEAM_UUID,
                COLUMN_BLOCK_TIMESTAMP
        };
    }

    public static abstract class OffRebTable implements BaseColumns {
        public static final String TABLE_NAME = "off_reb_table";
        public static final String ID = "_id";
        public static final String PLAYER_UUID = "player_uuid";
        public static final String GAME_UUID = "game_uuid";
        public static final String TEAM_UUID = "team_uuid";
        public static final String COLUMN_OFFREB_TIMESTAMP = "off_reb_timestamp";

        public static final String OFFREB_TABLE_CREATION_QUERY = "CREATE TABLE " +
                TABLE_NAME + " (" +
                ID + TYPE_INTEGER + PRIMARY_KEY + AUTO_INCREMENT + COMMA_SEPARATOR +
                PLAYER_UUID + TYPE_BLOB + COMMA_SEPARATOR +
                GAME_UUID + TYPE_BLOB + COMMA_SEPARATOR +
                TEAM_UUID + TYPE_BLOB + COMMA_SEPARATOR +
                COLUMN_OFFREB_TIMESTAMP + TYPE_DATETIME +
                ")";

        public static final String OFFREB_TABLE_DELETION_QUERY = "DROP TABLE IF EXISTS " + TABLE_NAME;

        public static final String OFFREBS_CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE +
                "vnd." + AUTHORITY + ".offrebs";
        public static final String OFFREB_CONTENT_ITEM_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE +
                "vnd." + AUTHORITY + ".offreb";

        public static final String URL_OFFREBS = "content://" + AUTHORITY + "/offrebs";
        public static final Uri CONTENT_URI_OFFREBS = Uri.parse(URL_OFFREBS);

        public static final String[] projectionForAll = {
                ID,
                PLAYER_UUID,
                GAME_UUID,
                TEAM_UUID,
                COLUMN_OFFREB_TIMESTAMP
        };
    }

    public static abstract class DefRebTable implements BaseColumns {
        public static final String TABLE_NAME = "def_reb_table";
        public static final String ID = "_id";
        public static final String PLAYER_UUID = "player_uuid";
        public static final String GAME_UUID = "game_uuid";
        public static final String TEAM_UUID = "team_uuid";
        public static final String COLUMN_DEFREB_TIMESTAMP = "def_reb_timestamp";

        public static final String DEFREB_TABLE_CREATION_QUERY = "CREATE TABLE " +
                TABLE_NAME + " (" +
                ID + TYPE_INTEGER + PRIMARY_KEY + AUTO_INCREMENT + COMMA_SEPARATOR +
                PLAYER_UUID + TYPE_BLOB + COMMA_SEPARATOR +
                GAME_UUID + TYPE_BLOB + COMMA_SEPARATOR +
                TEAM_UUID + TYPE_BLOB + COMMA_SEPARATOR +
                COLUMN_DEFREB_TIMESTAMP + TYPE_DATETIME +
                ")";

        public static final String DEFREB_TABLE_DELETION_QUERY = "DROP TABLE IF EXISTS " + TABLE_NAME;

        public static final String DEFREBS_CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE +
                "vnd." + AUTHORITY + ".defrebs";
        public static final String DEFREB_CONTENT_ITEM_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE +
                "vnd." + AUTHORITY + ".defreb";

        public static final String URL_DEFREBS = "content://" + AUTHORITY + "/defrebs";
        public static final Uri CONTENT_URI_DEFREBS = Uri.parse(URL_DEFREBS);

        public static final String[] projectionForAll = {
                ID,
                PLAYER_UUID,
                GAME_UUID,
                TEAM_UUID,
                COLUMN_DEFREB_TIMESTAMP
        };
    }

    public static abstract class TurnoverTable implements BaseColumns {
        public static final String TABLE_NAME = "turnover_table";
        public static final String ID = "_id";
        public static final String PLAYER_UUID = "player_uuid";
        public static final String GAME_UUID = "game_uuid";
        public static final String TEAM_UUID = "team_uuid";
        public static final String COLUMN_TURNOVER_TIMESTAMP = "turnover_timestamp";

        public static final String TURNOVER_TABLE_CREATION_QUERY = "CREATE TABLE " +
                TABLE_NAME + " (" +
                ID + TYPE_INTEGER + PRIMARY_KEY + AUTO_INCREMENT + COMMA_SEPARATOR +
                PLAYER_UUID + TYPE_BLOB + COMMA_SEPARATOR +
                GAME_UUID + TYPE_BLOB + COMMA_SEPARATOR +
                TEAM_UUID + TYPE_BLOB + COMMA_SEPARATOR +
                COLUMN_TURNOVER_TIMESTAMP + TYPE_DATETIME +
                ")";

        public static final String TURNOVER_TABLE_DELETION_QUERY = "DROP TABLE IF EXISTS " + TABLE_NAME;

        public static final String TURNOVERS_CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE +
                "vnd." + AUTHORITY + ".turnovers";
        public static final String TURNOVER_CONTENT_ITEM_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE +
                "vnd." + AUTHORITY + ".turnover";

        public static final String URL_TURNOVERS = "content://" + AUTHORITY + "/turnovers";
        public static final Uri CONTENT_URI_TURNOVERS = Uri.parse(URL_TURNOVERS);

        public static final String[] projectionForAll = {
                ID,
                PLAYER_UUID,
                GAME_UUID,
                TEAM_UUID,
                COLUMN_TURNOVER_TIMESTAMP
        };
    }

    public static abstract class AssistTable implements BaseColumns {
        public static final String TABLE_NAME = "assist_table";
        public static final String ID = "_id";
        public static final String PLAYER_UUID = "player_uuid";
        public static final String GAME_UUID = "game_uuid";
        public static final String TEAM_UUID = "team_uuid";
        public static final String COLUMN_ASSIST_TIMESTAMP = "assist_timestamp";

        public static final String ASSIST_TABLE_CREATION_QUERY = "CREATE TABLE " +
                TABLE_NAME + " (" +
                ID + TYPE_INTEGER + PRIMARY_KEY + AUTO_INCREMENT + COMMA_SEPARATOR +
                PLAYER_UUID + TYPE_BLOB + COMMA_SEPARATOR +
                GAME_UUID + TYPE_BLOB + COMMA_SEPARATOR +
                TEAM_UUID + TYPE_BLOB + COMMA_SEPARATOR +
                COLUMN_ASSIST_TIMESTAMP + TYPE_DATETIME +
                ")";

        public static final String ASSIST_TABLE_DELETION_QUERY = "DROP TABLE IF EXISTS " + TABLE_NAME;

        public static final String ASSISTS_CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE +
                "vnd." + AUTHORITY + ".assists";
        public static final String ASSIST_CONTENT_ITEM_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE +
                "vnd." + AUTHORITY + ".assist";

        public static final String URL_ASSISTS = "content://" + AUTHORITY + "/assists";
        public static final Uri CONTENT_URI_ASSISTS = Uri.parse(URL_ASSISTS);

        public static final String[] projectionForAll = {
                ID,
                PLAYER_UUID,
                GAME_UUID,
                TEAM_UUID,
                COLUMN_ASSIST_TIMESTAMP
        };

    }

    // todo: This is the very simple table, very inefficient. Improvement will be made later on
    // todo: I will try to use tables with Normalization1
    /*public static abstract class PerformanceTable implements BaseColumns {
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
        public static final String COLUMN_TECHNICAL_FAUL = "technical_faul";
        public static final String COLUMN_FLAGRANT_FAUL = "flagrant_faul";
        public static final String COLUMN_TURNOVER = "turnover";
        public static final String COLUMN_BLOCK = "block";
        public static final String COLUMN_PERFORMANCE_TABLE_CREATED_TIMESTAMP = "performance_table_created_timestamp";

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
                COLUMN_PERFORMANCE_TABLE_CREATED_TIMESTAMP,
                COLUMN_TECHNICAL_FAUL,
                COLUMN_FLAGRANT_FAUL
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
                COLUMN_PERFORMANCE_TABLE_CREATED_TIMESTAMP + TYPE_DATETIME +
                ")";

        public static final String PERFORMANCE_TABLE_DELETION = "DROP TABLE IF EXISTS " + TABLE_NAME;

    }


    public static abstract class GameTable implements BaseColumns {

        public static final String TABLE_NAME = "game_table";

        public static final String COLUMN_HOST_TEAM_UUID = "host_game_uuid";
        public static final String COLUMN_GUEST_TEAM_UUID = "guest_game_uuid";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_UUID = "game_uuid";
        public static final String COLUMN_STARTING_TIME = "starting_time";
        public static final String COLUMN_END_TIME = "end_time";
        public static final String COLUMN_LOCATION = "location";
    }*/
}
