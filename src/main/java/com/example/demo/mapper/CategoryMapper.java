package com.example.demo.mapper;

import com.example.demo.model.Category;
import com.example.demo.rest.dto.course.CategoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(source = "categoryName", target = "name")
    Category categoryDTOtoCategory(CategoryDTO categoryDTO);

}
