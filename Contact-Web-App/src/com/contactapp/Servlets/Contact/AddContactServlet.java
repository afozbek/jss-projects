package com.contactapp.Servlets.Contact;

import com.contactapp.Controllers.ContactController;
import com.db.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/add-contact")
public class AddContactServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/contact/add-contact.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PreparedStatement statement;
        Connection conn = Database.getConnection();

        String name = req.getParameter("name");
        String email = req.getParameter("name");
        String phone = req.getParameter("phone");

        boolean isInserted = ContactController.addContact(name, email, phone);

        resp.sendRedirect("/contacts");
    }
}
