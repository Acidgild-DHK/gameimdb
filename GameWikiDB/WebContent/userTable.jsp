<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LogTable</title>
<% request.getRequestDispatcher("/headerLoggedIn.jsp").include(request, response); %>
</head>
<body>
	<form action="userAddLog.jsp" method="post">
		<input type="submit" value="Add Log">
	</form>
	 <display:table name="sessionScope.logTable" pagesize="5" export="false" sort="list" decorator="model.GameWikiDecorator">
		  <display:column property="gameTitle" title="Game Title" sortable="true" headerClass="sortable" />
		  <display:column property="timePlayed" title="Time Played" sortable="true" headerClass="sortable" />
		  <display:column property="rating" title="Rating" sortable="true" headerClass="sortable" />
		  <display:column property="reviewText" title="Review"  sortable="true" headerClass="sortable" />
		  <display:column property="platform" title="Platform" sortable="true" headerClass="sortable" />
		  <display:column property="logID" title="Action" sortable="true" headerClass="sortable" />
	 </display:table>
</body>
</html>