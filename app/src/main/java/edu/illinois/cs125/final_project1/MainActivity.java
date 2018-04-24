package edu.illinois.cs125.final_project1;

import android.arch.lifecycle.OnLifecycleEvent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;
import android.content.Intent;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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



//        homefrommlb.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//
//                switch (v.getId()) {
//
//                    case R.id.home_from_mlb:
//                        setContentView(R.layout.activity_main);
//                        break;
//                }
//            }
//        });
////
//        home1.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//
//                switch (v.getId()) {
//
//                    case R.id.back_to_home:
//                        setContentView(R.layout.activity_main);
//                        break;
//                }
//            }
//        });
//
//        home2.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//
//                switch (v.getId()) {
//
//                    case R.id.back_to_home3:
//                        setContentView(R.layout.activity_main);
//                        break;
//                }
//            }
//        });



    }




