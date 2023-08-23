package com.iaustin.ggsapi.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iaustin.ggsapi.model.Category;
import com.iaustin.ggsapi.rest.dto.CategoryDto;

@SpringBootTest
public class CategoryMapperImplTest {

    @Autowired
    private CategoryMapperImpl categoryMapperImpl;

    @Test
    void testToCategoryDto() {
        Category cat = new Category();
        cat.setId(1L);
        cat.setName("testCat");
        cat.setParentId(1L);
        cat.setRank(1);
        CategoryDto catDto = new CategoryDto(cat.getId(), cat.getName(), cat.getParentId(), cat.getRank());
        CategoryDto implDto = categoryMapperImpl.toCategoryDto(cat);
        assertEquals(catDto, implDto);
    }

    public void runTests() {
        System.out.println("Running CategoryMapperImplTest...");
        testToCategoryDto();
        System.out.println("CategoryMapperImplTest complete.");
    }
}
