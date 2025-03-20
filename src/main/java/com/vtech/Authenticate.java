package com.vtech;

import java.util.Scanner;

public class Authenticate {

    static Scanner scanner = new Scanner(System.in);

    public static void entryPoint(){
        while (true){
            System.out.println("================================================");
            System.out.println("\tWelcome To Prepare CLI SOFTWARE!");
            System.out.println("================================================");
            System.out.println("\n 1 -> Login");
            System.out.println("\n 2 -> Create Account");
            System.out.println("\n 3 -> Exit\n");
            System.out.println("================================================");
            System.out.print("Enter Your Choice: ");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Login");
                    new Login();
                    break;
                case 2:
                    System.out.println("Create Account");
                    new RegisterUser();
                    break;
                case 3:
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
                default:
                    System.out.println("Invalid Choice!");
            }
        }


    }
}
