package com.bishopireton.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class OpeningActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening);
    }

    public void play(View v) {
        Intent moveOn = new Intent(this, MainActivity.class);
        startActivity(moveOn);
    }

    public void onCredit(View v) {
        //I named the Intent this because I felt like it and because it's true
        Intent everyShouldBeRecognized = new Intent(this, CreditActivity.class);
        startActivity(everyShouldBeRecognized);
    }
}
