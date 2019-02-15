package com.stone.javaweb;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 自定义一个Servlet接口的实现类，简化开发
 * @author Lei.Shi445
 *
 */
public abstract class MyGenericServlet implements Servlet, ServletConfig {
	
	private ServletConfig servletConfig;

	//以下方法为Servlet接口的方法
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.servletConfig = config;
		init();
	}

	public void init() throws ServletException {}

	@Override
	public ServletConfig getServletConfig() {
		return servletConfig;
	}

	@Override
	public abstract void service(ServletRequest req, ServletResponse res) throws ServletException, IOException; 

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {}

	//以下方法为ServletConfig接口的方法
	@Override
	public String getServletName() {
		return servletConfig.getServletName();
	}

	@Override
	public ServletContext getServletContext() {
		return servletConfig.getServletContext();
	}

	@Override
	public String getInitParameter(String name) {
		return servletConfig.getInitParameter(name);
	}

	@Override
	public Enumeration getInitParameterNames() {
		return servletConfig.getInitParameterNames();
	}
}