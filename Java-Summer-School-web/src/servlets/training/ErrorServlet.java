package servlets.training;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ErrorServlet")
public class ErrorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        req.getRequestDispatcher("/error.jsp").forward(req, resp);
        sendErrors(request, response);
    }

    private void sendErrors(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");

        if (servletName == null) {
            servletName = "Unknown";
        }

        getServletContext().setAttribute("statusCode", statusCode);
        getServletContext().setAttribute("servletName", servletName);

        request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
}

