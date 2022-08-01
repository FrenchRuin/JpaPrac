package com.example.jpa.bookmanager.service;

import com.example.jpa.bookmanager.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @DisplayName("1. test ")
    @Test
    void test_1(){
        userService.put();


        userRepository.findAll().forEach(System.out::println);
    }


}