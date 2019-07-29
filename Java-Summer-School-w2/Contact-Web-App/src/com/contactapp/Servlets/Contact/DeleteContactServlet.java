package com.contactapp.Servlets.Contact;

import com.contactapp.Controllers.ContactController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-contact")
public class DeleteContactServlet extends HttpServlet {

    private Integer controllingID(HttpServletRequest req, HttpServletResponse resp, String id) throws ServletException, IOException {
        int contactId;
        if (id != null) {
            try {
                contactId = Integer.parseInt(id);
                req.setAttribute("id", contactId);
                return contactId;
            } catch (NumberFormatException ex) {
                System.out.println(ex.getMessage());
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Your id was wrong");
            }
        }

        return null;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id == null) {
            id = "Enter Contact ID";
        }
        req.setAttribute("id", id);
        req.getRequestDispatcher("WEB-INF/contact/delete-contact.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Integer contactID = controllingID(req, resp, id);
        boolean isContactDeleted = false;

        if (contactID != null) {
            isContactDeleted = ContactController.deleteContact(contactID);
        }
        System.out.println(isContactDeleted);
        resp.sendRedirect("/contacts");
    }
}