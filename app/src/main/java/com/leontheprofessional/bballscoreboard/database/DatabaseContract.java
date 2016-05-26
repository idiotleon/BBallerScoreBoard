package com.leontheprofessional.bballscoreboard.database;

import android.provider.BaseColumns;

public final class DatabaseContract{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "scoreboard.db";

    // To prevent someone from accidentally instantiating the contract class
    // have an empty constructor
    private DatabaseContract(){}

    // todo: This is the very simple table, very inefficient. Improvement will be made later on
    public static abstract class PerformanceContract implements BaseColumns {
        public static final String TABLE_NAME = "performance_table";
        public static final String JERSEY_NUMBER = "jersey_number";
        public static final String COLUMN_PT3 = "pt_3";
        public static final String COLUMN_PT_2 = "pt_2";
        public static final String COLUMN_PT_1 = "pt_1";
        public static final String COLUMN_STEAL = "steal";
        public static final String COLUMN_O_REB = "offensive_reb";
        public static final String COLUMN_D_REB = "defensive_reb";
        public static final String COLUMN_FAUL = "faul";
        public static final String COLUMN_TURNOVER = "turnover";
        public static final String COLUMN_BLOCK = "block";
        public static final String COLUMN_TIMESTAMP = "timestamp";
        public static final String COLUMN_DATE = "date";
    }

    public static abstract class Pt3Contract implements BaseColumns{
        public static final String TABLE_NAME = "pt_3_table";
        public static final String COLUMN_TIMESTAMP = "timestamp";
        public static final String Column_PT3_TOTAL = "pt_3_total";
        public static final String COLUMN_DATE = "date";
    }

    public static abstract class Pt2Contract implements BaseColumns{
        public static final String TABLE_NAME = "pt_2_table";
        public static final String COLUMN_TIMESTAMP = "timestamp";
        public static final String COLUMN_PT2_TOTAL = "pt_2_total";
        public static final String COLUMN_DATE = "date";
    }

    public static abstract class Pt1Contract implements BaseColumns{
        public static final String TABLE_NAME = "pt_1_table";
        public static final String COLUMN_TIMESTAMP = "timestamp";
        public static final String COLUMN_PT3_TOTAL = "pt_1_total";
        public static final String COLUMN_DATE = "date";
    }

    public static abstract class StealContract implements BaseColumns{
        public static final String TABLE_NAME = "steal_table";
        public static final String COLUMN_TIMESTAMP = "timestamp";
        public static final String COLUMN_STEAL_TOTAL = "steal_total";
        public static final String COLUMN_DATE = "date";
    }

    public static abstract class ORebContract implements BaseColumns{
        public static final String TABLE_NAME = "o_reb_table";
        public static final String COLUMN_TIMESTAMP = "timestamp";
        public static final String COLUMN_O_REB_TOTAL = "o_reb_total";
        public static final String COLUMN_DATE = "date";
    }

    public static abstract class DRebContract implements BaseColumns{
        public static final String TABLE_NAME = "d_reb_table";
        public static final String COLUMN_TIMESTAMP = "timestamp";
        public static final String COLUMN_D_REB_TOTAL = "d_reb_total";
        public static final String COLUMN_DATE = "date";
    }

    public static abstract class TurnoverContract implements BaseColumns{
        public static final String TABLE_NAME = "turnover_table";
        public static final String COLUMN_TIMESTAMP = "timestamp";
        public static final String COLUMN_TURNOVER = "turnover_total";
        public static final String COLUMN_DATE = "date";
    }

    public static abstract class BlockContract implements BaseColumns{
        public static final String TABLE_NAME = "block_table";
        public static final String COLUMN_TIMESTAMP = "timestamp";
        public static final String COLUMN_BLOCK_TOTAL = "block_total";
        public static final String COLUMNn_DATE = "timestamp";
    }


}
