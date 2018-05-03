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

public class NFL extends AppCompatActivity {
    String input1;
    String input2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nfl);

        Button nflBack =  findViewById(R.id.nfl_back_button);
        Button nflCompare = findViewById(R.id.compare_nfl);
        final AutoCompleteTextView firstPlayer = findViewById(R.id.nfl_first);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item,quarterBacks);
        firstPlayer.setAdapter(adapter);

        final AutoCompleteTextView secondPlayer = findViewById(R.id.nfl_second);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item,quarterBacks);
        secondPlayer.setAdapter(adapter1);

        nflCompare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input1 = firstPlayer.getText().toString();
                input1 = input1.replace(' ','-');
                input2 = secondPlayer.getText().toString();
                input2 = input2.replace(' ','-');
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
        intent.putExtra("p1", input1);
        intent.putExtra("p2",input2);
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
    public String betterPlayer(String player1, String player2) {
        int playerA = 0;
        int playerB = 0;
        Data p1 = new Data(player1, "NFL");
        Data p2 = new Data(player2, "NFL");
        if (getPassingTD(p1.apiGetData()) > getPassingTD(p2.apiGetData())) {
            playerA++;
        } else {
            playerB++;
        }
        if (getPassingYards(p1.apiGetData()) > getPassingYards(p2.apiGetData())) {
            playerA++;
        } else {
            playerB++;
        }
        if (getQBRating(p1.apiGetData()) > getQBRating(p2.apiGetData())) {
            playerA++;
        } else {
            playerB++;
        }
        if (getInterceptions(p1.apiGetData()) < getInterceptions(p2.apiGetData())) {
            playerA++;
        } else {
            playerB++;
        }
        if (getPassPercentage(p1.apiGetData()) > getPassPercentage(p2.apiGetData())) {
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
    private static String[] quarterBacks = new String[] {"Tom Brady", "Drew Brees", "Aaron Rodgers", "Jay Cutler",
            "T. J. Yates","Jameis Winston", "Russell Wilson","Mitchell Trubisky","Tyrod Taylor","Drew Stanton","Matthew Stafford",
        "Matt Ryan","Philip Rivers","Dak Prescott","Bryce Petty","Cam Newton","Marcus Mariota","Sean Mannion","Eli Manning","Patrick Mahomes II",
        "Paxton Lynch","DeShone Kizer","Case Keenum","Landry Jones","Brett Hundley","Jimmy Garoppolo","Nick Foles","Joe Flacco","Andy Dalton",
        "Kirk Cousins","Derek Carr","Jacoby Brissett","Blake Bortles"};



}
