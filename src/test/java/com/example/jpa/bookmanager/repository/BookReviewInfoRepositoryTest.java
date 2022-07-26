package com.example.jpa.bookmanager.repository;

import com.example.jpa.bookmanager.domain.Book;
import com.example.jpa.bookmanager.domain.BookReviewInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookReviewInfoRepositoryTest {

    @Autowired
    private BookReviewInfoRepository bookReviewInfoRepository;
    @Autowired
    private BookRepository bookRepository;

//    @DisplayName("1. CRUD")
//    @Test
//    void test_1() {
//
//
//        BookReviewInfo bookReviewInfo = new BookReviewInfo();
//        bookReviewInfo.setBookId(1L);
//        bookReviewInfo.setAverageReviewScore(4.5f);
//        bookReviewInfo.setReviewCount(2);
//
//        bookReviewInfoRepository.save(bookReviewInfo);
//
//        System.out.println(">>>> " + bookReviewInfoRepository.findAll());
//    }


    @DisplayName("2. CRUD2")
    @Test
    void test_2() {
        givenReviewInfo();

        Book result = (bookReviewInfoRepository.
                findById(1L).
                orElseThrow(RuntimeException::new)
                .getBook());


        System.out.println(">>>> :" + result);

        BookReviewInfo result2 = bookRepository
                .findById(6L)
                .orElseThrow(RuntimeException::new)
                .getBookReviewInfo();

        System.out.println(">>>>> :" + result2);
    }

    private Book givenBook() {

        Book book = new Book();
        book.setName("Jpa 초격차 패키지");
        book.setAuthorId(1L);
//        book.setPublisherId(1L);

        return bookRepository.save(book);
    }

    private void givenReviewInfo() {
        BookReviewInfo bookReviewInfo = new BookReviewInfo();
        bookReviewInfo.setBook(givenBook());
        bookReviewInfo.setAverageReviewScore(4.5f);
        bookReviewInfo.setReviewCount(2);

        bookReviewInfoRepository.save(bookReviewInfo);

        System.out.println(">>>> : " + bookReviewInfoRepository.findAll());
    }

}