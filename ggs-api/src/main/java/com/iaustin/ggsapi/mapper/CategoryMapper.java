package com.iaustin.ggsapi.mapper;

import com.iaustin.ggsapi.model.Category;
import com.iaustin.ggsapi.rest.dto.CategoryDto;
import com.iaustin.ggsapi.rest.dto.CreateCategoryRequest;

public interface CategoryMapper {

    Category createToCategory(CreateCategoryRequest createCategoryRequest);
    CategoryDto toCategoryDto(Category category);
}