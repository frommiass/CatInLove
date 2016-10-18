package com.grino.catinlove.models;

import com.grino.catinlove.enums.KEY;

import java.util.EnumMap;
import java.util.Map;

public class Values
        extends EnumMap<KEY, Value>
        implements Keyable{

    private final static int MAX_IND = 100;
    private final static int MAX_RES = 2000000000;

    public Values(Class<KEY> keyType) {
        super(keyType);
    }

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
    public int get(KEY key) {
        return super.get(key).get();
    }

    public Values putRes(KEY key, int value){
        put(key, new Value(0, MAX_RES, value));
        return this;
    }

    public Values putInd(KEY key, int value){
        put(key, new Value(0, MAX_IND, value));
        return this;
    }
}
