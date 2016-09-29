package com.grino.catinlove;

public abstract class Value implements Nameable{

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

    private void set(int value){
        if (value < MIN_VALUE)
            setMin();
        else if (value > MAX_VALUE)
            setMax();
        else this.value = value;
    }

    @Override
    public String getName() {
        return null;
    }

    public void decrease(int value){
        set(get() - value);
    }
    public void increase(int value){
        set(get() + value);
    }

    public int get(){
        return value;
    }

    public void setMin() {
        value = MAX_VALUE;
    }

    public void setMax(){
        value = MAX_VALUE;
    }
}