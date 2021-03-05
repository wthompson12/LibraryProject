<%@page import="com.cognixia.jump.model.Patron"%>
<%@page import="java.util.List"%>

<%@ include file="header.jsp" %>
	
	
	<nav>  
		<a href="<%= request.getContextPath()%>/librarian.jsp">Home</a> 
	</nav>
	
	<form method="post" action="LibrarianServletUpdatePatrons">
	<div class="mb-3">
		    <label for="patronsid" class="form-label">Patrons Id</label>
		    <input type="number" class="form-control" id="patronsid" name="patronsid" >
		    <label for="account" class="form-label">Account Frozen Status</label>
		    <input type="number" min="0" max="1" class="form-control" id="account" name="account" >
		  </div>
		  <button type="submit" class="btn btn-primary">Submit</button>
	</form>
	
	<form method="get" action="LibrarianServletUpdatePatrons">
	<button  type="submit" class="btn btn-primary">Show ALL Patrons</button>
	<h2>Patrons Accounts: </h2>
	
	<dl>
	<%List<Patron> patrons = (List<Patron>) request.getAttribute("patron"); 
	if (patrons != null ){
		for (Patron patron : patrons){
	%>
		<dt>Id: <%=patron.getId() %>  &emsp; Patron Name: (<%=patron.getFirstName() %>, <%=patron.getLastName() %>)  &emsp; Is Account Frozen: <%=patron.isAccountFrozen() %></dt>
		
	<%	} 
	}
	%>
	</dl>
	</form>
	
	
<%@ include file="footer.jsp" %>