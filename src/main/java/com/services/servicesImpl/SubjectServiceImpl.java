package com.services.servicesImpl;

import com.dao.SubjectDao;
import com.dao.daoImpl.SubjectDaoImpl;
import com.entities.Subject;
import com.services.SubjectService;

import java.util.List;

public class SubjectServiceImpl implements SubjectService {

    private final SubjectDao subjectDao;

    SubjectServiceImpl(){
        subjectDao = new SubjectDaoImpl();
    }

    @Override
    public Subject getSubjectById(int id) {
        return subjectDao.getSubjectById(id);
    }

    @Override
    public Subject createSubject(Subject subject) {
        return subjectDao.createSubject(subject);
    }

    @Override
    public Subject updateSubject(Subject subject) {
        return subjectDao.updateSubject(subject);
    }

    @Override
    public String deleteSubject(int id) {
        return subjectDao.deleteSubject(id);
    }

    @Override
    public List<Subject> getAllSubjects() {
        return subjectDao.getAllSubjects();
    }
}
