package com.prjvitor.user_simples.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prjvitor.user_simples.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
}
