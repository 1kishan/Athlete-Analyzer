package edu.illinois.cs125.final_project1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NFLcompare extends AppCompatActivity {
    NFL getMethods = new NFL();
    public TextView passingTDs;
    public TextView interceptions;
    public TextView passingYards;
    public TextView qbRating;
    public TextView completetionPercentage;
    public TextView passingTDs1;
    public TextView interceptions1;
    public TextView passingYards1;
    public TextView qbRating1;
    public TextView completetionPercentage1;
    public TextView passingTDs2;
    public TextView interceptions2;
    public TextView passingYards2;
    public TextView qbRating2;
    public TextView completetionPercentage2;
    public TextView betterPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nflcompare);

        Button nflcompareback = (Button) findViewById(R.id.nfl_compare_back);
        Intent intent = getIntent();
        String input1 = intent.getStringExtra("p1");
        String input2 = intent.getStringExtra("p2");
        Data player1 = new Data(input1,"NFL");
        Data player2 = new Data(input2, "NFL");

        passingTDs.setText("Total Passing Touchdowns");
        interceptions.setText("Total Interceptions Thrown");
        passingYards.setText("Total Passing Yards");
        qbRating.setText("Average QB rating");
        completetionPercentage.setText("Completion Percentage");
        betterPlayer.setText("This is the better player");
        passingTDs1.setText(Integer.toString(getMethods.getPassingTD(player1.apiGetData())));
        passingTDs2.setText(Integer.toString(getMethods.getPassingTD(player2.apiGetData())));
        
        interceptions1.setText(Integer.toString(getMethods.getInterceptions(player1.apiGetData())));
        interceptions2.setText(Integer.toString(getMethods.getInterceptions(player2.apiGetData())));
        passingYards1.setText(Integer.toString(getMethods.getPassingYards(player1.apiGetData())));
        passingYards2.setText(Integer.toString(getMethods.getPassingYards(player2.apiGetData())));
        qbRating1.setText(Double.toString(getMethods.getQBRating(player1.apiGetData())));
        qbRating2.setText(Double.toString(getMethods.getQBRating(player2.apiGetData())));
        completetionPercentage1.setText(Double.toString(getMethods.getPassPercentage(player1.apiGetData())));
        completetionPercentage2.setText(Double.toString(getMethods.getPassPercentage(player2.apiGetData())));
        betterPlayer.setText(getMethods.betterPlayer());
        betterPlayer.setTextColor(Color.GREEN);
        nflcompareback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
