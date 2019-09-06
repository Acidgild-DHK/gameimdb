<<<<<<< Updated upstream:GameWikiDB/WebContent/UserProfile.jsp
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
	String userInfo = "<table>" +
			"<tr>" +
			"<td>UserName</td>" +
			"<td>" +
			user.username +
			"</td>" +
			"<tr>" +
			"<td>Gamer Tag</td>" +
			"<td>" +
			user.gamerTag +
			"</td>" +
			"<tr>" +
			"<td>Email</td>" +
			"<td>" +
			user.email +
			"</td>" +
			"</tr>" +
			"</table>";
	out.println(userInfo);
	
%>
	<form action="UserProfileUpdate.jsp" method ="get">
		<input type="submit" value="Update">
	</form>	
	<form action="" method="get">
		<input type="submit" value="Change Password">
	</form>
</body>
=======
<%@ page import="model.User" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
<%@include file="WEB-INF/Style.css"%>
</style>
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
>>>>>>> Stashed changes:GameWikiDB/WebContent/userProfile.jsp
</html>