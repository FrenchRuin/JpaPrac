package com.example.jpa.bookmanager.service;

import com.example.jpa.bookmanager.domain.User;
import com.example.jpa.bookmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private UserRepository userRepository;


    @Transactional
    public void put() {
        User user = new User();
        user.setName("newUser");
        user.setEmail("newUser@fastcampus.com");

        entityManager.persist(user);
//        entityManager.detach(user);

        user.setName("newUserAfterPersist");
        entityManager.merge(user);
//        entityManager.flush();
//        entityManager.clear();


        User user1 = userRepository.findById(1L).get();
        entityManager.remove(user1);

        user1.setName("marrrrrrrrtin");
        entityManager.merge(user1);

    }


}
