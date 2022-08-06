package com.example.jpa.bookmanager.repository;

import com.example.jpa.bookmanager.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface UserRepository extends JpaRepository<User, Long> {

    Set<User> findByName(String name);

    User findByEmail(String email);

    User getByEmail(String email);

    User readByEmail(String email);

    User queryByEmail(String email);

    User searchByEmail(String email);

    User streamByEmail(String email);

    User findUserByEmail(String email);

    User findSomethingByEmail(String email);

    @Query(value = "select * from user limit 1;", nativeQuery = true)
    Map<String, Object> findRowRecord();


    @Query(value = "select * from user",nativeQuery = true)
    List<Map<String, Object>> findAllRawRecord();

}
