package com.grino.catinlove.models;

import com.grino.catinlove.enums.KEY;

import java.util.HashMap;
import java.util.Map;

public class Values
        extends HashMap<KEY, Value>
        implements Keyable{

    public Keyable combineByKey(Keyable map) {
        for (Map.Entry<KEY, Value> e : entrySet())
            e.getValue().add(map.get(e.getKey()));
        return this;
    }

    public void fillMax(){
        for (Map.Entry<KEY, Value> entry : entrySet())
            entry.getValue().setMax();
    }

    @Override
    public String toString() {
        String s = "{" ;
        for (Map.Entry<KEY, Value> entry : entrySet())
            s = s + entry.getValue().getName() + "=" + entry.getValue().get() + ", ";
        s = s.substring(0, s.length()-2);
        return s + "}";
    }

    public String getDescription() {
        String s = "";
        int value;
        for (Map.Entry<KEY, Value> entry : entrySet()) {
            value = entry.getValue().get();
            if (value != 0) {
                if (value > 0) s = s + "+";
                s = s + value + " " + entry.getValue().getName() + ", ";
            }
        }
        if (s.length() > 1)
            s = s.substring(0, s.length()-2);
        else s = "";
        return s;
    }

    @Override
    public int get(KEY key) {
        return get(key);
    }

    @Override
    public Integer put(KEY key, Integer value) {
        return put(key, get(key));
    }
}
