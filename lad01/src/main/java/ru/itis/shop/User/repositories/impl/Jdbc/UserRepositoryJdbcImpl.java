package ru.itis.shop.User.repositories.impl.Jdbc;

import ru.itis.shop.User.entity.User;
import ru.itis.shop.User.repositories.UserRepository;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class UserRepositoryJdbcImpl implements UserRepository {
    private Connection connection;





    @Override
    public void save(User user) {

    }

    @Override
    public List<User> findAll() {
        return List.of();
    }

    @Override
    public void update(User user) {

    }

    @Override
    public Optional<User> findById(String uuid) {
        return Optional.empty();
    }
}
