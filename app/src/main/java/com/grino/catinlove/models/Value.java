package com.grino.catinlove.models;

public class Value{

    private final int MIN_VALUE;
    private final int MAX_VALUE;

    private int value;

    public Value(int min, int max) {
        MIN_VALUE = min;
        MAX_VALUE = max;
        this.value = MIN_VALUE;
    }
    public Value(int min, int max, int value) {
        MIN_VALUE = min;
        MAX_VALUE = max;
        this.value = value;
    }

    public int get(){
        return value;
    }
    protected void set(int value){
        if (value < MIN_VALUE)
            setMin();
        else if (value > MAX_VALUE)
            setMax();
        else this.value = value;
    }

    public void add(int value){
        set(get() + value);
    }

    public void setMin() {
        value = MIN_VALUE;
    }
    public void setMax(){
        value = MAX_VALUE;
    }

    public void increase(){
        value++;
    }
}
