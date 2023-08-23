package com.iaustin.ggsapi.repository;

/**
 * This class is used to run all tests for the Repository layer of the database.
 */
public class RepositoryTest {
    public void runTests() {
        CategoryRepositoryTest categoryRepositoryTest = new CategoryRepositoryTest();
        categoryRepositoryTest.runTests();
        System.out.println();
        EducationItemRepositoryTest educationItemRepositoryTest = new EducationItemRepositoryTest();
        educationItemRepositoryTest.runTests();
        System.out.println();
        UserRepositoryTest userRepositoryTest = new UserRepositoryTest();
        userRepositoryTest.runTests();
        System.out.println();
    }
}
