package com.grino.catinlove.models;

import android.content.Context;

import com.grino.catinlove.tools.Utils;

public class Player implements Nameable{

    private Context ctx;

    private String name;
    private int level;
    private Action condition;
    private int day;

    public Player(Context ctx) {
        this.ctx = ctx;
        this.name = "";
        level = 0;
        day = 1;
        condition = new Action(ctx, "Текущие состояние", true);
        condition.indicators.fillMax();
        condition.set(Resources.KEY_FOOD, 100);  //начальное состояние еды
    }

    @Override
    public String getName() {
        return name;
    }
    public void setName(String name) {
         this.name = name;
    }

    private void levelUp(){
        level++;
    }

    public void doTick(Action action){
        doAction(action);
        doAction(getNextDayAction());
    }

    private Action getNextDayAction(){
        Action action = new Action(ctx, "day " + day, false);
        action.setExperience(1);
        action.set(Indicators.KEY_ENERGY, Utils.rand(-10));
        action.set(Indicators.KEY_MOOD, Utils.rand(-10));
        action.set(Indicators.KEY_SATIETY, Utils.rand(-10));
        return action;
    }

    public void doAction(Action action){
        condition.add(action);
    }

    public Action getCondition() {
        return condition;
    }
}
