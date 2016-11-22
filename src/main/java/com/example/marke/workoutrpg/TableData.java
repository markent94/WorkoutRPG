package com.example.marke.workoutrpg;

import android.provider.BaseColumns;

/**
 * Created by marke on 10/18/2016.
 */
public class TableData {

    public TableData() {
    }

    public static abstract class TableInfo implements BaseColumns {
        public static final String USER_NAME = "user_name";
        public static final String USER_PASS = "user_pass";
        public static final String CORE = "core";
        public static final String CHEST = "chest";
        public static final String SHOULDERS = "shoulders";
        public static final String BACK = "back";
        public static final String BICEPS = "biceps";
        public static final String TRICEPS = "triceps";
        public static final String CALVES = "calves";
        public static final String QUADRICEPS = "quadriceps";
        public static final String TABLE_NAME = "user_stats";
    }
}
