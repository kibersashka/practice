package ru.itis.shop.console;

import ru.itis.shop.DTO.UserDTO;
import ru.itis.shop.entities.User;
import ru.itis.shop.services.UserService;

import java.util.List;
import java.util.Scanner;

public class UserConsole {
    private final Scanner scanner;
    private final UserService userService;

    public UserConsole(){
        this.scanner = new Scanner(System.in);
        this.userService = new UserService();
    }
    public void signUp(){
        System.out.println("Enter data for join:");
        String username = scanner.nextLine();
        String password = scanner.nextLine();

        userService.signUp(username, password);
    }
    public void printUsers(){
        List<UserDTO> users =  userService.getUsers();
        for(UserDTO userDTO : users){
            System.out.println(userDTO.getUuid() + "|" + userDTO.getUsername());
        }

    }
}
