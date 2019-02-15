package com.stone.javaweb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestAttr extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.在Servlet中无法得到pageContext对象
		
		//2.request
		Object requestAttr = request.getAttribute("requestAttr");
		System.out.println("requestAttr:" + requestAttr);
		
		//3.session
		Object sessionAttr = request.getSession().getAttribute("sessionAttr");
		System.out.println("sessionAttr:" + sessionAttr);
		
		//4.application
		Object applicationAttr = getServletContext().getAttribute("applicationAttr");
		System.out.println("applicationAttr:" + applicationAttr);	
	}
}