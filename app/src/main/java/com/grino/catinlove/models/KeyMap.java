package com.grino.catinlove.models;

import com.grino.catinlove.enums.KEY;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;

public class KeyMap
        extends EnumMap<KEY, Number> {

    public KeyMap(Class<KEY> keyType) {
        super(keyType);
    }

    public KeyMap(EnumMap<KEY, ? extends Number> m) {
        super(m);
    }

    public KeyMap combineByKey(KeyMap map) {
        for (Map.Entry<KEY, Number> e : map.entrySet()) {
            KEY key = e.getKey();
            int b = map.get(key).intValue();
            add(key, b);
        }
        return this;
    }

    public void add(KEY key, int value){
        put(key, get(key).intValue() + value);
    }

    @Override
    public String toString() {
        String s = "";
        for (EnumMap.Entry<KEY, Number> e : entrySet()) {
            int i = e.getValue().intValue();
            if (i != 0) {
                if (i > 0) s = s + "+";
                s = s + i + " " + e.getKey().getName() + ",  ";
            }
        }
        if (s.length() > 1)
            s = s.substring(0, s.length()-3);
        return s;
    }

    public boolean arePositive(ArrayList<KEY> keys){
        boolean result = true;
        for (EnumMap.Entry<KEY, Number> e : entrySet()) {
            if ( keys.contains(e.getKey()) & (e.getValue().intValue() <= 0))
                result = false;
        }
        return result;
    }
}
