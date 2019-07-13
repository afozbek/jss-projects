package com.javasummerschool.helloworldservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = -1572973502988090951L;

	/*@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Inside service method 1");
		
		System.out.println("Inside service method 2");
		resp.getWriter().write("Service()");
		//super.service(req, resp);
	}*/
	
	/**
	 * 
	 */

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter writer = resp.getWriter();
		writer.write("<html><body>");
		writer.write("<h1>Hello World GET method!</h1>");
		writer.write("</body></html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		writer.write("<html><body>");
		writer.write("<h1>Hello World POST method!</h1>");
		writer.write("</body></html>");
	}
	
	@Override
	public void destroy() {
		System.out.println("Destroy");
	}

}
