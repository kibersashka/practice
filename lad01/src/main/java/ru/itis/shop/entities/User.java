package ru.itis.shop.entities;

public class User {
    private final String username;
    private String uuid;
    private String password;

    public User(String username, String uuid, String password) {
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
}
