package com.services.servicesImpl;

import com.dao.QuestionDao;
import com.dao.daoImpl.QuestionDaoImpl;
import com.entities.Question;
import com.services.QuestionService;

import java.util.List;

public class QuestionServiceImpl implements QuestionService {

    private final QuestionDao questionDao;

    public QuestionServiceImpl() {
        this.questionDao = new QuestionDaoImpl();
    }

    @Override
    public Question createQuestion(Question question) {
        return questionDao.createQuestion(question);
    }

    @Override
    public List<Question> getQuestionsByFieldModelSubjectAndChapter(Long fieldModelId, Long subjectId, Long chapterId) {
        return questionDao.getQuestionsByFieldModelSubjectAndChapter(fieldModelId, subjectId, chapterId);
    }

    @Override
    public int getCount(Long fieldModelId, Long subjectId, Long chapterId) {
        return questionDao.getCount(fieldModelId, subjectId, chapterId);
    }

    @Override
    public List<Question> getTestSet(int startIndex, Long fieldModelId, Long subjectId, Long chapterId) {
        return questionDao.getTestSet(startIndex, fieldModelId, subjectId, chapterId);
    }
}