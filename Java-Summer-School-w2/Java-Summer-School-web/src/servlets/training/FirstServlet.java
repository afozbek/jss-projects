package servlets.training;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/servlets.training.FirstServlet")
public class FirstServlet extends HttpServlet {

    public FirstServlet() {}


    // CRUD Operations
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("<h1>Hello, You are in Servlet Page</h1>" +
                "<a href=\"index.jsp\">Go to Home</a>");
    }


    // Determine what to do.
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }
}
