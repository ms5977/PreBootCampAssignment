package com.main.services;

import com.main.enitity.Subject;

import java.util.List;

public interface SubjectService {
    Subject createSubject(Subject subject);
    List<Subject> getAllSubjects();
}
