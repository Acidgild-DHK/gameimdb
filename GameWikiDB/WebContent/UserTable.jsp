<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LogTable</title>
</head>
<body>
<% out.println(session.getAttribute("username")); %>

 <display:table name="requestScope.results.rows">
	 <display:column property="log_id" title="log" />
	  <display:column property="time_played" />
	  <display:column property="rating" />
	  <display:column property= "review_text" />
	  <display:column property= "platform" />
 </display:table>


</body>
</html>