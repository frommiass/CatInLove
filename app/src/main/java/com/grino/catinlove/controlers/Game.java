package com.grino.catinlove.controlers;

import android.content.Context;

import com.grino.catinlove.enums.DO;
import com.grino.catinlove.rx.RxBus;

public class Game {

    public Context ctx;

    public Game(Context ctx) {
        this.ctx = ctx;
    }

    private Player cat = null;
    public Player getCat() {
        if (cat == null) cat = new Player(ctx, bus);
        return cat;
    }

    private Actions actions = null;
    public Actions getActions() {
        if (actions == null) {
            actions = new Actions(DO.class, ctx.getResources());
        }
        return actions;
    }

    private RxBus bus = null;
    public RxBus getBus() {
        if (bus == null) bus = new RxBus();
        return bus;
    }
}
