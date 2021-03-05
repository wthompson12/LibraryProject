<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<fieldset>
	<h2>Add a Product:</h2>
	<form method="POST" action="ProductUpdateServlet">
		<label for="firstname">First Name</label><br>
		<input type="text" name="firstname" id="firstname"><br>
		<label for="lastname">Last Name</label><br>
		<input type="text" name="lastname" id="lastname"><br>
		<input type="submit">
	</form>
</fieldset>
</body>
</html>