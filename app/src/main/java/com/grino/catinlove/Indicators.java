package com.grino.catinlove;

import android.content.Context;

public class Indicators {

    private Context ctx;

    private Indicator satiety;
    private Indicator mood;
    private Indicator energy;

    public Indicators(Context ctx) {
        this.ctx = ctx;
        satiety = new Indicator(ctx.getString(R.string.indicator_satiety));
        mood = new Indicator(ctx.getString(R.string.indicator_mood));
        energy = new Indicator(ctx.getString(R.string.indicator_energy));

        fillMax();
    }

    public Indicators(Context ctx, int satiety, int mood, int energy) {
        this.ctx = ctx;
        this.satiety = new Indicator(ctx.getString(R.string.indicator_satiety), satiety);
        this.mood = new Indicator(ctx.getString(R.string.indicator_mood), mood);
        this.energy = new Indicator(ctx.getString(R.string.indicator_energy), energy);
    }

    public void doTick(){
        satiety.decrease(1);
        mood.decrease(1);
        energy.decrease(1);
    }

    public void fillMax(){
        satiety.setMax();
        mood.setMax();
        energy.setMax();
    }

    public void setSatiety(int satiety) {
        this.satiety.set(satiety);
    }

    public void setMood(int mood) {
        this.mood.set(mood);
    }

    public void setEnergy(int energy) {
        this.energy.set(energy);
    }
}
