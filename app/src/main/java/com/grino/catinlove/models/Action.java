package com.grino.catinlove.models;

import com.grino.catinlove.enums.KEY;

import java.util.EnumMap;

public class Action
        extends EnumMap<KEY, Integer>
        implements Nameable, Keyable{

    private String name;
    private int iconID;

    public Action(EnumMap<KEY, ? extends Integer> m, String name, int iconID) {
        super(m);
        this.name = name;
        this.iconID = iconID;
    }

    public Action(Class<KEY> keyType) {
        super(keyType);
    }

    public int getIconID() {
        return iconID;
    }
    public Action setIconID(int iconID) {
        this.iconID = iconID;
        return this;
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
    public String getName() {
        return null;
    }

    @Override
    public int get(KEY key) {
        return get(key);
    }
}
