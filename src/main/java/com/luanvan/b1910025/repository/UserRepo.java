package com.luanvan.b1910025.repository;

import com.luanvan.b1910025.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findById(Long id);

    Optional<User> findByUsernameOrEmail(String username, String email);

    Optional<User> findByRole(String role);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

}