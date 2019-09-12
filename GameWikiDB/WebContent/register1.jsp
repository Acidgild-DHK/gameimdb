<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<style type="text/css">
<%@include file="WEB-INF/Style.css"%>
</style>
</head>

<body>
<h1>
<%

String st=(String)request.getAttribute("error");
Boolean log=false;
if(request.getSession().getAttribute("login")!=null) {
	log=(Boolean)request.getSession().getAttribute("login");
}
RequestDispatcher rd1;
if(log) {
	rd1=request.getRequestDispatcher("headerLoggedIn.jsp");
}
else {
	rd1=request.getRequestDispatcher("header.jsp");
	
}
rd1.include(request, response);



System.out.println(st);
if(st!=null ) {
	if(st.equals("ageSt")) {
		out.print("Age must be a number, not characters");
	}
	if(st.equals("empty")) {
		out.print("Error registering: all fields must be filled<br>");
	}
	else if(st.equals("already exists")) {
		out.print("Error registering: username already taken<br>");
	}
	else if (st.equals("Password too long")) {
		out.print("Password cannot be longer than 25 characters<br>");
	}
	else if(st.equals("Invalid age")) {
		out.print("Age is in invalid range");
	}
	else if (st.equals("Invalid name")) {
		out.print("Name must be alphabetic characters only");
	}
}

%>
Enter Information below to create an account

</h1>
<div>
<form action="RegVerify" method="post" required>
<table style="width:50%">
<tr>
<td>Username</td>
<td><input type="text" name="username" required></td>
</tr>

<tr>
<td>Tag/Screen Name</td>
<td><input type="text" name="name" required></td>
</tr>

<tr>
<td>Name(first and last)</td>
<td><input type="text" name="flname" required></td>
</tr>

<tr>
<td>Age in years</td>
<td><input type="text" name="age" required></td>
</tr>



<tr>
<td>Password: Max 25 characters</td>
<td><input type="password" name="password" required></td>
</tr>

</table>
<input type="submit" value="Submit">
</form>
</div>
</body>
</html>