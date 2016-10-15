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
        return "Action[" +
                "name='" + name + '\'' +
                super.toString() +
                ']';
    }
    public String getDescription() {
        return toString();
    }

    @Override
    public int get(KEY key) {
        return get(key);
    }
}
