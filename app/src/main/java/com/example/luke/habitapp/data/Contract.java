package com.example.luke.habitapp.data;


import android.provider.BaseColumns;

public class Contract {

    public static class HabitsEntry implements BaseColumns {
        public static final String TABLE_NAME = "habits";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_HABIT_NAME ="habit_name";
        public final static String COLUMN_HABIT_INTERVAL ="habit_interval";

    }
}
