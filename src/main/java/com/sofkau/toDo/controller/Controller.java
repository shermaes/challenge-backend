package com.sofkau.toDo.controller;

import com.sofkau.toDo.models.entity.Category;
import com.sofkau.toDo.models.entity.Task;
import com.sofkau.toDo.service.CategoryServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class Controller {

    @Autowired
    private CategoryServiceDAO service;

    @GetMapping("get/categories")
    public List<Category> getAllCategories() {
        return service.findAllCategories();
    }

    @PostMapping("save/category")
    public Category createCategory(@RequestBody Category category) {
        return service.createCategory(category);
    }

    @PostMapping("save/task")
    public Category createTask(@RequestBody Task task) {
        return service.createTask(task);
    }

    //update not working as it should
    @PutMapping("update/task")
    public Category updateTask(@RequestBody Task task){return service.updateTask(task);}

    @DeleteMapping("delete/category")
    public void deleteCategory(@RequestBody Category category) {
        service.deleteCategory(category);
    }

    @DeleteMapping("delete/task")
    public void deleteTask(@RequestBody Task task) {
        service.deleteTask(task);
    }
}
