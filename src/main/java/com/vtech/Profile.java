package com.vtech;

import com.entities.User;
import com.helpers.AppConstants;
import com.services.UserService;
import com.services.servicesImpl.UserServiceImpl;

import java.util.Scanner;

public class Profile {
    private User user;
    private UserService userService;
    private static final Scanner scanner = new Scanner(System.in);

    public Profile(User loggedUser) {
        this.user = loggedUser;
        this.userService = new UserServiceImpl();
    }

    public void seeProfile(){
        System.out.println("================================================");
        System.out.println(user.getName()+"'s Profile");
        System.out.println("================================================\n");
        System.out.println("\t Name: "+user.getName());
        System.out.println("\t Email: "+user.getEmail());
        System.out.println("\t Password: "+user.getPassword());
        System.out.println("\t Phone No.: "+user.getPhone());
        System.out.println("\t City: "+user.getCity());
        System.out.println("\t Role: "+user.getRole());
        System.out.println("\n================================================\n");
    }

    public User updateProfile(){
        User updatedUser = userInput();
        if (updatedUser.getName().isEmpty() || updatedUser.getRole().isEmpty() || updatedUser.getCity().isEmpty() || updatedUser.getPhone().isEmpty() || updatedUser.getEmail().isEmpty() || updatedUser.getPassword().isEmpty() || !(updatedUser.getEmail().endsWith(".com"))){
            System.out.println("You Doesn't Provide Sufficient Information!");
        }else{
            User whenUserUpdated = userService.updateUser(updatedUser.getId(),updatedUser);
            if (whenUserUpdated == null){
                System.out.println("Something is wrong, please try again after sometime.");
            }else{
                System.out.println("Your Profile Updated Successfully!");
                return whenUserUpdated;
            }
        }
        return null;
    }

    private User userInput(){
        User retunableUser = new User();
        System.out.println("================================================");
        System.out.println("Provide following Information to update your account,\n");
        System.out.print("Enter your previous/new name: ");
        retunableUser.setName(scanner.nextLine());
        System.out.print("Enter your previous/new email: ");
        retunableUser.setEmail(scanner.nextLine());
        System.out.print("Create a previous/new password: ");
        retunableUser.setPassword(scanner.nextLine());
        System.out.print("Enter your previous/new city: ");
        retunableUser.setCity(scanner.nextLine());
        System.out.print("Enter your previous/new phone no.: ");
        retunableUser.setPhone(scanner.nextLine());
        retunableUser.setRole(String.valueOf(AppConstants.User_Role));
        retunableUser.setId(user.getId());
        return retunableUser;
    }

    public void updateField(User user){
        this.user=user;
    }

}
