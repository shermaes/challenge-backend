package com.sofkau.toDo.mapper;

import com.sofkau.toDo.models.dtopattern.TaskDTO;
import com.sofkau.toDo.models.entity.Task;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    @Mappings({
            // @Mappings Configures the mappings of several bean attributes.
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "title", target = "title"),
            @Mapping(source = "message", target = "message"),
            @Mapping(source = "done", target = "done"),
            @Mapping(source = "fkCategoryId", target = "fkCategoryId")
    })
    TaskDTO taskDTO(Task task); //sending the values from task to taskDTO
    List<TaskDTO> toTaskDTO(List<Task> tasks);

    @InheritInverseConfiguration
    Task toTask(TaskDTO taskDTO);
}
