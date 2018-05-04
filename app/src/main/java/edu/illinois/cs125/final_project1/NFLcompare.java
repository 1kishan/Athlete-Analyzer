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

   public TextView nflplayer1name;
   public TextView nflplayer2name;

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


    public TextView nflbetterPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nflcompare);

        Button nflcompareback = (Button) findViewById(R.id.nfl_compare_back);
        Intent intent = getIntent();
        String input1 = intent.getStringExtra("p1");
        String input2 = intent.getStringExtra("p2");
        int season = intent.getIntExtra("year",2018);
        boolean playOff = intent.getBooleanExtra("playoffs",false);
        Data player1 = new Data(input1,"NFL",season,playOff);
        Data player2 = new Data(input2, "NFL",season,playOff);
        String jsonPlayer1 = player1.apiGetData();
        String jsonPlayer2 = player2.apiGetData();
        String p1Name = input1;
        String p2Name = input2;
        p1Name = p1Name.replace('-',' ');
        p2Name = p2Name.replace('-',' ');
        
        
        nflplayer1name = findViewById(R.id.nfl_player1_name);
        nflplayer1name.setText(p1Name);

        nflplayer2name = findViewById(R.id.nfl_player2_name);
        nflplayer2name.setText(p2Name);


        //set player 1 info
        passingTDs1 = findViewById(R.id.nflplayer1tpd);
        passingTDs1.setText(Integer.toString(getMethods.getPassingTD(jsonPlayer1)));

        interceptions1 = findViewById(R.id.nflplayer1ti);
        interceptions1.setText(Integer.toString(getMethods.getInterceptions(jsonPlayer1)));

        passingYards1 = findViewById(R.id.nflplayer1tpy);
        passingYards1.setText(Integer.toString(getMethods.getPassingYards(jsonPlayer1)));

        qbRating1 = findViewById(R.id.nflplayer1qbr);
        qbRating1.setText(Double.toString(getMethods.getQBRating(jsonPlayer1)));

        completetionPercentage1 = findViewById(R.id.nflplayer1cp);
        completetionPercentage1.setText(Double.toString(getMethods.getPassPercentage(jsonPlayer1)));

        //set player 2 info
        passingTDs2 = findViewById(R.id.nflplayer2tpd);
        passingTDs2.setText(Integer.toString(getMethods.getPassingTD(jsonPlayer2)));

        interceptions2 = findViewById(R.id.nflplayer2ti);
        interceptions2.setText(Integer.toString(getMethods.getInterceptions(jsonPlayer2)));

        passingYards2 = findViewById(R.id.nflplayer2tpy);
        passingYards2.setText(Integer.toString(getMethods.getPassingYards(jsonPlayer2)));

        qbRating2 = findViewById(R.id.nflplayer2qbr);
        qbRating2.setText(Double.toString(getMethods.getQBRating(jsonPlayer2)));

        completetionPercentage2 = findViewById(R.id.nflplayer2cp);
        completetionPercentage2.setText(Double.toString(getMethods.getPassPercentage(jsonPlayer2)));

        nflbetterPlayer = findViewById(R.id.the_better_player2);
        nflbetterPlayer.setText("The better player is: " + getMethods.betterPlayer(input1, input2));
        nflbetterPlayer.setTextColor(Color.GREEN);

        //sets color of winner to green.. loser of category to red
        if (getMethods.getPassPercentage(jsonPlayer1) > getMethods.getPassPercentage(jsonPlayer2)) {
            completetionPercentage1.setTextColor(Color.GREEN);
            completetionPercentage2.setTextColor(Color.RED);
        } else {
            completetionPercentage2.setTextColor(Color.GREEN);
            completetionPercentage1.setTextColor(Color.RED);
        }
        if (getMethods.getQBRating(jsonPlayer1) > getMethods.getQBRating(jsonPlayer2)) {
            qbRating1.setTextColor(Color.GREEN);
            qbRating2.setTextColor(Color.RED);
        } else {
            qbRating2.setTextColor(Color.GREEN);
            qbRating1.setTextColor(Color.RED);
        }
        if (getMethods.getInterceptions(jsonPlayer1) < getMethods.getInterceptions(jsonPlayer2)) {
            interceptions1.setTextColor(Color.GREEN);
            interceptions2.setTextColor(Color.RED);
        } else {
            interceptions2.setTextColor(Color.GREEN);
            interceptions1.setTextColor(Color.RED);
        }
        if (getMethods.getPassingYards(jsonPlayer1) > getMethods.getPassingYards(jsonPlayer2)) {
            passingYards1.setTextColor(Color.GREEN);
            passingYards2.setTextColor(Color.RED);
        } else {
            passingYards2.setTextColor(Color.GREEN);
            passingYards1.setTextColor(Color.RED);
        }
        if (getMethods.getPassingTD(jsonPlayer1) > getMethods.getPassingTD(jsonPlayer2)) {
            passingTDs1.setTextColor(Color.GREEN);
            passingTDs2.setTextColor(Color.RED);
        } else {
            passingTDs2.setTextColor(Color.GREEN);
            passingTDs1.setTextColor(Color.RED);
        }


        nflcompareback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
