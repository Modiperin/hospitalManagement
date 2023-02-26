package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletConfig config = getServletConfig();
		String uname= config.getInitParameter("username");
		String pass=config.getInitParameter("password");
		System.out.println(uname);
		System.out.println(pass);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		RequestDispatcher rd=null;
		if(username.equals(uname) && password.equals(pass))
		{
			rd=request.getRequestDispatcher("mainPage.jsp");
		}
		else {
			request.setAttribute("credentialError", "Please enter valid email and Password");
			rd=request.getRequestDispatcher("adminController.jsp");
		}
		rd.forward(request, response);
	}
}
