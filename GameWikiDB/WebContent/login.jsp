<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<script>
function validateForm() {
  var x = document.forms["login"]["username"].value;
  var y=document.forms["login"]["password"].value;
  if (x == "" || y == "") {
    alert("Name and password must be filled out");
    return false;
  }
}
</script>
</head>
<body>
<style type="text/css">
<%@ include file="WEB-INF/Style.css" %>
</style>
	<%
		String st = (String) request.getSession().getAttribute("error");
		Boolean log = false;
		if (request.getSession().getAttribute("login") != null) {
			log = (Boolean) request.getSession().getAttribute("login");
		}

		RequestDispatcher rd1;
		if (log) {
			rd1 = request.getRequestDispatcher("headerLoggedIn.jsp");
		} else {
			rd1 = request.getRequestDispatcher("header.jsp");

		}
		rd1.include(request, response);
		if (st != null) {

<<<<<<< HEAD
%>

<div>
<form name="login"  method="post" onsubmit="return validateForm()">
<table style width:50%">
<tr><td>Username</td>
<td><input type="text" name="username"></td></tr>
=======
			out.println("<h2>" + st + "</h2>");
		}
	%>
	<div>
		<form action="LoginServ" method="post">
			<table stylewidth:50%">
				<tr>
					<td>Username</td>
					<td><input type="text" name="username"></td>
				</tr>
>>>>>>> Karissa_branch

				<tr>
					<td>Password</td>
					<td><input type="password" name="password"></td>
				</tr>


			</table>
			<input type="submit" value="Login" />
		</form>
	</div>
</body>
</html>