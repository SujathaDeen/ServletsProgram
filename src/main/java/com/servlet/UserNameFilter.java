package com.servlet;

import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebFilter("/login")
public class UserNameFilter implements Filter {

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest=(HttpServletRequest) request;
		HttpServletResponse httpResponse=(HttpServletResponse) response;
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		if(userName.equals("Full Creative") && password.equals("abc@123")) {
			chain.doFilter(request, response);
		}
		else {
			response.getWriter().println("Login Failed");
		}
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

/*
  <filter>
  <filter-name>FirstFilter</filter-name>
  <filter-class>com.servlet.UserNameFilter</filter-class>
  </filter>
  <filter-mapping>
  <filter-name>FirstFilter</filter-name>
  <url-pattern>/login</url-pattern>
  </filter-mapping>
 */
