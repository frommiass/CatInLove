package com.grino.catinlove.controlers;

import android.content.res.Resources;

import com.grino.catinlove.enums.DO;
import com.grino.catinlove.enums.KEY;
import com.grino.catinlove.enums.SEQUENCE_TYPE;
import com.grino.catinlove.models.Action.Projects;
import com.grino.catinlove.models.Action.Sequence;
import com.grino.catinlove.models.Action.SequenceActions;

import java.util.EnumMap;

public class ProjectsTable {

    private Resources res;

    EnumMap<DO, SequenceActions> activate = new EnumMap<>(DO.class);
    EnumMap<DO, SequenceActions> run = new EnumMap<>(DO.class);
    EnumMap<DO, SequenceActions> effect = new EnumMap<>(DO.class);

    EnumMap<DO, Projects> projects = new EnumMap<>(DO.class);

    public ProjectsTable(Resources res) {
        this.res = res;

        fillTable();
        for (DO d: DO.getAll())
            projects.put(d, new Projects(
                    activate.get(d),
                    run.get(d),
                    effect.get(d)
            ));
    }

    public void fillTable(){
        Sequence sProb1 = new Sequence(SEQUENCE_TYPE.CONSTANT, 1);
        Sequence sProb2 = new Sequence(SEQUENCE_TYPE.LINEAR_DEPENDENCE, -100, 3500);
        Sequence sProb3 = new Sequence(SEQUENCE_TYPE.CONSTANT, (int) 0.5);

        Sequence seqExp1 = new Sequence(SEQUENCE_TYPE.LINEAR_DEPENDENCE, -5, 0);
        Sequence seqExp2 = new Sequence(SEQUENCE_TYPE.LINEAR_DEPENDENCE, 1, 0);

        Sequence seqFood1 = new Sequence(SEQUENCE_TYPE.LINEAR_DEPENDENCE, -5, 0);
        Sequence seqFood2 = new Sequence(SEQUENCE_TYPE.NUMBERS);

        Sequence seqInd = new Sequence(SEQUENCE_TYPE.LINEAR_DEPENDENCE, 4, 88);

        setActivate(DO.PLAY,   sProb1, KEY.EXP, seqExp1);
        setActivate(DO.EAT,    sProb1, KEY.EXP, seqExp1);
        setActivate(DO.RELAX,  sProb1, KEY.EXP, seqExp1);
        setActivate(DO.HUNT,   sProb1, KEY.FOOD, seqExp1);
        setActivate(DO.CREATE, sProb1, KEY.FOOD, seqExp1);

        setRun(DO.PLAY,   sProb2, KEY.EXP,    seqExp2);
        setRun(DO.EAT,    sProb2, KEY.EXP,    seqExp2);
        setRun(DO.RELAX,  sProb2, KEY.EXP,    seqExp2);
        setRun(DO.HUNT,   sProb1, KEY.FOOD,   seqFood1);
        setRun(DO.CREATE, sProb1, KEY.FOOD,   seqFood1);

        setEffect(DO.PLAY,   sProb1, KEY.MOOD,    seqInd);
        setEffect(DO.EAT,    sProb1, KEY.SATIETY, seqInd);
        setEffect(DO.RELAX,  sProb1, KEY.ENERGY,  seqInd);
        setEffect(DO.HUNT,   sProb1, KEY.FOOD,    seqFood2);
        setEffect(DO.CREATE, sProb1, KEY.FOOD,    seqFood2);
    }

    public void setActivate(DO d, Sequence sProb, KEY k1, Sequence s1){
        int count = res.getStringArray(d.getStringsID()).length;
        SequenceActions actions = new SequenceActions(res.getString(d.getActivateID()), count);
        actions.setIcons(d.getIconID());
        actions.setProbability(sProb);
        actions.setSequence(k1, s1);

        if (d == DO.CREATE) actions.createTrapList();
        else    actions.createActionList();

        activate.put(d, actions);
    }
    public void setRun(DO d, Sequence sProb, KEY k1, Sequence s1){
        String[] names = res.getStringArray(d.getStartID());
        SequenceActions actions = new SequenceActions(names);
        actions.setIcons(d.getIconID());
        actions.setProbability(sProb);
        actions.setSequence(k1, s1);

        if (d == DO.CREATE) actions.createTrapList();
        else    actions.createActionList();

        run.put(d, actions);
    }
    public void setEffect(DO d, Sequence sProb, KEY k1, Sequence s1){
        String[] names = res.getStringArray(d.getStringsID());
        SequenceActions actions = new SequenceActions(names);
        actions.setIcons(res, d);
        actions.setProbability(sProb);
        actions.setSequence(k1, s1);

        if (d == DO.CREATE) actions.createTrapList();
        else    actions.createActionList();

        effect.put(d, actions);
    }


    public Projects getProjectsList(DO d){
        return projects.get(d);
    }
}
