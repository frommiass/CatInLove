package com.grino.catinlove;

import android.content.Context;

public class Condition {

    Context ctx;

    private Indicator satiety;
    private Indicator mood;
    private Indicator energy;

    public Condition(Context ctx) {

        this.ctx = ctx;

        satiety = new Indicator(ctx.getString(R.string.indicator_satiety), 100);
        mood = new Indicator(ctx.getString(R.string.indicator_mood), 100);
        energy = new Indicator(ctx.getString(R.string.indicator_energy), 100);
    }
}
