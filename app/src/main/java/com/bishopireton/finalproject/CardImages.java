package com.bishopireton.finalproject;

/**
 * Created by AnneMarie on 6/8/2017.
 */

public class CardImages {
    private static final int[][] IDS = {
            {R.drawable.clubs1, R.drawable.clubs2, R.drawable.clubs3, R.drawable.clubs4,
                    R.drawable.clubs5, R.drawable.clubs6, R.drawable.clubs7, R.drawable.clubs8,
                    R.drawable.clubs9, R.drawable.clubs10, R.drawable.clubs11, R.drawable.clubs12,
                    R.drawable.clubs13},
            {R.drawable.diamonds1, R.drawable.diamonds2, R.drawable.diamonds3, R.drawable.diamonds4,
                    R.drawable.diamonds5, R.drawable.diamonds6, R.drawable.diamonds7, R.drawable.diamonds8,
                    R.drawable.diamonds9, R.drawable.diamonds10, R.drawable.diamonds11, R.drawable.diamonds12,
                    R.drawable.diamonds13},
            {R.drawable.hearts1, R.drawable.hearts2, R.drawable.hearts3, R.drawable.hearts4,
                    R.drawable.hearts5, R.drawable.hearts6, R.drawable.hearts7, R.drawable.hearts8,
                    R.drawable.hearts9, R.drawable.hearts10, R.drawable.hearts11, R.drawable.hearts12,
                    R.drawable.hearts13},
            {R.drawable.spades1, R.drawable.spades2, R.drawable.spades3, R.drawable.spades4,
                    R.drawable.spades5, R.drawable.spades6, R.drawable.spades7, R.drawable.spades8,
                    R.drawable.spades9, R.drawable.spades10, R.drawable.spades11, R.drawable.spades12,
                    R.drawable.spades13}
    };

    public static int getImage(Card card) {
        return IDS[card.getSuit()][card.getRank()];
    }
}
