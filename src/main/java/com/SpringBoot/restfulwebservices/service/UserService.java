package com.SpringBoot.restfulwebservices.service;

import com.SpringBoot.restfulwebservices.dto.UserDto;
import com.SpringBoot.restfulwebservices.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);

    UserDto getUserById(Long userId);

    List<UserDto> getAllUser();

    UserDto updateUser(UserDto user);

    void deleteUser(Long userId);
}
