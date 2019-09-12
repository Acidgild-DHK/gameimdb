<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
<%@include file="WEB-INF/Style.css"%>
</style>
<meta charset="ISO-8859-1">
<title>Index</title>
</head>
<body>
	<%
	
		String st=(String)request.getSession().getAttribute("error");
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
		// RequestDispatcher rd2=request.getRequestDispatcher("games.jsp");
		// rd2.include(request,response);
	%>
</body>
</html>