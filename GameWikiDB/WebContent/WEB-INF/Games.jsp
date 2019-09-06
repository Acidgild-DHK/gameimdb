<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Games</title>
</head>

<body>
<% request.getRequestDispatcher("/headerLoggedIn.jsp").include(request, response); %>
<ul>
<li> <a href="GameSearch.jsp">Search through Games by name</a></li>
<li> <a href="GameTable.jsp">Table of Games</a></li>
<li> <a href="GameUpdate.jsp">Add a Game</a></li>
</ul>
</body>
</html>