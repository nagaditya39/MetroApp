package com.example.metroapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "metroapp.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_TICKETS = "tickets";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_ORIGIN = "origin";
    public static final String COLUMN_DESTINATION = "destination";

    private static final String CREATE_TABLE_TICKETS =
            "CREATE TABLE " + TABLE_TICKETS + "(" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_ORIGIN + " TEXT, " +
                    COLUMN_DESTINATION + " TEXT)";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_TICKETS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle database schema upgrades
        // This method is called when the database version changes
    }
}
