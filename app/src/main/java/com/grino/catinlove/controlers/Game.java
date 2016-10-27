package com.grino.catinlove.controlers;

import android.content.Context;

import com.grino.catinlove.rxBus.RxBus;

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

    private ProjectsTable projectsTable = null;
    public ProjectsTable getProjectsTable() {
        if (projectsTable == null) {
            projectsTable = new ProjectsTable(ctx.getResources());
        }
        return projectsTable;
    }

    private RxBus bus = null;
    public RxBus getBus() {
        if (bus == null) bus = new RxBus();
        return bus;
    }
}
