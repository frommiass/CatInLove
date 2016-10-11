package com.grino.catinlove.models;

import android.content.Context;

import com.grino.catinlove.R;

public class Resources
        extends Values{

    public final static int KEY_FOOD = 2000 + 1;
    public final static int KEY_REAL = 2000 + 2;

    public Resources(Context ctx) {
        super();
        put(KEY_FOOD, new Resource(ctx.getString(R.string.resource_food)));
        put(KEY_REAL, new Resource(ctx.getString(R.string.resource_real)));
    }

    public Resources(Context ctx, int food, int real) {
        super();
        put(KEY_FOOD, new Resource(ctx.getString(R.string.resource_food), food));
        put(KEY_REAL, new Resource(ctx.getString(R.string.resource_real), real));
    }

    @Override
    public String toString() {
        return "RES:" + super.toString();
    }

    public static boolean isResourcesKey(int key){
        return (key==KEY_FOOD)||(key==KEY_REAL);
    }
}
