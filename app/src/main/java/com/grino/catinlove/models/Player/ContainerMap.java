package com.grino.catinlove.models.Player;

import com.grino.catinlove.enums.KEY;
import com.grino.catinlove.models.KeyMap;

import java.util.ArrayList;

public class ContainerMap
        extends KeyMap<KEY, Container> {

    private final static int MAX_IND = 1000;
    private final static int MAX_RES = 2000000000;

    public ContainerMap(Class<KEY> keyType) {
        super(keyType);
    }

    @Override
    public void set(KEY key, int value) {
        for (Entry<KEY, Container> e: this.entrySet())
            if (containsKey(key))
                get(key).set(value);
    }

    public void fillMax(ArrayList<KEY> keys){
        for (KEY key : keys)
            get(key).setMax();
    }

    public ContainerMap putRes(KEY key, int value){
        put(key, new Container(0, MAX_RES, value));
        return this;
    }

    public ContainerMap putInd(KEY key, int value){
        put(key, new Container(0, MAX_IND, value));
        return this;
    }

    public Container get(KEY key){
        return (Container)super.get(key);
    }

    public int getInt(KEY key){
        return super.get(key).intValue();
    }
}
