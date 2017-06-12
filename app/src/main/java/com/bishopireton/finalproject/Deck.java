package com.bishopireton.finalproject;

/**
 * Created by AnneMarie on 6/8/2017.
 * This creates the Deck class, which creates a standard 52 card deck and fills it
 * It adds a method to shuffle it for you as well
 */

public class Deck {
    private Card[] cards;
    private int current; //the current card that has been dealt

    Deck() {
        cards = new Card[52];
        fill();
    }

    public void fill() {
        int pos = 0;

        for (int s = 1; s <= 4; s++)
            for (int r = 1; r < 14; r++) {
                cards[pos] = new Card(s, r);
                pos++;
            }
    }

    public void shuffle () {
        for(int j = cards.length - 1; j >= 0; j--) {
            int random = (int) (Math.random() * j);

            cards = swap(cards, j, random);
        }

        current = 0; //resets the current field
    }

    //private because it is only used in shuffle
    private Card[] swap(Card[] cs, int f, int l) {
        Card temp = cs[l];
        cs[l] = cs[f];
        cs[f] = temp;

        return cs;
    }

    public Card deal() {
        current++;
        return cards[current - 1];
    }
}
