package edu.illinois.cs125.final_project1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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


    }

    /**
     * This method extracts the points per game for  a player
     * @param json json string from the sportsfeed api
     * @return return the points per game
     */
    public int getPPG(String json) {
        if (json == null) {
            return 0;
        }
        return 0;
    }

    /**
     * This method extracts the assists per game for  a player
     * @param json json string from the sportsfeed api
     * @return return the assists per game
     */
    public int getAPG(String json) {
        return 0;
    }

    /**
     * This method extracts the rebounds per game for  a player
     * @param json json string from the sportsfeed api
     * @return return the rebounds per game
     */
    public int getRPG(String json) {
        return 0;
    }

    /**
     * This method extracts the three point percentage per game for  a player
     * @param json json string from the sportsfeed api
     * @return return the 3 point fg % per game
     */
    public int getFg3PtPct(String json) {
        return 0;
    }

    /**
     * This method extracts the turnovers per game for  a player
     * @param json json String from the sportsfeed api
     * @return returns the turnovers per game for a player
     */
    public int getTovPerGame(String json) {
        return 0;
    }




}
