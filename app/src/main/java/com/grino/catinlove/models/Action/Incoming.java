package com.grino.catinlove.models.Action;

import com.grino.catinlove.enums.KEY;

import java.util.ArrayList;

public class Incoming
        extends ArrayList<Income>{

    public Action getAction(){
        Action action = new Action(KEY.class);

        for(Income i: this){
            if (i.isReady())
                action.combineByKey(i);
        }

        return action;
    }

    public void put(Action action){
        if (action instanceof TrapIncome)
            add(new TrapIncome(action));
    }

}
