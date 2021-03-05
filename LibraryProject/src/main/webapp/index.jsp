<%@ include file="header.jsp" %>
	<div class="container">
		<h2>User Login Page</h2>
	</div>
	
	<form method="post" action="LoginServlet">
	<fieldset>
	<legend>Type of User</legend>
	<div class="form-check">
  <input class="form-check-input" type="radio" name="usertype" id="librarian" value="Librarian">
  <label class="form-check-label" for="usertype">Librarian</label>
  </div>
	<div class="form-check">
  <input class="form-check-input" type="radio" name="usertype" id="patron" value="Patron">
  <label class="form-check-label" for="usertype">Patron</label>
 	</div>
	</fieldset>
		  <div class="mb-3">
		    <label for="exampleInputEmail1" class="form-label">User Name</label>
		    <input type="text" class="form-control" id="exampleInputEmail1" name="useremail" >
		  </div>
		  <div class="mb-3">
		    <label for="exampleInputPassword1" class="form-label">Password</label>
		    <input type="password" class="form-control" id="exampleInputPassword1" name="userpassword">
		  </div>
		  <button type="submit" class="btn btn-primary">Submit</button>
		</form><br>
		
		<nav> 
		<a href="<%= request.getContextPath()%>/signup.jsp">Sign Up</a><br>
	</nav>
	

<%@ include file="footer.jsp" %>
