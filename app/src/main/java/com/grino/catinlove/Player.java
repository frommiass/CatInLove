package com.grino.catinlove;

import android.content.Context;

public class Player implements Nameable{

    private Context ctx;

    private String name;
    private Indicators indicators;
    private Resources resources;
    private int level;
    private int experience;
    private int day;

    public Player(Context ctx, String name) {
        this.ctx = ctx;
        this.name = name;
        this.indicators = new Indicators(ctx);
        this.level = 0;
        this.experience = 0;
        this.day = 1;
    }

    @Override
    public String getName() {
        return name;
    }

    public void levelUp(){
        level++;
    }

    public void doTick(Action action){
        doAction(action);
        doAction(getNextDayAction());

        // выполнить ежедневное экшн
    }


    public Action getNextDayAction(){
        Action action = new Action(ctx, "day " + day);
        action.setExperience(1);
        action.indicators.setEnergy((int)(Math.random() * (-5)));
        action.indicators.setSatiety((int)(Math.random() * (-5)));
        action.indicators.setMood((int)(Math.random() * (-5)));
        return action;
    }

}
