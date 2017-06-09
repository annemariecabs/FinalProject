package com.bishopireton.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public static User player; //public because I wanted to be able to access them from EndingActivity
    public static Computer house;
    private static Deck deck;
    private static Button stayButton;
    private static Button hitButton;
    private static int timesHit; //will be used for both users

    public static User winner;
    public static String playerOutcome;
    public static String houseOutcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        setValues();
        initialDeal();
    }

    public void setValues() {
        Card.cardBack = R.drawable.card_back; //setting the back of the card for all cards;

        //sets the arrays for each User
        //both have 9 ImageViews because that is the most cards before a player busts (for sure)
        //when playing with one deck
        ImageView[] pImgs = {(ImageView) findViewById(R.id.player1), (ImageView) findViewById(R.id.player2),
                (ImageView) findViewById(R.id.player3), (ImageView) findViewById(R.id.player4),
                (ImageView) findViewById(R.id.player5), (ImageView) findViewById(R.id.player6),
                (ImageView) findViewById(R.id.player7), (ImageView) findViewById(R.id.player8),
                (ImageView) findViewById(R.id.player9)};

        ImageView[] cImgs = {(ImageView) findViewById(R.id.comp1), (ImageView) findViewById(R.id.comp2),
                (ImageView) findViewById(R.id.comp3), (ImageView) findViewById(R.id.comp4),
                (ImageView) findViewById(R.id.comp5), (ImageView) findViewById(R.id.comp6),
                (ImageView) findViewById(R.id.comp7), (ImageView) findViewById(R.id.comp8),
                (ImageView) findViewById(R.id.comp9)};

        //initializing all necessary objects and values
        player = new User(pImgs);
        house = new Computer(cImgs);
        deck = new Deck();
        stayButton = (Button) findViewById(R.id.stay_button);
        hitButton = (Button) findViewById(R.id.hit_button);
        timesHit = 0;
        playerOutcome = null;
        houseOutcome = null;

        //makes buttons disappear
        stayButton.setVisibility(View.GONE);
        hitButton.setVisibility(View.GONE);

        //shuffles deck
        deck.shuffle();
    }

    public void initialDeal() {

        player.addCard(deck.deal());
        setCard(player.nextView(), player.cards().get(0));

        house.addCard(deck.deal());
        setImage(house.nextView(), Card.cardBack);

        player.addCard(deck.deal());
        setCard(player.nextView(), player.cards().get(1));

        house.addCard(deck.deal());
        setCard(house.nextView(), house.cards().get(1));

        //make both buttons appear
        stayButton.setVisibility(View.VISIBLE);
        hitButton.setVisibility(View.VISIBLE);
    }

    public void setImage(ImageView view, int id) {
        view.setImageResource(id);
    }

    public void setCard(ImageView view, Card c) {
        int id = CardImages.getImage(c);
        setImage(view, id);
    }

    public void hitOnClick(View view) {
        player.addCard(deck.deal());
        setCard(player.nextView(), player.cards().get(timesHit + 2));//+ 2 because there are already two cards

        if(player.checkBust())
            busted();
        else
            timesHit++;
    }

    public void stayOnClick(View view){
        playerOutcome = "stayed";

        stayButton.setVisibility(View.GONE);
        hitButton.setVisibility(View.GONE);

        timesHit = 0;
        while(house.hit()) {
            house.addCard(deck.deal());
            if (house.checkBust())
                    break;
            setCard(house.nextView(), house.cards().get(timesHit + 2));
            timesHit++;
        }

        if (house.checkBust()) {
            houseOutcome = "busted";
            winner = player;
        }

        else {
            houseOutcome = "stayed";
            if(house.sumCards() == player.sumCards())
                winner = null;
            else if (house.sumCards() > player.sumCards())
                winner = house;
            else
                winner = player;
        }

        movingOn();
    }

    public void busted() {
        playerOutcome = "busted";
        winner = house;

        movingOn();
    }

    public void blackjack() {
        int playerTotal = player.sumCards();
        int houseTotal = house.sumCards();

        if(playerTotal == 21 && houseTotal == 21) {
            winner = null;
            houseOutcome = "blackjack";
            playerOutcome = "blackjack";
        }
        else if(houseTotal == 21) {
            winner = house;
            houseOutcome = "blackjack";
        }
        else {
            winner = player;
            playerOutcome = "blackjack";
        }

        movingOn();
    }

    public void movingOn() {
        Intent timeToGo = new Intent(this, EndingActivity.class);
        startActivity(timeToGo);
    }
}
