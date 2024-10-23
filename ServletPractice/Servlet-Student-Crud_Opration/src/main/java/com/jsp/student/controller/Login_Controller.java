package com.jsp.student.controller;

import java.io.IOException;

import com.jsp.student.dto.Student;
import com.jsp.student.service.StudentService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Login_Controller extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 /*
		  * Student Session will be created by the HttpSession Interface 
		  * and get the Session and after the log in we set the session 
		  */
		HttpSession httpSession=req.getSession();
		
		
		String user=req.getParameter("userName");
		String pass=req.getParameter("password");
		StudentService service=new StudentService();
		
		
		Student student= service.fetchStudentByEmailForLoginService(user);
		
		if (student!=null) {
			if (student.getPassword().equals(pass)) {
				req.getRequestDispatcher("home.jsp").forward(req, resp);
				/*
				 * the session object is set by setAttribute(variable,details)
				 * 
				 * for  session time out after an paarticular time we 
				 * have to use setMaxInactiveInterval(30)  method
				 * 
				 * 
				 */
				
				httpSession.setMaxInactiveInterval(30);
			//	req.setAttribute("name", user);
				
				httpSession.setAttribute("studentSession", user);
				
			} else {
				req.setAttribute("msg", "inccorrect password");
				RequestDispatcher requestDispatcher=req.getRequestDispatcher("Login.jsp");
				requestDispatcher.include(req, resp);
				

			}
		}
		else {
			req.setAttribute("msg", "inccorrect email");
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("Login.jsp");
			requestDispatcher.include(req, resp);
			
		}
		
		
	}

}
