package com.grino.catinlove.models.Action;

import java.util.ArrayList;

public class Projects
        extends ArrayList<Project>{

    private SequenceActions s1;
    private SequenceActions s2;
    private SequenceActions s3;

    private int count;

    public Projects(SequenceActions s1, SequenceActions s2, SequenceActions s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;

        count = s1.getCount();
        if (s2.getCount()<count) count=s2.getCount();
        if (s3.getCount()<count) count=s3.getCount();

        for (int i=0; i<count; i++){
            add(new Project(s1.get(i), s2.get(i), s3.get(i)));
        }
    }


}
