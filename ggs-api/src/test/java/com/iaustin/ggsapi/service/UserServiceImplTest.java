package com.iaustin.ggsapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iaustin.ggsapi.model.User;
import com.iaustin.ggsapi.repository.UserRepository;

@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userServiceImpl;
    private UserRepository userRepository;

    @Test
    void testDeleteUser() {
        User user = new User();
        user.setName("testDel");
        userRepository.delete(user);
        System.out.println("User deleted: " + userRepository.existsById(user.getId()));
    }

    @Test
    void testGetUserByEmail() {
        User user = new User();
        user.setEmail("testEmail");
        userRepository.save(user);

        Optional<User> userImpl = userServiceImpl.getUserByEmail(user.getEmail());
        Optional<User> userRepo = userRepository.findByEmail(user.getEmail());

        assertEquals(userImpl, userRepo);
    }

    @Test
    void testGetUserByUsername() {
        User user = new User();
        user.setUsername("testUsername");
        userRepository.save(user);

        Optional<User> userImpl = userServiceImpl.getUserByUsername(user.getUsername());
        Optional<User> userRepo = userRepository.findByUsername(user.getUsername());

        assertEquals(userImpl, userRepo);
    }

    @Test
    void testGetUsers() {
        List<User> userItems = userServiceImpl.getUsers();
        List<User> userItemsRepo = userRepository.findAll();
        assertEquals(userItems, userItemsRepo);
    }

    @Test
    void testHasUserWithEmail() {
        User user = new User();
        user.setEmail("testEmail2");
        userRepository.save(user);

        Boolean userImpl = userServiceImpl.hasUserWithEmail(user.getEmail());
        Boolean userRepo = userRepository.existsByEmail(user.getEmail());

        assertEquals(userImpl, userRepo);
    }

    @Test
    void testHasUserWithUsername() {
        User user = new User();
        user.setUsername("testUsername2");
        userRepository.save(user);

        Boolean userImpl = userServiceImpl.hasUserWithUsername(user.getUsername());
        Boolean userRepo = userRepository.existsByUsername(user.getUsername());

        assertEquals(userImpl, userRepo);
    }

    @Test
    void testSaveUser() {
        User user = new User();
        user.setName("testSave");
        User catItemSaved = userRepository.save(user);
        assertEquals(user, catItemSaved);
    }

    @Test
    void testValidateAndGetUserByUsername() {
        User user = new User();
        user.setUsername("testValidate");
        userRepository.save(user);

        User userValandGetUser = userServiceImpl.validateAndGetUserByUsername(user.getUsername());
        User userByUsername = userServiceImpl.getUserByUsername(user.getUsername()).get();

        assertEquals(userValandGetUser, userByUsername);
    }

    public void runTests() {
        System.out.println("Running UserServiceImpl tests...");
        testDeleteUser();
        testGetUserByEmail();
        testGetUserByUsername();
        testGetUsers();
        testHasUserWithEmail();
        testHasUserWithUsername();
        testSaveUser();
        testValidateAndGetUserByUsername();
        System.out.println("UserServiceImpl tests complete.");
    }
}
