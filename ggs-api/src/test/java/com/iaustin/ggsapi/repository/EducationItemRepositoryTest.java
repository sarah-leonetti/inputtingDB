package com.iaustin.ggsapi.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iaustin.ggsapi.model.EducationItem;

@SpringBootTest
public class EducationItemRepositoryTest {

    @Autowired
    private EducationItemRepository educationItemRepository;

    @Test
    void saveTest() {
        // Create a EducationItem
        EducationItem educationItem = new EducationItem();
        educationItem.setId(1L);
        educationItem.setName("test");
        //educationItem.setCategoryId("SCAMS");
        // Save the EducationItem
        EducationItem savedEducationItem = educationItemRepository.save(educationItem);
        // Display successful save
        System.out.println("Saved EducationItem: " + savedEducationItem.toString());
    }

    // @Test
    // void updateTest() {
    //     System.out.println("updateTest");
    //     // Find educationItem
    //     EducationItem educationItem = educationItemRepository.findById(1L).get();
    //     // Update educationItem
    //     educationItem.setName("test2");
    //     // Save updated educationItem
    //     EducationItem savedEducationItem = educationItemRepository.save(educationItem);
    //     // Display updated educationItem
    //     System.out.println("Saved EducationItem: " + savedEducationItem.toString());
    // }

    // @Test
    // void findByIdTest() {
    //     System.out.println("findByIdTest");
    //     // Find educationItem
    //     EducationItem educationItem = educationItemRepository.findById(1L).get();
    //     // Display educationItem
    //     System.out.println("Found EducationItem: " + educationItem.toString());
    // }

    @Test
    void saveAllTest() {
        System.out.println("saveAllTest");
        // Create a educationItem
        EducationItem educationItem2 = new EducationItem();
        educationItem2.setId(2L);
        educationItem2.setName("test2");
      //  educationItem2.setCategoryId(2L);
        // Create a educationItem
        EducationItem educationItem3 = new EducationItem();
        educationItem3.setId(3L);
        educationItem3.setName("test3");
       // educationItem3.setCategoryId(3L);
        // Save the categories
        Iterable<EducationItem> savedCategories = educationItemRepository
                .saveAll(java.util.Arrays.asList(educationItem2, educationItem3));
        // EducationItem savedCategories =
        // educationItemRepository.saveAll(List.of(educationItem2,
        // educationItem3));
        // Display successful save
        System.out.println("Saved Categories: " + savedCategories.toString());
    }

    @Test
    void findAllTest() {
        System.out.println("findAllTest");
        // Find all categories
        Iterable<EducationItem> categories = educationItemRepository.findAll();
        // Display categories
        System.out.println("Found Categories: " + categories.toString());
    }

    @Test
    void deleteByIdTest() {
        System.out.println("deleteByIdTest");
        // Find educationItem
        EducationItem educationItem = educationItemRepository.findById(1L).get();
        // Delete educationItem
        educationItemRepository.deleteById(educationItem.getId());
        // Display successful delete
        System.out.println("Deleted EducationItem: " + educationItemRepository.existsById(educationItem.getId()));
    }

    @Test
    void deleteTest() {
        System.out.println("deleteTest");
        // Find educationItem
        EducationItem educationItem = educationItemRepository.findById(2L).get();
        // Delete educationItem
        educationItemRepository.delete(educationItem);
        // Display successful delete
        System.out.println("Deleted EducationItem: " + educationItemRepository.existsById(educationItem.getId()));
    }

    public void runTests() {
        System.out.println("Running EducationItemRepository tests...");
        saveTest();
        // updateTest();
        // findByIdTest();
        saveAllTest();
        findAllTest();
        deleteByIdTest();
        deleteTest();
        System.out.println("EducationItemRepository tests complete.");
    }
}
