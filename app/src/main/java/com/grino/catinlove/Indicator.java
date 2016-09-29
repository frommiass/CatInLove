package com.grino.catinlove;

public class Indicator {

    final int MIN_VALUE = 0;
    final int MAX_VALUE = 100;

    private String name;
    private int value;

    public Indicator(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public void set(int value){
        if ((value >= MIN_VALUE) &
            (value <= MAX_VALUE))
            this.value = value;
    }

    public int get(){
        return value;
    }

    public String getName(){
        return name;
    }
}
