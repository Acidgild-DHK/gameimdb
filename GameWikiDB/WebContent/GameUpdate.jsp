<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Game Update</title>
</head>
<body>

<% request.getRequestDispatcher("/headerLoggedIn.jsp").include(request, response); %>
<br/>
<h2>Insert</h2>
<form action="GameUpdate" method="post"></form>
<input type="hidden" name="type" value="insert">
		Add Game<input type="text" name="name"> 
		<input type="submit" value="Add Game">
</body>
</html>