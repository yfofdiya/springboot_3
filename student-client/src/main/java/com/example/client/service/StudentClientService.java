package com.example.client.service;

import com.example.client.model.Student;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange("/api/students")
public interface StudentClientService {

    @GetExchange
    List<Student> getAllStudents();
}
