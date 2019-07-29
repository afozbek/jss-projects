package servlets.training;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DynamicServlet/*")
public class DynamicServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        System.out.println(url);

        if (url.contains("secured")) {
            resp.setStatus(403);
            resp.setHeader("Content-Type", "text/plain");
            resp.getWriter().write("Your string contains secured :( ");
        } else {
            resp.setStatus(200);
            req.getRequestDispatcher("/styled.jsp").forward(req, resp);
        }
    }
}
