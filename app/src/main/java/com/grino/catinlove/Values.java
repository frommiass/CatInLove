package com.grino.catinlove;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

public class Values {
    private Context ctx;

    private Map<Integer, Value> map;

    public Values(Context ctx) {
        this.ctx = ctx;
        this.map = new HashMap<Integer, Value>();
    }

    public void put(int key, Value value){
        map.put(key, value);
    }

    public Value get(int key){
        return map.get(key);
    }

    public void set(int key, int value){
        map.get(key).set(value);
    }

    public void add(Indicators indicators){
        for (Map.Entry<Integer, Value> entry : map.entrySet())
            entry.getValue().add(indicators.get(entry.getKey()).get());
    }

    public void fillMax(){
        for (Map.Entry<Integer, Value> entry : map.entrySet())
            entry.getValue().setMax();
    }

}
