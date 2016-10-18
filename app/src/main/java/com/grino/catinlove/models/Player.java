package com.grino.catinlove.models;

import com.grino.catinlove.enums.KEY;
import com.grino.catinlove.tools.Utils;

import lombok.Getter;
import lombok.Setter;

public class Player implements Nameable{

    @Getter @Setter
    private String name;

    private Container level, day;
    private ContainerMap my;

    public Player() {
        this.name = "";
        level = new Container(1, 20000000, 1);
        day = new Container(1, 20000000, 1);
        my = new ContainerMap(KEY.class)
            .putRes(KEY.EXP, 0)
            .putInd(KEY.ENERGY, 1000)
            .putInd(KEY.SATIETY, 1000)
            .putInd(KEY.MOOD, 1000)
            .putRes(KEY.FOOD, 50)
            .putRes(KEY.REAL, 10);
    }

    private void levelUp(){
        level.increase();
    }

    public void doTick(Action action){
        doAction(action);
        doAction(getNextDayAction());
    }

    private Action getNextDayAction(){
        Action action = new Action(KEY.class);
        action.put(KEY.EXP, 1);
        action.put(KEY.ENERGY, Utils.rand(-10));
        action.put(KEY.MOOD, Utils.rand(-10));
        action.put(KEY.SATIETY, Utils.rand(-10));
        return action;
    }

    public void doAction(Action action){
        my.combineByKey(action);
    }


    public int getContent(KEY key) {
        return my.get(key);
    }
}
