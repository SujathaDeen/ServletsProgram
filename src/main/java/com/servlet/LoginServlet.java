package com.servlet;

import java.io.IOException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		response.getWriter().println(""+userName);
		response.getWriter().println(""+password);
		
		ServletConfig config=getServletConfig();
		response.getWriter().println(""+config.getInitParameter("name"));
		
		if(userName.equals("Full Creative") && password.equals("abc@123")) {
			response.getWriter().println("Login Successful");
		}
		else {
			response.getWriter().println("Login Failed");
		}
		}catch(Exception e) {
			response.getWriter().println("Error : "+e.getMessage());
		}
		
	}


}
