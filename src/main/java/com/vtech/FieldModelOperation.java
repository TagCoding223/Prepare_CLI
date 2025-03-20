package com.vtech;

import com.entities.FieldModel;
import com.services.FieldModelService;
import com.services.servicesImpl.FieldModelServiceImpl;

import java.util.List;
import java.util.Scanner;

public class FieldModelOperation {

    private List<FieldModel> allFieldModels;
    private FieldModelService fieldModelService;
    private static Scanner scanner = new Scanner(System.in);

    FieldModelOperation() {
        fieldModelService = new FieldModelServiceImpl();
        allFieldModels = fieldModelService.getAllFieldModel();
    }

    public void prepareMenu() {
        System.out.println("================================================");
        System.out.println("\t Welcome To Prepare Menu");
        System.out.println("================================================");
        System.out.println("\t Select a Field,\n");

        if (allFieldModels == null || allFieldModels.isEmpty()) {
            System.out.println("No Field Models available.");
            return;
        }

        for (int i = 0; i < allFieldModels.size(); i++) {
            System.out.println("\t " + (i + 1) + " -> " + allFieldModels.get(i).getName() + "\n");
            // System.out.println("\t "+(i+1)+" -> "+allFieldModels.get(i)+"\n");
        }
        System.out.print("\nEnter Your Choice: ");
        int choice = scanner.nextInt();

        if (choice > 0 && choice <= allFieldModels.size()) {
            selectSubject(allFieldModels.get(choice - 1));
        } else {
            System.out.println("Invalid choice. Please try again.");
        }
    }

    private void selectSubject(FieldModel fieldModel) {
        System.out.println("\n================================================");
        System.out.println("\t Select a Subject,\n");
        System.out.println(fieldModel);
        System.out.println(fieldModel.getFieldModelSubjects().get(0).getSubject());
        
        for (int i = 0; i < fieldModel.getFieldModelSubjects().size(); i++) {
            System.out.println(
                    "\t " + (i + 1) + " -> " + (fieldModel.getFieldModelSubjects().get(i).getSubject().getName()));
        }

        System.out.print("\nEnter Your Choice: ");
        int subjectChoice = scanner.nextInt();

        new ChapterOperation(subjectChoice, fieldModel).selectChapter();
    }
}
