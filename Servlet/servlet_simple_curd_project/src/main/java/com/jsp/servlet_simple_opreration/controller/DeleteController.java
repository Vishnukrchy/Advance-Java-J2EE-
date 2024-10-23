package com.jsp.servlet_simple_opreration.controller;

import java.io.IOException;

import com.jsp.servlet_simple_opreration.dao.StudentDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet(value = "/delete")
public class DeleteController extends HttpServlet {
 // Before the session
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String email=req.getParameter("email");
//		
//		System.out.println(email);
//		
//		StudentDao std_Dao=new StudentDao();
//		std_Dao.deleteByEmail(email);
//		req.getRequestDispatcher("home.jsp").forward(req, resp);
//	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession=req.getSession();
		// set log session attributes
		
		String str=(String) req.getAttribute("stdSession");
		StudentDao studentDao=new StudentDao();
		// Get   email paramter;
		String email=req.getParameter("email");
		
		if (str!=null) {
			studentDao.deleteByEmail(email);
			req.getRequestDispatcher("home.jsp").forward(req, resp);
			
		} else {
			req.setAttribute("msg", "Your is Session is out");
           req.getRequestDispatcher("Log.jsp").include(req, resp);
		}
		
	}
}
