package com.grino.catinlove.models.Action;

import lombok.Getter;
import lombok.Setter;

public class ProjectAction {

    @Setter
    Action a1, a2, a3;

    @Getter
    Action action;

    public ProjectAction(Action a1, Action a2, Action a3) {
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;

        action = a1;
    }

    public void Activate(){
        action = a2;
    }

    public void Run(){
        action = a3;
    }

    public void Stop(){
        action = a2;
    }
}
