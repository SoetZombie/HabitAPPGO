package com.example.luke.habitapp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class Helper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "habits.db";
    private static final int DATABASE_VERSION = 1;

    public Helper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void populateDatabase(String name, int interval) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues habitValues = new ContentValues();
        habitValues.put(Contract.HabitsEntry.COLUMN_HABIT_NAME, name);
        habitValues.put(Contract.HabitsEntry.COLUMN_HABIT_INTERVAL, interval);
        sqLiteDatabase.insert(Contract.HabitsEntry.TABLE_NAME, null, habitValues);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL_CREATE_TABLE =  "CREATE TABLE " + Contract.HabitsEntry.TABLE_NAME + " (" + Contract.HabitsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + Contract.HabitsEntry.COLUMN_HABIT_NAME + " TEXT , " + Contract.HabitsEntry.COLUMN_HABIT_INTERVAL + " INTEGER); ";sqLiteDatabase.execSQL(SQL_CREATE_TABLE);
    }


    public Cursor queryAll() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        String[] array = {
                Contract.HabitsEntry._ID, Contract.HabitsEntry.COLUMN_HABIT_NAME, Contract.HabitsEntry.COLUMN_HABIT_INTERVAL

        };
        return sqLiteDatabase.query(
                Contract.HabitsEntry.TABLE_NAME,
                array,
                null,
                null,
                null,
                null,
                null
        );
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}
