package com.iaustin.ggsapi.service;

import com.iaustin.ggsapi.model.Category;

import java.util.List;

public interface CategoryService {
    Category validateAndGetCategory(Long id);

    List<Category> getCategories();

    List<Category> getCategories(Long parent_id);

    Category saveCategory(Category cat);

    void deleteCategory(Category cat);
}
