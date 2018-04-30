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

    public int PassTD(String json) {
        JsonParser parser = new JsonParser();
        JsonObject rootObj = parser.parse(json).getAsJsonObject();
        JsonArray playerStatsArray = rootObj.getAsJsonArray("playerstatsentry");
        for (JsonElement element : playerStatsArray) {
            JsonObject elementObject = element.getAsJsonObject();
            String elementString = elementObject.getAsString();
            if (elementString.equals("stats")) {
                JsonElement homeRunsElement = elementObject.get("PassTD");
                JsonObject homeRunsObject = homeRunsElement.getAsJsonObject();
                return homeRunsObject.get("#text").getAsInt();

            }
        }
        return 0;
    }
}
