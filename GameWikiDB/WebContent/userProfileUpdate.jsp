
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
<%@include file="WEB-INF/Style.css"%>
</style>
<meta charset="ISO-8859-1">
<title>Update Profile</title>
<% request.getRequestDispatcher("/headerLoggedIn.jsp").include(request, response); %>
</head>
<body>

	<div>
	<form align="center"action="user_update" method="post">
	<table>
	<tr>
	<td>Gamer Tag:</td> <td><input type="text" name="gamer_tag"></td></tr> <br />
	<td>Email: </td> <td><input type="text" name="email"></td></tr> <br />
	<td>Name:</td> <td> <input type="text" name="name"></td></tr> <br />
	<td>Age:</td> <td> <input type="text" name="age"></td></tr><br />
	</table>
	<input type = "submit" value ="update">
	</form>
	
	</div>
</body>
</html>