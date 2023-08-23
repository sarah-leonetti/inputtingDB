package com.iaustin.ggsapi.service;

/**
 * This class is used to run all tests for the Service layer of the database.
 */
public class ServiceTest {
    public void runTests() {
        CategoryServiceImplTest categoryServiceImplTest = new CategoryServiceImplTest();
        categoryServiceImplTest.runTests();
        System.out.println();
        EducationItemServiceImplTest educationItemServiceImplTest = new EducationItemServiceImplTest();
        educationItemServiceImplTest.runTests();
        System.out.println();
        UserServiceImplTest userServiceImplTest = new UserServiceImplTest();
        userServiceImplTest.runTests();
        System.out.println();
    }
}
