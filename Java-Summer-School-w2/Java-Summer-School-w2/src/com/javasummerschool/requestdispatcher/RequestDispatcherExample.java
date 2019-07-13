package com.javasummerschool.requestdispatcher;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestDispatcherExample
 */
@WebServlet("/RequestDispatcherExample")
public class RequestDispatcherExample extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String username = request.getParameter("username");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/requestdispatcher/reqdispatcher.jsp");
		dispatcher.forward(request, response);
	}

}
