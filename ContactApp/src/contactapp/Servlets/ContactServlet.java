package contactapp.Servlets;

import com.db.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/contact")
public class ContactServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PreparedStatement statement;
        ResultSet resultSet;
        Connection conn = Database.getConnection();

        String query = "select * from contacts;";

        try {
            statement = conn.prepareStatement(query);
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                System.out.println("Your name: " + resultSet.getString("name") + " Your Phone: " + resultSet.getString("phone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher("contacts.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PreparedStatement statement;
        Connection conn = Database.getConnection();

        String name = req.getParameter("name");
        String email = req.getParameter("name");
        String phone = req.getParameter("phone");

        String query = "insert into contacts (name, email, phone)" +
                " values (?,?,?);";
        try {
            statement = conn.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, phone);
            statement.executeUpdate();
            System.out.println("Insert success");

            statement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("add-contact.jsp").forward(req, resp);
    }
}
