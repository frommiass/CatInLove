package com.grino.catinlove.models;

import com.grino.catinlove.enums.KEY;

import java.util.EnumMap;

import lombok.Getter;
import lombok.Setter;

public class Action
        extends EnumMap<KEY, Integer>
        implements Nameable, Keyable{

    @Getter @Setter     private String name;
    @Getter @Setter     private int iconID;

    public Action(EnumMap<KEY, ? extends Integer> m, String name, int iconID) {
        super(m);
        this.name = name;
        this.iconID = iconID;
    }

    public Action(Class<KEY> keyType) {
        super(keyType);
    }

    @Override
    public String toString() {
        String s = "";
        for (EnumMap.Entry<KEY, Integer> e : entrySet()) {
            int i = e.getValue();
            if (i != 0) {
                if (i > 0) s = s + "+";
                else s = s + "-";
                s = s + i + " " + e.getKey().getName() + ",  ";
            }
        }
        if (s.length() > 1)
            s = s.substring(0, s.length()-3);
        else s = "";
        return s;
    }

    @Override
    public int get(KEY key) {
        return get(key);
    }
}
