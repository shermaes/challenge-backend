package com.sofkau.toDo.models.dtopattern;

import com.sofkau.toDo.models.entity.Task;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CategoryDTO implements Serializable {

    private Long id;

    private List<Task> tasks = new ArrayList<>();

    private String title;

    private String message;

    private boolean done;

    private Long fkTaskId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Long getFkTaskId() {
        return fkTaskId;
    }

    public void setFkTaskId(Long fkTaskId) {
        this.fkTaskId = fkTaskId;
    }
}
