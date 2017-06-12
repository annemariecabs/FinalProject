package com.bishopireton.finalproject;

/*
AnneMarie Caballero
6/11/2017
This corresponds with the bet screen where the User bets before they play
 */

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class BetActivity extends Activity {

    public static int yourBet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bet);
    }

    @Override
    protected void onStart() {
        super.onStart();

        TextView myMoney = (TextView)findViewById(R.id.current_money);
        myMoney.setText("$" + OpeningActivity.preferences.getInt("money", 0));

    }

    public void onBet(View view) {
        EditText betText = (EditText) findViewById(R.id.enter_bet);
        TextView error = (TextView) findViewById(R.id.error_message);

        String bet = betText.getText().toString();
        if(bet.equals("")) {
            error.setText(R.string.error_nothingthere);
            error.setVisibility(View.VISIBLE);
            return;
        }

        Integer betVal;

        if(isInteger(bet)) {
            betVal = Integer.parseInt(bet);
        }
        else {
            betVal = null;
            error.setVisibility(View.VISIBLE);
            error.setText(R.string.error_notanumber);
        }
        if(betVal != null) {
            if (betVal == 0) {
                error.setVisibility(View.VISIBLE);
                error.setText(R.string.error_toolittle);
            } else if (betVal > OpeningActivity.yourMoney) {
                error.setVisibility(View.VISIBLE);
                error.setText(R.string.error_toomuch);
            } else {
                yourBet = betVal;
                startActivity(new Intent(this, MainActivity.class));
            }
        }
    }

    private static boolean isInteger(String input) {
        char[] inputParts = input.toCharArray();
        boolean isInt = true;

        for(char c: inputParts) {
            if (! Character.isDigit(c)) {
                isInt = false;
            }
        }

        return isInt;
    }

    public void onMoney(View view) {
        startActivity(new Intent(this, ClickActivity.class));
    }

    public void onHome(View view) {
        startActivity(new Intent(this, OpeningActivity.class));
    }

}
