package com.example.demo.student.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


@Entity
public class Student {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id // indicate primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // id auto created and increment
    private Long id;
    @NotNull(message = "ID must not be null")
    @NotEmpty(message = "Name must not be empty")
    private String name;

    @NotNull(message = "Age must not be null")
    @Positive(message = "Age must be greater than 0")
    private int age;
    @NotEmpty(message = "Address must not be empty")
    private String address;

    public Student(String name, int age, String address,Long id ) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
