package com.sofkau.toDo.models.dtopattern;

import com.sofkau.toDo.models.entity.Task;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class CategoryDTO implements Serializable {

    private Long id;

    private String name;

    private List<Task> tasks = new ArrayList<>();


}
