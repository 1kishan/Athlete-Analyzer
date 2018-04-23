package edu.illinois.cs125.final_project1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    ImageButton nfl = (ImageButton) findViewById(R.id.NFL_button);
    ImageButton nba = (ImageButton) findViewById(R.id.NBA_button);
    ImageButton mlb = (ImageButton) findViewById(R.id.MLB_button);



}
