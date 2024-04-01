package com.example.metroapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Main3Activity extends AppCompatActivity {

    TextView origin3, destination3;
    String ori="", dest="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main3);

        origin3=findViewById(R.id.origin3);
        destination3=findViewById(R.id.destination3);

        ori=getIntent().getStringExtra("Origin");
        dest=getIntent().getStringExtra("Destination");

        origin3.setText(ori);
        destination3.setText(dest);

        CardView bookTicketCardView = findViewById(R.id.cardView);
        bookTicketCardView.setOnClickListener(view -> {
            saveTicketToDatabase(ori, dest);
        });

        // Main3Activity.java

// Inside the onCreate method
        Button viewHistoryButton = findViewById(R.id.viewHistoryButton);

        viewHistoryButton.setOnClickListener(v -> {
            Intent intent = new Intent(Main3Activity.this, TicketHistoryActivity.class);
            startActivity(intent);
        });

    }

    private void saveTicketToDatabase(String origin, String destination) {
        TicketDataSource dataSource = new TicketDataSource(this);
        dataSource.open();

        long result = dataSource.insertTicket(origin, destination);

        dataSource.close();

        if (result != -1) {
            Toast.makeText(this, "Ticket booked and saved to database", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Error booking ticket", Toast.LENGTH_SHORT).show();
        }

    }
}
