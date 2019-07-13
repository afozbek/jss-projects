package com.javasummerschool.allrequestshandlerservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/")
public class AllRequestsHandlerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = String.valueOf(req.getRequestURL());
		if(url.contains("secured")) {
			resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
		} else {
			req.getRequestDispatcher("/static.jsp").forward(req, resp);
		}
	}
}
