package com.grino.catinlove.models;

import com.grino.catinlove.enums.KEY;

import java.util.EnumMap;
import java.util.Map;

public class ContainerMap
        extends EnumMap<KEY, Container>
        implements Keyable{

    private final static int MAX_IND = 100;
    private final static int MAX_RES = 2000000000;

    public ContainerMap(Class<KEY> keyType) {
        super(keyType);
    }

    public Keyable combineByKey(Keyable map) {
        for (Map.Entry<KEY, Container> e : entrySet()) {
            KEY key = e.getKey();
            int b = map.get(key);
            Container a = e.getValue();
            a.add(b);
        }
        return this;
    }

    public void fillMax(){
        for (Map.Entry<KEY, Container> entry : entrySet())
            entry.getValue().setMax();
    }

    @Override
     public int get(KEY key) {
        return super.get(key).get();
    }

    public ContainerMap putRes(KEY key, int value){
        put(key, new Container(0, MAX_RES, value));
        return this;
    }

    public ContainerMap putInd(KEY key, int value){
        put(key, new Container(0, MAX_IND, value));
        return this;
    }
}
