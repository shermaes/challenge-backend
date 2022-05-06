package com.sofkau.toDo.controller;

import com.sofkau.toDo.models.dtopattern.CategoryDTO;
import com.sofkau.toDo.models.entity.Category;
import com.sofkau.toDo.models.entity.Task;
import com.sofkau.toDo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class Controller {

    @Autowired
    private CategoryService service;

    @GetMapping("get/categories")
    public List<CategoryDTO> getAllCategories() {
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

    @PutMapping("update/task")
    public Category updateTask(@RequestBody Task task){return service.updateTask(task);}

    @DeleteMapping("delete/category/{id}")
    public void deleteCategory(@PathVariable Long id) {
        service.deleteCategory(id);
    }

    @DeleteMapping("delete/task/{id}")
    public void deleteTask(@PathVariable Long id) {
        service.deleteTask(id);}

}
