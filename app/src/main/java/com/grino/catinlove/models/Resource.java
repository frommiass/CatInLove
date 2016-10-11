package com.grino.catinlove.models;

public class Resource
        extends Value{

    private final static int MIN_RESOURCE_VALUE = 0;
    private final static int MAX_RESOURCE_VALUE = 2000000000;

    public Resource(String name) {
        super(name, MIN_RESOURCE_VALUE, MAX_RESOURCE_VALUE);
    }

    public Resource(String name, int value) {
        super(name, MIN_RESOURCE_VALUE, MAX_RESOURCE_VALUE, value);
    }
}
