package com.example.service;

import com.example.model.Student;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private ObservationRegistry registry;

    static List<Student> studentList = new ArrayList<>();

    public Student addStudent(Student student) {
        studentList.add(student);
//        return student;
        return Observation
                .createNotStarted("addStudent", registry)
                .observe(() -> student);
    }

    public List<Student> getAllStudents() {
//        return studentList;
        return Observation
                .createNotStarted("getAllStudents", registry)
                .observe(() -> studentList);
    }

    public Student getStudentByStudentId(String studentId) {
//        return getStudentById(studentId);

        return Observation
                .createNotStarted("getStudentByStudentId", registry)
                .observe(() -> getStudentById(studentId));
    }

    private Student getStudentById(String studentId) {
        return studentList
                .stream()
                .filter(student -> student.studentId().equals(studentId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Student is not available with provide id: " + studentId));
    }
}
