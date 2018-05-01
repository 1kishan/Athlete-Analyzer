package edu.illinois.cs125.final_project1;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

public class NBAcompare extends AppCompatActivity {

    public TextView nbaPlayer1ppg;
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

        nbaPlayer1ppg = findViewById(R.id.nbaPlayer1ppg);


        nbaPlayer1ppg.setText(Double.toString(getMethods.getPPG(player1.apiGetData())));

    }


}
