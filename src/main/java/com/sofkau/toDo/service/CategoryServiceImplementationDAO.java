package com.sofkau.toDo.service;

import com.sofkau.toDo.models.entity.Category;
import com.sofkau.toDo.models.entity.Task;
import com.sofkau.toDo.repository.CategoryRepository;
import com.sofkau.toDo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryServiceImplementationDAO implements CategoryServiceDAO{

@Autowired
private CategoryRepository categoryRepository;

@Autowired
private TaskRepository taskRepository;


    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category createTask(Task task) {
        Category category = categoryRepository.findById(task.getFkCategoryId()).get();
        category.addTask(task);
        taskRepository.save(task);
        return categoryRepository.save(category);
    }

    @Override
    //Check if this works as it should
    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteCategory(Category category) {
        Category categoryToBeDeleted = categoryRepository.findById(category.getId()).get();
        if(categoryToBeDeleted.getTasks().size()>=0){
            categoryToBeDeleted.getTasks().forEach(task -> taskRepository.deleteById(task.getId()));
        }
        categoryRepository.deleteById(category.getId());
    }

    @Override
    public void deleteTask(Task task) {
        taskRepository.deleteById(task.getId());
    }

    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }
}
