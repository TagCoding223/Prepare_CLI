package com.vtech;

import com.entities.User;
import com.services.UserService;
import com.services.servicesImpl.UserServiceImpl;

import java.util.Scanner;

class Login {

    private String email;
    private String password;
    private final Scanner scanner = new Scanner(System.in);

    Login(){
        getInput();
        UserService userService = new UserServiceImpl();
        User user = userService.findUserByEmailAndPassword(email,password);
        if (user == null) {
            System.out.println("================================================");
            System.out.println("No Account Found!");
            System.out.println("================================================");
        }else{
            // if user logged in
            Gateway.mainMenu(user);
        }
    }

    private void getInput(){
        System.out.println("================================================");
        System.out.print("\nEnter your email: ");
        email = scanner.nextLine();
        System.out.print("\nEnter your password: ");
        password = scanner.nextLine();
    }
}
