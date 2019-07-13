package com.obss.jdbc;

import java.sql.*;

public class JdbcWriteTest {
    public static void main(String[] args) {
            try {
            Connection connection =
                    DriverManager.getConnection("jdbc:mysql://localhost/obss", "root", "123456789");

            PreparedStatement ps = connection.prepareStatement("INSERT INTO STUDENT VALUES(?, ?, ?)");

            ps.setInt(1, 2);
            ps.setString(2, "MERT");
            ps.setString(3, "AKIF");

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
