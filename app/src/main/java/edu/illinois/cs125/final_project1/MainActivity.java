package edu.illinois.cs125.final_project1;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageButton nfl = (ImageButton) findViewById(R.id.NFL_button);
        ImageButton nba = (ImageButton) findViewById(R.id.NBA_button);
        ImageButton mlb = (ImageButton) findViewById(R.id.MLB_button);


        nba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchNBA();
            }
        });

        nfl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchNFL();
            }
        });

        mlb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchMLB();
            }
        });
    }

    public void launchMLB() {

        Intent intent = new Intent(this, MLB.class);
        startActivity(intent);
    }

    public void launchNBA() {

        Intent intent = new Intent(this, NBA.class);
        startActivity(intent);
    }

    public void launchNFL() {

        Intent intent = new Intent(this, NFL.class);
        startActivity(intent);
    }

    }




