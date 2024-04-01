package com.example.metroapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Main2Activity extends AppCompatActivity {

    CardView cardView1,cardView2,cardView3,cardView4;
    TextView origin2,destination2;
    String originOne=" ",DestinationOne=" ";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main2);

        origin2=findViewById(R.id.origin2);
        destination2=findViewById(R.id.destination2);

        originOne=getIntent().getStringExtra("Origin");
        DestinationOne=getIntent().getStringExtra("Destination");

        origin2.setText(originOne);
        destination2.setText(DestinationOne);

        cardView1 = findViewById(R.id.cardView1);
        cardView1.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), Main3Activity.class);
            Bundle b = new Bundle();
            b.putString("Origin",origin2.getText().toString());
            b.putString("Destination",destination2.getText().toString());
            intent.putExtras(b);
            startActivity(intent);


        });
        cardView2 = findViewById(R.id.cardView2);
        cardView2.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), Main3Activity.class);
            Bundle b = new Bundle();
            b.putString("Origin",origin2.getText().toString());
            b.putString("Destination",destination2.getText().toString());
            intent.putExtras(b);
            startActivity(intent);


        });
        cardView3 = findViewById(R.id.cardView3);
        cardView3.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), Main3Activity.class);
            Bundle b = new Bundle();
            b.putString("Origin",origin2.getText().toString());
            b.putString("Destination",destination2.getText().toString());
            intent.putExtras(b);
            startActivity(intent);


        });
        cardView4 = findViewById(R.id.cardView4);
        cardView4.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), Main3Activity.class);
            Bundle b = new Bundle();
            b.putString("Origin",origin2.getText().toString());
            b.putString("Destination",destination2.getText().toString());
            intent.putExtras(b);
            startActivity(intent);


        });
    }
}