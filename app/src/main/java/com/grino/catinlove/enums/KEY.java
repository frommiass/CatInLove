package com.grino.catinlove.enums;

import com.grino.catinlove.MyApp;
import com.grino.catinlove.R;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum KEY {

        EXP   (100 + 1, R.string.indicator_exp),

        SATIETY (1000 + 1, R.string.indicator_satiety),
        MOOD    (1000 + 2, R.string.indicator_mood),
        ENERGY  (1000 + 3, R.string.indicator_energy),

        FOOD   (2000 + 1, R.string.resource_food),
        REAL   (2000 + 2, R.string.resource_real),

        CLAWS  (3000 + 1, R.string.attribute_claws),
        PAWS   (3000 + 1, R.string.attribute_paws),
        MUSTACHE  (3000 + 1, R.string.attribute_mustache);

        @Getter
        private final int key;

        @Getter
        private final int nameID;

        public String getName(){
                return MyApp.getContextForResources().getString(getNameID());
        }

        public static ArrayList<KEY> getInd(){
                ArrayList<KEY> ind = new ArrayList<KEY>();
                ind.add(KEY.MOOD);
                ind.add(KEY.SATIETY);
                ind.add(KEY.ENERGY);

                return ind;
        }
}
