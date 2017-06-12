package com.bishopireton.finalproject;

import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by AnneMarie on 6/9/2017.
 * This class creates Computer a subclass of User, which can choose whether to hit or stay based off of
 * house Blackjack logic
 */

public class Computer extends User {
    Computer(ImageView[] i) {
        super(i);
    }

    //if it returns true, it hits, if it returns false, it stays
    public boolean hit() {
        int value = sumCards();

        if(value <= 16)
            return true;
        else
            return false;
    }
}
