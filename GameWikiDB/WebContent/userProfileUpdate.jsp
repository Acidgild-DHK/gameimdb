
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
<% 
request.getSession().setAttribute("valid","");
request.getRequestDispatcher("validLogin.jsp").include(request,response);

String val=(String)request.getSession().getAttribute("valid");
if(val!=null && val.equals("false")) {
	return;
} %>
</head>
<body>

	<div>
	<form align="center"action="user_update" method="post" onSubmit>
	<table>
	<tr>
	<td>Gamer Tag:</td> <td><input default=type="text" name="gamer_tag" required pattern="[a-zA-Z]+[a-zA-Z0-9]+" title="Gamertag is only alphanumeric characters and must start with alphabetic character"></td></tr> <br />
	<td>Email: </td> <td><input type="text" name="email" required pattern="[a-zA-Z0-9]+[@][a-zA-Z0-9]+.[a-zA-Z]{2,3}" title="Invalid email format"></td></tr> <br />
	<td>Name:</td> <td> <input type="text" name="name" required pattern="[a-zA-Z0-9'_]+" title="must include first and last name with space"></td></tr> <br />
	<td>Age:</td> <td> <input type="number" name="age" required min=0 max=120></td></tr><br />
	</table>
	<input type = "submit" value ="update">
	</form>
	
	</div>
</body>
</html>