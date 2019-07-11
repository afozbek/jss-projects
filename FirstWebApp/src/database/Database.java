package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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


    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
