package servlets.training.auth;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "filterLogin", urlPatterns = {"/private/*"})
public class FilterLogin implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        PrintWriter out = resp.getWriter();
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpServletRequest request = (HttpServletRequest) req;

        // Check for user exist
        if (request.getSession().getAttribute("name") == null) {
            out.print("username or password error!");
            response.sendRedirect("/public/login.jsp");
        } else {
            System.out.println("You are Admin");
            request.getRequestDispatcher("/private/secured.jsp").forward(request, response);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
