package com.grino.catinlove;

import android.content.Context;

import com.grino.catinlove.models.Player;
import com.grino.catinlove.rx.RxBus;

public class MyApp extends android.app.Application {

    private static MyApp instance;

    public MyApp() {
        instance = this;
    }

    public static Context getContextForResources() {
        return instance;
    }

    private static RxBus bus = null;
    public static RxBus getBus() {
        if (bus == null) bus = new RxBus();
        return bus;
    }

    private static Player cat = null;
    public static Player getCat() {
        if (cat == null) cat = new Player();
        return cat;
    }


}