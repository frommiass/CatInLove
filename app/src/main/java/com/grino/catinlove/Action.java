package com.grino.catinlove;

import android.content.Context;

public class Action implements Nameable{

    private Context ctx;
    private String name;

    private int experience;
    public Resources resources;
    public Indicators indicators;

    public Action(Context ctx, String name, int experience, Resources resources, Indicators indicators) {
        this.ctx = ctx;
        this.name = name;
        this.experience = experience;
        this.resources = resources;
        this.indicators = indicators;
    }

    public Action(Context ctx, String name){
        this.ctx = ctx;
        this.name = name;
        this.experience = 0;
        this.resources = new Resources(ctx);
        this.indicators = new Indicators(ctx);
    }

    @Override
    public String getName() {
        return name;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setResources(Resources resources) {
        this.resources = resources;
    }

    public void setIndicators(Indicators indicators) {
        this.indicators = indicators;
    }
}
