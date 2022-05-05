package com.sofkau.toDo.models.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name="Task")
@Table(name="task")
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String message;

    private boolean done;

    private Long fkTaskId;
}
