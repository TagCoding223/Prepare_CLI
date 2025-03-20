package com.vtech;

import java.util.List;
import java.util.Scanner;

import com.entities.FieldModel;
import com.entities.FieldModelSubject;
import com.entities.Question;
import com.services.QuestionService;
import com.services.servicesImpl.QuestionServiceImpl;

public class ChapterOperation {

    private FieldModel fieldModel;
    private int subjectChoice;
    private QuestionService questionService;
    private Scanner scanner = new Scanner(System.in);
    ChapterOperation(int subjectChoice,FieldModel fieldModel){
        this.fieldModel = fieldModel;
        this.subjectChoice = subjectChoice;
        questionService = new QuestionServiceImpl();
    }

    public void selectChapter(){
        FieldModelSubject selectedSubject = fieldModel.getFieldModelSubjects().get(subjectChoice - 1);

        System.out.println("\n================================================");
        System.out.println("\t Chapters for Subject: " + selectedSubject.getSubject().getName());
        System.out.println("================================================");

        for(int i=0;i<selectedSubject.getFieldModelSubjectChapters().size();i++){
            System.out.println("\t "+(i+1)+" -> "+(selectedSubject.getFieldModelSubjectChapters().get(i).getChapter().getName()));
        }

        System.out.print("\n Enter Your Choice: ");
        int choice = scanner.nextInt();

        showSets(selectedSubject.getFieldModel().getId(),selectedSubject.getSubject().getId(),selectedSubject.getFieldModelSubjectChapters().get(choice-1).getChapter().getId());
    }

    void showSets(Long fieldModelId, Long subjectId, Long chapterId){
        
        int setCount = questionService.getCount(fieldModelId,subjectId,chapterId);
        System.out.println("\t\t vishal count: "+setCount);
        
        System.out.println("\n\tSelect a set for test,\n");
        System.out.println("\n================================================");
        for(int i=1;i<=(setCount/10);i++){
            System.out.println("\t"+i+" -> Set "+i);
        }
        System.out.println("\n================================================");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        List<Question> testSet;
        if (choice==1) {
            testSet = questionService.getTestSet(choice-1, fieldModelId, subjectId, chapterId);
        }else{
            testSet = questionService.getTestSet(choice*10-10, fieldModelId, subjectId, chapterId);
        }
        new QuestionOperation().performTest(testSet);

    }
}
