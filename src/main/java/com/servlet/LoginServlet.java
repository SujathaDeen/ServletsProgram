package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		
		PrintWriter printWriter=response.getWriter();
		
		HttpSession session =request.getSession();
		
		try 
		{
		String userName = (String) session.getAttribute("userName");
		String email = (String) session.getAttribute("email");
		String password=(String) session.getAttribute("password");
		
		printWriter.println("User Name : "+userName);
		printWriter.println("<br>Email : "+email);
		printWriter.println("<br>Password : "+password);
		
		ServletConfig config=getServletConfig();
		printWriter.println("<br>Name : "+config.getInitParameter("name"));
		
		printWriter.println("<br>Login Successful");
		
		session.invalidate();
		//Try to check whether the session is invalidate or not
		userName = (String) session.getAttribute("userName");
		
		}
		
		catch(Exception e) 
		{
			printWriter.println("<br><br>Error : "+e.getMessage());
		}
		
	}


}


