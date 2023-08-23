package com.iaustin.ggsapi.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iaustin.ggsapi.model.User;
import com.iaustin.ggsapi.rest.dto.UserDto;

@SpringBootTest
public class UserMapperImplTest {

    @Autowired
    private UserMapperImpl userMapperImpl;

    @Test
    void testToUserDto() {
        User user = new User();
        user.setId(1L);
        user.setUsername("testUser");
        user.setName("testName");
        user.setEmail("testEmail");
        user.setRole("testRole");
        UserDto userDto = new UserDto(user.getId(), user.getUsername(), user.getName(), user.getEmail(),
                user.getRole());
        UserDto implDto = userMapperImpl.toUserDto(user);
        assertEquals(userDto, implDto);
    }

    public void runTests() {
        System.out.println("Running UserMapperImplTest...");
        testToUserDto();
        System.out.println("UserMapperImplTest complete.");
    }
}
