package edu.illinois.cs125.final_project1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;

public class MLB extends AppCompatActivity {
    String input1,input2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mlb);
        Intent intent = getIntent();
        ArrayList<String> x = intent.getStringArrayListExtra("players");

        Button mlbBack = (Button) findViewById(R.id.mlb_back_button);
        mlbBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



//        final TextInputEditText firstPlayer = findViewById(R.id.mlb_first);
//        final TextInputEditText secondPlayer = findViewById(R.id.mlb_second);
        final AutoCompleteTextView firstPlayer = findViewById(R.id.mlb_first);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item,x);
        firstPlayer.setAdapter(adapter);

        final AutoCompleteTextView secondPlayer = findViewById(R.id.mlb_second);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item,x);
        secondPlayer.setAdapter(adapter1);

        Button mlbCompare = (Button) findViewById(R.id.compare_mlb);
        mlbCompare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input1 = firstPlayer.getText().toString();
                input1 = input1.replace(' ','-');
                input2 = secondPlayer.getText().toString();
                input2 = input2.replace(' ','-');
                Data player1 = new Data(input1,"MLB");
                Data player2 = new Data(input2, "MLB");
                System.out.println(player1.urlBuilder());
                System.out.println(player2.urlBuilder());
                launchMLBCompare();
            }
        });

    }

    public void launchMLBCompare() {

        Intent intent = new Intent(this, MLBcompare.class);
        intent.putExtra("p1", input1);
        intent.putExtra("p2",input2);
        startActivity(intent);
    }

    /**
     * Extracts the Homeruns for a player
     * @param json json string that is retrieved by the API call
     * @return returns the number of homeruns for a player
     */
    public int getHR(String json) {
        if (json == null) {
            return 0;
        }
        JsonParser parser = new JsonParser();
        JsonObject rootObj = parser.parse(json).getAsJsonObject();
        JsonObject cumulativeplayerstats = rootObj.getAsJsonObject("cumulativeplayerstats");
        JsonArray playerStatsArray = cumulativeplayerstats.get("playerstatsentry").getAsJsonArray();
        int qbRating = playerStatsArray.get(0).getAsJsonObject().get("stats").getAsJsonObject().get("Homeruns").
                getAsJsonObject().get("#text").getAsInt();
        return qbRating;
    }

    /**
     * Extracts the Runs batted in for a player
     * @param json json string that is retrieved by the API call
     * @return returns the number of runs batted in for a player
     */
    public int getRBI(String json) {
        if (json == null) {
            return 0;
        }
        JsonParser parser = new JsonParser();
        JsonObject rootObj = parser.parse(json).getAsJsonObject();
        JsonObject cumulativeplayerstats = rootObj.getAsJsonObject("cumulativeplayerstats");
        JsonArray playerStatsArray = cumulativeplayerstats.get("playerstatsentry").getAsJsonArray();
        int qbRating = playerStatsArray.get(0).getAsJsonObject().get("stats").getAsJsonObject().get("RunsBattedIn").
                getAsJsonObject().get("#text").getAsInt();
        return qbRating;
    }

    /**
     * Extracts the batting average for a player
     * @param json json string that is retrieved by the API call
     * @return returns the number of batting average for a player
     */
    public double getBattingAvg(String json) {
        if (json == null) {
            return 0;
        }
        JsonParser parser = new JsonParser();
        JsonObject rootObj = parser.parse(json).getAsJsonObject();
        JsonObject cumulativeplayerstats = rootObj.getAsJsonObject("cumulativeplayerstats");
        JsonArray playerStatsArray = cumulativeplayerstats.get("playerstatsentry").getAsJsonArray();
        double qbRating = playerStatsArray.get(0).getAsJsonObject().get("stats").getAsJsonObject().get("BattingAvg").
                getAsJsonObject().get("#text").getAsDouble();
        return qbRating;
    }

    /**
     * Extracts the Homeruns for a player
     * @param json json string that is retrieved by the API call
     * @return returns the number of homeruns for a player
     */
    public int getErrors(String json) {
        if (json == null) {
            return 0;
        }
        JsonParser parser = new JsonParser();
        JsonObject rootObj = parser.parse(json).getAsJsonObject();
        JsonObject cumulativeplayerstats = rootObj.getAsJsonObject("cumulativeplayerstats");
        JsonArray playerStatsArray = cumulativeplayerstats.get("playerstatsentry").getAsJsonArray();
        int qbRating = playerStatsArray.get(0).getAsJsonObject().get("stats").getAsJsonObject().get("Errors").
                getAsJsonObject().get("#text").getAsInt();
        return qbRating;
    }

    /**
     * Extracts the Strikeouts for a player
     * @param json json string that is retrieved by the API call
     * @return returns the number of strikeouts for a player
     */
    public int getStrikeouts(String json) {
        if (json == null) {
            return 0;
        }
        JsonParser parser = new JsonParser();
        JsonObject rootObj = parser.parse(json).getAsJsonObject();
        JsonObject cumulativeplayerstats = rootObj.getAsJsonObject("cumulativeplayerstats");
        JsonArray playerStatsArray = cumulativeplayerstats.get("playerstatsentry").getAsJsonArray();
        int qbRating = playerStatsArray.get(0).getAsJsonObject().get("stats").getAsJsonObject().get("BatterStrikeouts").
                getAsJsonObject().get("#text").getAsInt();
        return qbRating;
    }
    public String betterPlayer(String player1, String player2) {
        int playerA = 0;
        int playerB = 0;
        Data p1 = new Data(player1, "MLB");
        Data p2 = new Data(player2, "MLB");
        if (getHR(p1.apiGetData()) > getHR(p2.apiGetData())) {
            playerA++;
        } else {
            playerB++;
        }
        if (getHR(p1.apiGetData()) > getHR(p2.apiGetData())) {
            playerA++;
        } else {
            playerB++;
        }
        if (getRBI(p1.apiGetData()) > getRBI(p2.apiGetData())) {
            playerA++;
        } else {
            playerB++;
        }
        if (getStrikeouts(p1.apiGetData()) < getStrikeouts(p2.apiGetData())) {
            playerA++;
        } else {
            playerB++;
        }
        if (getErrors(p1.apiGetData()) < getErrors(p2.apiGetData())) {
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
    public static ArrayList<String> players(String jsonPlayers) {
        if (jsonPlayers == null) {
            return null;
        }
        ArrayList<String> allPlayers = new ArrayList<>();
        JsonParser parser = new JsonParser();
        JsonObject rootObj = parser.parse(jsonPlayers).getAsJsonObject();
        JsonObject rosterplayers = rootObj.getAsJsonObject("rosterplayers");
        JsonArray playerentry = rosterplayers.get("playerentry").getAsJsonArray();
        for (int i = 0; i < playerentry.size(); i++) {
            String first = playerentry.get(i).getAsJsonObject().get("player").getAsJsonObject().get("FirstName").getAsString();
            String last =  playerentry.get(i).getAsJsonObject().get("player").getAsJsonObject().get("LastName").getAsString();
            String fullName = first +" "+ last;
            allPlayers.add(fullName);
        }
        return allPlayers;

    }
    public static String getPlayers() {
        try {
            URL url = new URL ("https://api.mysportsfeeds.com/v1.2/pull/mlb/2017-regular/roster_players.json?fordate=20170802");
            String username = "1kishan:CS125Project";
            byte[] user = username.getBytes();
            String encoding = Base64.getEncoder().encodeToString(user);

            byte[] encodedBytes = Base64.getEncoder().encode("Test".getBytes());
            System.out.println("encodedBytes " + new String(encodedBytes));
            byte[] decodedBytes = Base64.getDecoder().decode(encodedBytes);
            System.out.println("decodedBytes " + new String(decodedBytes));

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            //connection.setDoOutput(true);
            connection.setRequestProperty("Authorization", "Basic " + encoding);
            InputStream content = (InputStream)connection.getInputStream();
            BufferedReader in =
                    new BufferedReader(new InputStreamReader(content));
            String line;
            String jsonPlayers = "";
            while ((line = in.readLine()) != null) {
                jsonPlayers += line;
            }
            return jsonPlayers;

        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

