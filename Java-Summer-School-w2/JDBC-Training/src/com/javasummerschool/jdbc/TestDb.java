package com.javasummerschool.jdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/test")
public class TestDb extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1- Set up the print writer
        PrintWriter writer = response.getWriter();
        response.setContentType("text/plain");

        // 2- Get a connection to the database
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            conn = DBUtil.getConnection();

            // 3- Create SQL statements
            String sql = "select * from contacts";
            statement = conn.createStatement();

            // 4- Execute SQL query
            resultSet = statement.executeQuery(sql);

            // 5- Process the result set
            while (resultSet.next()) {
                String email = resultSet.getString("email");
                writer.println(email);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
