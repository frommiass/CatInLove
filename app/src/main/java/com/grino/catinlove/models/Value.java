package com.grino.catinlove.models;

public class Value
        implements Nameable{

    private final int MIN_VALUE;
    private final int MAX_VALUE;

    private String name;
    private int value;

    public Value(String name, int min, int max) {
        MIN_VALUE = min;
        MAX_VALUE = max;
        this.name = name;
        this.value = MIN_VALUE;
    }

    public Value(String name, int min, int max, int value) {
        MIN_VALUE = min;
        MAX_VALUE = max;
        this.name = name;
        this.value = value;
    }

    protected void set(int value){
        if (value < MIN_VALUE)
            setMin();
        else if (value > MAX_VALUE)
            setMax();
        else this.value = value;
    }

    @Override
    public String getName() {
        return name;
    }

    public void add(int value){
        set(get() + value);
    }

    public int get(){
        return value;
    }

    public void setMin() {
        value = MIN_VALUE;
    }

    public void setMax(){
        value = MAX_VALUE;
    }
}
