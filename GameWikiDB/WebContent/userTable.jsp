<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>



<!DOCTYPE html>
<html>
<head>
<% 
request.getSession().setAttribute("valid","");
request.getRequestDispatcher("validLogin.jsp").include(request,response);

String val=(String)request.getSession().getAttribute("valid");
if(val!=null && val.equals("false")) {
	return;
} %>
<style type="text/css">
<%@include file="WEB-INF/Style.css"%>
</style>
<meta charset="ISO-8859-1">
<title>LogTable</title>
</head>
<body>
	<form action="userAddLog.jsp" method="post">
		<input type="submit" value="Add Log">
	</form>
	 <display:table name="sessionScope.logTable" pagesize="5" export="false" sort="list" decorator="model.GameWikiDecorator">
		  <display:column property="game" title="Game Title" sortable="true" headerClass="sortable" />
		  <display:column property="timePlayed" title="Time Played" sortable="true" headerClass="sortable" />
		  <display:column property="rating" title="Rating" sortable="true" headerClass="sortable" />
		  <display:column property="reviewText" title="Review"  sortable="true" headerClass="sortable" />
		  <display:column property="platform" title="Platform" sortable="true" headerClass="sortable" />
		  <display:column property="logID" title="Action" sortable="false" headerClass="sortable" />
	 </display:table>
</body>
</html>