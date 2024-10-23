package com.jsp.student.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class Student_Connection {
public static Connection getStudentConnection() {
	
	try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		 String url = "jdbc:mysql://localhost:3306/servlet";
         String user = "root";
         String pass = "9999";
         
         return DriverManager.getConnection(url, user, pass);
         
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
		
	}
	
}
}
