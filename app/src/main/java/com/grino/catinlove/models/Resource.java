package com.grino.catinlove.models;

public class Resource
        extends Container {

    private final static int MIN_RESOURCE_VALUE = 0;
    private final static int MAX_RESOURCE_VALUE = 2000000000;

    public Resource() {
        super(MIN_RESOURCE_VALUE, MAX_RESOURCE_VALUE);
    }

    public Resource(int value) {
        super(MIN_RESOURCE_VALUE, MAX_RESOURCE_VALUE, value);
    }
}
