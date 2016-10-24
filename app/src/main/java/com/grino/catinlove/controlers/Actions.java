package com.grino.catinlove.controlers;

import android.content.res.Resources;

import com.grino.catinlove.enums.DO;
import com.grino.catinlove.enums.KEY;
import com.grino.catinlove.enums.SEQUENCE_TYPE;
import com.grino.catinlove.models.Action.Sequence;
import com.grino.catinlove.models.Action.SequenceActions;

import java.util.EnumMap;

public class Actions
        extends EnumMap<DO, SequenceActions> {

    private Resources res;

    public Actions(Class<DO> keyType, Resources res) {
        super(keyType);

        this.res = res;

        fillActions();
    }
    public Actions fillActions(){

        Sequence seq0 = new Sequence(SEQUENCE_TYPE.CONSTANT, 1);
        Sequence seq02 = new Sequence(SEQUENCE_TYPE.CONSTANT, 2);
        Sequence seq1 = new Sequence(SEQUENCE_TYPE.NUMBERS);
        Sequence seq2 = new Sequence(SEQUENCE_TYPE.LINEAR_DEPENDENCE, 88, 4);

        for (DO d: DO.values()){
            SequenceActions actions = new SequenceActions(res.getStringArray(d.getStringsID()));
            actions.setIcons(res, d);
            actions.setSequence(KEY.EXP, seq0);

                 if (d == DO.PLAY)   actions.set(KEY.MOOD,    seq2, seq1, seq0);
            else if (d == DO.EAT)    actions.set(KEY.SATIETY, seq2, seq1, seq0);
            else if (d == DO.RELAX)  actions.set(KEY.ENERGY,  seq2, seq1, seq0);
            else if (d == DO.HUNT)   actions.set(KEY.FOOD,    seq1, seq1, seq0);
            else if (d == DO.CREATE) actions.set(KEY.FOOD,    seq1, seq1, seq0);

            actions.fill();
            put(d, actions);
        }

        return this;
    }

}
