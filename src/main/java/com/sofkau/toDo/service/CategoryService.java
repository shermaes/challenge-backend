package com.sofkau.toDo.service;

import com.sofkau.toDo.models.dtopattern.CategoryDTO;
import com.sofkau.toDo.models.entity.Category;
import com.sofkau.toDo.models.entity.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    Category createCategory(Category category);

    Category createTask(Task task);

    Category updateTask(Task task);

    void deleteCategory(Long id);

    void deleteTask(Long id);

    List<CategoryDTO> findAllCategories();
}
