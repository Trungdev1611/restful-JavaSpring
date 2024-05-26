package com.example.demo.student.service;

import com.example.demo.student.entity.Student;

import java.util.List;
import java.util.Optional;


public interface StudentService {
    Student createStudent(Student student);
    List<Student> getStudents();
    Optional<Student> getStudentById(Long studentId);

    Student updateStudent(Long id, Student student);

    void deleteStudent(Long id);
}
