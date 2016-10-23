package com.grino.catinlove.models;

import android.content.Context;

import com.grino.catinlove.MyApp;
import com.grino.catinlove.R;
import com.grino.catinlove.enums.KEY;
import com.grino.catinlove.rx.BusGameOver;
import com.grino.catinlove.rx.BusMessage;
import com.grino.catinlove.rx.BusUpdatePlayer;
import com.grino.catinlove.rx.RxBus;
import com.grino.catinlove.tools.Utils;

import lombok.Getter;
import lombok.Setter;

public class Player implements Nameable{

    Context ctx;

    @Getter @Setter
    private String name;

    @Getter
    private Container level, day;
    private ContainerMap my;

    private int deadlyCountdown;

    public Player() {
        this.name = "";
        this.ctx = MyApp.getContextForResources();
        level = new Container(1, 20000000, 1);
        day = new Container(1, 20000000, 1);
        my = new ContainerMap(KEY.class)
            .putRes(KEY.EXP, 0)
            .putInd(KEY.ENERGY, 1000)
            .putInd(KEY.SATIETY, 1000)
            .putInd(KEY.MOOD, 1000)
            .putRes(KEY.FOOD, 50)
            .putRes(KEY.REAL, 10);
        deadlyCountdown = -1;
    }

    private void levelUp(){
        if (my.get(KEY.EXP) > getMaxExp()) {
            level.increase();
            my.putRes(KEY.EXP, 0);
            my.putInd(KEY.ENERGY, 1000);
            my.putInd(KEY.SATIETY, 1000);
            my.putInd(KEY.MOOD, 1000);
            MyApp.getBus().sendObservers(new BusUpdatePlayer());
        }
    }
    private void deadlyConrol(){
        String msg = "";
        RxBus bus = MyApp.getBus();
        if (deadlyCountdown > 0) {
            if (atDeathIsDoor()) {
                deadlyCountdown --;
                msg = ctx.getString(R.string.msg_deadly_warning) + deadlyCountdown;
            } else {
                deadlyCountdown = -1;
                msg = ctx.getString(R.string.msg_death_passed) + deadlyCountdown;
            }
            bus.send(new BusMessage(msg));
        } else {
            deadlyCountdown = -2;
            bus.send(new BusGameOver());
        }
    }
    private boolean atDeathIsDoor(){
        return my.arePositive(KEY.getRes());
    }
    public int getMaxExp(){
        return (50 + level.get()*10);
    }

    public void doTick(Action action){
        doAction(action);
        doAction(getNextDayAction());
        levelUp();
        deadlyConrol();
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
        return (level.get() >= requirements);
    }
}
