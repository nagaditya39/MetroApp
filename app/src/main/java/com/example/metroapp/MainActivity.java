package com.example.metroapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button search_buses;
    EditText Destination,Origin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        Destination=findViewById(R.id.Destination);
        Origin=findViewById(R.id.Origin);

        search_buses = findViewById(R.id.search_buses);
        search_buses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                Bundle b = new Bundle();
                b.putString("Origin",Origin.getText().toString());
                b.putString("Destination",Destination.getText().toString());
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }
}