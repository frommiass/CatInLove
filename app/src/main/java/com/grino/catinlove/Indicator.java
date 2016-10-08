package com.grino.catinlove;

public class Indicator
        extends Value {

    private final static int MIN_INDICATOR_VALUE = 0;
    private final static int MAX_INDICATOR_VALUE = 100;

    public Indicator(String name) {
        super(name, MIN_INDICATOR_VALUE, MAX_INDICATOR_VALUE);
    }

    public Indicator(String name, int value) {
        super(name, MIN_INDICATOR_VALUE, MAX_INDICATOR_VALUE, value);
    }
}
