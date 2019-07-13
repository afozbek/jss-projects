package com.obss.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcTryWithResources {

    public static List<JdbcReadTest.Student> tryWithResources(String name) {
        List<JdbcReadTest.Student> studentList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/obss", "root", "123456789");
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM STUDENT where name=?")) {
            ps.setString(1, name);
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    String firstName = resultSet.getString("name");
                    int id = resultSet.getInt("id");
                    String surname = resultSet.getString("surname");
                    JdbcReadTest.Student student = new JdbcReadTest.Student(id, firstName, surname);
                    studentList.add(student);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }
}
