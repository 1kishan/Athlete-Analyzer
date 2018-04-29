package edu.illinois.cs125.final_project1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
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
        Button compare = findViewById(R.id.compare_nba);
        compare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Data player1 = new Data("Lebron-James","NBA");
                player1.apiGetData();
            }
        });


    }

    public static String playerPPG(String player1, String player2, String json) {
        int player1PPG = 0;
        int player2PPG = 0;
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
            JsonElement PPGElement = statsObject.get("PtsPerGame");
            JsonObject PPGObject = PPGElement.getAsJsonObject();
            int PPG = PPGObject.get("#text").getAsInt();
            if (player1.equals(firstName + " " + lastName)) {
                player1PPG = PPG;
            }
            if (player2.equals(firstName + " " + lastName)) {
                player2PPG = PPG;
            }
        }
        if (player1PPG > player2PPG) {
            return player1;
        }
        if (player2PPG > player1PPG) {
            return player2;
        } else {
            return player1 + " and " + player2 + " are tied.";
        }
    }
}
