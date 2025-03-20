package com.dao;

import com.entities.Question;

import java.util.List;

public interface QuestionDao {
    Question createQuestion(Question question);
    List<Question> getQuestionsByFieldModelSubjectAndChapter(Long fieldModelId, Long subjectId, Long chapterId);
    int getCount(Long fieldModelId, Long subjectId, Long chapterId);
    List<Question> getTestSet(int startIndex,Long fieldModelId, Long subjectId, Long chapterId);
}