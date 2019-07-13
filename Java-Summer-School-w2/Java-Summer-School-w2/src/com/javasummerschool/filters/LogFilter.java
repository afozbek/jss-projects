package com.javasummerschool.filters;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LogFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
		String initParam = filterConfig.getInitParameter("filterInitParam");
		System.out.println("Filter init param: " + initParam);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String ipAddress = request.getRemoteAddr();
		System.out.println("Client ip address is: " + ipAddress + ", Request time is: " + new Date().toString());
		chain.doFilter(request, response);
	}

	
}
