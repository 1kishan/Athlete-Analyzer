package edu.illinois.cs125.final_project1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class NBA extends AppCompatActivity {

    String input1;
    String input2;

    public TextView nbaPlayer1ppg;

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


        final TextInputEditText firstPlayer = findViewById(R.id.nba_first);
        final TextInputEditText secondPlayer = findViewById(R.id.nba_second);



        Button nbaCompare = findViewById(R.id.compare_nba);
        nbaCompare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input1 = firstPlayer.getText().toString();
                input1 = input1.replace(' ','-');
                input2 = secondPlayer.getText().toString();
                input2 = input2.replace(' ','-');
                launchNBAcompare();

            }
        });


    }
    public void launchNBAcompare() {
        Intent intent = new Intent(this, NBAcompare.class);
        intent.putExtra("p1", input1);
        intent.putExtra("p2",input2);
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
    public String betterPlayer(String player1, String player2) {
        int playerA = 0;
        int playerB = 0;
        Data p1 = new Data(player1,"NBA");
        Data p2 = new Data(player2,"NBA");
        if (getAPG(p1.apiGetData()) > getAPG(p2.apiGetData())) {
            playerA++;
        } else {
            playerB++;
        }
        if (getFg3PtPct(p1.apiGetData()) > getFg3PtPct(p2.apiGetData())) {
            playerA++;
        } else {
            playerB++;
        }
        if (getPPG(p1.apiGetData()) > getPPG(p2.apiGetData())) {
            playerA++;
        } else {
            playerB++;
        }
        if (getTovPerGame(p1.apiGetData()) < getAPG(p2.apiGetData())) {
            playerA++;
        } else {
            playerB++;
        }
        if (getRPG(p1.apiGetData()) > getRPG(p2.apiGetData())) {
            playerA++;
        } else {
            playerB++;
        }
        if (playerA > playerB) {
            return player1;
        } else {
            return player2;
        }
    }


}
