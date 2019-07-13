package servlets.training;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/servlets.training.ParamTable")
public class ParamTable extends HttpServlet {
    public ParamTable() {}
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = req.getParameter("name");
//        String lastName = req.getParameter("lastName");
//        String age = req.getParameter("age");


//        resp.getWriter().write(
//                "<table style=\"width:100%\">\n"+
//                    "  <tr>\n"+
//                    "    <th>Firstname</th>\n"+
//                    "    <th>Lastname</th> \n"+
//                    "    <th>Age</th>\n"+
//                    "  </tr>\n"+
//                    "  <tr>\n"+
//                    "    <td>"+ name +"</td>\n"+
//                    "    <td>"+ lastName +"</td> \n"+
//                    "    <td>"+ age +"</td>\n"+
//                    "  </tr>\n"+
//                "</table>");
    }
}
