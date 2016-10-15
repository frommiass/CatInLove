package com.grino.catinlove.models;

import android.content.res.Resources;

import com.grino.catinlove.R;
import com.grino.catinlove.enums.DO;
import com.grino.catinlove.tools.MapSequences;

import java.util.HashMap;
import java.util.Map;

public class Actions {

    private Map<DO, SequenceActions> map = new HashMap<DO, SequenceActions>();

    public Actions(Resources res) {
        fillActions(res);
    }

    public Action get(DO key, int n){
        return map.get(key).get(n);
    }

    public Actions fillActions(Resources res){
        MapSequences sequences = (new MapSequences()).allNumbers();
        int[] iconIDs = {R.mipmap.ic_launcher};
        map.put(DO.PLAY, new SequenceActions(res.getStringArray(R.array.do_play), iconIDs, sequences));
        map.put(DO.EAT, new SequenceActions(res.getStringArray(R.array.do_eat), iconIDs, sequences));
        map.put(DO.RELAX, new SequenceActions(res.getStringArray(R.array.do_relax), iconIDs, sequences));
        map.put(DO.HUNT, new SequenceActions(res.getStringArray(R.array.do_hunt), iconIDs, sequences));
        map.put(DO.CREATE, new SequenceActions(res.getStringArray(R.array.do_create), iconIDs, sequences));
        return this;
    }

    public SequenceActions get(DO key){
        return map.get(key);
    }

}
