package com.grino.catinlove;

public class Resource
        extends Value
        implements Nameable{

    private final static int MIN_RESOURCE_VALUE = 0;
    private final static int MAX_RESOURCE_VALUE = 2000000000;

    public Resource(String name) {
        super(name, MIN_RESOURCE_VALUE, MAX_RESOURCE_VALUE);

        setMin();
    }

    @Override
    public String getName() {
        return null;
    }



}
