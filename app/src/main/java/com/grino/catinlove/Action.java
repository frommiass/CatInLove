package com.grino.catinlove;

import android.content.Context;

public class Action implements Nameable{

    private Context ctx;
    private String name;

    private int experience;
    private Resources resources;
    private Condition condition;

    public Action(Context ctx, String name, int experience, Resources resources, Condition condition) {
        this.ctx = ctx;
        this.name = name;
        this.experience = experience;
        this.resources = resources;
        this.condition = condition;
    }

    public Action(Context ctx, String name){
        this.ctx = ctx;
        this.name = name;
        this.experience = 0;
        this.resources = new Resources(ctx);
        this.condition = new Condition(ctx);
    }

    @Override
    public String getName() {
        return name;
    }

}
