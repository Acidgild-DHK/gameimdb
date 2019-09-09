<%@ page import="model.User" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
<%@include file="WEB-INF/Style.css"%>
</style>
<meta charset="ISO-8859-1">
<title>LogTable</title>
<% request.getRequestDispatcher("/headerLoggedIn.jsp").include(request, response); %>
</head>
<body>
<div>
	<form action="userAddLog.jsp" method="post">
		<input type="submit" value="Add Log">
	</form>
	 <display:table name="sessionScope.logTable" pagesize="5" export="false" sort="list">
		 <display:column property="logID" title="Log ID" sortable="true" headerClass="sortable" />
		  <display:column property="gameTitle" title="Game Title" sortable="true" headerClass="sortable" />
		  <display:column property="timePlayed" title="Time Played" sortable="true" headerClass="sortable" />
		  <display:column property="rating" title="Rating" sortable="true" headerClass="sortable" />
		  <display:column property="reviewText" title="Review"  sortable="true" headerClass="sortable" />
		  <display:column property="platform" title="Platform" sortable="true" headerClass="sortable" />
		  <display:column property="updateButton" title="Update" sortable="true" headerClass="sortable" />
	 </display:table>
	 </div>
</body>
</html>