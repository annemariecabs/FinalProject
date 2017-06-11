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
    }

    @Override
    protected void onStart() {
        super.onStart();
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

        if("stayed".equals(MainActivity.playerOutcome))
            playerResult.setText(R.string.stayed);
        else if("busted".equals(MainActivity.playerOutcome))
            playerResult.setText(R.string.busted);
        else if("blackjack".equals(MainActivity.playerOutcome))
            playerResult.setText("BLACK\nJACK");
        else
            playerResult.setVisibility(View.GONE);

        if("stayed".equals(MainActivity.houseOutcome))
            houseResult.setText(R.string.stayed);
        else if("busted".equals(MainActivity.houseOutcome))
            houseResult.setText(R.string.busted);
        else if("blackjack".equals(MainActivity.houseOutcome))
            houseResult.setText("BLACK\nJACK");
        else
            houseResult.setVisibility(View.GONE);
    }

    public void onHome(View view) {
        //reset all values somehow
        Intent goBack = new Intent(this, OpeningActivity.class);
        startActivity(goBack);
    }
}
