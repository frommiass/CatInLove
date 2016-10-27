package com.grino.catinlove.models.Action;

import com.grino.catinlove.tools.Random;

public class TrapIncome
        extends Income{

    public TrapIncome(Action action) {
        super(action);
    }

    @Override
    public boolean isReady() {
        return Random.isMade(getProbability());
    }
}
