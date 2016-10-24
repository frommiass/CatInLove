package com.grino.catinlove.models.Player;

import com.grino.catinlove.enums.KEY;
import com.grino.catinlove.models.Keyable;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;

public class ContainerMap
        extends EnumMap<KEY, Container>
        implements Keyable {

    private final static int MAX_IND = 1000;
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

    @Override
    public String toString() {
        String s = "";
        for (EnumMap.Entry<KEY, Container> e : entrySet()) {
            int i = e.getValue().get();
            if (i != 0) {
                if (i > 0) s = s + "+";
                s = s + i + " " + e.getKey().getName() + ",  ";
            }
        }
        if (s.length() > 1)
            s = s.substring(0, s.length()-3);
        else s = "";
        return s;
    }

    public boolean arePositive(ArrayList<KEY> keys){
        boolean result = true;
        for (EnumMap.Entry<KEY, Container> e : entrySet()) {
            if ( keys.contains(e.getKey()) & (!e.getValue().isPositive()))
                result = false;
        }
        return result;
    }
}
