package com.grino.catinlove;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

public class Indicators {

    private Context ctx;

    private Map<Integer, Value> map = new HashMap<Integer, Value>();

    private final int KEY_SATIETY = 1;
    private final int KEY_MOOD = 2;
    private final int KEY_ENERGY = 3;

    public Indicators(Context ctx) {
        this.ctx = ctx;
        map.put(KEY_ENERGY, new Indicator(ctx.getString(R.string.indicator_energy)));
        map.put(KEY_MOOD, new Indicator(ctx.getString(R.string.indicator_mood)));
        map.put(KEY_SATIETY, new Indicator(ctx.getString(R.string.indicator_satiety)));
    }

    public void fillMax(){
        for (Map.Entry<Integer, Value> entry : map.entrySet())
            entry.getValue().setMax();
    }

    public void set(int key, int value){
        map.get(key).set(value);
    }

    public void add(Indicators indicators){
        for (Map.Entry<Integer, Value> entry : map.entrySet())
            entry.getValue().add(indicators.get(entry.getKey()).get());
    }

    public Value get(int key){
        return map.get(key);
    }

}
