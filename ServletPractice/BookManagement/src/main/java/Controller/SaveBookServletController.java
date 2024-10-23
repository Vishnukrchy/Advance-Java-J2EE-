package Controller;

import java.io.IOException;

import DAO.BookDAO;
import DTO.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/saveBook")
public class SaveBookServletController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("book-id"));
		String name = req.getParameter("book-name");
		String title = req.getParameter("book-title");
		String anmae = req.getParameter("author-name");
		double price = Double.parseDouble(req.getParameter("price"));
		
		Book book=new Book(id, name, title, name, price);
		
		Book book1=new BookDAO().saveBook(book);
		
		if (book1!=null) {
			resp.sendRedirect("home.jsp");
		}else {
			resp.sendRedirect("addBook.jsp");
		}
		
		
		
		
	}
}
