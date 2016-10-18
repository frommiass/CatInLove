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

        Sequence seq0 = new Sequence(SEQUENCE_TYPE.CONSTANT, 1);
        Sequence seq1 = new Sequence(SEQUENCE_TYPE.NUMBERS);
        Sequence seq2 = new Sequence(SEQUENCE_TYPE.LINEAR_DEPENDENCE, 88, 4);

        for (DO d: DO.values()){
            MapSequences s = new MapSequences(KEY.class);
            s.put(KEY.EXP, seq0);

                 if (d == DO.PLAY)   s.put(KEY.MOOD,    seq2);
            else if (d == DO.EAT)    s.put(KEY.SATIETY, seq2);
            else if (d == DO.RELAX)  s.put(KEY.ENERGY,  seq2);
            else if (d == DO.HUNT)   s.put(KEY.FOOD,    seq1);
            else if (d == DO.CREATE) s.put(KEY.FOOD,    seq1);

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
