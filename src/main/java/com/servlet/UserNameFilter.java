package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


//@WebFilter("/login")
public class UserNameFilter implements Filter {

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest=(HttpServletRequest) request;
		HttpServletResponse httpResponse=(HttpServletResponse) response;
		
		PrintWriter printWriter=response.getWriter();
		
		HttpSession session = httpRequest.getSession();
		
		try
		{
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String userName = request.getParameter("userName");
		
		session.setAttribute("userName", userName);
		session.setAttribute("email", email);
		session.setAttribute("password", password);
		
		String regex = "^[a-zA-Z_.]+$";
		
		if(userName.matches(regex)) {
			chain.doFilter(request, response);
		}
		else {
			response.getWriter().println("Username should be in Alphabetic");
		}
		}
		
		catch(Exception e){
			printWriter.println("Error : "+e.getMessage());
		}
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

