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


request.getSession().setAttribute("valid","");
	request.getRequestDispatcher("validLogin.jsp").include(request,response);

	String val=(String)request.getSession().getAttribute("valid");
	if(val!=null && val.equals("false")) {
		return;
	}
%>

%>
<div>
<form action="UserPasswordChange" method="post">
<table style width:50%">

<tr><td>Current Password</td>
<td><input type="password" name="currpassword" ></td></tr>

<tr><td>New Password</td>
<td><input type="password" name="newpassword" ></td></tr>

</table>
<input type="submit" value="Change password" />
</form>
</div>


</body>
</html>