package com.khanapakao.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminLogin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if (username.equals("admin") && password.equals("admin123")) {
			HttpSession s = req.getSession(true);
			s.putValue("username", username);
			s.putValue("password", password);
			RequestDispatcher rd = req.getRequestDispatcher("/adminPage.jsp");
			rd.forward(req, resp);
		} else {
			req.setAttribute("logincheck", "no");
			RequestDispatcher rd = req.getRequestDispatcher("/adminLogin.jsp");
			rd.forward(req, resp);
		}
	}
}
