package com.grino.catinlove.models;

import android.content.res.Resources;

import com.grino.catinlove.MyApp;
import com.grino.catinlove.R;
import com.grino.catinlove.enums.DO;
import com.grino.catinlove.enums.KEY;
import com.grino.catinlove.enums.SEQUENCE_TYPE;
import com.grino.catinlove.tools.Sequence;

import java.util.EnumMap;
import java.util.HashMap;

public class Actions
        extends EnumMap<DO, SequenceActions> {

    static HashMap<DO, int[]> icons = new HashMap<>();
    static{
        int[] relaxIcons = {
                R.drawable.relax_01,
                R.drawable.relax_02,
                R.drawable.relax_03,
                R.drawable.relax_04,
                R.drawable.relax_05,
                R.drawable.relax_06,
                R.drawable.relax_07,
                R.drawable.relax_08,
                R.drawable.relax_09,
                R.drawable.relax_10,
                R.drawable.relax_11,
                R.drawable.relax_12,
                R.drawable.relax_13,
                R.drawable.relax_14,
                R.drawable.relax_15,
                R.drawable.relax_16,
                R.drawable.relax_17,
                R.drawable.relax_18,
                R.drawable.relax_19,
                R.drawable.relax_20,
                R.drawable.relax_21,
                R.drawable.relax_22,
                R.drawable.relax_23,
                R.drawable.relax_24,
                R.drawable.relax_25,
                R.drawable.relax_26,
                R.drawable.relax_27,
                R.drawable.relax_28,
                R.drawable.relax_29,
                R.drawable.relax_30,
                R.drawable.relax_31,
                R.drawable.relax_32,
                R.drawable.relax_33,
                R.drawable.relax_34,
                R.drawable.relax_35,
        };

        int[] eatIcons = {
                R.drawable.eat_01,
                R.drawable.eat_02,
                R.drawable.eat_03,
                R.drawable.eat_04,
                R.drawable.eat_05,
                R.drawable.eat_06,
                R.drawable.eat_07,
                R.drawable.eat_08,
                R.drawable.eat_09,
                R.drawable.eat_10,
                R.drawable.eat_11,
                R.drawable.eat_12,
                R.drawable.eat_13,
                R.drawable.eat_14,
                R.drawable.eat_15,
                R.drawable.eat_16,
                R.drawable.eat_17,
                R.drawable.eat_18,
                R.drawable.eat_19
        };

        int[] huntIcons = {
                R.drawable.hunt_01,
                R.drawable.hunt_02,
                R.drawable.hunt_03,
                R.drawable.hunt_04,
                R.drawable.hunt_05,
                R.drawable.hunt_06,
                R.drawable.hunt_07,
                R.drawable.hunt_08,
                R.drawable.hunt_09,
                R.drawable.hunt_10,
                R.drawable.hunt_11,
                R.drawable.hunt_12,
                R.drawable.hunt_13,
                R.drawable.hunt_14,
                R.drawable.hunt_15,
                R.drawable.hunt_16,
                R.drawable.hunt_17,
                R.drawable.hunt_18,
                R.drawable.hunt_19,
                R.drawable.hunt_20,
                R.drawable.hunt_21,
                R.drawable.hunt_22,
                R.drawable.hunt_23
        };

        icons.put(DO.RELAX, relaxIcons);
        icons.put(DO.EAT, eatIcons);
        icons.put(DO.PLAY, relaxIcons);
        icons.put(DO.HUNT, huntIcons);
        icons.put(DO.CREATE, relaxIcons);
    }


    public Actions(Class<DO> keyType) {
        super(keyType);
    }
    public Actions fillActions(){

        Resources res = MyApp.getContextForResources().getResources();

        Sequence seq0 = new Sequence(SEQUENCE_TYPE.CONSTANT, 1);
        Sequence seq02 = new Sequence(SEQUENCE_TYPE.CONSTANT, 2);
        Sequence seq1 = new Sequence(SEQUENCE_TYPE.NUMBERS);
        Sequence seq2 = new Sequence(SEQUENCE_TYPE.LINEAR_DEPENDENCE, 88, 4);

        for (DO d: DO.values()){

            SequenceActions actions = new SequenceActions(res.getStringArray(d.getStringsID()));
            actions.setIcons(icons.get(d), R.drawable.placeholder);
            actions.setSequence(KEY.EXP, seq0);

                 if (d == DO.PLAY)   actions.set(KEY.MOOD,    seq2, seq0, seq0);
            else if (d == DO.EAT)    actions.set(KEY.SATIETY, seq2, seq0, seq0);
            else if (d == DO.RELAX)  actions.set(KEY.ENERGY,  seq2, seq02, seq0);
            else if (d == DO.HUNT)   actions.set(KEY.FOOD,    seq1, seq02, seq0);
            else if (d == DO.CREATE) actions.set(KEY.FOOD,    seq1, seq02, seq0);

            actions.fill();
            put(d, actions);
        }

        return this;
    }


}
