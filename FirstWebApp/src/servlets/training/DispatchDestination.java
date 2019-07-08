package servlets.training;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/servlets.training.DispatchDestination")
public class DispatchDestination extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jspName = req.getParameter("destination");
        if (jspName == null) {
            return;
        }

        resp.setContentType("text/html");
        resp.setStatus(200);

        req.getRequestDispatcher(jspName).forward(req, resp);
    }
}
