package com.example.jpa.bookmanager.service;

import com.example.jpa.bookmanager.repository.AuthorRepository;
import com.example.jpa.bookmanager.repository.BookRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookServiceTest {

    @Autowired
    private BookService bookService;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @DisplayName("1. transactionTest")
    @Test
    void test_1(){
        try {
            bookService.putBookAndAuthor();

        } catch (RuntimeException e) {
            System.out.println(">>>>> " + e.getMessage());
        }

        System.out.println("books : " + bookRepository.findAll());
        System.out.println("authors : " + authorRepository.findAll());

    }

    @DisplayName("1. converterErrorTest")
    @Test
    void test_5(){
        bookService.getAll();

        bookRepository.findAll().forEach(System.out::println);
    }



}