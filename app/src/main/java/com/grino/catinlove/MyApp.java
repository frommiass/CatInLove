package com.grino.catinlove;

import android.content.Context;

public class MyApp extends android.app.Application {

    private static MyApp instance;

    public MyApp() {
        instance = this;
    }

    public static Context getContextForResources() {
        return instance;
    }

}