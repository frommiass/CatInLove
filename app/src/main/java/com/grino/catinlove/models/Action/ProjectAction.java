package com.grino.catinlove.models.Action;

import lombok.Getter;

public class ProjectAction
        extends Action{

    @Getter
    private Project project;

    public ProjectAction(Project project, Action action) {
        super(action);
        this.project = project;
    }

    @Override
    public void Made(){
        project.Next();
    }
}
