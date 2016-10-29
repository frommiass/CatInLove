package com.grino.catinlove.models.Action;

import lombok.Getter;
import lombok.Setter;

public class Project {

    public final static int STATUS_NOT_ACTIVATE = 1;
    public final static int STATUS_ACTIVATE = 2;
    public final static int STATUS_RUN = 3;

    @Getter
    private int status;

    @Setter
    ProjectAction a1, a2, a3;

    @Getter
    ProjectAction action;

    public Project(Action a1, Action a2, Action a3) {
        this.a1 = new ProjectAction(this, a1);
        this.a2 = new ProjectAction(this, a2);
        this.a3 = new ProjectAction(this, a3);

        action = this.a1;
        status = STATUS_NOT_ACTIVATE;
    }

    public void Activate(){
        action = a2;
        status = STATUS_ACTIVATE;
    }

    public void Run(){
        action = a3;
        status = STATUS_RUN;
    }

    public void Stop(){
        action = a2;
        status = STATUS_ACTIVATE;
    }

    public void Next(){
        if (status == STATUS_NOT_ACTIVATE) Run();
        else if (status == STATUS_ACTIVATE) Run();
        else if (status == STATUS_RUN) Stop();
    }
}
