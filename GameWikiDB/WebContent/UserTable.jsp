<%@ page import="model.User" %>
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
<% 
	java.util.ArrayList<User> us = new java.util.ArrayList<User>();
// 	out.println(session.getAttribute("username"));
	
	
	us.add(new User("kar", "kar", "kar@gmail.com"));
	us.add(new User("kat", "kat", "kat@gmail.com"));
	us.add(new User("kar1", "kar1", "kar1@gmail.com"));
	us.add(new User("kat2", "kat2", "kat2@gmail.com"));
	us.add(new User("kar3", "kar3", "ka3r@gmail.com"));
	us.add(new User("kat4", "<input type='submit' value='ka4t'>", "k4at@gmail.com"));
	session.setAttribute("test", us);
	
	%>

 <display:table name="sessionScope.test" pagesize="5" export="false" sort="list">
	 <display:column property="username" title="username" sortable="true" headerClass="sortable" />
	  <display:column property="gamerTag" sortable="true" headerClass="sortable" />
	  <display:column property="email" sortable="true" headerClass="sortable" />
 </display:table>

<%--  <display:table name="requestScope.results.rows"> --%>
<%-- 	 <display:column property="log_id" title="log" /> --%>
<%-- 	  <display:column property="time_played" /> --%>
<%-- 	  <display:column property="rating" /> --%>
<%-- 	  <display:column property= "review_text" /> --%>
<%-- 	  <display:column property= "platform" /> --%>
<%--  </display:table> --%>


</body>
</html>