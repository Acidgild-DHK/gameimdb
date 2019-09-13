<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Game Site</title>
<style type="text/css">
<%@include file="WEB-INF/Style.css"%>
</style>
<script src="scripts/register-validation.js">

</script>
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
	out.println(st);
}

%>
Enter Information below to create an account

</h1>
<div>
<form name="registrationForm" action="RegVerify" onsubmit="return formValidation();" method="post" required>
<table style="width:50%">
<tr>
<td>Username</td>
<td><input type="text" name="username"></td>
</tr>

<tr>
<td>Tag/Screen Name</td>
<td><input type="text" name="name" ></td>
</tr>

<tr>
<td>Name</td>
<td><input type="text" name="flname"></td>
</tr>

<tr>
<td>Age in years</td>
<td><input type="text" name="age" ></td>
</tr>

<tr>
<td>Email:</td>
<td><input type="text" name="email"></td>
</tr>

<tr>
<td>Password: 5-12 characters</td>
<td><input type="password" name="password" ></td>
</tr>

<tr>
<td>Security Question:</td>
<td><input type="text" name="question" >?</td>
</tr>

<tr>
<td>Answer:</td>
<td><input type="text" name="answer"></td>
</tr>

</table>
<input type="submit" value="Submit">
</form>
</div>
</body>
</html>