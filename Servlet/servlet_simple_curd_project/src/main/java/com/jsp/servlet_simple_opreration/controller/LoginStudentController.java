package com.jsp.servlet_simple_opreration.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.jsp.servlet_simple_opreration.dto.Student;
import com.jsp.servlet_simple_opreration.service.StudentService;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginStudentController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession=req.getSession();
		
		StudentService service = new StudentService();

		String user = req.getParameter("username");
		String password = req.getParameter("password");

		Student student = service.fetchStudentByEmailForLoginService(user);
		PrintWriter printWriter = resp.getWriter();

		if (student != null) {

			if (student.getPassword().equals(password)) {
                  // Log in successfully
				httpSession.setAttribute("stdSession", user);
				req.getRequestDispatcher("home.jsp").forward(req, resp);
				
			} else {
				req.setAttribute("msg", " Incorrect password");

				req.getRequestDispatcher("Log.jsp").include(req, resp);
			}

		} else {

			req.setAttribute("msg", " incorrect Email");
//               req.getRequestDispatcher("login.jsp").forward(req, res);
			req.getRequestDispatcher("Log.jsp").include(req, resp);

		}
	}

	// @Override
//	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		StudentService service=new StudentService();
//		
//		String user=req.getParameter("username");
//		String password=req.getParameter("password");
//		
//		 Student student = service.fetchStudentByEmailForLoginService(user);
//		 PrintWriter printWriter=res.getWriter();
//		
//		if (student!=null) {
//			
//			if (student.getPassword().equals(password)) {
//				
//			req.getRequestDispatcher("home.jsp").forward(req, res);
//			} else {
//                   // Servlets part
////				printWriter.write("<html><body><h2>Password is wrong</h2></body></html>");
////				RequestDispatcher dispatcher = req.getRequestDispatcher("Log.jsp");
////				dispatcher.include(req, res);
//                req.getRequestDispatcher("Log.jsp").include(req, res);
//			}
//			
//		} else {
//			printWriter.write("<html><body><h2>Email  is wrong</h2></body></html>");
//			   
////               req.getRequestDispatcher("login.jsp").forward(req, res);
//			req.getRequestDispatcher("Log.jsp").include(req, res);
//			
//		}
//	}

}
