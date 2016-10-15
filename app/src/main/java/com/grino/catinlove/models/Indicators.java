package com.grino.catinlove.models;

import android.content.Context;

import com.grino.catinlove.R;
import com.grino.catinlove.enums.KEY;

public class Indicators
        extends Values{

    protected final static int MIN = 0;
    protected final static int MAX = 100;

    public Indicators(Context ctx, boolean physical) {
        super();
        int min = MIN;
        if (!physical) min = (-1)*MAX;
        put(KEY.ENERGY, new Value(ctx.getString(R.string.indicator_energy), min, MAX, 0));
        put(KEY.MOOD, new Value(ctx.getString(R.string.indicator_mood), min, MAX, 0));
        put(KEY.SATIETY, new Value(ctx.getString(R.string.indicator_satiety), min, MAX, 0));
    }

}
