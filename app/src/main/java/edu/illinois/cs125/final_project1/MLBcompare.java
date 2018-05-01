package edu.illinois.cs125.final_project1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MLBcompare extends AppCompatActivity {
    MLB getMethods = new MLB();
    public TextView homeRuns1;
    public TextView rbi1;
    public TextView battingAvg1;
    public TextView strikeouts1;
    public TextView errors1;
    public TextView homeruns2;
    public TextView rbi2;
    public TextView battingAvg2;
    public TextView strikeouts2;
    public TextView errors2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mlbcompare);


        Button mlbcompareback = (Button) findViewById(R.id.mlb_compare_back);
        Intent intent = getIntent();
        String input1 = intent.getStringExtra("p1");
        String input2 = intent.getStringExtra("p2");
        Data player1 = new Data(input1,"MLB");
        Data player2 = new Data(input2, "MLB");

        //player 1 data
        homeRuns1.setText(Integer.toString(getMethods.getHR(player1.apiGetData())));

        rbi1.setText(Integer.toString(getMethods.getRBI(player1.apiGetData())));

        battingAvg1.setText(Double.toString(getMethods.getBattingAvg(player1.apiGetData())));

        strikeouts1.setText(Integer.toString(getMethods.getStrikeouts(player1.apiGetData())));

        errors1.setText(Integer.toString(getMethods.getErrors(player1.apiGetData())));


        //player 2 data
        homeruns2.setText(Integer.toString(getMethods.getHR(player2.apiGetData())));

        rbi2.setText(Integer.toString(getMethods.getRBI(player2.apiGetData())));

        battingAvg2.setText(Double.toString(getMethods.getBattingAvg(player2.apiGetData())));

        strikeouts2.setText(Integer.toString(getMethods.getStrikeouts(player2.apiGetData())));

        errors2.setText(Integer.toString(getMethods.getErrors(player2.apiGetData())));


        //Sets Color

        if (getMethods.getHR(player1.apiGetData()) > getMethods.getHR(player2.apiGetData())) {
            homeRuns1.setTextColor(Color.GREEN);
            homeruns2.setTextColor(Color.RED);
        } else {
            homeruns2.setTextColor(Color.GREEN);
            homeRuns1.setTextColor(Color.RED);
        }
        if (getMethods.getRBI(player1.apiGetData()) > getMethods.getRBI(player2.apiGetData())) {
            rbi1.setTextColor(Color.GREEN);
            rbi2.setTextColor(Color.RED);
        } else {
            rbi2.setTextColor(Color.GREEN);
            rbi1.setTextColor(Color.RED);
        }
        if (getMethods.getErrors(player1.apiGetData()) < getMethods.getErrors(player2.apiGetData())) {
            errors1.setTextColor(Color.GREEN);
            errors2.setTextColor(Color.RED);
        } else {
            errors2.setTextColor(Color.GREEN);
            errors1.setTextColor(Color.RED);
        }
        if (getMethods.getBattingAvg(player1.apiGetData()) > getMethods.getBattingAvg(player2.apiGetData())) {
            battingAvg1.setTextColor(Color.GREEN);
            battingAvg2.setTextColor(Color.RED);
        } else {
            battingAvg2.setTextColor(Color.GREEN);
            battingAvg1.setTextColor(Color.RED);
        }
        if (getMethods.getStrikeouts(player1.apiGetData()) < getMethods.getStrikeouts(player2.apiGetData())) {
            strikeouts1.setTextColor(Color.GREEN);
            strikeouts2.setTextColor(Color.RED);
        } else {
            strikeouts2.setTextColor(Color.GREEN);
            strikeouts1.setTextColor(Color.RED);
        }
        mlbcompareback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }



}
