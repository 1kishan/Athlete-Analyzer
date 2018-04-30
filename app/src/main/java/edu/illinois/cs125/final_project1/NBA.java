package edu.illinois.cs125.final_project1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NBA extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nba);


        Button nbaBack = (Button) findViewById(R.id.nba_back_button);


        nbaBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Button compare = findViewById(R.id.compare_nba);
        compare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Data player1 = new Data("Lebron-James","NBA");
                player1.apiGetData();
            }
        });

        Button nbaCompare = (Button) findViewById(R.id.compare_nba);

        nbaCompare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchNBACompare();
            }
        });



    }

    public void launchNBACompare() {

        Intent intent = new Intent(this, NBAcompare.class);
        startActivity(intent);
    }

}
