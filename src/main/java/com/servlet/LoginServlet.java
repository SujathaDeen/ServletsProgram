package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter printWriter=response.getWriter();
		
		try 
		{
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		printWriter.println("User Name : "+userName);
		printWriter.println("Password : "+password);
		
		ServletConfig config=getServletConfig();
		printWriter.println("Name : "+config.getInitParameter("name"));
		
		printWriter.println("Login Successful");
		}
		
		catch(Exception e) 
		{
			printWriter.println("Error : "+e.getMessage());
		}
		
	}


}
