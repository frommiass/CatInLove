package com.grino.catinlove.models.Action;

import com.grino.catinlove.enums.KEY;
import com.grino.catinlove.models.KeyMap;

import java.util.EnumMap;

import lombok.Getter;
import lombok.Setter;

public class Action
        extends KeyMap {

    @Getter @Setter     private String name;
    @Getter @Setter     private int iconID;
    @Getter @Setter     private Requirement requirement;
    @Getter @Setter     private double probability;

    public Action(EnumMap<KEY, ? extends Number> m,
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

    @Override
    public String toString() {
        String s = super.toString();
        s = s + ", Вероятность = " + probability + ",  " + requirement;
        return s;
    }

}
