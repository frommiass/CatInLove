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
}
