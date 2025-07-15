package ru.itis.shop.repositories;

import ru.itis.shop.DTO.UserDTO;
import ru.itis.shop.entities.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class UserRepositoryFile {
    private final String FILENAME = "result.txt";
    private final List<User> users = new ArrayList<>();
    //TODO: запись в файл
    public void save(User user){
        try(FileWriter fileWriter = new FileWriter(new File(FILENAME))){
            String uuid = UUID.randomUUID().toString();

            user.setUuid(uuid);

            fileWriter.write(user.getUuid() + "|" + user.getUsername() + "|" + user.getPassword());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //TODO: вернуть из файла
    public List<User> findAll(){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(FILENAME))){
            String lines;
            User user;
            while ((lines = bufferedReader.readLine()) != null){
                String[] userNames = lines.split("\\|");

                user = new User(userNames[0], userNames[1], userNames[2]);

                users.add(user);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return users;
    }
}
