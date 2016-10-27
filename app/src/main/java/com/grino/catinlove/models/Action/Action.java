package com.grino.catinlove.models.Action;

import com.grino.catinlove.enums.KEY;
import com.grino.catinlove.models.KeyMap;
import com.grino.catinlove.tools.Random;

import java.util.EnumMap;

import lombok.Getter;
import lombok.Setter;

public class Action
        extends KeyMap<KEY, Integer> {

    @Getter @Setter     private String name;
    @Getter @Setter     private int iconID;
    @Getter @Setter     private double probability;

    public Action(EnumMap<KEY, ? extends Integer> m,
                  String name,
                  int iconID,
                  double probability) {
        super(m);
        this.name = name;
        this.iconID = iconID;
        this.probability = probability;
    }

    public Action(Class<KEY> keyType) {
        super(keyType);
    }

    public Action(Action action) {
        super(action);
        this.name = action.name;
        this.iconID = action.iconID;
        this.probability = action.probability;
    }

    @Override
    public void set(KEY key, int value) {
        put(key, value);
    }

    @Override
    public String toString() {
        String s = super.toString();
        s = s + ", Вероятность = " + probability;
        return s;
    }

    public boolean isMade() {
        boolean isMade = Random.isMade(getProbability());
        if (isMade) Made();
        return isMade;
    }

    public void Made(){

    }
}
