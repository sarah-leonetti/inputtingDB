package com.iaustin.ggsapi.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iaustin.ggsapi.model.EducationItem;
import com.iaustin.ggsapi.rest.dto.EducationItemDto;

@SpringBootTest
public class EducationItemMapperImplTest {

    @Autowired
    private EducationItemMapperImpl educationItemMapperImpl;

    @Test
    void testToEducationItemDto() {
        EducationItem edu = new EducationItem();
        edu.setId(1L);
        edu.setName("testEdu");
       // edu.setType("VIDEO");
        EducationItemDto eduDto = new EducationItemDto(edu.getId(), edu.getName());
        EducationItemDto implDto = educationItemMapperImpl.toEducationItemDto(edu);
        assertEquals(eduDto, implDto);
    }

    public void runTests() {
        System.out.println("Running EducationItemMapperImplTest...");
        testToEducationItemDto();
        System.out.println("EducationItemMapperImplTest complete.");
    }
}
