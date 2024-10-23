package com.jsp.servlet_simple_opreration.controller;

import java.io.IOException;

import com.jsp.servlet_simple_opreration.dao.StudentDao;
import com.jsp.servlet_simple_opreration.dto.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/studentUpdate")
public class UpdateController extends HttpServlet {

//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// Get the parameters from the request
//		String email = request.getParameter("email");
//		String newName = request.getParameter("name");
//		String newPhone = request.getParameter("phone");
//		String degree = request.getParameter("degree");
//		String branch = request.getParameter("branch");
//		String gender = request.getParameter("gender");
//		String password = request.getParameter("password");
//
//		
//		StudentDao studentDao = new StudentDao();
//
//		
//		studentDao.updateStudent(email, newName, newPhone, degree, branch, gender, password);
//		request.getRequestDispatcher("home.jsp").forward(request, response);
//
//	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		StudentDao dao = new StudentDao();

		String email = request.getParameter("email");
		String newName = request.getParameter("name");
		String newPhone = request.getParameter("phone");
		String degree = request.getParameter("degree");
		String branch = request.getParameter("branch");
		String gender = request.getParameter("gender");
		String password = request.getParameter("password");

		
		Student student = new Student(newName, email, newPhone, degree, branch, gender, password);
		
		dao.updateStudentByEmail(student);
		
	      request.getRequestDispatcher("home.jsp").forward(request, resp);
	}
}


