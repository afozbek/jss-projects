package com.contactapp;

import java.sql.*;
import java.util.Date;

public class Main {
    private static Connection connection;
    private static Statement statement;
    private static ResultSet results;

    private static void insertUser(){
        String query = "insert into users (first_name, last_name,  is_admin, num_points)" +
                       " values ('Sena','Canim', 1, 13);";
        try{
            statement.executeUpdate(query);
            System.out.println("Insert Success");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private static void getUsers(){
        String query = "select * from users";
        try {
            results = statement.executeQuery(query);

            while(results.next()){
                System.out.println(results.getString("first_name") + " - " + results.getString("last_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void updateUser() {
        String query = "update users set first_name='Furkan' where id=4;";
        try {
            statement.executeUpdate(query);
            System.out.println("Update success");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteUser() {
        String query = "delete from users where first_name='Sena';";

        try {
            int numberOfRows = statement.executeUpdate(query);
            System.out.println(numberOfRows + " affected");
            System.out.println("Delete success");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try{
            String url = "jdbc:mysql://localhost:3307/test?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";

            // Creating a connection
            connection = DriverManager.getConnection(url,"root","");

            // Creating a statement
            statement = connection.createStatement();

            // Delete User or Users
            deleteUser();

            // Insert a User
            insertUser();

            // Update User
            updateUser();

            // Get Users
            getUsers();


            statement.close();
            connection.close();
            results.close();

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

}