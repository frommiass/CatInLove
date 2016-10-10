package com.grino.catinlove;

import android.content.Context;

public class Indicators
        extends Values{

    public final static int KEY_SATIETY = 1000 + 1;
    public final static int KEY_MOOD = 1000 + 2;
    public final static int KEY_ENERGY = 1000 + 3;

    public Indicators(Context ctx) {
        super(ctx);
        put(KEY_ENERGY, new Indicator(ctx.getString(R.string.indicator_energy)));
        put(KEY_MOOD, new Indicator(ctx.getString(R.string.indicator_mood)));
        put(KEY_SATIETY, new Indicator(ctx.getString(R.string.indicator_satiety)));
    }

    @Override
    public String toString() {
        return "Indicators: " + super.toString();
    }

    public static boolean isIndicatorsKey(int key){
        return (key==KEY_ENERGY)||(key==KEY_MOOD)||(key==KEY_SATIETY);
    }
}
