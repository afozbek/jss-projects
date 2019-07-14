package com.contactapp.Servlets;

import com.contactapp.Controllers.ContactController;
import com.contactapp.Models.ContactBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update-contact")
public class UpdateContactServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        ContactBean contact;

        if (id != null) {
            try {
                contact = ContactController.getContact(Integer.parseInt(id));
                if (contact == null) {
                    throw new NullPointerException();
                }
                req.setAttribute("id", id);
                req.setAttribute("name", contact.getName());
                req.setAttribute("email", contact.getEmail());
                req.setAttribute("phone", contact.getPhone());
            } catch (NumberFormatException | NullPointerException ex) {
                System.out.println(ex.getMessage());
            }
        }
        req.getRequestDispatcher("/contact/update-contact.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int contactId;
        boolean isContactUpdated = false;
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");

        try {
            contactId = Integer.parseInt(id);
            isContactUpdated = ContactController.updateContact(contactId, name, email, phone);
        } catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
        }
        req.setAttribute("isContactUpdated", isContactUpdated);
        resp.sendRedirect("/contacts");
    }
}
