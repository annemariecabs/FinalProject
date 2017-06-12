package com.bishopireton.finalproject;

import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by AnneMarie on 6/8/2017.
 * This program creates the User class which is used to represent the users in the game (both player and house)\
 * However, the house is actually a subclass of User, Computer.
 */

public class User {
    private ArrayList<Card> cards;
    private ImageView[] images;
    private int current;// keeps track of current ImageView and Card

    User(ImageView[] i) {
        cards = new ArrayList<Card>();
        images = i;
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
            sum += card.getValue();

        int cur = 0;

        while(sum > 21 && cur < cards.size()) {
            if (cards.get(cur).getRank() == 1)
                cards.get(cur).setAce(true);
            cur++;
            sum = 0;
            for (Card card : cards)
                sum += card.getValue();
        }

        return sum;
    }

    public ImageView nextView() {
        current++;
        return images[current - 1];
    }

    //if this returns true, user busted
    public boolean checkBust() {
        return sumCards() > 21;
    }

    public void disappearViews() {
        for(ImageView i: images)
            i.setVisibility(View.GONE);
    }
}

