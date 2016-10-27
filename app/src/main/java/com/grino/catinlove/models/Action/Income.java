package com.grino.catinlove.models.Action;

public abstract class Income
        extends Action{

    public Income(Action action) {
        super(action);
    }

    abstract boolean isReady();
}

