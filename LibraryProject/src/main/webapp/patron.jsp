<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patron Page</title>
</head>
<body>
	<h1>Patron Options</h1><br>
	<br>

	<nav> 
		<a href="<%= request.getContextPath()%>/index.jsp">Back to Login</a><br>
	
		<a href="<%= request.getContextPath()%>/patronUpdate.jsp">Update Name</a>  
		<a href="<%= request.getContextPath()%>/patronUpdate2.jsp">Update Username</a> 
		<a href="<%= request.getContextPath()%>/patronUpdate3.jsp">Update Password</a> 
	</nav>

</body>
</html>