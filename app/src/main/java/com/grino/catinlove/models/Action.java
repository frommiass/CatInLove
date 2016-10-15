package com.grino.catinlove.models;

import com.grino.catinlove.enums.KEY;

import java.util.HashMap;
import java.util.Map;

public class Action
        implements Nameable{

    private Map<KEY, Integer> map = new HashMap<KEY, Integer>();

    private String name;
    private int iconID;

    public Action(String name) {
        this.name = name;
    }
    public Action(String name, Map<KEY, Integer> map) {
        this.name = name;
        this.map = map;
    }


    @Override
    public String getName() {
        return name;
    }

    public int getIconID() {
        return iconID;
    }
    public Action setIconID(int iconID) {
        this.iconID = iconID;
        return this;
    }

    public void set(KEY key, int i){
        map.put(key, i);
    }
    public int get(KEY key){
        return map.get(key);
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

}
