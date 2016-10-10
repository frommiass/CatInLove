package com.grino.catinlove;

import android.content.Context;

public class Resources
        extends Values{

    private final int KEY_FOOD = 2000 + 1;
    private final int KEY_REAL = 2000 + 2;

    public Resources(Context ctx) {
        super(ctx);
        put(KEY_FOOD, new Indicator(ctx.getString(R.string.indicator_energy)));
        put(KEY_REAL, new Indicator(ctx.getString(R.string.indicator_mood)));
    }

    public Resources(Context ctx, int food, int real) {
        super(ctx);
        put(KEY_FOOD, new Resource(ctx.getString(R.string.resource_food), food));
        put(KEY_FOOD, new Resource(ctx.getString(R.string.resource_food), real));
    }


}
