package servlets.training;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/servlets.training.ParameterServlet")
public class ParameterServlet extends HttpServlet {
    public ParameterServlet() {}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/plain");

        String param = "name";
        String paramValue = req.getParameter(param);

        if(paramValue == null){
            out.write("Please define the name parameter");
            return;
        }

        out.write(param + " = " + paramValue);

        out.close();
    }

    // Determine what to do.
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }
}
