package ru.itis.shop.App;

import ru.itis.shop.User.console.UserConsole;
import ru.itis.shop.User.repositories.UserRepository;
import ru.itis.shop.User.repositories.impl.File.UserRepositoryFile;
import ru.itis.shop.User.repositories.impl.List.UserRepositoryList;
import ru.itis.shop.User.service.UserService;
import ru.itis.shop.console.Menu;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepoitoryFile = new UserRepositoryFile("result.txt");
        UserRepository userRepoitoryList = new UserRepositoryList();

        UserService userService = new UserService(userRepoitoryFile);

        UserConsole userConsole = new UserConsole(userService);

        Menu menu = new Menu(userConsole);
        menu.run();
    }
}
