package com.bishopireton.finalproject;

/**
 * Created by AnneMarie on 6/8/2017.
 * This creates the Card class
 */

public class Card {
    private int suit; //club = 1; diamond = 2; heart = 3; spade = 4
    private int rank; // rank of ace is 1
    private boolean ace; //if ace is true, ace acts as one, if not, ace is eleven

    public static int cardBack; //hold the id for the image that will act as all of the card's backs

    Card(int s, int r) {
        suit = s;
        rank = r;
    }

    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    //returns the value of a card in Blackjack
    public int getValue() {
        if(rank == 1) {
            if (getAce())
                return 1;
            else
                return 11;
        }
        else if (rank > 10)
            return 10;
        else
            return rank;    }

    public boolean getAce() {
        return ace;
    }

    public void setAce(boolean one) {
        ace = one;
    }
}
