<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
<%@include file="WEB-INF/Style.css"%>
</style>
<%


	RequestDispatcher rd1;
	rd1=request.getRequestDispatcher("header.jsp");
	rd1.include(request,response);
%>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>You must be logged in to access that page</h1>
<h1>This page will redirect to login</h1>
<meta http-equiv="Refresh" content="5;url=login.jsp">
</body>
</html>