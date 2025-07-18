package ru.itis.shop.User.DTO;

public class UserDTO {
    private final String username;
    private final String uuid;

    public UserDTO(String username, String uuid) {
        this.username = username;
        this.uuid = uuid;
    }

    public String getUsername() {
        return username;
    }



    public String getUuid() {
        return uuid;
    }
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", uuid='" + uuid + '\'' +
                '}';
    }


}
