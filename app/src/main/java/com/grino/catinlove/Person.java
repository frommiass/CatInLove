package com.grino.catinlove;

import android.content.Context;

public class Person {

    private Context ctx;

    private String name;
    private Condition condition;

    public Person(Context ctx, String name) {
        this.ctx = ctx;
        this.name = name;
        condition = new Condition(ctx);
    }

    public String getName() {
        return name;
    }
}
