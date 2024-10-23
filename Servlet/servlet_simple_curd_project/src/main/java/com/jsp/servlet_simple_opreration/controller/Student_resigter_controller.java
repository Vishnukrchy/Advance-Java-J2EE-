package com.jsp.servlet_simple_opreration.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.jsp.servlet_simple_opreration.dao.StudentDao;
import com.jsp.servlet_simple_opreration.dto.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class Student_resigter_controller implements Servlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phone =req.getParameter("phone");
		String degree = req.getParameter("degree");
		String branch = req.getParameter("branch");
		String gender = req.getParameter("gender");
		String password = req.getParameter("password");

		// Print the received data
//		System.out.println("Name: " + name);
//		System.out.println("Email: " + email);
//		System.out.println("Phone: " + phone);
//		System.out.println("Qualification: " + qualification);
//		System.out.println("Branch: " + branch);
//		System.out.println("Gender: " + gender);
		
		StudentDao s_Dao = new StudentDao();

		Student s = new Student(name, email, phone, degree, branch, gender, password);
		Student student=s_Dao.insertRecord(s);

		PrintWriter printWriter = res.getWriter();
	 
		if (student!=null) {
			printWriter.write("<html><body><h2>Register</h2></body></html>");

			RequestDispatcher dispatcher = req.getRequestDispatcher("Log.jsp");
			dispatcher.include(req, res);

		} else {
			printWriter.write("<html><body><h2>Not Register</h2></body></html>");
			RequestDispatcher dispatcher=req.getRequestDispatcher("Student_register.jsp");
			dispatcher.include(req, res);
		}
		
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
