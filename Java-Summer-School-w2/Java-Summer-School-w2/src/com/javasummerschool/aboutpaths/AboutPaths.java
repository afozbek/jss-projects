package com.javasummerschool.aboutpaths;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AboutPaths
 */
@WebServlet("/AboutPaths/*")
public class AboutPaths extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		writer.write("getRequestUrl(): " + request.getRequestURL());
		writer.write("\n");
		writer.write("getRequestUri(): " + request.getRequestURI());
		writer.write("\n");
		writer.write("getServletPath(): " + request.getServletPath());
		writer.write("\n");
		writer.write("getContextPath(): " + request.getContextPath());
		writer.write("\n");
		writer.write("getPathInfo(): " + request.getPathInfo());
		writer.write("\n");
		writer.write("getPathTranslated(): " + request.getPathTranslated());
		writer.write("\n");
	}
}
