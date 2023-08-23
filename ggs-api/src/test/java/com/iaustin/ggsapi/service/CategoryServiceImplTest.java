package com.iaustin.ggsapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iaustin.ggsapi.model.Category;
import com.iaustin.ggsapi.repository.CategoryRepository;

@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryServiceImpl;
    private CategoryRepository categoryRepository;

    @Test
    void testGetCategory() {
        List<Category> catItems = categoryServiceImpl.getCategories();
        List<Category> catItemsRepo = categoryRepository.findAll();
        assertEquals(catItems, catItemsRepo);
    }

    @Test
    void testSaveCategorys() {
        Category catItem = new Category();
        catItem.setName("testSave");
        Category catItemSaved = categoryRepository.save(catItem);
        assertEquals(catItem, catItemSaved);
    }

    @Test
    void testDeleteCategory() {
        Category catItem = new Category();
        catItem.setName("testDel");
        categoryRepository.delete(catItem);
        System.out.println("Category deleted: " + categoryRepository.existsById(catItem.getId()));
    }

    public void runTests() {
        System.out.println("Running CategoryServiceImpl tests...");
        testGetCategory();
        testSaveCategorys();
        testDeleteCategory();
        System.out.println("CategoryServiceImpl tests complete.");
    }
}
