package com.javasummerschool.jdbc;

import java.sql.*;

public class DBUtil {
    public void saveUser(User user) throws SQLException {
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = getConnection();

            // 3- Create SQL statements
            String sql = "insert into users(first_name, last_name, email) values(?, ?, ?)";
            statement = conn.prepareStatement(sql);

            // 4- Execute SQL query
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getEmail());
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(conn, statement, null);
        }
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey",
                    "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConnection(Connection conn, Statement statement, ResultSet resultSet) throws SQLException {
        if(resultSet != null) {
            resultSet.close();
        }

        if(statement != null) {
            statement.close();
        }

        if(conn != null) {
            conn.close();
        }
    }

}
