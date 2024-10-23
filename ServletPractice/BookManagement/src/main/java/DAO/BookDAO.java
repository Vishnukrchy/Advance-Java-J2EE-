package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.naming.PartialResultException;

import Connection.BookConnection;
import DTO.Book;

public class BookDAO {
	Connection connection = BookConnection.getCooncetion();

	public Book saveBook(Book book) {
		String insertQry = "insert Into Book(id,name,title,author,price) values(?,?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(insertQry);
			ps.setInt(1, book.getId());
			ps.setString(2, book.getName());
			ps.setString(3, book.getTitle());
			ps.setString(4, book.getAuthorName());
			ps.setDouble(5, book.getPrice());

			int result = ps.executeUpdate();
			if (result > 0) {
				return book;
			} else {
				return null;

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public List<Book> getAllBookDetails() {
		String selectQry = "Select * FRom Book";
		Statement ps;
		try {
			ps = connection.createStatement();
			ResultSet resultSet = ps.executeQuery(selectQry);
			List<Book> lisBooks = new LinkedList<>();
			Book book = null;
			while (resultSet.next()) {
				book = new Book(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getDouble(5));
				lisBooks.add(book);
			}
			return lisBooks;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public boolean deleteById(int id) {
		String deleteQry = "DELETE FROM BOOK WHERE ID=?";
		try {
			PreparedStatement ps = connection.prepareStatement(deleteQry);
			ps.setInt(1, id);
			int result = ps.executeUpdate();
			return result > 0 ? true : false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public boolean updateBookById(int id, String name, String authorname, String title, double price) {
        String updateQry = "UPDATE Book SET name=?, title=?, author=?, price=? WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(updateQry)) {
            ps.setString(1, name);
            ps.setString(2, title);
            ps.setString(3, authorname);
            ps.setDouble(4, price);
            ps.setInt(5, id);
            int result = ps.executeUpdate();
            return result > 0?true:false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

	public Book getBookDetailsByid(int id) {
		String selectQry = "Select * From  Book Where Id =?";
		try {
			PreparedStatement ps = connection.prepareStatement(selectQry);
			ps.setInt(1, id);
			ResultSet resultSet = ps.executeQuery();
			Book book = null;
			if (resultSet.next()) {
				book = new Book(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getDouble(5));
			}
			return book;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

}
