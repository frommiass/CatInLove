package com.grino.catinlove.models;

import android.content.Context;

import com.grino.catinlove.enums.KEY;
import com.grino.catinlove.tools.Utils;

public class Player implements Nameable{

    private String name;
    private int level;
    private Action condition;
    private int day;

    public Player() {
        this.name = "";
        level = 0;
        day = 1;
        condition = new Action("Текущие состояние", true);
        condition.indicators.fillMax();
        condition.set(KEY.FOOD, 100);  //начальное состояние еды
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
        Action action = new Action("day " + day, false);
        action.set(KEY.EXP, 1);
        action.set(KEY.ENERGY, Utils.rand(-10));
        action.set(KEY.MOOD, Utils.rand(-10));
        action.set(KEY.SATIETY, Utils.rand(-10));
        return action;
    }

    public void doAction(Action action){
        condition.add(action);
    }

    public Action getCondition() {
        return condition;
    }
}
