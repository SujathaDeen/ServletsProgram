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
public class EmailFilter implements Filter {

    
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpRequest=(HttpServletRequest) request;
		HttpServletResponse httpResponse=(HttpServletResponse) response;
		
		PrintWriter printWriter = response.getWriter();
		
		HttpSession session = httpRequest.getSession();
		
		try {
		String email = (String) session.getAttribute("email");
		String password=(String) session.getAttribute("password");
		
		String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
		
		if(email.matches(regex)){
			if(password.equals("abc@123")) {
			chain.doFilter(request, response);
			}
			
			else {
				response.getWriter().println("Invalid Password");
			}
		}
		else {
			response.getWriter().println("Invalid Email");
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
