package servlets.training;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {


    private boolean checkCookieExist(HttpServletRequest request) {
        Cookie cookies[] = request.getCookies();
        return cookies != null;
    }

    private Cookie creteCookie(String key, String value) {
        return new Cookie(key, value);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addCookie(new Cookie("summerActivity", "intership"));
        req.getRequestDispatcher("/WEB-INF/cookie/cookie_display.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        Cookie cookies[] = req.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                writer.append("Name: ")
                        .append(cookie.getName())
                        .append(" Value: ")
                        .append(cookie.getValue());
            }
        }
    }

    //    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String value = req.getParameter("name");
//
//        Cookie cookie = creteCookie("name", value);
//        Cookie cookies[] = req.getCookies();
//
//        resp.addCookie(cookie);
//
//        req.setAttribute("cookies", cookies);
//
//        if (checkCookieExist(req)) {
//            req.setAttribute("cookieNumber", cookies.length);
//        }
//
//        req.getRequestDispatcher("cookie.jsp").forward(req, resp);
//    }
}
