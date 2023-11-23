package com.SpringBoot.restfulwebservices.service;

import com.SpringBoot.restfulwebservices.dto.UserDto;
import com.SpringBoot.restfulwebservices.entity.User;
import com.SpringBoot.restfulwebservices.mapper.UserMapper;
import com.SpringBoot.restfulwebservices.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto userDto) {


        User user= UserMapper.mapToUser(userDto);

//  Convert UserDto into User JPA Entity
//        User user= new User(
//                userDto.getId(),
//                userDto.getFirstName(),
//                userDto.getLastName(),
//                userDto.getEmail()
//        );
        User savedUser = userRepository.save(user);

        UserDto savedUserDto= UserMapper.mapToUserDto(savedUser);

//  Convert User JPA Entity into UserDto
//        UserDto savedUserDto = new UserDto(
//                savedUser.getId(),
//                savedUser.getFirstName(),
//                savedUser.getLastName(),
//                savedUser.getEmail()
//        );
        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long userId) {
        Optional<User> optionalUser=userRepository.findById(userId);
        User user= optionalUser.get();
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> users= userRepository.findAll();
        return users.stream().map(UserMapper::mapToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User existingUser =userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existingUser);
        return UserMapper.mapToUserDto(updatedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

}
