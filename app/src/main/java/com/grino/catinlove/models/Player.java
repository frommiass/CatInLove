package com.grino.catinlove.models;

import com.grino.catinlove.enums.KEY;
import com.grino.catinlove.tools.Utils;

import lombok.Getter;
import lombok.Setter;

public class Player implements Nameable{

    @Getter @Setter
    private String name;

    @Getter
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
        if (my.get(KEY.EXP) > getMaxExp()) {
            level.increase();
            my.putRes(KEY.EXP, 0);
            my.putInd(KEY.ENERGY, 1000);
            my.putInd(KEY.SATIETY, 1000);
            my.putInd(KEY.MOOD, 1000);
        }
    }
    public int getMaxExp(){
        return (50 + level.get()*10);
    }

    public void doTick(Action action){
        doAction(action);
        doAction(getNextDayAction());
        levelUp();
    }

    private Action getNextDayAction(){
        Action action = new Action(KEY.class);
        action.put(KEY.EXP, 1);
        action.put(KEY.ENERGY, Utils.rand(-70));
        action.put(KEY.MOOD, Utils.rand(-70));
        action.put(KEY.SATIETY, Utils.rand(-70));
        return action;
    }

    public void doAction(Action action){
        my.combineByKey(action);
    }


    public int getContent(KEY key) {
        return my.get(key);
    }

    public boolean satisfies(int requirements){
        return true;//(level.get() >= requirements);
    }
}
