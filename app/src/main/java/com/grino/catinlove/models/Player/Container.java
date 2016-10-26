package com.grino.catinlove.models.Player;

public class Container
        extends Number{

    private final int MIN_VALUE;
    private final int MAX_VALUE;

    private int value;

    public Container(int min, int max) {
        MIN_VALUE = min;
        MAX_VALUE = max;
        this.value = MIN_VALUE;
    }
    public Container(int min, int max, int value) {
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

    @Override
    public int intValue() {
        return value;
    }

    @Override
    public long longValue() {
        return (long)value;
    }

    @Override
    public float floatValue() {
        return (float)value;
    }

    @Override
    public double doubleValue() {
        return (double)value;
    }
}
