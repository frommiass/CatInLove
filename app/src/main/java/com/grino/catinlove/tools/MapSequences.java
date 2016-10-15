package com.grino.catinlove.tools;


import com.grino.catinlove.enums.KEY;
import com.grino.catinlove.enums.SEQUENCE_TYPE;
import com.grino.catinlove.models.Action;

import java.util.EnumMap;

public class MapSequences
        extends EnumMap<KEY, Sequence>{


    public MapSequences(Class<KEY> keyType) {
        super(keyType);
    }

    public Action getAction(int n) {
        Action action = new Action(KEY.class);
        for (EnumMap.Entry<KEY, Sequence> e : entrySet()) {
            action.put(e.getKey(), e.getValue().get(n));
        }
        return action;
    }

    public MapSequences allNumbers(){
        Sequence sequence = new Sequence(SEQUENCE_TYPE.NUMBERS);
        for (KEY key: KEY.values())
            put(key, sequence);
        return this;
    }

}
