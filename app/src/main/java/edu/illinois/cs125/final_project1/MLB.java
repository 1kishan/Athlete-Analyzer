package edu.illinois.cs125.final_project1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
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

    /**
     * Extracts the Homeruns for a player
     * @param json json string that is retrieved by the API call
     * @return returns the number of homeruns for a player
     */
    public int getHR(String json) {
        return 0;
    }

    /**
     * Extracts the Runs batted in for a player
     * @param json json string that is retrieved by the API call
     * @return returns the number of runs batted in for a player
     */
    public int getRBI(String json) {
        return 0;
    }

    /**
     * Extracts the batting average for a player
     * @param json json string that is retrieved by the API call
     * @return returns the number of batting average for a player
     */
    public int getBattingAvg(String json) {
        return 0;
    }

    /**
     * Extracts the Homeruns for a player
     * @param json json string that is retrieved by the API call
     * @return returns the number of homeruns for a player
     */
    public int getErrors(String json) {
        return 0;
    }

    /**
     * Extracts the Strikeouts for a player
     * @param json json string that is retrieved by the API call
     * @return returns the number of strikeouts for a player
     */
    public int getStrikeouts(String json) {
        return 0;
    }

}

