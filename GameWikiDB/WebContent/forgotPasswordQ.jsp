<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
<%@include file="WEB-INF/Style.css"%>
</style>

</head>
<body>
<div>
<form action="ForgotPassword" method="post">
<%@ page import="service.UserService" %>
<%@ page import="model.User"%>
<h2>Answer the below security question in order to reset your password</h2>
<table style width:50%><tr><td><h3>
<%
String username=(String)request.getParameter("username");
request.getSession().setAttribute("username", username);
UserService userServ = new UserService(username);
User user = userServ.getUser();

String q=user.getQuestion();
%>
<%=q %>
</h3>
</td></tr>
<tr><td><input type="text" name="answer"></td></tr></table><br>
<input type="submit" name="Submit" width="135">

</form>
</div>
</body>
</html>