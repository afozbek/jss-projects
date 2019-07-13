package com.javasummerschool.multithreading;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AtmServlet
 */
@WebServlet("/AtmServletNotThreadSafe")
public class AtmServletNotThreadSafe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Account account;
	
	@Override
	public void init() throws ServletException {
		super.init();
		account = new Account(5000);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//super.doGet(req, resp);
		HttpSession session = req.getSession();
		String param = (String)session.getAttribute("param");
		resp.getWriter().write(param);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sAmount = request.getParameter("amount");
		double amount = Double.parseDouble(sAmount);
		double balance;
		balance = account.getBalance();
		try {
			Thread.sleep(5000);
			if(balance - amount >= 0) {
				balance = balance - amount;
				account.setBalance(balance);
			} else {
				throw new ServletException("Account balance is not enough!");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		PrintWriter writer = response.getWriter();
		writer.write("Account balance is: " + balance);
	}

}
