package com.jsp.servlet_simple_opreration.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class StudentConnection {
    
    public static Connection geStudentConnection() {
    
        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
            String url = "jdbc:mysql://localhost:3306/mydatabase";
            String user = "root";
            String pass = "9999";
            
            return DriverManager.getConnection(url, user, pass);    
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
