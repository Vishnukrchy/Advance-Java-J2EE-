package com.jsp.student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.jsp.student.dao.StudentDao;

import com.jsp.student.dto.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class StudentRegisterController implements Servlet {

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

		int id = Integer.valueOf(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String degree = req.getParameter("degree");
		String branch = req.getParameter("branch");
		String gender = req.getParameter("gender");
		String password = req.getParameter("password");
		
		Student  s= new Student(id, name, email, phone, degree, branch, gender, password);
		
		StudentDao dao =new StudentDao();
		Student student =dao.insertRecord(s);
		PrintWriter printWriter = res.getWriter();
		 
		if (student!=null) {
			printWriter.write("<html><body><h2>Register</h2></body></html>");

			RequestDispatcher dispatcher = req.getRequestDispatcher("Login.jsp");
			dispatcher.include(req, res);

		} else {
			printWriter.write("<html><body><h2>Not Register</h2></body></html>");
			RequestDispatcher dispatcher=req.getRequestDispatcher("student-register.jsp");
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
