<%@ page import="model.User" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Profile</title>
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
	
%>
	<form action="/UserProfileUpdate.jsp" method ="get">
		<input type="submit" value="Update">
	</form>	
	<form action="" method="get">
		<input type="submit" value="Change Password">
	</form>
</body>
</html>