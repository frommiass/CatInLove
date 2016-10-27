package com.grino.catinlove.models.Action;

import com.grino.catinlove.enums.KEY;
import com.grino.catinlove.models.KeyMap;

import java.util.EnumMap;

import lombok.Getter;
import lombok.Setter;

public class Action
        extends KeyMap<KEY, Integer> {

    @Getter @Setter     private String name;
    @Getter @Setter     private int iconID;
    @Getter @Setter     private Requirement requirement;
    @Getter @Setter     private double probability;

    public Action(EnumMap<KEY, ? extends Integer> m,
                  String name,
                  int iconID,
                  Requirement requirement,
                  double probability) {
        super(m);
        this.name = name;
        this.iconID = iconID;
        this.requirement = requirement;
        this.probability = probability;
    }

    public Action(Class<KEY> keyType) {
        super(keyType);
    }

    public Action(Action action) {
        super(action);
        this.name = action.name;
        this.iconID = action.iconID;
        this.requirement = action.requirement;
        this.probability = action.probability;
    }

    @Override
    public void set(KEY key, int value) {
        put(key, value);
    }

    @Override
    public String toString() {
        String s = super.toString();
        s = s + ", Вероятность = " + probability + ",  " + requirement;
        return s;
    }
}
