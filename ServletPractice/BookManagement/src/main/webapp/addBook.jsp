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
	justify-content: center;
	align-items: center;
	height: 100vh;
	margin: 0;
}

.form-container {
	background-color: white;
	padding: 20px;
	border-radius: 10px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	width: 400px;
}

.form-container h2 {
	text-align: center;
	margin-bottom: 20px;
}

.form-container label {
	display: block;
	margin-bottom: 5px;
	font-weight: bold;
}

.form-container input[type="text"], .form-container input[type="number"]
	{
	width: 100%;
	padding: 10px;
	margin-bottom: 15px;
	border: 1px solid #ccc;
	border-radius: 5px;
}

.form-container button {
	width: 100%;
	padding: 10px;
	background-color: #007bff;
	color: white;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	font-size: 16px;
}

.form-container button:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>
	<div class="form-container">
		<h2>Book Information</h2>
		<form action="saveBook" method="post">
			<label for="book-id">Book ID:</label> <input type="text" id="book-id"
				name="book-id" required> <label for="book-name">Book
				Name:</label> <input type="text" id="book-name" name="book-name" required>

			<label for="book-title">Book Title:</label> <input type="text"
				id="book-title" name="book-title" required> <label
				for="author-name">Author Name:</label> <input type="text"
				id="author-name" name="author-name" required> <label
				for="price">Price:</label> <input type="number" id="price"
				name="price" required>

			<button type="submit">Submit</button>
		</form>
	</div>
</body>
</html>