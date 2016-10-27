package com.grino.catinlove.models;

import com.grino.catinlove.enums.KEY;

import java.util.ArrayList;
import java.util.EnumMap;

public abstract class KeyMap<K extends KEY, N extends Number>
        extends EnumMap<KEY, N> {

    public KeyMap(Class<KEY> keyType) {
        super(keyType);
    }

    public KeyMap(EnumMap<KEY, ? extends N> m) {
        super(m);
    }

    public KeyMap<K, N> combineByKey(KeyMap<K, ? extends Number> map) {
        for (Entry<KEY, ? extends Number> e : map.entrySet()) {
            KEY key = e.getKey();
            int b = map.get(key).intValue();
            add(key, b);
        }
        return this;
    }

    public void add(KEY key, int value){
        if (get(key) != null)
            set(key, get(key).intValue() + value);
        else set(key, value);
    }

    public abstract void set(KEY key, int values);

    @Override
    public String toString() {
        String s = "";
        for (KeyMap.Entry<KEY, N> e : entrySet()) {
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
        for (KeyMap.Entry<KEY, N> e : entrySet()) {
            if ( keys.contains(e.getKey()) & (e.getValue().intValue() <= 0))
                result = false;
        }
        return result;
    }
}
