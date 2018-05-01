package edu.illinois.cs125.final_project1;

import android.graphics.Color;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

public class NBAcompare extends AppCompatActivity {

    public TextView nbaPlayer1name;
    public TextView nbaPlayer1ppg;
    public TextView nbaPlayer1apg;
    public TextView nbaPlayer1rpg;
    public TextView nbaPlayer1fg3ptpct;
    public TextView nbaPlayer1tpg;

    public TextView nbaPlayer2name;
    public TextView nbaPlayer2ppg;
    public TextView nbaPlayer2apg;
    public TextView nbaPlayer2rpg;
    public TextView nbaPlayer2fg3ptpct;
    public TextView nbaPlayer2tpg;

    public TextView betterplayertext;

    NBA getMethods = new NBA();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nbacompare);
        Intent intent = getIntent();
        String input1 = intent.getStringExtra("p1");
        String input2 = intent.getStringExtra("p2");
        Button nbacompareback = (Button) findViewById(R.id.nba_compare_back);
        nbacompareback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Data player1 = new Data(input1,"NBA");
        Data player2 = new Data(input2, "NBA");


        //set all the data for player 1
        nbaPlayer1name = findViewById(R.id.nba_player1_name);
        nbaPlayer1name.setText(input1);

        nbaPlayer1ppg = findViewById(R.id.nbaPlayer1ppg);
        nbaPlayer1ppg.setText(Double.toString(getMethods.getPPG(player1.apiGetData())));

        nbaPlayer1apg = findViewById(R.id.nbaPlayer1apg);
        nbaPlayer1apg.setText(Double.toString(getMethods.getAPG(player1.apiGetData())));

        nbaPlayer1rpg = findViewById(R.id.nbaPlayer1rpg);
        nbaPlayer1rpg.setText(Double.toString(getMethods.getRPG(player1.apiGetData())));

        nbaPlayer1fg3ptpct = findViewById(R.id.nbaPlayer1fg3ptpct);
        nbaPlayer1fg3ptpct.setText(Double.toString(getMethods.getFg3PtPct(player1.apiGetData())));

        nbaPlayer1tpg = findViewById(R.id.nbaPlayer1ftpg);
        nbaPlayer1tpg.setText(Double.toString(getMethods.getTovPerGame(player1.apiGetData())));


        //set the player 2 data
        nbaPlayer2name = findViewById(R.id.nba_player2_name)
        nbaPlayer2name.setText(input2);

        nbaPlayer2ppg = findViewById(R.id.nbaPlayer2ppg);
        nbaPlayer2ppg.setText(Double.toString(getMethods.getPPG(player2.apiGetData())));

        nbaPlayer2apg = findViewById(R.id.nbaPlayer2apg);
        nbaPlayer2apg.setText(Double.toString(getMethods.getAPG(player2.apiGetData())));

        nbaPlayer2rpg = findViewById(R.id.nbaPlayer2rpg);
        nbaPlayer2rpg.setText(Double.toString(getMethods.getRPG(player2.apiGetData())));

        nbaPlayer2fg3ptpct = findViewById(R.id.nbaPlayer2fg3ptpct);
        nbaPlayer2fg3ptpct.setText(Double.toString(getMethods.getFg3PtPct(player2.apiGetData())));

        nbaPlayer2tpg = findViewById(R.id.nbaPlayer2ftpg);
        nbaPlayer2tpg.setText(Double.toString(getMethods.getTovPerGame(player2.apiGetData())));

        //Sets text of the better player

        //sets color based on who wins the category
        if (getMethods.getPPG(player1.apiGetData()) > getMethods.getPPG(player2.apiGetData())) {
            nbaPlayer1ppg.setTextColor(Color.GREEN);
            nbaPlayer2ppg.setTextColor(Color.RED);
        } else {
            nbaPlayer1ppg.setTextColor(Color.RED);
            nbaPlayer2ppg.setTextColor(Color.GREEN);
        }
        if (getMethods.getAPG(player1.apiGetData()) > getMethods.getAPG(player2.apiGetData())) {
            nbaPlayer1ppg.setTextColor(Color.GREEN);
            nbaPlayer2ppg.setTextColor(Color.RED);
        } else {
            nbaPlayer1ppg.setTextColor(Color.RED);
            nbaPlayer2ppg.setTextColor(Color.GREEN);
        }
        if (getMethods.getRPG(player1.apiGetData()) > getMethods.getRPG(player2.apiGetData())) {
            nbaPlayer1ppg.setTextColor(Color.GREEN);
            nbaPlayer2ppg.setTextColor(Color.RED);
        } else {
            nbaPlayer1ppg.setTextColor(Color.RED);
            nbaPlayer2ppg.setTextColor(Color.GREEN);
        }
        if (getMethods.getTovPerGame(player1.apiGetData()) < getMethods.getTovPerGame(player2.apiGetData())) {
            nbaPlayer1ppg.setTextColor(Color.GREEN);
            nbaPlayer2ppg.setTextColor(Color.RED);
        } else {
            nbaPlayer1ppg.setTextColor(Color.RED);
            nbaPlayer2ppg.setTextColor(Color.GREEN);
        }
        if (getMethods.getFg3PtPct(player1.apiGetData()) > getMethods.getFg3PtPct(player2.apiGetData())) {
            nbaPlayer1ppg.setTextColor(Color.GREEN);
            nbaPlayer2ppg.setTextColor(Color.RED);
        } else {
            nbaPlayer1ppg.setTextColor(Color.RED);
            nbaPlayer2ppg.setTextColor(Color.GREEN);
        }
        if (getMethods.betterPlayer().equals(input1)) {
            nbaPlayer1name.setTextColor(Color.GREEN);
            nbaPlayer2name.setTextColor(Color.RED);
            betterplayertext.setTextColor(Color.GREEN);
        } else {
            nbaPlayer1name.setTextColor(Color.RED);
            nbaPlayer2name.setTextColor(Color.GREEN);
            betterplayertext.setTextColor(Color.GREEN);
        }

    }



}
