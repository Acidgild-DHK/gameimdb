<%@ page import="model.User" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Profile</title>
<% request.getRequestDispatcher("/headerLoggedIn.jsp").include(request, response); %>
</head>
<body>
	<% 
	User user = (User) request.getAttribute("user");
	
	%>

	<table>
		<tr>
			<td>UserName</td>
			<td><%=user.getUsername() %></td>
		</tr>
		<tr>
			<td>Gamer Tag</td>
			<td><%=user.getGamerTag() %></td>
		</tr>
		<tr>
			<td>Name</td>
			<td><%=user.getName()%></td>
		</tr>
		<tr>
			<td>Age</td>
			<td><%=user.getAge() %></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><%=user.getEmail() %></td>
		</tr>
	</table>
	<form action="userProfileUpdate.jsp" method ="get">
		<input type="submit" value="Update">
	</form>	
	<form action="" method="get">
		<input type="submit" value="Change Password">
	</form>
</body>
</html>