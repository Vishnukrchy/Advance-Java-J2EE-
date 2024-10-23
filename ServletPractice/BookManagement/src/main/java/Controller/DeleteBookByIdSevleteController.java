package Controller;

import java.io.IOException;

import DAO.BookDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteBookByIdSevleteController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		boolean result = new BookDAO().deleteById(id);
		System.out.println(result ? " Data Is Deleted" : "Data Not Deletd");
		if (result) {
			resp.sendRedirect("home.jsp");
		}
	}
}
