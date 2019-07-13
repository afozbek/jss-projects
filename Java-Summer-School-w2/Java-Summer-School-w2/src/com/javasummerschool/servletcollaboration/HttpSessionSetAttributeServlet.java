package com.javasummerschool.servletcollaboration;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HttpSessionServlet
 */
@WebServlet("/HttpSessionSetAttributeServlet")
public class HttpSessionSetAttributeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("param", "Param");
		request.getRequestDispatcher("HttpSessionGetAttributeServlet").forward(request, response);
		//or we could forward to a jsp page and read the attribute in jsp file using session.getAttribute() methods
	}
}
