package com.onlinebookstore.bookstoreback2.repository;

import com.onlinebookstore.bookstoreback2.dto.UserDto;
import com.onlinebookstore.bookstoreback2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findUserByUsername(String username);
}
