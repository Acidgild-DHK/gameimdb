<%@ page import="model.Game" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Games</title>
<style type="text/css">
<%@include file="WEB-INF/Style.css"%>
</style>

<% request.getRequestDispatcher("/headerLoggedIn.jsp").include(request, response); %>
</head>
<body>

<!-- 	<li> <a href="GameSearch.jsp">Search through Games by name</a></li> -->
<!-- <li> <a href="GameTable.jsp">Table of Games</a></li> -->
<!-- <li> <a href="GameUpdate.jsp">Add a Game</a></li> -->
<!-- </ul> -->
	<form action="gameAddLog.jsp" method="post">
		<input type="submit" value="Add Game">
	</form>
	 <display:table class="log" name="sessionScope.gameTable" pagesize="5" export="false" sort="list" decorator="model.GameWikiDecorator">
		  <display:column property="gameName" title="Game Title" sortable="true" headerClass="sortable" />
		  <display:column property="publisher" title="Publisher" sortable="true" headerClass="sortable" />
		  <display:column property="release_date" title="Release Date" sortable="true" headerClass="sortable" />
		  <display:column property="description" title="Description"  sortable="true" headerClass="sortable" />
		  <display:column property="esrb" title="ESRB Rating" sortable="true" headerClass="sortable" />
		  <display:column property="averageRating" title="Average Rating" sortable="true" headerClass="sortable" />
		  <display:column property="genre" title="Genre" sortable="true" headerClass="sortable" />
		  <display:column property="userCount" title="Number of Players" sortable="true" headerClass="sortable" />
		  <display:column property="gameID" title="Action" sortable="false" headerClass="sortable" />
	 </display:table>
</body>
</html>