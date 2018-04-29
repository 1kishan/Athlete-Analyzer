package edu.illinois.cs125.final_project1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    public static String playerTD(String player1, String player2, String json) {
        int player1TD = 0;
        int player2TD = 0;
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
            JsonElement TDElement = statsObject.get("PassTD");
            JsonObject TDObject = TDElement.getAsJsonObject();
            int TD = TDObject.get("#text").getAsInt();
            if (player1.equals(firstName + " " + lastName)) {
                player1TD = TD;
            }
            if (player2.equals(firstName + " " + lastName)) {
                player2TD = TD;
            }
        }
        if (player1TD > player2TD) {
            return player1;
        }
        if (player2TD > player1TD) {
            return player2;
        } else {
            return player1 + " and " + player2 + " are tied.";
        }
    }
}
