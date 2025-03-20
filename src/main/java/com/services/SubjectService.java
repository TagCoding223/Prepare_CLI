package com.services;

import com.entities.Subject;

import java.util.List;

public interface SubjectService {
    Subject getSubjectById(int id);
    Subject createSubject(Subject subject);
    Subject updateSubject(Subject subject);
    String deleteSubject(int id);
    List<Subject> getAllSubjects();
}
