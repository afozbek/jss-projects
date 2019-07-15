package com.contactapp.Servlets.Contact;

import com.contactapp.Controllers.ContactController;
import com.contactapp.Models.ContactBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/contacts")
public class ReviewContactServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ContactBean> contactList = ContactController.getContacts();

        req.setAttribute("contactList", contactList);

        req.getRequestDispatcher("WEB-INF/contact/contacts.jsp").forward(req, resp);
    }
}
