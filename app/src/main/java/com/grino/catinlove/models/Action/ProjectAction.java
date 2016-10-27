package com.grino.catinlove.models.Action;

public class ProjectAction
        extends Action{

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
