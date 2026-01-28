package com.kevin.spring_security_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RestController;
import com.kevin.spring_security_demo.model.User;
import com.kevin.spring_security_demo.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.security.core.Authentication;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public User saveUser(@RequestBody User user) {

        return userService.saveUser(user);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));

        if (authentication.isAuthenticated()) {
            return "Success";
        } else
            return "Login failed";
    }

}
