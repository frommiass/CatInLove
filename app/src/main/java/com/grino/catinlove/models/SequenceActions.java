package com.grino.catinlove.models;

import com.grino.catinlove.tools.MapSequences;

import java.util.ArrayList;

public class SequenceActions {

    private ArrayList<Action> actions;

    public SequenceActions(String[] names, int[] iconIDs, MapSequences map) {
        Action action;
        for (int i=0; i< names.length; i++) {
            action = new Action(names[i], iconIDs[0], map.getLine(i));
            actions.add(action);
        }
    }

    public Action get(int n){
        return actions.get(n);
    }

    public int size(){
        return actions.size();
    }
}

