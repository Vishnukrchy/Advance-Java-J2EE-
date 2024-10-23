<%@page import="jakarta.servlet.http.HttpSession"%>
<%@page import="com.jsp.student.dto.Student"%>
<%@page import="com.jsp.student.dao.StudentDao"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Student Homepage</title>
<style>
/* Reset some default browser styles */
body {
	font-family: Arial, sans-serif;
	line-height: 1.6;
	background-color: #f9f9f9;
	margin: 0;
	padding: 0;
}

/* Basic styling */
header {
	background-color: #333;
	color: #fff;
	padding: 20px 0;
	text-align: center;
	position: relative; /* Required for absolute positioning */
}

nav ul {
	list-style-type: none;
	padding: 0;
	text-align: center;
	margin: 0;
}

nav ul li {
	display: inline;
	margin-right: 20px;
}

nav ul li a {
	text-decoration: none;
	color: #fff;
	font-weight: bold;
}

/* Position logout button */
.logout-button {
	position: absolute;
	top: 20px; /* Adjust top position */
	right: 20px; /* Adjust right position */
}

main {
	padding: 20px;
	display: flex;
	flex-direction: column;
	align-items: center;
}

section {
	margin-bottom: 30px;
	padding: 20px;
	background-color: #fff;
	border-radius: 8px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	max-width: 900px; /* Increased width */
	width: 100%;
}

section h2 {
	margin-bottom: 20px;
	color: #333;
}

section p {
	color: #666;
	line-height: 1.8;
}

section ul {
	list-style-type: none;
	padding: 0;
}

section ul li {
	margin-bottom: 10px;
}

table {
	width: 100%; /* Table takes full width of its container */
	border-collapse: collapse; /* Collapses table borders */
}

th, td {
	border: 1px solid #ddd; /* Adding border to cells */
	padding: 8px;
	text-align: left;
}

th {
	background-color: #333;
	color: #fff;
}

.action-buttons button {
	padding: 8px 12px; /* Adjust button padding */
	background-color: #dc3545; /* Red color for delete button */
	border: none;
	color: white;
	border-radius: 4px;
	cursor: pointer;
	transition: background-color 0.3s; /* Smooth transition */
}

.action-buttons button.update {
	background-color: #007bff; /* Blue color for update button */
	margin-left: 5px;
}

.action-buttons button:hover {
	background-color: #c82333;
	/* Darker red color on hover for delete button */
}

.action-buttons button.update:hover {
	background-color: #0056b3;
	/* Darker blue color on hover for update button */
}
</style>
</head>
<body>
	<header>
		<h1>Welcome to My Student Homepage</h1>
		<nav>
			<ul>
				<li><a href="#about">About Me</a></li>
				<li><a href="#courses">Courses</a></li>
				<li><a href="#contact">Contact</a></li>
				<li><a href="#">Student</a></li>
				<!-- Added Student navbar item -->
			</ul>
		</nav>
		<a href="Login.jsp" class="logout-button"><button>Logout</button></a> <!-- Logout button -->
	</header>
	
	
	<%
	StudentDao stDao = new StudentDao();
	List<Student> stdList = stDao.getAllDetails();
	HttpSession httpSession=request.getSession();
	String email=(String)httpSession.getAttribute("studentSession");
     Student st=stDao.getNameBySessionAttributes(email);
			
			
			
	%>
<%-- 	<h><%= st.getName()%></h> --%>
	
	
	
	<main>
		<section id="student-table">
			<h2>Student Table</h2>
			<div style="overflow-x: auto;">
				<table>
					<tr>
						<th>Id</th>
						<th>Email</th>
						<th>Name</th>
						<th>Gender</th>
						<th>Branch</th>
						<th>Degree</th>
						<th>Password</th>
						<th>Phone</th>
						<th colspan="2">Action</th>
					</tr>
					<%
					for (Student std : stdList) {
					%>
					<tr>
						<td><%=std.getId()%></td>
						<td><%=std.getEmail()%></td>
						<td><%=std.getName()%></td>
						<td><%=std.getGender()%></td>
						<td><%=std.getBranch()%></td>
						<td><%=std.getDegree()%></td>
						<td><%=std.getPassword()%></td>
						<td><%=std.getPhone()%></td>
						<td class="action-buttons">
							<a href="delete?id=<%=std.getId()%>"><button>DELETE</button></a>
						</td>
						<td class="action-buttons"><a
							href="update.jsp?id=<%=std.getId()%>"><button
									class="update">UPDATE</button></a></td>
					</tr>
					<%
					}
					%>
				</table>
			</div>
		</section>
	</main>

	<footer>
		<p style="text-align: center;">&copy; 2024 Student Homepage. All rights reserved.</p>
	</footer>
	
	
</body>
</html>
