<%@page import="com.jsp.servlet_simple_opreration.dto.Student"%>
<%@page import="com.jsp.servlet_simple_opreration.dao.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
<style type="text/css">
body {
	font-family: Arial, sans-serif;
	background-color: #f0f0f0;
	margin: 0;
	padding: 0;
}

form {
	max-width: 600px;
	margin: 20px auto;
	padding: 20px;
	background-color: #fff;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

label {
	display: block;
	margin-bottom: 10px;
}

input[type="text"], input[type="email"], input[type="password"], input[type="tel"],
	input[type="submit"] {
	width: calc(100% - 20px);
	padding: 10px;
	margin-bottom: 10px;
	border: 1px solid #ccc;
	border-radius: 4px;
	font-size: 16px;
	box-sizing: border-box;
}

input[type="submit"] {
	background-color: #007bff;
	color: #fff;
	cursor: pointer;
}

input[type="submit"]:hover {
	background-color: #0056b3;
}

/* Flex container for radio buttons */
.flex-container {
	display: flex;
	justify-content: space-between;
}

/* Styling for radio buttons */
.radio-container label {
	margin-right: 20px;
}
</style>

</head>
<body>



	<%
	StudentDao studentDao = new StudentDao();
	String email = request.getParameter("email");
    Student student=  studentDao.getStudentSetailsByEmail(email);

	
	%>
    <form action="studentU*6pdate" method="post">
		<label for="f1">Name</label> <input type="text"
			placeholder="Enter Student Name" id="f1" name="name" value="<%= student.getName()%>"> <label
			for="f2">Email</label> <input type="email"
			placeholder="Enter Student Email" id="f2" name="email" value="<%= student.getEmail()%>" > <label
			for="f3">Password</label> <input type="password"
			placeholder="Enter password No" id="f3" name="password" value="<%= student.getPassword()%>"> <label
			for="f4">Phone</label> <input type="tel"
			placeholder="Enter Student phone No" id="f4" name="phone" value="<%= student.getPhone()%>">

		<!-- Degree, Branch, and Gender in row -->
		<div class="flex-container">
			<div class="radio-container">
				<label>Degree</label> <input type="radio" name="degree"
					value="B.tech" <%if(student.getDegree().equalsIgnoreCase("B.tech")){ %>checked="true" <% }%>> B.tech
					
					 
					<input type="radio" name="degree"	value="BCA"   <%if(student.getDegree().equalsIgnoreCase("BCA")){ %>checked="true" <% }%>> BCA 
				
					<input type="radio" name="degree"value="Others"  <%if(student.getDegree().equalsIgnoreCase("Others")){ %>checked="true" <% }%>> Others
				
			</div>
			<div class="radio-container">
				<label>Branch</label> <input type="radio" name="branch" value="CS"  <%if(student.getBranch().equalsIgnoreCase("CS")){ %>checked="true" <% }%>>
				CS <input type="radio" name="branch" value="Non-CS" <%if(student.getBranch().equalsIgnoreCase("Non-CS")){ %>checked="true" <% }%>> Non-CS
				<input type="radio" name="branch" value="Others" <%if(student.getBranch().equalsIgnoreCase("Others")){ %>checked="true" <% }%>> Others
			</div>
			<div class="radio-container">
				<label>Gender</label> <input type="radio" name="gender" value="M" <%if(student.getGender().equalsIgnoreCase("M")){ %>checked="true" <% }%>>
				Male <input type="radio" name="gender" value="F" <%if(student.getGender().equalsIgnoreCase("F")){ %>checked="true" <% }%>> Female <input
					type="radio" name="gender" value="O" <%if(student.getGender().equalsIgnoreCase("O")){ %>checked="true" <% }%>> Others
			</div>
		</div>

		<input type="submit" name="submit" value="Update">
	</form>
	
	
	
	


</body>
</html>