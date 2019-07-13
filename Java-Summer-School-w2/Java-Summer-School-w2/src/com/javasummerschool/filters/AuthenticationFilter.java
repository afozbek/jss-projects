package com.javasummerschool.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class AuthenticationFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Cookie [] cookies = ((HttpServletRequest)request).getCookies();
		String username = null;
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("username")) {
					username = cookie.getValue();
					break;
				}
			}
		}
		
		if(username != null) {
			chain.doFilter(request, response);
		} else {
			request.getRequestDispatcher("/public/login.jsp").forward(request, response);
		}
	}

}
