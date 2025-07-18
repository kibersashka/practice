package ru.itis.shop.User.service;

import ru.itis.shop.User.DTO.UserDTO;
import ru.itis.shop.User.entity.User;
import ru.itis.shop.User.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserService {
    private final UserRepository userRepository;

    private final int MAX_PASSWORD_LENGTH = 7;

    public UserService(UserRepository userRepoitory) {
        this.userRepository = userRepoitory;

    }

    public void signUp(String username, String password){
        chekValidatePassword(password);
        User user = new User(password, username);
        userRepository.save(user);
    }

    private void chekValidatePassword(String password) {
        if (password.length() < MAX_PASSWORD_LENGTH){
            throw new IllegalArgumentException("more char!");
        }
    }
    public List<UserDTO> getUsers(){
        return userRepository.findAll().stream()
                .map(user -> new UserDTO(user.getUsername(), user.getUuid()))
                .toList();
    }
    /**TODO: а как сделать новые методы примерное решение
     * 1! создать новые методы
     * 2! создать обьект интефейса
     * но вот как определить у чего вызывать
     * и если решение 1 то как вызывать откуда пользовательн в консоли это может знать
     *
     */
    public void updatePassword(String uuid, String newPassword){
        //TODO: мне нужно найти по айди и создать
        // нового юзера затем удалить старого или лучше перезаписать весь файл
        User user = userRepository
                .findById(uuid)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        user.setPassword(newPassword);
        System.out.println(user);
        userRepository.update(user);
    }


}
