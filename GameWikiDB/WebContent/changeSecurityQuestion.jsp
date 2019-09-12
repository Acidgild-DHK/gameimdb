<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Security Question</title>
<style type="text/css">
<%@include file="WEB-INF/Style.css"%>
</style>

<%
String err=(String)request.getSession().getAttribute("error");
if(err!=null && !err.isEmpty()) {
	out.print(err);
}
%>
</head>
<body>
<div>
<form action="ChangeQuestions" method="post">
<table style width:50%">
<tr><td>New Question</td>
<td><input type="text" name="question" maxlength="255" pattern="[.]{1,255}" title="Maximum length is 255"></td></tr>

<tr><td>New Answer</td>
<td><input type="text" name="answer" maxlength="255" pattern="[.]{1,255}" title="Maximum length is 255"></td></tr>

<tr><td>Password</td>
<td><input type="password" name="password" ></td></tr>

</table>
<input type="submit" name="Change question">
</form>
</div>
</body>
</html>