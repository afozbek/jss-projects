package com.javasummerschool.helloworldstyled;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorldStyledServlet
 */
@WebServlet("/HelloWorldStyledServlet")
public class HelloWorldStyledServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		writer.write("<html><body>");
		writer.write("<table border='1'>");
		writer.write("<tr><th>Time</th></tr>");
		writer.write("<tr><td style='color:red; font-weight:bold;'>The time on server is: " + new Date() + "</td></tr>");
		writer.write("</table>");
		writer.write("</body></html>");
	}

}
