package com.grino.catinlove.models;

import java.util.HashMap;
import java.util.Map;

public class Values {

    private Map<Integer, Value> map;

    public Values() {
        this.map = new HashMap<Integer, Value>();
    }

    protected void put(int key, Value value){
        map.put(key, value);
    }

    public Value get(int key){
        return map.get(key);
    }

    public void set(int key, int value){
        map.get(key).set(value);
    }

    public void add(Values values){
        for (Map.Entry<Integer, Value> entry : map.entrySet())
            entry.getValue().add(values.get(entry.getKey()).get());
    }

    public void fillMax(){
        for (Map.Entry<Integer, Value> entry : map.entrySet())
            entry.getValue().setMax();
    }

    @Override
    public String toString() {
        String s = "{" ;
        for (Map.Entry<Integer, Value> entry : map.entrySet())
            s = s + entry.getValue().getName() + "=" + entry.getValue().get() + ", ";
        s = s.substring(0, s.length()-2);
        return s + "}";
    }

    public String getDescription() {
        String s = "";
        int value;
        for (Map.Entry<Integer, Value> entry : map.entrySet()) {
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
