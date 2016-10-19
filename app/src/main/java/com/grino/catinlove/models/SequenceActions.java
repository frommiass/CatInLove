package com.grino.catinlove.models;

import com.grino.catinlove.tools.MapSequences;

import java.util.ArrayList;

public class SequenceActions
        extends ArrayList<Action>{

    public SequenceActions(String[] names, int[] iconIDs, MapSequences map) {
        Action action;
        for (int i=0; i< names.length; i++) {
            action = new Action(map.getAction(i), names[i], iconIDs[i]);
            add(action);
        }
    }

}

