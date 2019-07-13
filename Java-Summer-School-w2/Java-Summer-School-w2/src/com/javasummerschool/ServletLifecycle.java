package com.javasummerschool;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletLifecyclet
 */
@WebServlet(urlPatterns= {"/ServletLifecycle"}, loadOnStartup=3)
public class ServletLifecycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private String email;
	
	@Override
	public void init() throws ServletException {
		super.init();
		email = getServletContext().getInitParameter("email");
	}
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Email is: " + email);
	}
	
	@Override
	public void destroy() {
		System.out.println("Destroy method is called on ServletLifecycle servlet");
	}

}
