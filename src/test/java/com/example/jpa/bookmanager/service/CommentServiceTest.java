package com.example.jpa.bookmanager.service;

import com.example.jpa.bookmanager.repository.CommentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentServiceTest {

    @Autowired
    private CommentService commentService;
    @Autowired
    private CommentRepository commentRepository;

    @DisplayName("1. commentTest")
    @Test
    void test_1(){
        commentService.init();

//        commentRepository.findAll().forEach(System.out::println);

        commentService.updateSomething();
//        commentService.insertSomething();

    }

}