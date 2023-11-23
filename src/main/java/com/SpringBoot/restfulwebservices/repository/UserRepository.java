package com.SpringBoot.restfulwebservices.repository;


import com.SpringBoot.restfulwebservices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
