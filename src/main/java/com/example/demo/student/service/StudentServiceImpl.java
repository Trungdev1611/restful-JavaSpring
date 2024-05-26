package com.example.demo.student.service;

import com.example.demo.exception.NotFoundEx;
import com.example.demo.student.entity.Student;
import com.example.demo.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentById(Long studentId) {
        return studentRepository.findById(studentId);
    }

    @Override
    public Student updateStudent(Long studentId, Student student) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        Student studentFound =  optionalStudent.orElseThrow(() -> new NotFoundEx("not found student respectively"));

        studentFound.setName(student.getName());
        studentFound.setAge(student.getAge());
        studentFound.setAddress(student.getAddress());

        return studentRepository.save(studentFound);

    }

    @Override
    public void deleteStudent(Long studentId) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        Student studentFound =  optionalStudent.orElseThrow(() -> new NotFoundEx("not found student to delete"));
        studentRepository.deleteById(studentId);
    }
}
