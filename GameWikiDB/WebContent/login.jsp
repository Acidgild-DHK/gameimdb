<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Game Site</title>
<script>
function validateForm() {
	  var uname = document.forms["loginForm"]["username"].value;
	  var pass = document.forms["loginForm"]["password"].value
	  if (uname == "" || pass == "") {
	    alert("Username and password must be filled out");
	    return false;
	  }
	}
</script>
</head>
<body>
<style type="text/css">
<%@include file="WEB-INF/Style.css"%>
</style>
<%
String st=(String)request.getSession().getAttribute("error");
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
rd1.include(request,response);
if(st!=null ) {

	out.println("<h2>" + st + "</h2>");
}

%>
<div>
<h2>Enter your username and password below to log in</h2>
<form name="loginForm" action="LoginServ" onsubmit="return validateForm()" method="post">
<table style width:50%">
<tr><td>Username</td>
<td><input type="text" name="username"></td></tr>

<tr><td>Password</td>
<td><input type="password" name="password"></td></tr>


</table>
<input type="submit" value="Login" /></form>

<br>
<h2><a href="forgotUserForm.jsp"> Forgot Password?</a></h2>

</form>
</div>
</body>
</html>