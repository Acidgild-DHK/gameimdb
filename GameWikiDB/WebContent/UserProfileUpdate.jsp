<<<<<<< Updated upstream:GameWikiDB/WebContent/UserProfileUpdate.jsp

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Profile</title>
<% request.getRequestDispatcher("/headerLoggedIn.jsp").include(request, response); %>
</head>
<body>

	
	<form action="UserProfileUpdate" method="post">
		Gamer Tag: <input type="text" name="gamer_tag"> <br />
		Email: <input type="text" name="email"> <br />
		<input type = "submit" value ="update">
	</form>
</body>
=======

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
<%@include file="WEB-INF/Style.css"%>
</style>
<meta charset="ISO-8859-1">
<title>Update Profile</title>
<% request.getRequestDispatcher("/headerLoggedIn.jsp").include(request, response); %>
</head>
<body>

	
	<form align="center"action="user_update" method="post">
	
		Gamer Tag: <input type="text" name="gamer_tag"> <br />
		Email: <input type="text" name="email"> <br />
		Name: <input type="text" name="name"> <br />
		Age: <input type="text" name="age"><br />
		<input type = "submit" value ="update">
	</form>
</body>
>>>>>>> Stashed changes:GameWikiDB/WebContent/userProfileUpdate.jsp
</html>