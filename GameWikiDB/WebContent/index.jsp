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
	session.setAttribute("username", "kurwhibble");
	getServletContext().getRequestDispatcher("/user_logs").forward(request, response);
%>

</body>
</html>