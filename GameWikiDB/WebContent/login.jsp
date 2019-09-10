<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
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