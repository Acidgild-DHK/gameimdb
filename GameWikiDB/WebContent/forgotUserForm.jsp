<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<% Boolean log=false;
if(request.getSession().getAttribute("login")!=null) {
	log=(Boolean)request.getSession().getAttribute("login");
}

RequestDispatcher rd1;
if(log) {
	rd1=request.getRequestDispatcher("headerLoggedIn.jsp");
}
else {
	rd1=request.getRequestDispatcher("header.jsp");
	
}%>
<style type="text/css">
<%@include file="WEB-INF/Style.css"%>
</style>
<script src="scripts/username-validation.js">

</script>
<meta charset="ISO-8859-1">
<title>Game Site</title>
</head>
<body>
<div>
<h2>Forgot password? Enter username below to recover </h2>
<form name="usernameForm" action="forgotPasswordQ.jsp" onSubmit="return formValidation()" method="post">
<table style width:50%">
<tr><td>Username</td>
<td><input type="text" name="username" ></td></tr>


</table>
<input type="submit" value="Recover Password" />
</form>
</div>
</body>
</html>