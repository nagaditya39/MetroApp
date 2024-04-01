package com.example.metroapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class TicketHistoryActivity extends AppCompatActivity {

    private ListView listView;
    private TicketDataSource ticketDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_history);

        listView = findViewById(R.id.listView);
        ticketDataSource = new TicketDataSource(this);

        // Fetch booked tickets from the database
        ArrayList<String> ticketHistory = ticketDataSource.getAllTickets();

        // Display the ticket history using a ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ticketHistory);
        listView.setAdapter(adapter);

        // Find the Clear History button
        Button btnClearHistory = findViewById(R.id.btnClearHistory);

        // Set a click listener to the Clear History button
        btnClearHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call the method to delete all tickets
                ticketDataSource.deleteAllTickets();

                // Update your UI (refresh the list, show a message, etc.)
                refreshTicketHistory();

                // Optionally, notify the user that the history has been cleared
                Toast.makeText(getApplicationContext(), "History cleared", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void refreshTicketHistory() {
        // Fetch booked tickets from the database after clearing
        ArrayList<String> ticketHistory = ticketDataSource.getAllTickets();

        // Update the ArrayAdapter to reflect the changes
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ticketHistory);
        listView.setAdapter(adapter);
    }
}
