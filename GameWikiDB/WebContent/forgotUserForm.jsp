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

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
<h2>Forgot password? Enter username below to recover </h2>
<form action="forgotPasswordQ.jsp" method="post">
<table style width:50%">
<tr><td>Username</td>
<td><input type="text" name="username" required pattern="[a-zA-Z]{1}[a-zA-Z0-9]{5,}" 
title="Username must be at least 6 characters,starting with an alphabetic character" ></td></tr>


</table>
<input type="submit" value="Recover Password" />
</form>
</div>
</body>
</html>