package com.db;

import java.sql.*;

public class Database {
    private static Connection connection;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";

        // Creating a connection
        try {
            connection = DriverManager.getConnection(url, "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static void create() {

    }

    public static void closeConnection(Connection conn,
                                       Statement statement)
            throws SQLException {


        if (statement != null) {
            statement.close();
        }

        if (conn != null) {
            conn.close();
        }
    }

    public static void closeConnection(Connection conn,
                                       Statement statement,
                                       ResultSet resultSet)
            throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }

        if (statement != null) {
            statement.close();
        }

        if (conn != null) {
            conn.close();
        }
    }


}
