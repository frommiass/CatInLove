package com.grino.catinlove.models;

import com.grino.catinlove.tools.MapSequences;

import java.util.ArrayList;

public class SequenceActions {

    private ArrayList<Action> actions;

    public SequenceActions(String[] names, MapSequences map) {
        Action action;
        for (int i=0; i< names.length; i++) {
            action = new Action(names[i], map.getLine(i));
            actions.add(action);
        }
    }

    public Action get(int n){
        return actions.get(n);
    }


}

