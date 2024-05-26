package com.example.demo.student.controller;

import com.example.demo.exception.NotFoundEx;
import com.example.demo.reponse.Response;
import com.example.demo.student.entity.Student;
import com.example.demo.student.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/createStudent")  //url method post
    ResponseEntity<Response> AddStudent(@Valid @RequestBody Student student) {
        Student studentResponse = studentService.createStudent(student);
        Response responseSuccess = Response.successResponse(studentResponse);
        return new ResponseEntity<>(responseSuccess, HttpStatus.OK);
    }

    @GetMapping("/students")
    ResponseEntity<?> getListStudent() {
        List<Student> studentResponse = studentService.getStudents();
        Response responseSuccess = Response.successResponse(studentResponse);
        return new ResponseEntity<>(responseSuccess, HttpStatus.OK);
    }

    @GetMapping("/students/{idStudent}")
    ResponseEntity<Response> getStudentById(@PathVariable Long idStudent)  {
        Optional<Student> optionalStudent = studentService.getStudentById(idStudent);

        Student studentResponse = optionalStudent.orElseThrow(() -> new NotFoundEx("Not found with id"));
        Response responseSuccess = Response.successResponse(studentResponse);
        return new ResponseEntity<>(responseSuccess, HttpStatus.OK);
    }

    @PutMapping("/students/{idStudent}")
    ResponseEntity<Response> updateStudent(@Valid @RequestBody Student student, @PathVariable Long idStudent)  {
        Student studentFind = studentService.updateStudent(idStudent, student );

        Response responseSuccess = Response.successResponse(studentFind);
        return new ResponseEntity<>(responseSuccess, HttpStatus.OK);
    }

    @DeleteMapping("/students/{idStudent}")
    ResponseEntity<Response> deleteStudent( @PathVariable Long idStudent)  {
         studentService.deleteStudent(idStudent );

        Response responseSuccess = Response.successResponse(null);
        return new ResponseEntity<>(responseSuccess, HttpStatus.OK);
    }
}
