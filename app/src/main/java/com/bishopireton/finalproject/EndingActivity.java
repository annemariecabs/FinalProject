package com.bishopireton.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EndingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ending);

        setValues();
    }

    public void setValues() {
        TextView winSign = (TextView) findViewById(R.id.winner_sign);
        TextView playerPts = (TextView) findViewById(R.id.your_points);
        TextView housePts = (TextView) findViewById(R.id.house_points);
        TextView playerResult = (TextView) findViewById(R.id.your_outcome);
        TextView houseResult = (TextView) findViewById(R.id.house_outcome);

        if(MainActivity.winner == null)
            winSign.setText(R.string.tie_game);
        else if(MainActivity.winner == MainActivity.player)
            winSign.setText(R.string.you_won);
        else
            winSign.setText(R.string.you_lost);

        playerPts.setText("" + MainActivity.player.sumCards());
        housePts.setText("" + MainActivity.house.sumCards());

        if(MainActivity.playerOutcome.equals("stayed"))
            playerResult.setText(R.string.stayed);
        else if(MainActivity.playerOutcome.equals("busted"))
            playerResult.setText(R.string.busted);
        else if(MainActivity.playerOutcome.equals("blackjack"))
            playerResult.setText(R.string.blackjack);

        if(MainActivity.houseOutcome.equals("stayed"))
            houseResult.setText(R.string.stayed);
        else if(MainActivity.houseOutcome.equals("busted"))
            houseResult.setText(R.string.busted);
        else if(MainActivity.houseOutcome.equals("blackjack"))
            houseResult.setText(R.string.blackjack);
    }

    public void onHome(View view) {
        //reset all values somehow
        Intent goBack = new Intent(this, OpeningActivity.class);
        startActivity(goBack);
    }
}
