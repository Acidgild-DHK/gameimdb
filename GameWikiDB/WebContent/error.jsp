<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    isErrorPage="true" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
<%@include file="WEB-INF/Style.css"%>
</head>
<body>
<%
	request.getSession().invalidate(); 
	request.getRequestDispatcher("header.jsp").include(request, response);
%>
<h1>Something went wrong. Please try again later.</h1>
</body>
</html>