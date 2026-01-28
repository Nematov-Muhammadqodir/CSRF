package com.kevin.spring_security_demo.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;

import com.kevin.spring_security_demo.model.Student;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class StudentController {

    List<Student> students = new ArrayList<>(List.of(
            new Student(1, "Kevin", "JS"), new Student(2, "Navin", "Java"), new Student(3, "Nuri", "Python")));

    @GetMapping("students")
    public List<Student> getAllStudents() {
        return students;
    }

    @PostMapping("students")
    public void addStudents(@RequestBody Student student) {
        students.add(student);
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute(CsrfToken.class.getName());

    }

}
