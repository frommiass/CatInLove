package com.grino.catinlove.models;

import android.content.Context;
import android.util.Log;

import com.grino.catinlove.MyApp;
import com.grino.catinlove.R;
import com.grino.catinlove.enums.KEY;
import com.grino.catinlove.rx.BusEvent;
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
        restart();
    }

    private void restart(){
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
        Log.d("Grino", "restart Player");
        send(new BusUpdatePlayer());
    }
    private void levelUp(){
        if (my.get(KEY.EXP) > getMaxExp()) {
            level.increase();
            my.putRes(KEY.EXP, 0);
            my.putInd(KEY.ENERGY, 1000);
            my.putInd(KEY.SATIETY, 1000);
            my.putInd(KEY.MOOD, 1000);
            deadlyCountdown = -1;
            say(R.string.msg_level_up);
            send(new BusUpdatePlayer());
        }
    }
    private void deadlyControl(){
        if (atDeathIsDoor()){
            if (deadlyCountdown == 0) {
                deadlyCountdown = -2;
                restart();
                say(R.string.msg_game_over);
            }else{
                if (deadlyCountdown == -1)  deadlyCountdown = 3;
                say(ctx.getString(R.string.msg_deadly_warning) + deadlyCountdown);
                deadlyCountdown--;
            }
        }else if (deadlyCountdown >= 0){
            deadlyCountdown = -1;
            say(R.string.msg_death_passed);
        }
    }
    private void send(BusEvent event){
        MyApp.getBus().send(event);
    }
    private void say(int msgID){
        MyApp.getBus().send(new BusMessage(ctx.getString(msgID)));
    }
    private void say(String msg){
        MyApp.getBus().send(new BusMessage(msg));
    }
    private boolean atDeathIsDoor(){
        return !my.arePositive(KEY.getRes());
    }
    public int getMaxExp(){
        return (50 + level.get()*10);
    }

    public void doTick(Action action){
        doAction(action);
        doAction(getNextDayAction());
        levelUp();
        deadlyControl();
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
