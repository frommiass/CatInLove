package com.grino.catinlove.tools;


import com.grino.catinlove.enums.KEY;
import com.grino.catinlove.enums.SEQUENCE_TYPE;

import java.util.HashMap;
import java.util.Map;

public class MapSequences {

    private Map<KEY, Sequence> map = new HashMap<KEY, Sequence>();

    public Map<KEY, Integer> getLine(int n) {
        Map<KEY, Integer> line = new HashMap<KEY, Integer>();
        for (Map.Entry<KEY, Sequence> e : map.entrySet()) {
            line.put(e.getKey(), e.getValue().get(n));
        }
        return line;
    }

    public MapSequences allNumbers(){
        KEY[] keys = KEY.values();
        Sequence sequence = new Sequence(SEQUENCE_TYPE.NUMBERS);
        for (int i=0; i<keys.length; i++)
            map.put(keys[i], sequence);
        return this;
    }

}
