package com.example.jpa.bookmanager.repository;

import com.example.jpa.bookmanager.domain.Address;
import com.example.jpa.bookmanager.domain.Gender;
import com.example.jpa.bookmanager.domain.User;
import com.example.jpa.bookmanager.domain.UserHistory;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

@SpringBootTest
@Transactional
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserHistoryRepository userHistoryRepository;

    @Autowired
    private EntityManager entityManager;

    @DisplayName("1. CRUD ")
    @Test
    @Transactional
    void crud() {

        userRepository.save(new User("david", "david@fastcampus.com"));

        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);

        user.setEmail("martin-update@fastcampus.com");

        userRepository.save(user);

    }

    @DisplayName("2. select")
    @Test
    void test_2() {

        System.out.println(userRepository.findByName("dennis"));

        System.out.println("findByEmail : " + userRepository.findByEmail("martin@fastcampus.com"));
        System.out.println("getByEmail : " + userRepository.getByEmail("martin@fastcampus.com"));
        System.out.println("readByEmail : " + userRepository.readByEmail("martin@fastcampus.com"));
        System.out.println("queryByEmail : " + userRepository.queryByEmail("martin@fastcampus.com"));
        System.out.println("searchByEmail : " + userRepository.searchByEmail("martin@fastcampus.com"));
        System.out.println("streamByEmail : " + userRepository.streamByEmail("martin@fastcampus.com"));
        System.out.println("findUserByEmail : " + userRepository.findUserByEmail("martin@fastcampus.com"));

        System.out.println("findSomethingByEmail : " + userRepository.findSomethingByEmail("martin@fastcampus.com"));
    }

    @DisplayName("3. insertAndUpdate")
    @Test
    void test_3() {

        User user = new User();

        user.setName("martin");
        user.setEmail("martin2@fastcampus.com");

        userRepository.save(user);

        User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);

        user2.setName("marrrrrtin");

        userRepository.save(user2);
    }

//    @DisplayName("4. ENUM")
//    @Test
//    void test_4() {
//        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
//        user.setGender(Gender.MALE);
//
//        userRepository.save(user);
//
//        userRepository.findAll().forEach(System.out::println);
//
//        System.out.println(userRepository.findRowRecord().get("gender"));
//    }

    @DisplayName("listner test")
    @Test
    void test_6() {
        User user = new User();
        user.setEmail("martin2@fastcampus.com");
        user.setName("martin");

        userRepository.save(user);

        User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user2.setName("marrrrrtin");
        userRepository.save(user2);

        userRepository.deleteById(4L);
    }


    @DisplayName("5. prePersistTest")
    @Test
    void test_5() {

        User user = new User();
        user.setEmail("martin2@fastcampus.com");
        user.setName("martin");
//        user.setCreatedAt(LocalDateTime.now());
//        user.setUpdatedAt(LocalDateTime.now());

        userRepository.save(user);

        System.out.println(userRepository.findByEmail("martin2@fastcampus.com"));

    }

    @DisplayName("preUpdateTest ")
    @Test
    void test_8() {
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);

        System.out.println("as-is : " + user);

        user.setName("martin22");
        userRepository.save(user);

        System.out.println("to be : " + userRepository.findAll().get(0));

    }

    @DisplayName("5. userHistoryTest")
    @Test
    void userHistoryTest() {
        User user = new User();
        user.setEmail("martin-new@fastcampus.com");
        user.setName("martin-new");
        userRepository.save(user);

        user.setName("martin-new-new");

        userRepository.save(user);

        userHistoryRepository.findAll().forEach(System.out::println);
    }


//    @DisplayName("2. userRelationTest")
//    @Test
//    void userRelationTest() {
//        User user = new User();
//        user.setName("david");
//        user.setEmail("david@fastcampus.com");
//        user.setGender(Gender.MALE);
//
//        userRepository.save(user);
//
//        user.setName("daniel");
//        userRepository.save(user);
//
//        user.setEmail("daniel@fastcampus.com");
//        userRepository.save(user);
//
//        userHistoryRepository.findAll().forEach(System.out::println);
//
//
//        List<UserHistory> result = userRepository.findByEmail("daniel@fastcampus.com").getUserHistories();
//
//        result.forEach(System.out::println);
//
//        System.out.println("UserHistory getUSer() :" + userHistoryRepository.findAll().get(0).getUser());
//    }




    @DisplayName("1. embedTest")
    @Test
    void test_1(){
        userRepository.findAll().forEach(System.out::println);

        User user = new User();
        user.setName("steve");
        user.setHomeAddress(new Address("서울시", "강서구", "우장산로2길 25", "763487"));
        user.setCompanyAddress(new Address("서울시", "마곡동", "퀸즈파크A동", "347894"));

        userRepository.save(user);

        User user1 = new User();
        user1.setName("joshua");
        user1.setHomeAddress(null);
        user1.setCompanyAddress(null);
        userRepository.save(user1);

        User user2 = new User();
        user2.setName("jordan");
        user2.setHomeAddress(new Address());
        user2.setCompanyAddress(new Address());
        userRepository.save(user2);

//        entityManager.clear();

        userRepository.findAll().forEach(System.out::println);
        userHistoryRepository.findAll().forEach(System.out::println);

        userRepository.findAllRawRecord().forEach(a -> System.out.println(a.values()));

        assertAll(
                () -> assertThat(userRepository.findById(7L).get().getHomeAddress()).isNull(),
                () -> assertThat(userRepository.findById(8L).get().getHomeAddress()).isInstanceOf(Address.class)
        );
    }

}