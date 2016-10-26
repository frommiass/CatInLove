package com.grino.catinlove.models.Action;

import com.grino.catinlove.enums.KEY;
import com.grino.catinlove.tools.Random;

import java.util.EnumMap;

public class Trap
        extends Action
        implements Income{

    public Trap(EnumMap<KEY, ? extends Integer> m, String name, int iconID, Requirement requirement, double probability) {
        super(m, name, iconID, requirement, probability);
    }

    @Override
    public boolean isReady() {
        return Random.isMade(getProbability());
    }
}
