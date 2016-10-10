package com.grino.catinlove;

import android.content.Context;

public class Indicators
        extends Values{

    private final int KEY_SATIETY = 1000 + 1;
    private final int KEY_MOOD = 1000 + 2;
    private final int KEY_ENERGY = 1000 + 3;

    public Indicators(Context ctx) {
        super(ctx);
        put(KEY_ENERGY, new Indicator(ctx.getString(R.string.indicator_energy)));
        put(KEY_MOOD, new Indicator(ctx.getString(R.string.indicator_mood)));
        put(KEY_SATIETY, new Indicator(ctx.getString(R.string.indicator_satiety)));
    }

}
