<%@page import="jakarta.servlet.http.HttpSession"%>
<%@page import="jakarta.servlet.http.HttpServletRequest"%>
<%@ page language="java" contentType="text/html; 
charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
}

.login-container {
	max-width: 400px;
	margin: 0 auto;
	padding: 20px;
	background-color: #fff;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.login-container h2 {
	text-align: center;
	margin-bottom: 20px;
}

.login-container input[type="text"], .login-container input[type="password"]
	{
	width: 100%;
	padding: 10px;
	margin-bottom: 10px;
	border: 1px solid #ccc;
	border-radius: 5px;
	box-sizing: border-box;
}

.login-container input[type="submit"] {
	width: 100%;
	padding: 10px;
	background-color: #007bff;
	color: #fff;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	transition: background-color 0.3s;
}

.login-container input[type="submit"]:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>
	<%
	/*   accept The msg from thr logController Class*/
	String msg = (String) request.getAttribute("msg");
	HttpSession httpSession = request.getSession();
	%>
	<%
	if (httpSession.getAttribute("stdSession") != null)
		;
	{
	%>
	    <%
	     httpSession.invalidate();
	    %>

	<%
	}
	%>
	<div class="login-container">
		<h2>Login</h2>
		*
		<form action="loginStudent" method="post">

			<!-- For Not Show Null Initially  -->
			<%
			if (msg != null) {
			%>
			<h5 style="color: red"><%=msg%></h5>
			<%
			}
			%>

			<input type="text" name="username" placeholder="Username" required>
			<input type="password" name="password" placeholder="Password"
				required> <input type="submit" value="Login">
		</form>
	</div>
</body>
</html>