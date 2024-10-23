<%@page import="DTO.Book"%>
<%@page import="java.util.List"%>
<%@page import="DAO.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	font-family: Arial, sans-serif;
	background-color: #f0f0f0;
	display: flex;
	flex-direction: column;
	align-items: center;
	padding: 20px;
}

h1 {
	text-align: center;
	margin-bottom: 20px;
}

table {
	width: 80%;
	border-collapse: collapse;
	margin-bottom: 20px;
}

th, td {
	border: 1px solid #ccc;
	padding: 10px;
	text-align: left;
}

th {
	background-color: #f2f2f2;
}

tr:nth-child(even) {
	background-color: #f9f9f9;
}

.btn {
	padding: 5px 10px;
	margin: 2px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	font-size: 14px;
}

.btn-update {
	background-color: #007bff;
	color: white;
}

.btn-update:hover {
	background-color: #0056b3;
}

.btn-delete {
	background-color: #dc3545;
	color: white;
}

.btn-delete:hover {
	background-color: #c82333;
}
</style>
</head>
<body>
	<h1>Book Details</h1>
	<table>
		<thead>
			<tr>
				<th>Book ID</th>
				<th>Book Name</th>
				<th>Book Title</th>
				<th>Author Name</th>
				<th>Price</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<!-- Example book rows -->

			<%
			List<Book> lisBook = new BookDAO().getAllBookDetails();
			for (Book book : lisBook) {
			%>
			<tr>
				<td><%=book.getId()%></td>
				<td><%=book.getName()%></td>
				<td><%=book.getAuthorName()%></td>
				<td><%=book.getTitle()%></td>
				<td><%=book.getPrice()%></td>
				<td><a href="upadte.jsp?id=<%=book.getId()%>">
						<button class="btn btn-update">Update Book</button>
				</a> <a href="delete?id=<%=book.getId()%>">
						<button class="btn btn-delete">Delete Book</button>
				</a></td>
			</tr>
			<%
			}
			%>
			<!-- Add more book rows as needed -->
		</tbody>
	</table>
</body>
</html>