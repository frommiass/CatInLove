package com.grino.catinlove;

import android.content.Context;

public class Resources {

    private Context ctx;

    private Resource food;
    private Resource real;

    public Resources(Context ctx) {
        this.ctx = ctx;

        food = new Resource(ctx.getString(R.string.resource_food));
        real = new Resource(ctx.getString(R.string.resource_real));
    }

    public Resources(Context ctx, int food, int real) {
        this.ctx = ctx;
        this.food = new Resource(ctx.getString(R.string.resource_food), food);
        this.food = new Resource(ctx.getString(R.string.resource_food), real);
    }

    public void setFood(int food) {
        this.food.set(food);
    }

    public void setReal(int real) {
        this.real.set(real);
    }
}
