package edu.illinois.cs125.final_project1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class NFL extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nfl);

        Button nflBack = (Button) findViewById(R.id.nfl_back_button);


        nflBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });

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
        JsonArray playerStatsArray = rootObj.getAsJsonArray("playerstatsentry");
        for (JsonElement element : playerStatsArray) {
            JsonObject elementObject = element.getAsJsonObject();
            String elementString = elementObject.getAsString();
            if (elementString.equals("stats")) {
                JsonElement homeRunsElement = elementObject.get("PassTD");
                if (homeRunsElement == null) {
                    return 0;
                }
                JsonObject homeRunsObject = homeRunsElement.getAsJsonObject();
                return homeRunsObject.get("#text").getAsInt();

            }
        }
        return 0;
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
        JsonArray playerStatsArray = rootObj.getAsJsonArray("playerstatsentry");
        for (JsonElement element : playerStatsArray) {
            JsonObject elementObject = element.getAsJsonObject();
            String elementString = elementObject.getAsString();
            if (elementString.equals("stats")) {
                JsonElement homeRunsElement = elementObject.get("PassInt");
                if (homeRunsElement == null) {
                    return 0;
                }
                JsonObject homeRunsObject = homeRunsElement.getAsJsonObject();
                return homeRunsObject.get("#text").getAsInt();

            }
        }
        return 0;
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
        JsonArray playerStatsArray = rootObj.getAsJsonArray("playerstatsentry");
        for (JsonElement element : playerStatsArray) {
            JsonObject elementObject = element.getAsJsonObject();
            String elementString = elementObject.getAsString();
            if (elementString.equals("stats")) {
                JsonElement homeRunsElement = elementObject.get("PassYards");
                if (homeRunsElement == null) {
                    return 0;
                }
                JsonObject homeRunsObject = homeRunsElement.getAsJsonObject();
                return homeRunsObject.get("#text").getAsInt();

            }
        }
        return 0;
    }
    /**
     * extracts completion percetange from the json
     * @param json json string that is retrieved from the webapi call
     * @return returns the completion percentage for the 2017 season
     */
    public int getPassPercentage(String json) {
        if (json == null) {
            return 0;
        }
        JsonParser parser = new JsonParser();
        JsonObject rootObj = parser.parse(json).getAsJsonObject();
        JsonArray playerStatsArray = rootObj.getAsJsonArray("playerstatsentry");
        for (JsonElement element : playerStatsArray) {
            JsonObject elementObject = element.getAsJsonObject();
            String elementString = elementObject.getAsString();
            if (elementString.equals("stats")) {
                JsonElement homeRunsElement = elementObject.get("PassPct");
                if (homeRunsElement == null) {
                    return 0;
                }
                JsonObject homeRunsObject = homeRunsElement.getAsJsonObject();
                return homeRunsObject.get("#text").getAsInt();

            }
        }
        return 0;
    }
    /**
     * extracts passer rating from the json
     * @param json json string that is retrieved from the webapi call
     * @return returns the average QB rating for the player for the 2017 season
     */
    public int getQBRating(String json) {
        if (json == null) {
            return 0;
        }
        JsonParser parser = new JsonParser();
        JsonObject rootObj = parser.parse(json).getAsJsonObject();
        JsonArray playerStatsArray = rootObj.getAsJsonArray("playerstatsentry");
        for (JsonElement element : playerStatsArray) {
            JsonObject elementObject = element.getAsJsonObject();
            String elementString = elementObject.getAsString();
            if (elementString.equals("stats")) {
                JsonElement homeRunsElement = elementObject.get("QBRating");
                if (homeRunsElement == null) {
                    return 0;
                }
                JsonObject homeRunsObject = homeRunsElement.getAsJsonObject();
                return homeRunsObject.get("#text").getAsInt();

            }
        }
        return 0;
    }


}
