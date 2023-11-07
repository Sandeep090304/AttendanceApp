package com.example.attendanceapp.Dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import com.example.attendanceapp.R;

public class Dashboard extends AppCompatActivity {
    public CardView cardView, cardView2, cardView3, cardView4;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        cardView = (CardView) findViewById(R.id.cardView);
        cardView2 = (CardView) findViewById(R.id.cardView2);
        cardView3 = (CardView) findViewById(R.id.cardView3);
        cardView4 = (CardView) findViewById(R.id.cardView4);
        Intent in = getIntent();
        String str = in.getStringExtra("name");
        System.out.println(str);
        t1= (TextView) findViewById(R.id.username1);
        t1.setText(str);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the activity for the first card
                Intent intent = new Intent(Dashboard.this, Dashboard.class);
                startActivity(intent);
            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the activity for the second card
                Intent intent = new Intent(Dashboard.this, Dashboard.class);
                startActivity(intent);
            }
        });
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the activity for the second card
                Intent intent = new Intent(Dashboard.this, Dashboard.class);
                startActivity(intent);
            }
        });
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the activity for the second card
                Intent intent = new Intent(Dashboard.this, Dashboard.class);
                startActivity(intent);
            }
        });
    }

}



