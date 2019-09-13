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
<script src="scripts/answer-validation.js">

</script>
</head>
<body>


<%@ page import="service.UserService" %>
<%@ page import="model.User"%>


<%
String username=(String)request.getParameter("username");
request.getSession().setAttribute("username", username);
UserService userServ = new UserService(username);
User user = userServ.getUser();

String q=user.getQuestion();
%>
<div>
<form name="answerForm" action="ForgotPassword" onSubmit="return formValidation()" method="post">
<table border="1" style width:50%><tr><td id="q">
<h2>Answer the below security question in order to reset your password</h2></td></tr>
<tr><td id="question"><%=q %>

</td></tr>
<tr ><td id="question2"><input type="text" name="answer"></td></tr></table><br>
<input type="submit" name="Submit" width="135">

</form>
</div>
</body>
</html>