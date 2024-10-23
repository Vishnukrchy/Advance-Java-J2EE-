<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!--  Script   -->
	<%for(int i=0;i<=10;i++) { %>
	<!--  Expression -->
	<%-- <p > <%=i %></p> --%>

	<!--  Conditional statemnts  -->
	<%if(i%2==0){ %>
	<!--  Expression -->
	<p style="color: red">  <%=i %></p>
  
     <%}  else{%>
     <!--  Expression -->
     <p style="color: green;"> <%=i %></p>
     <%} %>

    <%} %>
    
    <%! 
    public String getTodayDate(){
    	
    	return "Today date is "+LocalDate.now();
    }
    %>
    <% %>
</body>
</html>