package com.vtech;

import com.entities.User;
import com.helpers.AppConstants;
import com.services.UserService;
import com.services.servicesImpl.UserServiceImpl;

import java.util.Scanner;

public class RegisterUser {

    private final Scanner scanner = new Scanner(System.in);
    private final User newUser;

    RegisterUser(){
        newUser = new User();
        UserService userService = new UserServiceImpl();
        userInput();
        if (newUser.getName().isEmpty() || newUser.getCity().isEmpty() || newUser.getEmail().isEmpty() || newUser.getPassword().isEmpty() || newUser.getPhone().isEmpty() || !(newUser.getEmail().endsWith(".com"))){
            System.out.println("You Doesn't Provide Sufficient Information!");
        }else {
            if (userService.findByEmail(newUser.getEmail()) == null) {
                if (userService.createUser(newUser) != null) {
                    System.out.println("Account Created Successfully!");
                }
            } else {
                System.out.println("User already exist!");
            }
        }
    }

    private void userInput(){
        System.out.println("================================================");
        System.out.println("Provide following Information to create an account,\n");
        System.out.print("Enter your name: ");
        newUser.setName(scanner.nextLine());
        System.out.print("Enter your email: ");
        newUser.setEmail(scanner.nextLine());
        System.out.print("Create a password: ");
        newUser.setPassword(scanner.nextLine());
        System.out.print("Enter your city: ");
        newUser.setCity(scanner.nextLine());
        System.out.print("Enter your phone no.: ");
        newUser.setPhone(scanner.nextLine());
        newUser.setRole(String.valueOf(AppConstants.User_Role));
    }
}
