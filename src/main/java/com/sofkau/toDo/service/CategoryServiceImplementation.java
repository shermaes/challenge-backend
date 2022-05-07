package com.sofkau.toDo.service;


import com.sofkau.toDo.models.dtopattern.CategoryDTO;
import com.sofkau.toDo.models.entity.Category;
import com.sofkau.toDo.models.entity.Task;
import com.sofkau.toDo.repository.CategoryRepository;
import com.sofkau.toDo.repository.TaskRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImplementation implements CategoryService {

@Autowired
private CategoryRepository categoryRepository;

@Autowired
private TaskRepository taskRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public CategoryDTO createCategory(Category category) {
        return convertEntityToDTO(categoryRepository.save(category));
    }

    @Override
    public CategoryDTO createTask(Task task) {
        Category category = categoryRepository.findById(task.getFkCategoryId()).get();
        category.addTask(task);
        taskRepository.save(task);
        return  convertEntityToDTO(categoryRepository.save(category));
    }

    @Override
    public CategoryDTO updateTask(Task task) {
        Category category = categoryRepository.findById(task.getFkCategoryId()).get();
        taskRepository.save(task);
        return  convertEntityToDTO(categoryRepository.save(category));
    }

    @Override
    public void deleteCategory(Long id){ categoryRepository.deleteById(id);
    }

    @Override
    public void deleteTask(Long id){ taskRepository.deleteById(id);}

    @Override
    public List<CategoryDTO> findAllCategories() {
        return categoryRepository.findAll().stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    private CategoryDTO convertEntityToDTO(Category category){

        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);

        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO = modelMapper.map(category, CategoryDTO.class);
        return categoryDTO;
    }

    private Category convertDTOToEntity(CategoryDTO categoryDTO){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        Category category = new Category();
        category = modelMapper.map(categoryDTO, Category.class);
        return category;
}
}
