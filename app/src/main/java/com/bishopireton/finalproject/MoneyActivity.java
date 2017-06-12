package com.bishopireton.finalproject;

/*
AnneMarie Caballero
6/11/2017
This screen is the center of the money aspects, showing you your current money and
having a button leading  you to the ClickActivity screen (which is how you get more money)
 */
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MoneyActivity extends AppCompatActivity {

    private TextView money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money);

        money = (TextView) findViewById(R.id.your_money);
    }

    @Override
    protected void onStart() {
        super.onStart();
        money.setText("$" + OpeningActivity.yourMoney);
        money.setVisibility(View.VISIBLE);
    }

    public void onGetMoney(View view) {
        Intent goToClick = new Intent(this, ClickActivity.class);
        startActivity(goToClick);
    }

    public void onBack(View view) {
        Intent goBack = new Intent(this, OpeningActivity.class);
        startActivity(goBack);
    }
}
