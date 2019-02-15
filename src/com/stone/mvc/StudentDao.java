package com.stone.mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
	public void deleteByFlowId(Integer flowId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			String dirverClass = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://172.30.60.14:3306/mybatis";
			String user = "stest1";
			String password = "P@ssw0rd1";
			
			Class.forName(dirverClass);
			connection = DriverManager.getConnection(url, user, password);
			
			String sql = "delete from examstudent where flowid=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, flowId);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {			
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
	}
	
	public List<Student> getAll(){
		List<Student> students = new ArrayList<>(); 
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			String dirverClass = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://172.30.60.14:3306/mybatis";
			String user = "stest1";
			String password = "P@ssw0rd1";
			
			Class.forName(dirverClass);
			connection = DriverManager.getConnection(url, user, password);
			
			String sql = "select flowid,type,idcard,examcard,studentname,location,grade from examstudent";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Integer flowId = resultSet.getInt(1);
				Integer type = resultSet.getInt(2);
				String idCard = resultSet.getString(3);
				String examCard = resultSet.getString(4);
				String studentName = resultSet.getString(5);
				String location = resultSet.getString(6);
				Integer grade = resultSet.getInt(7);
				Student student = new Student(flowId, type, idCard, examCard, studentName, location, grade);
				students.add(student);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
		return students;
	}
}