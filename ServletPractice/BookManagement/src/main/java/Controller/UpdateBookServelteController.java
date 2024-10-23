package Controller;

import java.io.IOException;

import DAO.BookDAO;
import DTO.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateBook")
public class UpdateBookServelteController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("book-id"));
		String name = req.getParameter("book-name");
		String authorname = req.getParameter("author-name");
		String title = req.getParameter("book-title");
		double price = Double.parseDouble(req.getParameter("price"));
		
		
		
		boolean result=new BookDAO().updateBookById(id, name, authorname, title, price);
		System.out.println(result);
		if (result) {
			resp.sendRedirect("home.jsp");
		} else {
req.getRequestDispatcher("upadte.jsp").forward(req, resp);;
		}
	}
}
