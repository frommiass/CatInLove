package com.grino.catinlove;

import android.content.Context;
import android.util.Log;

public class Action
        implements Nameable{

    private Context ctx;
    private String name;
    private int iconID;

    private int experience;
    public Resources resources;
    public Indicators indicators;

    public Action(Context ctx, String name, int experience, Resources resources, Indicators indicators) {
        this.ctx = ctx;
        this.name = name;
        this.experience = experience;
        this.resources = resources;
        this.indicators = indicators;
    }

    public Action(Context ctx, String name, boolean physical){
        this.ctx = ctx;
        this.name = name;
        this.experience = 0;
        this.resources = new Resources(ctx);
        this.indicators = new Indicators(ctx, physical);
    }

    @Override
    public String getName() {
        return name;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setResources(Resources resources) {
        this.resources = resources;
    }

    public void setIndicators(Indicators indicators) {
        this.indicators = indicators;
    }

    public void add(Action action){
        Log.d("Grino", this.toString());
        Log.d("Grino", action.toString());
        experience = experience + action.experience;
        resources.add(action.resources);
        indicators.add(action.indicators);
    }

    @Override
    public String toString() {
        return "Action[" +
                "name='" + name + '\'' +
                ", exp=" + experience + " - " +
                resources.toString() + " - " +
                indicators.toString() + " - " +
                ']';
    }

    public String getDescription() {
        return "Опыт=" + experience + ", " +
                resources.getDescription() + ", " +
                indicators.getDescription();
    }

    public void set(int key, int value){
        if (Indicators.isIndicatorsKey(key))
            indicators.set(key, value);
        if (Resources.isResourcesKey(key))
            resources.set(key, value);
    }

    public Integer get(int key){
        if (Indicators.isIndicatorsKey(key))
            return indicators.get(key).get();
        if (Resources.isResourcesKey(key))
            return indicators.get(key).get();
        return null;
    }

    public int getIconID() {
        return iconID;
    }

    public void setIconID(int iconID) {
        this.iconID = iconID;
    }
}
