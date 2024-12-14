package com.main.controller;

import com.main.enitity.Student;
import com.main.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")

public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create-student")
    public ResponseEntity<Student>createStudent(@RequestBody Student student){
        Student studentData = studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.OK).body(studentData);
    }
    @GetMapping("getAllStudent")
    public  ResponseEntity<List<Student>>getAllStudent(){
        List<Student> students = studentService.getAllStudents();
        return  ResponseEntity.ok().body(students);
    }
}
