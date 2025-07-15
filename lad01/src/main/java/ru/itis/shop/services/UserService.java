package ru.itis.shop.services;

import ru.itis.shop.DTO.UserDTO;
import ru.itis.shop.entities.User;
import ru.itis.shop.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private final UserRepository userRepository;
    private final int MAX_PASSWORD_LENGTH = 7;

    public UserService() {
        this.userRepository = new UserRepository();
    }

    public void signUp(String username, String password){
        chekValidatePassword(password);
        User user = new User(username, password);
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
}
