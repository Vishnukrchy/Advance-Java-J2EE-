<%@page import="java.util.List"%>
<%@page import="com.jsp.servlet_simple_opreration.dao.StudentDao"%>
<%@page import="com.jsp.servlet_simple_opreration.dto.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Student Homepage</title>
<!--   <style>
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
    }

    nav ul {
      list-style-type: none;
      padding: 0;
      text-align: center;
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
      max-width: 600px;
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

    footer {
      background-color: #333;
      color: #fff;
      text-align: center;
      padding: 20px 0;
      width: 100%;
      position: fixed;
      bottom: 0;
    }

    footer p {
      margin: 0;
    }
  </style> -->
</head>
<body>
	<header>
		<h1>Welcome to My Student Homepage</h1>
		
		<a href="Log.jsp"><button>Log out</button></a>
	</header>

	<%
	StudentDao stDao = new StudentDao();
	List<Student> stdList = stDao.getAllDetails();
	%>
	<div align=" center">
		<table border="1px">
			<tr>
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
				<td><%=std.getEmail()%></td>
				<td><%=std.getName()%></td>
				<td><%=std.getGender()%></td>
				<td><%=std.getBranch()%></td>
				<td><%=std.getDegree()%></td>
				<td><%=std.getPassword()%></td>
				<td><%=std.getPhone()%></td>
				<td style="background-color: red"><a
					href="delete?email=<%=std.getEmail()%>"><button>DELETE</button></a></td>

				<%-- <td><a href="update?email=<%=std.getEmail()%>"><button>UPDATE</button></a></td> --%>
				<td><a href="update.jsp?id=<%=std.getEmail()%>"><button>UPDATE</button></a></td>

			</tr>

			<%
			}
			%>
		</table>
	</div>

















	<%-- <nav>
    <ul>
      <li><a href="#about">About Me</a></li>
      <li><a href="#courses">Courses</a></li>
      <li><a href="#contact">Contact</a></li>
    </ul>
  </nav>

  <main>
    <section id="about">
      <h2>Student Table</h2>
 
	
    </section>
    
    <section id="courses">
      <h2>Courses</h2>
      <ul>
        <li>Mathematics</li>
        <li>Science</li>
        <li>History</li>
        <li>English</li>
      </ul>
    </section>
    
    <section id="contact">
      <h2>Contact</h2>
      <p>You can reach me at: <a href="mailto:your.email@example.com" style="color: #333;">your.email@example.com</a></p>
    </section>
  </main>

  <footer>
    <p>&copy; 2024 Student Homepage. All rights reserved.</p> --%>
	<!--   </footer> -->



</body>
</html>
,
