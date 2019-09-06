<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<style type="text/css">
<%@include file="WEB-INF/Style.css"%>
</style>
<%

request.getSession().invalidate();
response.sendRedirect("index.jsp");
%>
</body>
</html>