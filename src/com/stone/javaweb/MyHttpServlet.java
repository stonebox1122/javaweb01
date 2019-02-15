package com.stone.javaweb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 针对于HTTP协议定义的一个Servlet基类
 * @author Lei.Shi445
 *
 */
public class MyHttpServlet extends MyGenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		if (request instanceof HttpServletRequest) {
			HttpServletRequest httpServletRequest = (HttpServletRequest) request;
			if (response instanceof HttpServletResponse) {
				HttpServletResponse httpServletResponse = (HttpServletResponse) response;
				sercive(httpServletRequest, httpServletResponse);
			}
		}
	}

	public void sercive(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取请求方法
		String method = request.getMethod();
		
		//2.根据请求方式再调用对应的处理方法
		if ("GET".equalsIgnoreCase(method)) {
			doGet(request, response);
		} else if ("POST".equalsIgnoreCase(method)) {
			doPost(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}