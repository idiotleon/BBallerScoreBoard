package com.leontheprofessional.bballscoreboard.database;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public final class DatabaseContract {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "scoreboard.db";
    public static final String COMMA_SEPARATOR = ", ";
    public static final String TYPE_INTEGER = " INTEGER";
    // Todo: change it to real DateTimeType
    public static final String TYPE_DATETIME = " TEXT";

    // All data of all players in a game
    public static final String AUTHORITY = "com.leontheprofessional.bballscoreboard";
    public static final String URL_PERFORMANCES = "content://" + AUTHORITY + "/performances";
    public static final Uri CONTENT_URI_PERFORMANCES = Uri.parse(URL_PERFORMANCES);
    public static final String[] projectionForAll = {
            DatabaseContract.PerformanceTable.COLUMN_JERSEY_NUMBER,
            DatabaseContract.PerformanceTable.COLUMN_PT_3,
            DatabaseContract.PerformanceTable.COLUMN_PT_2,
            DatabaseContract.PerformanceTable.COLUMN_PT_1,
            DatabaseContract.PerformanceTable.COLUMN_STEAL,
            DatabaseContract.PerformanceTable.COLUMN_OFF_REB,
            DatabaseContract.PerformanceTable.COLUMN_DEF_REB,
            DatabaseContract.PerformanceTable.COLUMN_FAUL,
            DatabaseContract.PerformanceTable.COLUMN_TURNOVER,
            DatabaseContract.PerformanceTable.COLUMN_BLOCK,
            DatabaseContract.PerformanceTable.COLUMN_TIMESTAMP
    };

    public static final String TABLE_CREATION = "CREATE TABLE " +
            PerformanceTable.TABLE_NAME + " (" +
            "_id" + TYPE_INTEGER + " PRIMARY KEY AUTOINCREMENT, " +
            PerformanceTable.COLUMN_JERSEY_NUMBER + " INTEGER" + COMMA_SEPARATOR +
            PerformanceTable.COLUMN_PT_3 + TYPE_INTEGER + COMMA_SEPARATOR +
            PerformanceTable.COLUMN_PT_2 + TYPE_INTEGER + COMMA_SEPARATOR +
            PerformanceTable.COLUMN_PT_1 + TYPE_INTEGER + COMMA_SEPARATOR +
            PerformanceTable.COLUMN_STEAL + TYPE_INTEGER + COMMA_SEPARATOR +
            PerformanceTable.COLUMN_OFF_REB + TYPE_INTEGER + COMMA_SEPARATOR +
            PerformanceTable.COLUMN_DEF_REB + TYPE_INTEGER + COMMA_SEPARATOR +
            PerformanceTable.COLUMN_FAUL + TYPE_INTEGER + COMMA_SEPARATOR +
            PerformanceTable.COLUMN_TURNOVER + TYPE_INTEGER + COMMA_SEPARATOR +
            PerformanceTable.COLUMN_BLOCK + TYPE_INTEGER + COMMA_SEPARATOR +
            PerformanceTable.COLUMN_TIMESTAMP + TYPE_DATETIME + ")";

    public static final String TABLE_DELETION = "DROP TABLE IF EXISTS " + PerformanceTable.TABLE_NAME;


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
        public static final String COLUMN_TIMESTAMP = "datetimestamp";

        public static final String PERFORMANCE_CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE +
                "vnd." + AUTHORITY + ".performances";
        public static final String PERFORMANCE_CONTENT_ITEM_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE +
                "vnd." + AUTHORITY + ".performance";
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
