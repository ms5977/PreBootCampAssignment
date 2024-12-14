package com.main.controller;

import com.main.enitity.Student;
import com.main.enitity.Subject;
import com.main.services.SubjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {
    private  final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }
    @PostMapping("/create-subject")
    public ResponseEntity<Subject> createStudent(@RequestBody Subject subject){
        Subject subjectData = subjectService.createSubject(subject);
        return ResponseEntity.status(HttpStatus.OK).body(subjectData);
    }
    @GetMapping("/getAllSubject")
    public  ResponseEntity<List<Subject>>getAllSubject(){
        List<Subject> subjects = subjectService.getAllSubjects();
        return  ResponseEntity.ok().body(subjects);
    }
}
