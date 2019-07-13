package com.obss.jdbc;

import java.io.OutputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcReadTest {

    public static void main(String[] args) {

        for (Student student : getStudentsFromDB("SEREF")) {
            System.out.println(student);
        }

        getStudentsFromDB("MERT").forEach((student) -> {
            System.out.println("Student : " + student);
        });

    }


    public static List<Student> getStudentsFromDB(String name) {
        List<Student> studentList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            connection =
                    DriverManager.getConnection("jdbc:mysql://localhost/obss", "root", "123456789");
            ps = connection.prepareStatement("SELECT * FROM STUDENT where name=?");
            ps.setString(1, name);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                String firstName = resultSet.getString("name");
                int id = resultSet.getInt("id");

                String surname = resultSet.getString("surname");

                Student student = new Student(id, firstName, surname);
                studentList.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                resultSet.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Sorgu bitti!");
        return studentList;
    }

    public static class Student {
        private int id;
        private String name;
        private String surname;

        public Student() {

        }

        public Student(int id, String name, String surname) {
            this.id = id;
            this.name = name;
            this.surname = surname;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    '}';
        }
    }
}
