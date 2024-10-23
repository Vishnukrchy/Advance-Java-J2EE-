<%@page import="jakarta.servlet.http.HttpSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="login.css">
</head>
<body>
	<div class="login-box">
		<h2>Login</h2>
		<form action="loginStudents" method="post">
			<%
			String msg = (String) request.getAttribute("msg");
			HttpSession httpSession = request.getSession();
		//	String email=(String)httpSession.getAttribute("studentSession");
			%>
			
			
			<%
			if (httpSession.getAttribute("studentSession") != null);{
			%>
				<!-- We can only write java code in srciptlet tag -->
			<%
			httpSession.invalidate();
			%>
			


			<%
			}
			%>

			<div class="user-box">
				//
				<!-- For Not Show Null Initially  -->
				<%
				if (msg != null) {
				%>
				<h5 style="color: red"><%=msg%></h5>
				<%
				}
				%>
				<input type="text" name="userName" required=""> <label>Username</label>
			</div>
			<div class="user-box">
				<input type="password" name="password" required=""> <label>Password</label>
			</div>
			<!--  <a href="#">
      <span></span>
      <span></span>
      <span></span>
      <span></span>
      Submit
    </a> -->
			 <input type="submit" required="required" style="height: 20px"
				width="20px"> 
			<%--  <a href="submit?email=<%=httpSession.getAttribute("studentSession") %>>"><button>Submit</button></a> --%>
		</form>
	</div>
</body>
</body>
</html>