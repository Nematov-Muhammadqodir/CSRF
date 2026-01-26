package com.kevin.spring_security_demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kevin.spring_security_demo.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {
    boolean existsByUserName(String username);

    User findByUserName(String username);
}
