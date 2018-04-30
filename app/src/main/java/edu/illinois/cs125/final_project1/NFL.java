package edu.illinois.cs125.final_project1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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


        Button nflCompare = (Button) findViewById(R.id.compare_nfl);


        nflCompare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchNFLCompare();
            }
        });



    }

    public void launchNFLCompare() {

        Intent intent = new Intent(this, NFLcompare.class);
        startActivity(intent);
    }

}
