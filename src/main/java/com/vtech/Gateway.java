package com.vtech;

import com.entities.User;
import com.helpers.AppConstants;

import java.util.Scanner;

public class Gateway {

    private static final Scanner scanner = new Scanner(System.in);
    private static Profile profile;
    private static User gatewayUser;
    private static FieldModelOperation fieldModelOperation;

    public static void mainMenu(User loggedUser) {
        gatewayUser = loggedUser;
        profile = new Profile(gatewayUser);

        while(true) {
            System.out.println("================================================");
            System.out.println("\tHello " + gatewayUser.getName() + ", Welcome to Main Menu!");
            System.out.println("================================================");
            if (gatewayUser.getRole().equalsIgnoreCase(AppConstants.User_Role.toString())) {
                System.out.println("\n 1 -> See Profile");
                System.out.println("\n 2 -> Update Profile");
                System.out.println("\n 3 -> Go To Prepare Section");
                System.out.println("\n 4 -> Logout"); // for exit
                Gateway.caseProcess(0); // 0 for user role
            } else {
                System.out.println("\n 1 -> See Profile");
                System.out.println("\n 2 -> Update Profile");
                System.out.println("\n 3 -> Go To Prepare Section");
                System.out.println("\n 4 -> Logout"); // for exit
                // dashboard in development
                System.out.println("\n 5 -> Dashboard");
                Gateway.caseProcess(1); // 1 for admin role
            }
        }
    }

    private static void caseProcess(int role) {
        System.out.println("================================================");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("See Profile");
                profile.seeProfile();
                break;
            case 2:
                System.out.println("Update Profile");
                User reflectUser = profile.updateProfile();
                if (reflectUser != null) {
                    gatewayUser = reflectUser;
                    profile.updateField(gatewayUser);
                }
                break;
            case 3:
                System.out.println("Go To Prepare Section");
                fieldModelOperation = new FieldModelOperation();
                fieldModelOperation.prepareMenu();
                break;
            case 4:
                System.out.print("Exit from Prepare CLI");
                for (int i = 0;i<3;i++){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.print(".");
                }
                System.exit(0);
                break;
            case 5:
                if (role==1){
                    System.out.println("Sorry! Dashboard in Development!");
                }else{
                    System.out.println("Invalid Choice!");
                }
                break;
            default:
                System.out.println("Invalid Choice!");
                break;
        }
    }
}
