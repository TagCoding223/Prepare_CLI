package com.dao;

import com.entities.Subject;

import java.util.List;

public interface SubjectDao {
    Subject getSubjectById(int id);
    Subject createSubject(Subject subject);
    Subject updateSubject(Subject subject);
    String deleteSubject(int id);
    List<Subject> getAllSubjects();
}
