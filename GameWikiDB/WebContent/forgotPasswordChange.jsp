<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Password</title>
<style type="text/css">
<%@include file="WEB-INF/Style.css"%>
</style>

</head>
<body>
<%
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
%>
<div>
<form action="UserPasswordChange" method="post">
<table style width:50%">

<tr><td>New Password</td>
<td><input type="password" name="newpassword" ></td></tr>
<input type="hidden" value="true" name="isforgot">
</table>
<input type="submit" value="Change password" />
</form>
</div>


</body>
</html>