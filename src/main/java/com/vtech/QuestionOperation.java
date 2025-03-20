package com.vtech;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.entities.Question;

public class QuestionOperation {
    private Scanner scanner = new Scanner(System.in);

    void performTest(List<Question> testSet) {
        System.out.println(testSet.get(0) + " : " + testSet.get(testSet.size() - 1));

        ArrayList<Integer> marsk = new ArrayList<Integer>();
        int choice;

        Question question;
        System.out.println("\n================================================");
        for(int i=0;i<=testSet.size()-1;i++){
            question = testSet.get(i);
            System.out.println("Question "+(i+1)+" : "+question.getQuestion().toString().trim());
            System.out.println("\nOptions,\n");
            System.out.println("\t 1 -> " + question.getOptionA());
            System.out.println("\t 2 -> " + question.getOptionB());
            System.out.println("\t 3 -> " + question.getOptionC());
            System.out.println("\t 4 -> " + question.getOptionD());
            System.out.print("\nEnter correct Option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (question.getOptionA().equalsIgnoreCase(question.getCorrectOption())) {
                        marsk.add(1);
                    }else{
                        marsk.add(0);
                    }
                    break;
                case 2:
                    if (question.getOptionB().equalsIgnoreCase(question.getCorrectOption())) {
                        marsk.add(1);
                    }else{
                        marsk.add(0);
                    }
                    break;
                case 3:
                    if (question.getOptionC().equalsIgnoreCase(question.getCorrectOption())) {
                        marsk.add(1);
                    }else{
                        marsk.add(0);
                    }
                    break;
                case 4:
                    if (question.getOptionD().equalsIgnoreCase(question.getCorrectOption())) {
                        marsk.add(1);
                    }else{
                        marsk.add(0);
                    }
                    break;
                default:
                    System.out.println("\nInvalid Choice");
                    i--;
                    break;
            }
            System.out.println("\n================================================");
        }

        int totalMarks = 0;
        for (Integer integer : marsk) {
            totalMarks+=integer;
        }

        System.out.println("\nTotal Marks: "+totalMarks);
    }
}
