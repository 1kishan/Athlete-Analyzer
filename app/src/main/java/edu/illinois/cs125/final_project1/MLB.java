package edu.illinois.cs125.final_project1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MLB extends AppCompatActivity {
    public TextView api;
    Data temp = new Data("Lebron-James","NBA");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mlb);

        Button mlbBack = (Button) findViewById(R.id.mlb_back_button);
        mlbBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button mlbCompare = (Button) findViewById(R.id.compare_mlb);

        mlbCompare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchMLBCompare();
            }
        });



    }

    public void launchMLBCompare() {

        Intent intent = new Intent(this, MLBcompare.class);
        startActivity(intent);
    }

}

