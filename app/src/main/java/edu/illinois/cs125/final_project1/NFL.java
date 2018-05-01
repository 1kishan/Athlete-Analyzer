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

public class NFL extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nfl);

        Button nflBack =  findViewById(R.id.nfl_back_button);
        Button nflCompare = findViewById(R.id.compare_nfl);
        final TextInputEditText firstPlayer = findViewById(R.id.nfl_first);
        final TextInputEditText secondPlayer = findViewById(R.id.nfl_second);
        nflCompare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input1 = firstPlayer.getText().toString();
                input1 = input1.replace(' ','-');
                String input2 = secondPlayer.getText().toString();
                input2 = input2.replace(' ','-');
                Data player1 = new Data(input1,"NFL");
                Data player2 = new Data(input2, "NFL");
                launchNFLcompare();
            }
        });

        nflBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });

    }
    public void launchNFLcompare() {
        Intent intent = new Intent(this, NFLcompare.class);
        startActivity(intent);
    }


    /**
     * extracts passing touchdowns from the json
     * @param json json string that is retrieved from the webapi call
     * @return returns the total touchdowns for the 2017 season
     */
    public int getPassingTD(String json) {
        if (json == null) {
            return 0;
        }
        JsonParser parser = new JsonParser();
        JsonObject rootObj = parser.parse(json).getAsJsonObject();
        JsonObject cumulativeplayerstats = rootObj.getAsJsonObject("cumulativeplayerstats");
        JsonArray playerStatsArray = cumulativeplayerstats.get("playerstatsentry").getAsJsonArray();
        int PassTD = playerStatsArray.get(0).getAsJsonObject().get("stats").getAsJsonObject().get("PassTD").
                getAsJsonObject().get("#text").getAsInt();
        return PassTD;
    }

    /**
     * extracts interceptions from the json
     * @param json json string that is retrieved from the webapi call
     * @return returns the total interceptions for the 2017 season
     */
    public int getInterceptions(String json) {
        if (json == null) {
            return 0;
        }
        JsonParser parser = new JsonParser();
        JsonObject rootObj = parser.parse(json).getAsJsonObject();
        JsonObject cumulativeplayerstats = rootObj.getAsJsonObject("cumulativeplayerstats");
        JsonArray playerStatsArray = cumulativeplayerstats.get("playerstatsentry").getAsJsonArray();
        int ints = playerStatsArray.get(0).getAsJsonObject().get("stats").getAsJsonObject().get("PassInt").
                getAsJsonObject().get("#text").getAsInt();
        return ints;
    }
    /**
     * extracts passing yards from the json
     * @param json json string that is retrieved from the webapi call
     * @return returns the total passing yards for the 2017 season
     */
    public int getPassingYards(String json) {
        if (json == null) {
            return 0;
        }
        JsonParser parser = new JsonParser();
        JsonObject rootObj = parser.parse(json).getAsJsonObject();
        JsonObject cumulativeplayerstats = rootObj.getAsJsonObject("cumulativeplayerstats");
        JsonArray playerStatsArray = cumulativeplayerstats.get("playerstatsentry").getAsJsonArray();
        int passYards = playerStatsArray.get(0).getAsJsonObject().get("stats").getAsJsonObject().get("PassYards").
                getAsJsonObject().get("#text").getAsInt();
        return passYards;
    }
    /**
     * extracts completion percetange from the json
     * @param json json string that is retrieved from the webapi call
     * @return returns the completion percentage for the 2017 season
     */
    public double getPassPercentage(String json) {
        if (json == null) {
            return 0;
        }
        JsonParser parser = new JsonParser();
        JsonObject rootObj = parser.parse(json).getAsJsonObject();
        JsonObject cumulativeplayerstats = rootObj.getAsJsonObject("cumulativeplayerstats");
        JsonArray playerStatsArray = cumulativeplayerstats.get("playerstatsentry").getAsJsonArray();
        double passPct = playerStatsArray.get(0).getAsJsonObject().get("stats").getAsJsonObject().get("PassPct").
                getAsJsonObject().get("#text").getAsDouble();
        return passPct;
    }
    /**
     * extracts passer rating from the json
     * @param json json string that is retrieved from the webapi call
     * @return returns the average QB rating for the player for the 2017 season
     */
    public double getQBRating(String json) {
        if (json == null) {
            return 0;
        }
        JsonParser parser = new JsonParser();
        JsonObject rootObj = parser.parse(json).getAsJsonObject();
        JsonObject cumulativeplayerstats = rootObj.getAsJsonObject("cumulativeplayerstats");
        JsonArray playerStatsArray = cumulativeplayerstats.get("playerstatsentry").getAsJsonArray();
        double qbRating = playerStatsArray.get(0).getAsJsonObject().get("stats").getAsJsonObject().get("QBRating").
                getAsJsonObject().get("#text").getAsDouble();
        return qbRating;
    }


}
