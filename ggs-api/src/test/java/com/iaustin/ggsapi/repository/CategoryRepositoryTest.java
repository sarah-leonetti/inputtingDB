package com.iaustin.ggsapi.repository;

//import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ContextConfiguration;

import com.iaustin.ggsapi.model.Category;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Optional;

//@ContextConfiguration(locations = "classpath*:/spring/applicationContext*.xml")
@SpringBootTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void saveTest() {
        System.out.println("saveTest");
        // Create a category
        Category category = new Category();
        category.setId(1L);
        category.setName("test");
        category.setParentId(1L);
        category.setRank(0);
        // Save the category
        Category savedCategory = categoryRepository.save(category);
        // Display successful save
        System.out.println("Saved Category: " + savedCategory.toString());

        // This is what you should use to automatically test
        // Checks if the two things equals eachother
        // https://www.guru99.com/junit-assert.html

        assertEquals(category, savedCategory);

        // UNCOMMENT BELOW TO SEE EXAMPLE OF A FAILED TEST

        // Category category2 = new Category();
        // category2.setId(2L);
        // category2.setName("test");
        // category2.setParentId(2L);
        // category2.setRank(0);

        // assertEquals(category2,savedCategory);

    }

    // @Test
    // void updateTest() {
    // System.out.println("updateTest");
    // // Find category
    // Category category = categoryRepository.findById(1L).get();
    // // Update category
    // category.setName("test2");
    // category.setRank(1);
    // // Save updated category
    // Category savedCategory = categoryRepository.save(category);
    // // Display updated category
    // System.out.println("Saved Category: " + savedCategory.toString());
    // }

    @Test
    void findByIdTest() {
        System.out.println("findByIdTest");
        // Find category
        Optional<Category> categoryOp = categoryRepository.findById(1L);
        Category categoryTest;
        if (categoryOp.isPresent()) {
            categoryTest = categoryOp.get();
            // Display category
            System.out.println("Found Category: " + categoryTest.toString());
        } else {
            // means that the object was not present in the option (did not return a value)
            assertEquals(true, false, "The id that was search for was not present");
        }
    }

    @Test
    void saveAllTest() {
        System.out.println("saveAllTest");
        // Create a category
        Category category2 = new Category();
        category2.setId(2L);
        category2.setName("test2");
        category2.setParentId(null);
        category2.setRank(2);
        // Create a category
        Category category3 = new Category();
        category3.setId(3L);
        category3.setName("test3");
        category3.setParentId(null);
        category3.setRank(3);
        // Save the categories
        Iterable<Category> savedCategories = categoryRepository.saveAll(java.util.Arrays.asList(category2, category3));
        // Category savedCategories = categoryRepository.saveAll(List.of(category2,
        // category3));
        // Display successful save
        System.out.println("Saved Categories: " + savedCategories.toString());
    }

    @Test
    void findAllTest() {
        System.out.println("findAllTest");
        // Find all categories
        Iterable<Category> categories = categoryRepository.findAll();
        // Display categories
        System.out.println("Found Categories: " + categories.toString());
    }

    @Test
    void deleteByIdTest() {
        System.out.println("deleteByIdTest");
        // Find category
        Category category = categoryRepository.findById(1L).get();
        // Delete category
        categoryRepository.deleteById(category.getId());
        // Display successful delete
        System.out.println("Deleted Category: " + categoryRepository.existsById(category.getId()));
    }

    @Test
    void deleteTest() {
        System.out.println("deleteTest");
        // Find category
        Category category = categoryRepository.findById(2L).get();
        // Delete category
        categoryRepository.delete(category);
        // Display successful delete
        System.out.println("Deleted Category: " + categoryRepository.existsById(category.getId()));
    }

    public void runTests() {
        System.out.println("Running CategoryRepository tests...");
        saveTest();
        // updateTest();
        // findByIdTest();
        saveAllTest();
        findAllTest();
        deleteByIdTest();
        deleteTest();
        System.out.println("CategoryRepository tests complete.");
    }
}
