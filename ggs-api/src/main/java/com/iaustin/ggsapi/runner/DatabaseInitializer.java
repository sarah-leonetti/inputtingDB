package com.iaustin.ggsapi.runner;

import com.iaustin.ggsapi.model.Category;
import com.iaustin.ggsapi.model.User;
import com.iaustin.ggsapi.security.oauth2.OAuth2Provider;
import com.iaustin.ggsapi.security.WebSecurityConfig;
import com.iaustin.ggsapi.service.CategoryService;
import com.iaustin.ggsapi.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class DatabaseInitializer implements CommandLineRunner {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    private final CategoryService categoryService;

    @Override
    public void run(String... args) {
        if (userService.getUsers().isEmpty()) {
            USERS.forEach(user -> {
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                userService.saveUser(user);
            });
        }
        if (categoryService.getCategories().isEmpty()) {
            CATEGORIES.forEach(cat -> {
                categoryService.saveCategory(cat);
            });
        }
        log.info("Database initialized");
    }

    private static final List<User> USERS = Arrays.asList(
            new User("admin", "admin", "Admin", "admin@mycompany.com", WebSecurityConfig.ADMIN, null,
                    OAuth2Provider.LOCAL, "1"),
            new User("user", "user", "User", "user@mycompany.com", WebSecurityConfig.USER, null, OAuth2Provider.LOCAL,
                    "2"));

    private static final List<Category> CATEGORIES = Arrays.asList(
            new Category(1L, "root", 1L, 1),
            new Category(2L, "Device 101", 1L, 1),
            new Category(3L, "Learn The basics", 1L, 2),
            new Category(4L, "IOS", 2L, 1)

    );

}
