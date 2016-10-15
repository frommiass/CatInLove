package com.grino.catinlove.models;

import android.content.res.Resources;

import com.grino.catinlove.R;
import com.grino.catinlove.enums.DO;
import com.grino.catinlove.enums.KEY;
import com.grino.catinlove.tools.MapSequences;

import java.util.EnumMap;

public class Actions
        extends EnumMap<DO, SequenceActions> {

    public Actions(Class<DO> keyType) {
        super(keyType);
    }

    public Actions fillActions(Resources res){
        MapSequences sequences = (new MapSequences(KEY.class)).allNumbers();
        int[] iconIDs = {R.mipmap.ic_launcher};
        put(DO.PLAY, new SequenceActions(res.getStringArray(R.array.do_play), iconIDs, sequences));
        put(DO.EAT, new SequenceActions(res.getStringArray(R.array.do_eat), iconIDs, sequences));
        put(DO.RELAX, new SequenceActions(res.getStringArray(R.array.do_relax), iconIDs, sequences));
        put(DO.HUNT, new SequenceActions(res.getStringArray(R.array.do_hunt), iconIDs, sequences));
        put(DO.CREATE, new SequenceActions(res.getStringArray(R.array.do_create), iconIDs, sequences));
        return this;
    }

}
