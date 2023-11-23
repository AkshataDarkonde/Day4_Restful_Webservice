package com.SpringBoot.restfulwebservices.service;

import com.SpringBoot.restfulwebservices.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    User getUserById(Long userId);

    List<User> getAllUser();

    User updateUser(User user);

    void deleteUser(Long userId);
}
