package com.sofkau.toDo.mapper;

import com.sofkau.toDo.models.dtopattern.CategoryDTO;
import com.sofkau.toDo.models.entity.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses={TaskMapper.class})
//marks the interface as mapping interface and lets the MapStruct processor kick in during compilation.
public interface CategoryMapper {

    @Mappings({
            // @Mappings Configures the mappings of several bean attributes.
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "tasks", target = "tasks")
    })
    CategoryDTO toCategoryDTO(Category category);
    List<CategoryDTO> toCategoryDTO(List<Category> categories);

    @InheritInverseConfiguration
    //Advises the code generator to apply all the Mappings from an inverse mapping method
    //to the annotated method as well. An inverse mapping method is a method which has the
    //annotated method's source type as target and the annotated method's target type as source type.
    Category toCategory(CategoryDTO categoryDTO);
}
