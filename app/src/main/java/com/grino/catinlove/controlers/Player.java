package com.grino.catinlove.controlers;

import android.content.Context;

import com.grino.catinlove.R;
import com.grino.catinlove.enums.KEY;
import com.grino.catinlove.models.Action.Action;
import com.grino.catinlove.models.Action.Income;
import com.grino.catinlove.models.Action.Incoming;
import com.grino.catinlove.models.Player.Container;
import com.grino.catinlove.models.Player.ContainerMap;
import com.grino.catinlove.rxBus.BusMessage;
import com.grino.catinlove.rxBus.BusUpdatePlayer;
import com.grino.catinlove.rxBus.RxBus;
import com.grino.catinlove.tools.Random;

import lombok.Getter;
import lombok.Setter;

public class Player {

    private Context ctx;
    private RxBus bus;

    @Getter @Setter
    private String name;

    @Getter
    private Container level, day;
    private ContainerMap my;

    private Incoming incoming;

    private int deadlyCountdown;

    public Player(Context ctx, RxBus bus) {
        this.name = "";
        this.ctx = ctx;
        this.bus = bus;
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
                .putRes(KEY.FOOD, 0)
                .putRes(KEY.REAL, 10);
        deadlyCountdown = -1;
        incoming = new Incoming();
        bus.send(new BusUpdatePlayer());
    }
    private void levelUp(){
        if (my.getInt(KEY.EXP) > getMaxExp()) {
            level.increase();
            my.putRes(KEY.EXP, 0);
            my.fillMax(KEY.getRes());
            deadlyCountdown = -1;
            say(R.string.msg_level_up);
        }
    }
    private boolean deadlyControl(){
        if (atDeathIsDoor()){
            if (deadlyCountdown == 0) {
                deadlyCountdown = -2;
                restart();
                say(R.string.msg_game_over);
                return false;
            }else{
                if (deadlyCountdown == -1)  deadlyCountdown = 3;
                say(ctx.getString(R.string.msg_deadly_warning) + deadlyCountdown);
                deadlyCountdown--;
            }
        }else if (deadlyCountdown >= 0){
            deadlyCountdown = -1;
            say(R.string.msg_death_passed);
        }
        return true;
    }
    private void say(int msgID){
        bus.send(new BusMessage(ctx.getString(msgID)));
    }
    private void say(String msg){
        bus.send(new BusMessage(msg));
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
        doAction(incoming.getAction());
        levelUp();
        deadlyControl();
        bus.send(new BusUpdatePlayer());
    }

    private Action getNextDayAction(){
        Action action = new Action(KEY.class);
        action.put(KEY.EXP, 1);
        action.put(KEY.ENERGY, Random.rand(-70));
        action.put(KEY.MOOD, Random.rand(-70));
        action.put(KEY.SATIETY, Random.rand(-70));
        action.setProbability(1.0);
        return action;
    }

    public void doAction(Action action){
        if (action instanceof Income)
            incoming.put(action);
        else if (action.isMade())
            my.combineByKey(action);
    }


    public int getContent(KEY key) {
        return my.getInt(key);
    }

}
