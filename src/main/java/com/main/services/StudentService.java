package com.main.services;

import com.main.enitity.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);
    List<Student> getAllStudents();
}
