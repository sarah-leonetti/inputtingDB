package com.iaustin.ggsapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iaustin.ggsapi.model.EducationItem;
import com.iaustin.ggsapi.repository.EducationItemRepository;

@SpringBootTest
public class EducationItemServiceImplTest {

    @Autowired
    private EducationItemServiceImpl educationItemServiceImpl;
    private EducationItemRepository educationItemRepository;

    @Test
    void testGetEducationItem() {
        List<EducationItem> eduItems = educationItemServiceImpl.getEducationItems();
        List<EducationItem> eduItemsRepo = educationItemRepository.findAll();
        assertEquals(eduItems, eduItemsRepo);
    }

    @Test
    void testSaveEducationItems() {
        EducationItem eduItem = new EducationItem();
        eduItem.setName("testSave");
        EducationItem eduItemSaved = educationItemRepository.save(eduItem);
        assertEquals(eduItem, eduItemSaved);
    }

    @Test
    void testDeleteEducationItem() {
        EducationItem eduItem = new EducationItem();
        eduItem.setName("testDel");
        educationItemRepository.delete(eduItem);
        System.out.println("EducationItem deleted: " + educationItemRepository.existsById(eduItem.getId()));
    }

    public void runTests() {
        System.out.println("Running EducationItemServiceImpl tests...");
        testGetEducationItem();
        testSaveEducationItems();
        testDeleteEducationItem();
        System.out.println("EducationItemServiceImpl tests complete.");
    }
}
