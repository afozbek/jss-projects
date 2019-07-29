package servlets.training.auth;

import database.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        Connection conn = Database.getConnection();

        PreparedStatement stmt = null;
        ResultSet result = null;

        try {
            stmt = conn.prepareStatement("select * from users where name='" +
                    name + "' and password='" + password + "'");
            result = stmt.executeQuery();

            if (result.next()) {
                System.out.println("We found the user");
                HttpSession session = req.getSession();
                session.setAttribute("name", "furkan");
                resp.sendRedirect("/private/secured.jsp");
            } else {
                req.setAttribute("message", new String("You are not logged in"));
                resp.sendRedirect("/public/login.jsp");
            }

            Database.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
