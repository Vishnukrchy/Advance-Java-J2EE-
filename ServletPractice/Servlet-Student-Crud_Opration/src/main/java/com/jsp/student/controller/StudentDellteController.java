package com.jsp.student.controller;

import java.io.IOException;

import com.jsp.student.dao.StudentDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(value = "/delete")
public class StudentDellteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();

		int id = Integer.valueOf(req.getParameter("id"));

		String str = (String) httpSession.getAttribute("studentSession");
		StudentDao stDao = new StudentDao();
		System.out.println("==== Deleted Id is =====" + id);

		if (str != null) {
			stDao.deleteStudentRecord(id);
			req.getRequestDispatcher("home.jsp").forward(req, resp);
			
		} else {
			req.setAttribute("msg", "your session is out");
			req.getRequestDispatcher("Login.jsp").forward(req, resp);
		}

	}
}
