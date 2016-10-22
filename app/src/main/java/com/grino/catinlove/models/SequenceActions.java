package com.grino.catinlove.models;

import com.grino.catinlove.enums.KEY;
import com.grino.catinlove.tools.MapSequences;
import com.grino.catinlove.tools.Sequence;

import java.util.ArrayList;

import lombok.Setter;

public class SequenceActions
        extends ArrayList<Action>{

    @Setter     private MapSequences values = new MapSequences(KEY.class);
    @Setter     Sequence requirement;
    @Setter     Sequence probability;

    private int[] icons;
    private int placeholder;
    private final String[] names;
    private final int count;

    public void fill() {
        Action action;
        for (int i=0; i<count; i++) {
            action = new Action(
                    values.getAction(i),
                    names[i],
                    getIcon(i),
                    new Requirement(requirement.get(i)),
                    (double)probability.get(i)
            );
            add(action);
        }
    }

    public SequenceActions(String[] names) {
        this.names = names;
        count = names.length;
    }

    public void set(KEY key, Sequence v, Sequence r, Sequence p){
        setSequence(key, v);
        setRequirement(r);
        setProbability(p);
    }

    public void setSequence(KEY k, Sequence s){
        values.put(k, s);
    }

    public void setIcons(int[] icons, int placeholder){
        this.icons = icons;
        this.placeholder = placeholder;
    }

    private int getIcon(int i){
        if (i < icons.length)
            return icons[i];
        else return placeholder;
    }
}

