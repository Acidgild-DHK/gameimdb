<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
out.print((String)request.getAttribute("login"));
String log=(String)request.getAttribute("login");
boolean loggedIn=false;
if(log!=null && log.equals("true")) {
	loggedIn=true;
}
RequestDispatcher rd1;
if(loggedIn) {
	rd1=request.getRequestDispatcher("headerLoggedIn.jsp");
}
else {
	rd1=request.getRequestDispatcher("header.jsp");
	
}
%>
Anythign
</body>
</html>