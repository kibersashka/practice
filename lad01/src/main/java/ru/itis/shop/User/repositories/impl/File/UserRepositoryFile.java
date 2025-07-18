package ru.itis.shop.User.repositories.impl.File;

import ru.itis.shop.User.entity.User;
import ru.itis.shop.User.repositories.UserRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UserRepositoryFile implements UserRepository {
    private final String fileName;

    //TODO: запись в файл

    public UserRepositoryFile(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void save(User user){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(fileName), true))){
            String uuid = UUID.randomUUID().toString();

            user.setUuid(uuid);

            bufferedWriter.write(UserToFileUtil.userToLine(user));
            bufferedWriter.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //TODO: вернуть из файла
    @Override
    public List<User> findAll(){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){
            return bufferedReader.lines().map(UserToFileUtil::userFromLine).toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(User user) {
        //считать удалить добавить записать
        List<User> users = new ArrayList<>(findAll());
        User oldUser = getOldUser(user);

        users.remove(oldUser);

        users.add(user);

        resave(users);

    }

    private User getOldUser(User user) {
        User oldUser = findById(user.getUuid())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return oldUser;
    }

    private void resave(List<User> users) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))){
            for(User user1 : users){

                bufferedWriter.write(UserToFileUtil.userToLine(user1));
                bufferedWriter.newLine();
            }
        } catch(IOException e){
            throw new RuntimeException(e);
        }
    }


    @Override
    public Optional<User> findById(String uuid) {
        // TODO: реализовать метод
        return findAll().stream().filter(user -> user.getUuid().equals(uuid)).findFirst();
    }
}
