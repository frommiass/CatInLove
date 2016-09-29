package com.grino.catinlove;

import android.content.Context;

public class Player implements Nameable{

    private Context ctx;

    private String name;
    private Condition condition;
    private Resources resources;
    private int level;
    private int experience;

    public Player(Context ctx, String name) {
        this.ctx = ctx;
        this.name = name;
        this.condition = new Condition(ctx);
        this.level = 0;
        this.experience = 0;
    }

    @Override
    public String getName() {
        return name;
    }

    public void levelUp(){
        level++;
    }

    public void doTick(){

    }

}
