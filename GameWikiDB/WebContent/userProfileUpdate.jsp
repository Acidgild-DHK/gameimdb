
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
<%@include file="WEB-INF/Style.css"%>
</style>
<script src="scripts/profile-validation.js">

</script>
<meta charset="ISO-8859-1">
<title>Game Site</title>
<% 
request.getSession().setAttribute("valid","");
request.getRequestDispatcher("validLogin.jsp").include(request,response);

String val=(String)request.getSession().getAttribute("valid");
if(val!=null && val.equals("false")) {
	return;
} %>
</head>
<body>
<h2>Update Profile</h2>
	<div>
	<form name = "profileForm" align="center" action="user_update" onSubmit = "return formValidation()" method="post">
	<table>
	<tr>
	<td>Gamer Tag:</td> <td><input default=type="text" name="gamer_tag" ></td></tr> <br />
	<td>Email: </td> <td><input type="text" name="email" ></td></tr> <br />
	<td>Name:</td> <td> <input type="text" name="name" ></td></tr> <br />
	<td>Age:</td> <td> <input type="number" name="age" ></td></tr><br />
	</table>
	<input type = "submit" value ="update">
	</form>
	
	</div>
</body>
</html>