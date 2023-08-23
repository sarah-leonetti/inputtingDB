package com.iaustin.ggsapi.mapper;

/**
 * This class is used to run all tests for the Mapper layer of the database.
 */
public class MapperTest {
    public void runTests() {
        CategoryMapperImplTest categoryMapperImplTest = new CategoryMapperImplTest();
        categoryMapperImplTest.runTests();
        System.out.println();
        EducationItemMapperImplTest educationItemMapperImplTest = new EducationItemMapperImplTest();
        educationItemMapperImplTest.runTests();
        System.out.println();
        UserMapperImplTest userMapperImplTest = new UserMapperImplTest();
        userMapperImplTest.runTests();
        System.out.println();
    }
}
