package ru.itis.shop.User.repositories;

import ru.itis.shop.User.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    void save(User user);
    List<User> findAll();
    void update(User user);
    Optional<User> findById(String uuid);

}
