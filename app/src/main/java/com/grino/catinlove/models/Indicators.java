package com.grino.catinlove.models;

import android.content.Context;

import com.grino.catinlove.R;

public class Indicators
        extends Values{

    public final static int KEY_SATIETY = 1000 + 1;
    public final static int KEY_MOOD = 1000 + 2;
    public final static int KEY_ENERGY = 1000 + 3;

    protected final static int MIN = 0;
    protected final static int MAX = 100;

    public Indicators(Context ctx, boolean physical) {
        super();
        int min = MIN;
        if (!physical) min = (-1)*MAX;
        put(KEY_ENERGY, new Value(ctx.getString(R.string.indicator_energy), min, MAX, 0));
        put(KEY_MOOD, new Value(ctx.getString(R.string.indicator_mood), min, MAX, 0));
        put(KEY_SATIETY, new Value(ctx.getString(R.string.indicator_satiety), min, MAX, 0));
    }

    @Override
    public String toString() {
        return "IND:" + super.toString();
    }

    public static boolean isIndicatorsKey(int key){
        return (key==KEY_ENERGY)||(key==KEY_MOOD)||(key==KEY_SATIETY);
    }
}
