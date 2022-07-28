package com.example.jpa.bookmanager.service;

import com.example.jpa.bookmanager.domain.User;
import com.example.jpa.bookmanager.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
@Transactional
public class EntityManagerTest {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private UserRepository userRepository;

    @DisplayName("1. entityManagerTest ")
    @Test
    void test_1(){

        System.out.println(entityManager.createQuery("select u from User u").getResultList());
    }

    @DisplayName("2. cacheFindTest")
    @Test
    void test_2(){

//        System.out.println(userRepository.findById(1L).get());
//        System.out.println(userRepository.findById(1L).get());
//        System.out.println(userRepository.findById(1L).get());

        userRepository.deleteById(1L);

    }

    @DisplayName("3. cacheFindTest2 ")
    @Test
    void test_3(){
        User user = userRepository.findById(1L).get();
        user.setName("marrrrrrrrrrrtin");
        userRepository.save(user);

        System.out.println("--------------------------");

        user.setEmail("marrrrrrrrrrtin@fastcampus.com");
        userRepository.save(user);

        System.out.println(userRepository.findAll());   // select * from user

    }



}
