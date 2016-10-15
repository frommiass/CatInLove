package com.grino.catinlove.models;

import com.grino.catinlove.enums.KEY;

import java.util.HashMap;
import java.util.Map;

public class Values {

    private Map<KEY, Value> map = new HashMap<KEY, Value>();

    public Values() {
    }
    public Values(Map<KEY, Value> map) {
        this.map = map;
    }

    protected void put(KEY key, Value value){
        map.put(key, value);
    }
    public void set(KEY key, int value){
        map.get(key).set(value);
    }
    public int get(KEY key){
        return map.get(key).get();
    }

    public void add(Values values){
        for (Map.Entry<KEY, Value> e : map.entrySet())
            e.getValue().add(values.get(e.getKey()));
    }

    public void fillMax(){
        for (Map.Entry<KEY, Value> entry : map.entrySet())
            entry.getValue().setMax();
    }

    @Override
    public String toString() {
        String s = "{" ;
        for (Map.Entry<KEY, Value> entry : map.entrySet())
            s = s + entry.getValue().getName() + "=" + entry.getValue().get() + ", ";
        s = s.substring(0, s.length()-2);
        return s + "}";
    }

    public String getDescription() {
        String s = "";
        int value;
        for (Map.Entry<KEY, Value> entry : map.entrySet()) {
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

}
