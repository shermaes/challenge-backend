package com.sofkau.toDo.service;

import com.sofkau.toDo.models.dtopattern.CategoryDTO;
import com.sofkau.toDo.models.entity.Category;
import com.sofkau.toDo.models.entity.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    CategoryDTO createCategory(Category category);

    CategoryDTO createTask(Task task);

    CategoryDTO updateTask(Task task);

    void deleteCategory(Long id);

    void deleteTask(Long id);

    List<CategoryDTO> findAllCategories();
}
