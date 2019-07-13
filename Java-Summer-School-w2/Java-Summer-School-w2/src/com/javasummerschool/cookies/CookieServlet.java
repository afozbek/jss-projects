package com.javasummerschool.cookies;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieServlet
 */
@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String favoriteLanguage = null;
		Cookie [] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equalsIgnoreCase("favoriteLanguage")) {
					favoriteLanguage = cookie.getValue();
					break;
				}
			}
		}
		
		if(favoriteLanguage != null) {
			//request.setAttribute("favoriteLanguage", favoriteLanguage);
			request.getRequestDispatcher("/cookies/main-page.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/cookies/favorite-language.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String favoriteLanguage = request.getParameter("favoriteLanguage");
		Cookie cookie = new Cookie("favoriteLanguage", favoriteLanguage);
		cookie.setMaxAge(30);
		response.addCookie(cookie);

		response.getWriter().write("<html><body>Thank you, we saved your choice. <br><a href='/cookies/main-page.jsp'>Return to homepage</a></body></html>");
		//request.getRequestDispatcher("/main-page.jsp").forward(request, response);
	}

}
