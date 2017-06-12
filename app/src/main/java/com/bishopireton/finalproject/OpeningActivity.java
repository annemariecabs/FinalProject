package com.bishopireton.finalproject;

/*
AnneMarie Caballero
6/8/2017
This is the launcher screen and the center of everything.
It has buttons to play, to access the money screen, and to access the credit screen.
It's kinda like Rome, all roads (or to be cs-y) paths lead here
 */

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class OpeningActivity extends AppCompatActivity {

    public static SharedPreferences preferences;
    public static SharedPreferences.Editor editor;
    public static int yourMoney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening);

        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = preferences.edit();
        if(! preferences.contains("money")) {
            editor.putInt("money", 2000); //you start with 2000 dollar
            editor.apply();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        yourMoney = preferences.getInt("money", 3000);
    }

    public void play(View v) {
        Intent moveOn = new Intent(this, BetActivity.class);
        startActivity(moveOn);
    }

    public void onCredit(View v) {
        //I named the Intent this because I felt like it and because it's true
        Intent everyShouldBeRecognized = new Intent(this, CreditActivity.class);
        startActivity(everyShouldBeRecognized);
    }

    public void onMoney(View v) {
        Intent moneyTime = new Intent(this, MoneyActivity.class);
        startActivity(moneyTime);
    }
}
