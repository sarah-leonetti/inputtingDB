package com.iaustin.ggsapi.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iaustin.ggsapi.model.User;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void saveTest() {
        // Create a user
        User user = new User("test", "test", "test", "test", "test", "test", null, "test");
        user.setId(1L);
        // Save the user
        User savedUser = userRepository.save(user);
        // Display successful save
        System.out.println("Saved user: " + savedUser.toString());
    }

    // @Test
    // void updateTest() {
    //     System.out.println("updateTest");
    //     // Find user
    //     User user = userRepository.findById(1L).get();
    //     // Update user
    //     user.setName("test2");
    //     user.setUsername("test2");
    //     user.setPassword("test2");
    //     user.setEmail("test2");
    //     user.setRole("test2");
    //     user.setProviderId("test2");
    //     // Save updated user
    //     User savedUser = userRepository.save(user);
    //     // Display updated user
    //     System.out.println("Saved User: " + savedUser.toString());
    // }

    // @Test
    // void findByIdTest() {
    //     System.out.println("findByIdTest");
    //     // Find user
    //     User user = userRepository.findById(1L).get();
    //     // Display user
    //     System.out.println("Found User: " + user.toString());
    // }

    @Test
    void saveAllTest() {
        System.out.println("saveAllTest");
        // Create a user
        User user2 = new User("test2", "test2", "test2", "test2", "test2", "test2", null, "test2");
        user2.setId(2L);
        // Create a user
        User user3 = new User("test3", "test3", "test3", "test3", "test3", "test3", null, "test3");
        user3.setId(3L);
        // Save the categories
        Iterable<User> savedCategories = userRepository
                .saveAll(java.util.Arrays.asList(user2, user3));
        // User savedCategories =
        // userRepository.saveAll(List.of(user2,
        // user3));
        // Display successful save
        System.out.println("Saved Categories: " + savedCategories.toString());
    }

    @Test
    void findAllTest() {
        System.out.println("findAllTest");
        // Find all categories
        Iterable<User> categories = userRepository.findAll();
        // Display categories
        System.out.println("Found Categories: " + categories.toString());
    }

    @Test
    void deleteByIdTest() {
        System.out.println("deleteByIdTest");
        // Find user
        User user = userRepository.findById(1L).get();
        // Delete user
        userRepository.deleteById(user.getId());
        // Display successful delete
        System.out.println("Deleted User: " + userRepository.existsById(user.getId()));
    }

    @Test
    void deleteTest() {
        System.out.println("deleteTest");
        // Find user
        User user = userRepository.findById(2L).get();
        // Delete user
        userRepository.delete(user);
        // Display successful delete
        System.out.println("Deleted User: " + userRepository.existsById(user.getId()));
    }

    @Test
    void testExistsByEmail() {

    }

    @Test
    void testExistsByUsername() {

    }

    @Test
    void testFindByEmail() {

    }

    @Test
    void testFindByUsername() {

    }

    public void runTests() {
        System.out.println("Running UserRepository tests...");
        saveTest();
        // updateTest();
        // findByIdTest();
        saveAllTest();
        findAllTest();
        deleteByIdTest();
        deleteTest();
        testExistsByEmail();
        testExistsByUsername();
        testFindByEmail();
        testFindByUsername();
        System.out.println("UserRepository tests complete.");
    }
}
