package com.example.metroapp;

import static com.example.metroapp.DBHelper.TABLE_TICKETS;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class TicketDataSource {

    private SQLiteDatabase database;
    private DBHelper dbHelper;

    public TicketDataSource(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public long insertTicket(String origin, String destination) {
        ContentValues values = new ContentValues();
        values.put(DBHelper.COLUMN_ORIGIN, origin);
        values.put(DBHelper.COLUMN_DESTINATION, destination);

        return database.insert(TABLE_TICKETS, null, values);
    }

    public ArrayList<String> getAllTickets() {
        ArrayList<String> tickets = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + DBHelper.TABLE_TICKETS, null);

        if (cursor.moveToFirst()) {
            do {
                // Assuming you have columns like "origin" and "destination"
                int originIndex = cursor.getColumnIndex(DBHelper.COLUMN_ORIGIN);
                int destinationIndex = cursor.getColumnIndex(DBHelper.COLUMN_DESTINATION);

                String origin = cursor.getString(originIndex);
                String destination = cursor.getString(destinationIndex);

                String ticketDetails = "Origin: " + origin + ", Destination: " + destination;
                tickets.add(ticketDetails);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return tickets;
    }
    public void deleteAllTickets() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(DBHelper.TABLE_TICKETS, null, null);
        db.close();
    }


}

