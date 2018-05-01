package edu.illinois.cs125.final_project1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

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
        Button nbaCompare = findViewById(R.id.compare_nba);
        final TextInputEditText firstPlayer = findViewById(R.id.nba_first);
        final TextInputEditText secondPlayer = findViewById(R.id.nba_second);
        nbaCompare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input1 = firstPlayer.getText().toString();
                input1 = input1.replace(' ','-');
                String input2 = secondPlayer.getText().toString();
                input2 = input2.replace(' ','-');
                Data player1 = new Data(input1,"NBA");
                Data player2 = new Data(input2, "NBA");
                launchNBAcompare();
                System.out.println(getAPG(player1.apiGetData()));
                System.out.println(getFg3PtPct(player1.apiGetData()));
                System.out.println(getPPG(player1.apiGetData()));
                System.out.println(getRPG(player1.apiGetData()));
                System.out.println(getTovPerGame(player1.apiGetData()));
            }
        });


    }
    public void launchNBAcompare() {
        Intent intent = new Intent(this, NBA.class);
        startActivity(intent);
    }

    /**
     * This method extracts the points per game for  a player
     * @param json json string from the sportsfeed api
     * @return return the points per game
     */
    public double getPPG(String json) {
        if (json == null) {
            return 0;
        }
        JsonParser parser = new JsonParser();
        JsonObject rootObj = parser.parse(json).getAsJsonObject();
        JsonObject cumulativeplayerstats = rootObj.getAsJsonObject("cumulativeplayerstats");
        JsonArray playerStatsArray = cumulativeplayerstats.get("playerstatsentry").getAsJsonArray();
        double qbRating = playerStatsArray.get(0).getAsJsonObject().get("stats").getAsJsonObject().get("PtsPerGame").
                getAsJsonObject().get("#text").getAsDouble();
        return qbRating;
    }

    /**
     * This method extracts the assists per game for  a player
     * @param json json string from the sportsfeed api
     * @return return the assists per game
     */
    public double getAPG(String json) {
        if (json == null) {
            return 0;
        }
        JsonParser parser = new JsonParser();
        JsonObject rootObj = parser.parse(json).getAsJsonObject();
        JsonObject cumulativeplayerstats = rootObj.getAsJsonObject("cumulativeplayerstats");
        JsonArray playerStatsArray = cumulativeplayerstats.get("playerstatsentry").getAsJsonArray();
        double qbRating = playerStatsArray.get(0).getAsJsonObject().get("stats").getAsJsonObject().get("AstPerGame").
                getAsJsonObject().get("#text").getAsDouble();
        return qbRating;
    }

    /**
     * This method extracts the rebounds per game for  a player
     * @param json json string from the sportsfeed api
     * @return return the rebounds per game
     */
    public double getRPG(String json) {
        if (json == null) {
            return 0;
        }
        JsonParser parser = new JsonParser();
        JsonObject rootObj = parser.parse(json).getAsJsonObject();
        JsonObject cumulativeplayerstats = rootObj.getAsJsonObject("cumulativeplayerstats");
        JsonArray playerStatsArray = cumulativeplayerstats.get("playerstatsentry").getAsJsonArray();
        double qbRating = playerStatsArray.get(0).getAsJsonObject().get("stats").getAsJsonObject().get("RebPerGame").
                getAsJsonObject().get("#text").getAsDouble();
        return qbRating;
    }

    /**
     * This method extracts the three point percentage per game for  a player
     * @param json json string from the sportsfeed api
     * @return return the 3 point fg % per game
     */
    public double getFg3PtPct(String json) {
        if (json == null) {
            return 0;
        }
        JsonParser parser = new JsonParser();
        JsonObject rootObj = parser.parse(json).getAsJsonObject();
        JsonObject cumulativeplayerstats = rootObj.getAsJsonObject("cumulativeplayerstats");
        JsonArray playerStatsArray = cumulativeplayerstats.get("playerstatsentry").getAsJsonArray();
        double qbRating = playerStatsArray.get(0).getAsJsonObject().get("stats").getAsJsonObject().get("Fg3PtPct").
                getAsJsonObject().get("#text").getAsDouble();
        return qbRating;
    }

    /**
     * This method extracts the turnovers per game for  a player
     * @param json json String from the sportsfeed api
     * @return returns the turnovers per game for a player
     */
    public double getTovPerGame(String json) {
        if (json == null) {
            return 0;
        }
        JsonParser parser = new JsonParser();
        JsonObject rootObj = parser.parse(json).getAsJsonObject();
        JsonObject cumulativeplayerstats = rootObj.getAsJsonObject("cumulativeplayerstats");
        JsonArray playerStatsArray = cumulativeplayerstats.get("playerstatsentry").getAsJsonArray();
        double qbRating = playerStatsArray.get(0).getAsJsonObject().get("stats").getAsJsonObject().get("TovPerGame").
                getAsJsonObject().get("#text").getAsDouble();
        return qbRating;
    }




}
