package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class adminNullValFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("AdminNullValFilter");
		String email=request.getParameter("username");
		String password=request.getParameter("password");
		
		boolean isError=false;
		boolean isType=false;
		String error="";
		if(email==null || email.trim().length()==0)
		{
			isError=true;
			request.setAttribute("emailError", "Please enter your email");
		}
		else
		{
			request.setAttribute("emailValue", email);
		}
		if(password==null || password.trim().length()==0)
		{
			isError=true;
			request.setAttribute("passwordError", "Please enter your Password");
		}
		else
		{
			request.setAttribute("passwordValue", password);
		}
		
		RequestDispatcher rd=null;
		if(isError)
		{
			rd=request.getRequestDispatcher("adminController.jsp");
			rd.forward(request, response);
		}
		else
		{
			chain.doFilter(request, response);
		}

		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
