<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Librarian Update Page</title>
</head>
<body>
<nav>  
		<a href="<%= request.getContextPath()%>/librarian.jsp">Home</a> 
	</nav>

<fieldset>
	<form method="POST" action="LibrarianServletUpdatePassword">
		<label for="password">Password</label><br>
		<input type="text" name="password" id="password"><br>
		<input type="submit">
	</form>
</fieldset>

</body>
</html>