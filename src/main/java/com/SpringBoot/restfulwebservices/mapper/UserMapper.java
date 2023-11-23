package com.SpringBoot.restfulwebservices.mapper;

import com.SpringBoot.restfulwebservices.dto.UserDto;
import com.SpringBoot.restfulwebservices.entity.User;

public class UserMapper {

//    To convert user JPA into userDto
    public  static UserDto mapToUserDto(User user){
        UserDto userDto= new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
        return userDto;
    }

//    To convert UserDto into user JPA entity
    public static User mapToUser(UserDto userDto){
        User user = new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );
        return user;
    }
}
