package com.stone.javaweb;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ForwardServlet's doGet...");
		
		//请求的转发
		//1.调用HttpServletRequest的getRequestDispatcher()方法获取RequestDispatcher对象
		//调用etRequestDispatcher()需要传入要转发的地址
		String path = "testServlet";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/" + path);
		
		//2.调用RequestDispatcher的forward(request, response)进行请求转发
		requestDispatcher.forward(request, response);
	}
}