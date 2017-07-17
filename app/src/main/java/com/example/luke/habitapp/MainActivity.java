package com.example.luke.habitapp;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.example.luke.habitapp.data.Helper;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getSimpleName();
    Helper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper =  new Helper(this);

        helper.populateDatabase(
                "Dog Walk",
                60);

        helper.populateDatabase(
                "Jogging",
                45);

        helper.populateDatabase(
                "Drinking Alcohol",
                1600);


    }
    public void read() {
        Cursor cursor = helper.queryAll();
        try {
            while (cursor.moveToNext()) {
                Log.i(LOG_TAG,
                        "Habit >> " + cursor.getInt(0) + " / " + cursor.getString(1) + " / " + cursor.getInt(2));
            }
        } finally {
            cursor.close();
        }
    }
}