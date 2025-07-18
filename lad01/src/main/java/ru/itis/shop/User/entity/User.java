package ru.itis.shop.User.entity;

import java.util.Objects;

public class User {
    private final String username;
    private String uuid;
    private String password;

    public User(String uuid, String username, String password) {
        this.username = username;
        this.uuid = uuid;
        this.password = password;
    }

    public User(String password, String username) {
        this.password = password;
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "uuid='" + uuid + '\'' +
                ", username='" + username + '\'' + "  " + password+
                '}';
    }

    public String getUuid() {
        return uuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(uuid, user.uuid);  // Сравниваем только по UUID
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
