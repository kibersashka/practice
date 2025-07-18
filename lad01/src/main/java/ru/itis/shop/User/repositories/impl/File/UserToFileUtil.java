package ru.itis.shop.User.repositories.impl.File;

import ru.itis.shop.User.entity.User;

public class UserToFileUtil {
    public static String userToLine(User user){

        return user.getUuid() + "|" + user.getUsername() + "|" + user.getPassword();
    }
    public static User userFromLine(String line){

        String[] userNames = line.split("\\|");

        return  new User(userNames[0], userNames[1], userNames[2]);
    }
}
