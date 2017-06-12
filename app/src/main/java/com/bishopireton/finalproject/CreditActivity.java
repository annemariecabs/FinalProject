package com.bishopireton.finalproject;

/*
AnneMarie Caballero
6/9/2017
This screen corresponds to the Credit screen where I give people and myself credit
Coding credit is commented in the code though
 */

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CreditActivity extends AppCompatActivity {

    private static TextView[] credits;
    private static Button homeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);

    }

    public void onHome(View view) {
        Intent goBack = new Intent(this, OpeningActivity.class);
        startActivity(goBack);
    }

}
