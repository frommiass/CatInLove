package com.grino.catinlove.controlers;

import android.content.res.Resources;

import com.grino.catinlove.enums.DO;
import com.grino.catinlove.enums.KEY;
import com.grino.catinlove.enums.SEQUENCE_TYPE;
import com.grino.catinlove.models.Action.KeySeq;
import com.grino.catinlove.models.Action.Project;
import com.grino.catinlove.models.Action.Sequence;
import com.grino.catinlove.models.Action.SequenceActions;

import java.util.ArrayList;
import java.util.EnumMap;

public class ProjectsTable {

    private Resources res;

    EnumMap<DO, SequenceActions> activate = new EnumMap<>(DO.class);
    EnumMap<DO, SequenceActions> run = new EnumMap<>(DO.class);
    EnumMap<DO, SequenceActions> effect = new EnumMap<>(DO.class);

    public ProjectsTable(Resources res) {
        this.res = res;

        fillTable();
    }

    public void fillTable(){
        Sequence sProb1 = new Sequence(SEQUENCE_TYPE.CONSTANT, 1);
        Sequence sProb2 = new Sequence(SEQUENCE_TYPE.LINEAR_DEPENDENCE, -100, 3500);

        Sequence seqExp1 = new Sequence(SEQUENCE_TYPE.LINEAR_DEPENDENCE, -1, 1);
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
        activate.put(d, getSequenceActions(d, sProb, new KeySeq(k1, s1)));
    }
    public void setRun(DO d, Sequence sProb, KEY k1, Sequence s1){
        run.put(d, getSequenceActions(d, sProb, new KeySeq(k1, s1)));
    }
    public void setEffect(DO d, Sequence sProb, KEY k1, Sequence s1){
        effect.put(d, getSequenceActions(d, sProb, new KeySeq(k1, s1)));
    }

    public SequenceActions getSequenceActions(DO d, Sequence sProb, KeySeq s1){
        SequenceActions actions = new SequenceActions(res.getStringArray(d.getStringsID()));
        actions.setIcons(res, d);
        actions.setProbability(sProb);
        actions.setSequence(s1.getKey(), s1.getValue());

        if (d == DO.CREATE) actions.createTrapList();
        else    actions.createActionList();

        return actions;
    }

    public ArrayList<Project> getProjectsList(){
        return null;
    }
}
