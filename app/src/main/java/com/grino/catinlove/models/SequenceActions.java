package com.grino.catinlove.models;

import android.content.res.Resources;

import com.grino.catinlove.enums.DO;
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

    private ArrayList<Integer> icons = new ArrayList<>();
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

    public void setIcons(Resources res, DO d){
        this.placeholder = DO.ERROR.getDrawableName();
        for (int i=1; i<=count; i++) {
            String name = res.getString(d.getDrawableName()) + getPrefix(i);
            int id = res.getIdentifier(name, "drawable", res.getResourcePackageName(placeholder));
            if (id == 0)
                id = placeholder;
            icons.add(id);
        }
    }

    private int getIcon(int i){
        if (i < icons.size())
            return icons.get(i);
        else return placeholder;
    }

    private String getPrefix(int i){
        String prefix = "_";
        if(i < 10) prefix = prefix + "0";
        return prefix + i;
    }
}

