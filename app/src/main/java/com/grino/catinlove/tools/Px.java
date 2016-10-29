package com.grino.catinlove.tools;


import android.content.Context;

public class Px {

    public static int getPx(Context ctx, int dp){
        final float scale = ctx.getResources().getDisplayMetrics().density;
        return (int)(dp * scale + 0.5f);
    }
}
