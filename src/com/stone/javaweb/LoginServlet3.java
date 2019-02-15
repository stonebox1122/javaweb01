package com.stone.javaweb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LoginServlet3 extends MyGenericServlet {
	
	@Override
	public void init() throws ServletException {
		System.out.println("初始化。。。");
	}

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		//1.获取web.xml中的参数
		String inituser = getServletContext().getInitParameter("user");
		String initpassword = getServletContext().getInitParameter("password");
		
		//2，获取请求参数
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		
		//3.对比参数并输出
		if (inituser.equals(user) && initpassword.equals(password)) {
			response.getWriter().println("Hello: " + user);
		} else {
			response.getWriter().println("Sorry: " + user);
		}
		
		//假如还需要获取请求方式是GET还是POST
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String method = httpServletRequest.getMethod();
		System.out.println(method);
	}
}