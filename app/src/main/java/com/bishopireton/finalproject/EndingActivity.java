package com.bishopireton.finalproject;

/*
AnneMarie Caballero
6/8/2017
This activity corresponds to the Ending screen of the game
 */

import android.content.Intent;
import android.graphics.Path;
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
        TextView moneyResult = (TextView) findViewById(R.id.money_result);

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

        int moneyWon = determineMoney();
        if(moneyWon > 0) {
            moneyResult.setText("+ $" + moneyWon);
            OpeningActivity.editor.putInt("money", OpeningActivity.yourMoney + moneyWon);
        }
        else if(MainActivity.winner == null){
            moneyResult.setText("------");
        }
        else {
            moneyResult.setText("- $" + BetActivity.yourBet);
            OpeningActivity.editor.putInt("money", OpeningActivity.yourMoney - BetActivity.yourBet);
        }

        OpeningActivity.editor.apply();

    }

    public void onHome(View view) {
        //reset all values somehow
        Intent goBack = new Intent(this, OpeningActivity.class);
        startActivity(goBack);
    }

    public int determineMoney() {
        int moneyAwarded = 0;

        if(MainActivity.winner == MainActivity.player) {
            //if blackjack money has a cents value then it gets rounded to an int
            if("blackjack".equals(MainActivity.playerOutcome))
                moneyAwarded = (int) (BetActivity.yourBet * 1.5 + .5);
            else
                moneyAwarded = BetActivity.yourBet;
        }

        return moneyAwarded;
    }
}
