package com.challenge.citylists.repository;

import com.challenge.citylists.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);

    User findUserByUsername(String username);

    User findUserById(int id);

    List<User> findUserByUsernameAndPassword(String username, String password);

}
