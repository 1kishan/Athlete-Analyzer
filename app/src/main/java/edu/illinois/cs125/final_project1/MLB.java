package edu.illinois.cs125.final_project1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

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

    public static String homeRuns(String player1, String player2, String json) {
        int player1HomeRuns = 0;
        int player2HomeRuns = 0;
        JsonParser parser = new JsonParser();
        JsonObject rootObj = parser.parse(json).getAsJsonObject();
        JsonArray playerStatsArray = rootObj.getAsJsonArray("playerstatsentry");
        for (JsonElement element : playerStatsArray) {
            JsonObject elementObject = element.getAsJsonObject();
            JsonObject playerObject = elementObject.getAsJsonObject("player");
            JsonElement firstNameElement = playerObject.get("FirstName");
            String firstName = firstNameElement.getAsString();
            JsonElement lastNameElement = playerObject.get("LastName");
            String lastName = lastNameElement.getAsString();
            JsonObject statsObject = elementObject.getAsJsonObject("stats");
            JsonElement homeRunsElement = statsObject.get("HomeRuns");
            JsonObject homeRunsObject = homeRunsElement.getAsJsonObject();
            int homeRuns = homeRunsObject.get("#text").getAsInt();
            String position = homeRunsObject.get("@category").getAsString();
            if (player1.equals(firstName + " " + lastName) && position.equals("Batting")) {
                player1HomeRuns = homeRuns;
            }
            if (player2.equals(firstName + " " + lastName) && position.equals("Batting")) {
                player2HomeRuns = homeRuns;
            }
        }
        if (player1HomeRuns > player2HomeRuns) {
            return player1;
        }
        if (player2HomeRuns > player1HomeRuns) {
            return player2;
        } else {
            return player1 + " and " + player2 + " are tied.";
        }
    }

}

