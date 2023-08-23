package com.iaustin.ggsapi.mapper;

import com.iaustin.ggsapi.model.Category;
import com.iaustin.ggsapi.rest.dto.CreateCategoryRequest;
import com.iaustin.ggsapi.rest.dto.CategoryDto;
import org.springframework.stereotype.Service;

@Service
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public Category createToCategory(CreateCategoryRequest createCategoryRequest) {
        if (createCategoryRequest == null) {
            return null;
        }
        Category cat = new Category();
        cat.setName(createCategoryRequest.getName());
        cat.setParentId(createCategoryRequest.getParentId());
        cat.setRank(createCategoryRequest.getRank());

        return cat;
    }

    @Override
    public CategoryDto toCategoryDto(Category category) {
        if (category == null) {
            return null;
        }
        return new CategoryDto(category.getId(), category.getName(), category.getParentId(), category.getRank());
    }
}
