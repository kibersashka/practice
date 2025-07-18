package ru.itis.shop.User.console;

import ru.itis.shop.User.DTO.UserDTO;
import ru.itis.shop.User.service.UserService;

import java.util.List;
import java.util.Scanner;

public class UserConsole {
    private final Scanner scanner;
    private final UserService userService;

    public UserConsole(UserService userService){
        this.scanner = new Scanner(System.in);
        this.userService = userService;
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
    public void updatePassword(){
        //TODO: вызвать сервис
        System.out.println("Введите id пользователя для обновления пароля:");
        String uuid = scanner.nextLine();
        String newPassword = scanner.nextLine();
        userService.updatePassword(uuid, newPassword);
    }
}
