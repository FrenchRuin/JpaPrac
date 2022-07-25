package com.example.jpa.bookmanager.repository;

import com.example.jpa.bookmanager.domain.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @DisplayName("1. BookTest")
    @Test
    void test_1(){

        Book book = new Book();
        book.setName("JPA 초격차 패키지");
        book.setAuthor("패스트캠퍼스");

        bookRepository.save(book);

        System.out.println(bookRepository.findAll());

    }

}