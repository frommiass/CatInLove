package com.grino.catinlove;

import android.content.Context;

public class Player implements Nameable{

    private Context ctx;

    private String name;
    private int level;
    private Action condition;
    private int day;

    public Player(Context ctx, String name) {
        this.ctx = ctx;
        this.name = name;
        level = 0;
        day = 1;
        condition = new Action(ctx, "Текущие состояние");
        condition.indicators.fillMax();
        condition.resources.setFood(100); //начальное состояние еды
    }

    @Override
    public String getName() {
        return name;
    }

    private void levelUp(){
        level++;
    }

    public void doTick(Action action){
        doAction(action);
        doAction(getNextDayAction());
    }

    private Action getNextDayAction(){
        Action action = new Action(ctx, "day " + day);
        action.setExperience(1);
        action.indicators.setEnergy((int)(Math.random() * (-5)));
        action.indicators.setSatiety((int)(Math.random() * (-5)));
        action.indicators.setMood((int)(Math.random() * (-5)));
        return action;
    }

    public void doAction(Action action){
        condition.add(action);
    }

}
