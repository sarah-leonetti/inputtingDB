package com.iaustin.ggsapi.service;

import com.iaustin.ggsapi.exception.CategoryNotFoundException;
import com.iaustin.ggsapi.model.Category;
import com.iaustin.ggsapi.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category validateAndGetCategory(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(String.format("Category with id %s not found", id)));
    }

    @Override
    public List<Category> getCategories() {
        return getCategories(1L);
    }

    @Override

    public List<Category> getCategories(Long ParentId) {
        return categoryRepository.findByParentIdOrderByRankAsc(ParentId);
    }

    @Override
    public Category saveCategory(Category cat) {
        return categoryRepository.save(cat);
    }

    @Override
    public void deleteCategory(Category cat) {
        categoryRepository.delete(cat);
    }
}
