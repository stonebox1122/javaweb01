package com.stone.javaweb;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlet implements Servlet {

	@Override
	public void destroy() {
		System.out.println("destory");
		
	}

	@Override
	public ServletConfig getServletConfig() {
		System.out.println("getServletConfig");
		return null;
	}

	@Override
	public String getServletInfo() {
		System.out.println("getServletInfo");
		return null;
	}

	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		System.out.println("init");
		String user = servletConfig.getInitParameter("user");
		System.out.println(user);
		Enumeration<String> names = servletConfig.getInitParameterNames();
		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			String value = servletConfig.getInitParameter(name);
			System.out.println("name: " + name + ",value:" + value);
			
		}
		String servletName = servletConfig.getServletName();
		System.out.println(servletName);
		
		//获取ServletContext对象
		ServletContext servletContext = servletConfig.getServletContext();
		String driver = servletContext.getInitParameter("driver");
		System.out.println("dirver:" + driver);
		Enumeration<String> names2 = servletContext.getInitParameterNames();
		while (names2.hasMoreElements()) {
			String name = (String) names2.nextElement();
			System.out.println("--->" + name);
		}
		
		String realPath = servletContext.getRealPath("hello.jsp");
		System.out.println(realPath);
		
		String path = servletContext.getContextPath();
		System.out.println(path);
		
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			InputStream is = classLoader.getResourceAsStream("jdbc.properties");
			System.out.println("1." + is);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {			
			InputStream is2 = servletContext.getResourceAsStream("/WEB-INF/classes/jdbc.properties");
			System.out.println("2." + is2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("service");
		
	}
	
	public HelloServlet() {
		System.out.println("HelloServlet constructor");
	}

}
