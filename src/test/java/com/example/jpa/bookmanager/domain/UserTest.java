package com.example.jpa.bookmanager.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void test() {
        User user = new User();
        user.setEmail("toxic023@naver.com");
        user.setName("LJC");

        System.out.println(">>>> " + user );

    }

}