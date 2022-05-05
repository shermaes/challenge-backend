package com.sofkau.toDo.service;

import com.sofkau.toDo.models.entity.Category;
import com.sofkau.toDo.models.entity.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryServiceDAO {

    Category createCategory(Category category);

    Category createTask(Task task);

    Category updateTask(Task task);

    void deleteCategory(Category category);

    void deleteTask(Task task);

    List<Category> findAllCategories();
}
