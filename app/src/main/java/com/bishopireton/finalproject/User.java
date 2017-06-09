package com.bishopireton.finalproject;

import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by AnneMarie on 6/8/2017.
 */

public class User {
    private ArrayList<Card> cards;
    private ImageView[] images;
    private int current;// keeps track of current ImageView and Card
    private boolean status; //still active (true) or has stayed (false)

    User(ImageView[] i) {
        cards = new ArrayList<Card>();
        images = i;
        status = true; //because the user is automatically playing
        current = 0;
    }

    public void addCard(Card c) {
        cards.add(c);

    }

    public int size() {
        return cards.size();
    }

    public ArrayList<Card> cards() {
        return cards;
    }

    public int sumCards() {
        int sum = 0;
        for (Card card : cards)
            sum += card.getRank();

        return sum;
    }

    public boolean status() {
        return status;
    }
    public void setStatus(boolean b) {status = b;}

    public ImageView nextView() {
        current++;
        return images[current - 1];
    }
}

