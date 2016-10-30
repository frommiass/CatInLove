package com.grino.catinlove.enums;

import com.grino.catinlove.MyApp;
import com.grino.catinlove.R;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum KEY {

        EXP     (100 + 1, R.string.indicator_exp, R.string.key_fail_exp),

        SATIETY (1000 + 1, R.string.indicator_satiety, R.string.key_fail_real),
        MOOD    (1000 + 2, R.string.indicator_mood, R.string.key_fail_real),
        ENERGY  (1000 + 3, R.string.indicator_energy, R.string.key_fail_real),

        FOOD   (2000 + 1, R.string.resource_food, R.string.key_fail_food),
        REAL   (2000 + 2, R.string.resource_real, R.string.key_fail_real),

        CLAWS     (3000 + 1, R.string.attribute_claws, R.string.key_fail_claws),
        PAWS      (3000 + 1, R.string.attribute_paws, R.string.key_fail_paws),
        MUSTACHE  (3000 + 1, R.string.attribute_mustache, R.string.key_fail_mustache);

        @Getter         private final int key;
        @Getter         private final int nameID;
        @Getter         private final int failStringID;

        public String getName(){
                return MyApp.getContextForResources().getString(getNameID());
        }

        public static ArrayList<KEY> getInd(){
                ArrayList<KEY> ind = new ArrayList<>();
                ind.add(KEY.MOOD);
                ind.add(KEY.SATIETY);
                ind.add(KEY.ENERGY);

                return ind;
        }
}
