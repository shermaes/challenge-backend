package com.sofkau.toDo.models.dtopattern;

import lombok.Data;

import java.io.Serializable;

@Data
public class TaskDTO implements Serializable {

    private Long id;

    private String title;

    private String message;

    private boolean done;

    private Long fkCategoryId;


}
