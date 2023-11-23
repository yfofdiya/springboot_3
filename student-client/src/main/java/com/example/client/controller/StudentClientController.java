package com.example.client.controller;

import com.example.client.model.Student;
import com.example.client.service.StudentClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class StudentClientController {

    @Autowired
    private StudentClientService service;

    private Logger logger = LoggerFactory.getLogger(StudentClientService.class);

    @GetMapping
    public List<Student> getAllStudents() {
        logger.info("From Client Controller");
        return service.getAllStudents();
    }
}
