package ru.itis.shop.App;

import java.sql.*;

public class Main2 {
    public static void main(String[] args) {
        String uri = "jdbc:postgresql://localhost:5432/news_db";
        String user = "postgres";
        String password = "4230526";

        try(Connection connection = DriverManager.getConnection(uri, user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from account");){
            System.out.println(connection);
            System.out.println(statement);
            while(resultSet.next()){
                System.out.println(resultSet.getInt("id"));
                System.out.println();
            }

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
