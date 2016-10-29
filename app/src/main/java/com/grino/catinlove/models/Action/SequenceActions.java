package com.grino.catinlove.models.Action;

import android.content.res.Resources;

import com.grino.catinlove.enums.DO;
import com.grino.catinlove.enums.KEY;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

public class SequenceActions
        extends ArrayList<Action>{

    @Setter     private MapSequences values = new MapSequences(KEY.class);
    @Setter     Sequence probability;

    private ArrayList<Integer> icons = new ArrayList<>();
    private int placeholder;
    private final String[] names;

    @Getter
    private final int count;

    public void createActionList() {
        addAll(getActionList());
    }

    public void createTrapList() {
        ArrayList<Action> list = getActionList();
        for (Action a: list)
            add(new TrapIncome(a));
    }

    public ArrayList<Action> getActionList(){
        ArrayList<Action> list = new ArrayList<>();
        Action action;
        for (int i=0; i<count; i++) {
            action = new Action(
                    values.getAction(i),
                    names[i],
                    getIcon(i),
                    probability.getDouble(i)
            );
            list.add(action);
        }
        return list;
    }

    public SequenceActions(String[] names) {
        this.names = names;
        count = names.length;
    }

    public SequenceActions(String name, int count) {
        this.count = count;
        names = new String[count];
        for(int i=0; i<count; i++)
            names[i] = name;
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

    public void setIcons(int id){
        for (int i=1; i<=count; i++) {
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

