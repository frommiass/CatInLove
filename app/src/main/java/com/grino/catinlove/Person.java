package com.grino.catinlove;

import android.content.Context;

public class Person implements Nameable{

    private Context ctx;

    private String name;
    private Condition condition;
    private int level;
    private int experience;

    public Person(Context ctx, String name) {
        this.ctx = ctx;
        this.name = name;
        condition = new Condition(ctx);
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
