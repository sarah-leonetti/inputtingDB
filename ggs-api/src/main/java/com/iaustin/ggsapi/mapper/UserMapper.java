package com.iaustin.ggsapi.mapper;

import com.iaustin.ggsapi.model.User;
import com.iaustin.ggsapi.rest.dto.UserDto;

public interface UserMapper {

    UserDto toUserDto(User user);
}