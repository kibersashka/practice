package ru.itis.shop.console;

import ru.itis.shop.User.console.UserConsole;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner;
    private final UserConsole userConsole;
    public Menu(UserConsole userConsole){
        this.scanner = new Scanner(System.in);
        this.userConsole = userConsole;
    }
    public void run(){

        while (true){
            showMenu();
            String command = scanner.nextLine();
            switch(command){
                case("1") -> userConsole.signUp();
                case("2") -> userConsole.printUsers();
                case("3") -> userConsole.updatePassword();
                case("0") -> System.exit(0);
            }
        }
    }
    public void showMenu(){
        System.out.println("1. регистрация");
        System.out.println("2. список всех пользователей");
        System.out.println("3. обновить пароль");
        System.out.println("0. выход");

    }
}
