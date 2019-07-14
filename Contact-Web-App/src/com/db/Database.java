package com.db;

import java.sql.*;

public class Database {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "";
    private static Connection connection;

    // Get the connection object
    public static Connection getConnection() {
        // Creating a connection
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return connection;
    }

    // Close the current connections
    public static void closeConnection(Connection conn, Statement statement) throws SQLException {
        if (statement != null) {
            statement.close();
        }

        if (conn != null) {
            conn.close();
        }
    }

    public static void closeConnection(Connection conn, Statement statement, ResultSet resultSet) throws SQLException {
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
