<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Librarian Page</title>
</head>
<body>
	<h1>Librarian Options</h1><br>
	<nav>  
		<a href="<%= request.getContextPath()%>/index.jsp">Back to Login</a><br>
	
		<a href="<%= request.getContextPath()%>/librarianUpdate.jsp">Update Username</a> 
		<a href="<%= request.getContextPath()%>/librarianUpdate2.jsp">Update Password</a> 
		<a href="<%= request.getContextPath()%>/librarianUpdate3.jsp">Update Patrons Account</a>
		
	</nav>

</body>
</html>