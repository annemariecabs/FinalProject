package com.bishopireton.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private User player;
    private User house;
    private Deck deck;
    private Button stayButton;
    private Button hitButton;
    private int timesHit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        house = new User(cImgs);
        deck = new Deck();
        stayButton = (Button) findViewById(R.id.stay_button);
        hitButton = (Button) findViewById(R.id.hit_button);
        timesHit = 0;

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
        //checkBust
        timesHit++;
    }
}
