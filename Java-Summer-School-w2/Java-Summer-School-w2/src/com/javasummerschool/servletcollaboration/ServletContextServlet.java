package com.javasummerschool.servletcollaboration;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletContextServlet
 */
@WebServlet("/ServletContextServlet")
public class ServletContextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String initParam;
	
	@Override
	public void init() throws ServletException {
		initParam = getServletContext().getInitParameter("email");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("The context param value read from servlet context is: " + initParam + ".  ");
		String doPostServletContextAttribute = (String) getServletContext().getAttribute("doPostServletContextAttribute");
		if(doPostServletContextAttribute != null) {
			response.getWriter().append("doPost servletContext attribute is: " + doPostServletContextAttribute);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().setAttribute("doPostServletContextAttribute", "doPost Param");
		doGet(req, resp);
	}
}
