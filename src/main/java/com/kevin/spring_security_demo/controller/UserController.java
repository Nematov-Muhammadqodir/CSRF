package com.kevin.spring_security_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.kevin.spring_security_demo.model.User;
import com.kevin.spring_security_demo.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User saveUser(@RequestBody User user) {
        System.out.println("Hello");

        return userService.saveUser(user);
    }

}
