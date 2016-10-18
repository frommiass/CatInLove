package com.grino.catinlove.models;

import android.content.res.Resources;

import com.grino.catinlove.MyApp;
import com.grino.catinlove.R;
import com.grino.catinlove.enums.DO;
import com.grino.catinlove.enums.KEY;
import com.grino.catinlove.enums.SEQUENCE_TYPE;
import com.grino.catinlove.tools.MapSequences;
import com.grino.catinlove.tools.Sequence;

import java.util.EnumMap;

public class Actions
        extends EnumMap<DO, SequenceActions> {

    public Actions(Class<DO> keyType) {
        super(keyType);
    }

    public Actions fillActions(){

        for (DO d: DO.values()){
            MapSequences s = new MapSequences(KEY.class);
            s.put(KEY.EXP, new Sequence(SEQUENCE_TYPE.CONSTANT, 1));

            if (d == DO.PLAY)
                s.put(KEY.MOOD, new Sequence(SEQUENCE_TYPE.NUMBERS));

            else if (d == DO.EAT)
                s.put(KEY.SATIETY, new Sequence(SEQUENCE_TYPE.NUMBERS));

            else if (d == DO.RELAX)
                s.put(KEY.ENERGY, new Sequence(SEQUENCE_TYPE.NUMBERS));

            else if (d == DO.HUNT)
                s.put(KEY.FOOD, new Sequence(SEQUENCE_TYPE.NUMBERS));

            else if (d == DO.CREATE)
                s.put(KEY.FOOD, new Sequence(SEQUENCE_TYPE.NUMBERS));

            int[] icons = {R.mipmap.ic_launcher};
            put(d, icons, s);
        }

        return this;
    }

    public void put(DO d, int[] icons, MapSequences sequences){
        Resources res = MyApp.getContextForResources().getResources();
        put(d, new SequenceActions(res.getStringArray(d.getStringsID()), icons, sequences));
    }

}
