package com.javasummerschool.webxmlservletdefiniton;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebXmlServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	//requires authentication for the role admin for the urls starting with /admin.
	//roles and users are defined in tomcat-users.xml file
	//<role rolename="admin"/>
	//<user username="admin" password="admin" roles="admin"/>
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = getServletContext().getInitParameter("email");
		resp.getWriter().write("Init param defined in web.xml is: " + email);
	}

}
