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

<%
	Boolean log = false;
	if (request.getSession().getAttribute("login") != null) {
		log = (Boolean) request.getSession().getAttribute("login");
	}

	RequestDispatcher rd1;

	if (log) {
		rd1 = request.getRequestDispatcher("headerLoggedIn.jsp");
	} else {
		rd1 = request.getRequestDispatcher("header.jsp");

	}
	rd1.include(request, response);
%>
</head>
<body>

<!-- 	<li> <a href="GameSearch.jsp">Search through Games by name</a></li> -->
<!-- <li> <a href="GameTable.jsp">Table of Games</a></li> -->
<!-- <li> <a href="GameUpdate.jsp">Add a Game</a></li> -->
<!-- </ul> -->
<div>

	<table>
			<tr>
				<td>
					<form action="gameAdd.jsp" method="post">
						<input type="submit" value="Add Game">
					</form>
				</td>
				<td>
					<form action="game_search" method="post">
						<input type="text" name="search_field">
						<input type="submit" value="Search">
					</form>
				</td>
			</tr>
		</table>
	 <display:table name="sessionScope.gameTable" pagesize="5" export="false" sort="list" decorator="model.GameWikiDecorator">
		  <display:column property="gameName" title="Game Title" sortable="true" headerClass="sortable" />
		  <display:column property="publisher" title="Publisher" sortable="true" headerClass="sortable" />
		  <display:column property="releaseDate" title="Release Date" sortable="true" headerClass="sortable" />
		  <display:column property="description" title="Description"  sortable="true" headerClass="sortable" />
		  <display:column property="esrb" title="ESRB Rating" sortable="true" headerClass="sortable" />
		  <display:column property="averageRating" title="Average Rating" sortable="true" headerClass="sortable" />
		  <display:column property="genre" title="Genre" sortable="true" headerClass="sortable" />
		  <display:column property="userCount" title="Number of Players" sortable="true" headerClass="sortable" />
		  <display:column property="gameID" title="Action" sortable="false" headerClass="sortable" />
	 </display:table>
</div>
</body>
</html>