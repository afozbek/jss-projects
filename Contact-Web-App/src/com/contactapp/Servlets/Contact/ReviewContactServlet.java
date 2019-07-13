package com.contactapp.Servlets.Contact;

import com.db.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/contacts")
public class ReviewContactServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PreparedStatement statement;
        ResultSet resultSet;
        Connection conn = Database.getConnection();

        String query = "select * from contacts;";

        try {
            statement = conn.prepareStatement(query);
            resultSet = statement.executeQuery();
            while(resultSet.next()) {

            }

            Database.closeConnection(conn, statement, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            req.getRequestDispatcher("/contact/contacts.jsp").forward(req, resp);
        }
    }
}
