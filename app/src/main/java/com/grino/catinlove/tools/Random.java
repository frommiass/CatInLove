package com.grino.catinlove.tools;

public class Random {

    public static int rand(int i){
        return (int)(Math.random() * i);
    }

    public static boolean isMade(double probability){
        return (Math.random() < probability);
    }
}
