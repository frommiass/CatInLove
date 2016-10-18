package com.grino.catinlove.models;

import android.content.res.Resources;

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

    public Actions fillActions(Resources res){
        MapSequences primerSequences = new MapSequences(KEY.class);
        primerSequences.put(KEY.EXP, new Sequence(SEQUENCE_TYPE.CONSTANT, 1));
        primerSequences.put(KEY.REAL, new Sequence(SEQUENCE_TYPE.CONSTANT, 0));

        MapSequences seqPlay = new MapSequences(primerSequences);
        seqPlay.put(KEY.MOOD, new Sequence(SEQUENCE_TYPE.NUMBERS));

        MapSequences seqEat = new MapSequences(primerSequences);
        seqEat.put(KEY.SATIETY, new Sequence(SEQUENCE_TYPE.NUMBERS));

        MapSequences seqRelax = new MapSequences(primerSequences);
        seqRelax.put(KEY.ENERGY, new Sequence(SEQUENCE_TYPE.NUMBERS));

        MapSequences seqHunt = new MapSequences(primerSequences);
        seqHunt.put(KEY.FOOD, new Sequence(SEQUENCE_TYPE.NUMBERS));

        MapSequences seqCreate = new MapSequences(primerSequences);
        seqCreate.put(KEY.FOOD, new Sequence(SEQUENCE_TYPE.NUMBERS));


        int[] iconIDs = {R.mipmap.ic_launcher};
        put(DO.PLAY, new SequenceActions(res.getStringArray(R.array.do_play), iconIDs, seqPlay));
        put(DO.EAT, new SequenceActions(res.getStringArray(R.array.do_eat), iconIDs, seqEat));
        put(DO.RELAX, new SequenceActions(res.getStringArray(R.array.do_relax), iconIDs, seqRelax));
        put(DO.HUNT, new SequenceActions(res.getStringArray(R.array.do_hunt), iconIDs, seqHunt));
        put(DO.CREATE, new SequenceActions(res.getStringArray(R.array.do_create), iconIDs, seqCreate));
        return this;
    }

}
