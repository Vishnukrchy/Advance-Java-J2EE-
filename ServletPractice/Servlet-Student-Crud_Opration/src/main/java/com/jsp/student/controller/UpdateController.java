package com.jsp.student.controller;
import java.io.IOException;

import com.jsp.student.dao.StudentDao;
import com.jsp.student.dto.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(value = "/studentUpdate")
public class UpdateController extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        int id =Integer.valueOf(req.getParameter("id"));
			String email = req.getParameter("email");
			String newName = req.getParameter("name");
			String newPhone = req.getParameter("phone");
			String degree = req.getParameter("degree");
			String branch = req.getParameter("branch");
			String gender = req.getParameter("gender");
			String password = req.getParameter("password");
			
			Student s=new Student(id, newName, email, newPhone, degree, branch, gender, password);
			StudentDao stDao=new StudentDao();
			System.out.println("Update Details is "+s);
			stDao.updateStudentByEmail(s);
			req.getRequestDispatcher("home.jsp").forward(req, resp);
}
}
