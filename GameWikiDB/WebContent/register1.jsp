<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<h1>
<%

String st=(String)request.getSession().getAttribute("error");
Boolean log=(Boolean)request.getSession().getAttribute("login");

RequestDispatcher rd1;
if(log) {
	rd1=request.getRequestDispatcher("headerLoggedIn.jsp");
}
else {
	rd1=request.getRequestDispatcher("header.jsp");
	
}
rd1.include(request, response);



if(st!=null ) {
	
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
<form action="RegVerify" method="post">
<table style="width:50%">
<tr>
<td>Username</td>
<td><input type="text" name="username"></td>
</tr>

<tr>
<td>Tag/Screen Name</td>
<td><input type="text" name="name"></td>
</tr>

<tr>
<td>Name(first and last)</td>
<td><input type="text" name="flname"></td>
</tr>

<tr>
<td>Age in years</td>
<td><input type="text" name="age"></td>
</tr>



<tr>
<td>Password: Max 25 characters</td>
<td><input type="password" name="password"></td>
</tr>

</table>
<input type="submit" value="Submit">
</form>
</body>
</html>