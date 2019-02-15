package com.stone.javaweb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1.获取请求的user，password
		String user = req.getParameter("user");
		String password = req.getParameter("password");

		//2.获取数据库连接
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			String sql = "select count(id) from test_users where user=? and password=?";
			connection = JDBCTools.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				int count = resultSet.getInt(1);
				if (count > 0) {
					resp.getWriter().print("Hello:" + user);
				} else {
					resp.getWriter().print("Sorry:" + user);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.release(resultSet, preparedStatement, connection);
		}
	}
}