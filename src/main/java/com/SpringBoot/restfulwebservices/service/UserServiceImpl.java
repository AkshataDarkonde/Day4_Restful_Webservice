package com.SpringBoot.restfulwebservices.service;

import com.SpringBoot.restfulwebservices.entity.User;
import com.SpringBoot.restfulwebservices.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
