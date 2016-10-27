package com.grino.catinlove;

import android.content.Context;

import com.grino.catinlove.controlers.Game;

public class MyApp extends android.app.Application {

    private static MyApp instance;
    public MyApp() {
        instance = this;
    }
    public static Context getContextForResources() {
        return instance;
    }

    private static Game game = null;
    public static Game getGame() {
        if (game == null) {
            game = new Game(getContextForResources());
        }
        return game;
    }
}