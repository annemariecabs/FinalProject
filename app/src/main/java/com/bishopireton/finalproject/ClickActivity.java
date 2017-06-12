package com.bishopireton.finalproject;
/*
AnneMarie Caballero
6/11/2017
This corresponds with the click screen where the User clicks for money
 */

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ClickActivity extends AppCompatActivity {

    private TextView moneyEarned;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click);

        moneyEarned = (TextView) findViewById(R.id.earnings);

    }

    public void onClickMe(View view) {
        int currentMoney = OpeningActivity.preferences.getInt("money", 3000);
        int random = ((int) (Math.random() * 5) + 1) * 100;
        moneyEarned.setText("Money Earned: " + random);

        OpeningActivity.editor.putInt("money", currentMoney + random);
        OpeningActivity.editor.apply();
    }

    public void onHome(View view) {
        startActivity(new Intent(this, OpeningActivity.class));
    }
}
