package servlets.training;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

 /*
        Caused by: java.lang.IllegalArgumentException:
        The servlets named [SimpleCounterServlet] and [servlets.training.SimpleCounterServlet]
        are both mapped to the url-pattern [/SimpleCounterServlet] which is not permitted
  */

@WebServlet("/SimpleCounterServlet")
public class SimpleCounterServlet extends HttpServlet {
    private static int count;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.getWriter().println("Since loading, this servlet has been accessed " + (++count) + " times.");
    }
}
