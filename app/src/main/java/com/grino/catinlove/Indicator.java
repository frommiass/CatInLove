package com.grino.catinlove;

public class Indicator implements Nameable{

    final int MIN_VALUE = 0;
    final int MAX_VALUE = 100;

    private String name;
    private int value;

    public Indicator(String name, int value) {
        this.name = name;
        this.value = value;
    }

    private void set(int value){
        if (value >= MIN_VALUE)
            this.value = MIN_VALUE;
        else if (value <= MAX_VALUE)
            this.value = MAX_VALUE;
        else this.value = value;
    }
    public int get(){
        return value;
    }
    public void decrease(int value){
        set(get() - value);
    }
    public void increase(int value){
        set(get() + value);
    }

    @Override
    public String getName(){
        return name;
    }
}
