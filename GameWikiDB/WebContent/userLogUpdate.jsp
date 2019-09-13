<%@ page import="model.Log" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Game Site</title>
<style type="text/css">
<%@include file="WEB-INF/Style.css"%>
</style>
<script src="scripts/add-log-validation.js">

</script>
</head>
<body>
	<% 
	 
	request.getSession().setAttribute("valid","");
	request.getRequestDispatcher("validLogin.jsp").include(request,response);

	String val=(String)request.getSession().getAttribute("valid");
	if(val!=null && val.equals("false")) {
		return;
	} 
		request.getRequestDispatcher("/log_retriever").include(request, response);
		Log log = (Log) request.getAttribute("log");
		String err=(String)request.getAttribute("error");
		if(err!=null && !err.isEmpty()) {
			out.println("<h1>"+ err+"</h1>");
		}
		
	%>
	<h2>Log Update</h2>
	<div>
	<form name="logForm" action="user_log_update" onSubmit="return formValidation()" method="post">
		<input type="hidden" name="logID" value="<%=log.getLogID() %>">
		<table style="width:50%">
		
		<tr>
			<td> Game Title</td>
			<td>
				<input type="text" name="game" value="<%=log.getGame().getGameName() %>" readonly="readonly" >
			</td> 
		</tr>
		
		<tr>
			<td>Time Played</td> 
			<td><input type="text" name="time" value="<%=log.getTimePlayed() %>"> </td>
		</tr>
		
		<tr>
			<td> Rating </td>
			<td> 
				<select name="rating">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="10">10</option>
				</select>
			</td> 
		</tr>
		
		<tr>
			<td>Review </td>
			<td>
				<textarea rows="5" col="200" name="review"><%=log.getReviewText() %></textarea>
			</td>
		 </tr>
		 
		<tr>
			<td> Platform Played </td>
			<td> 
				<select name="platform">
					<option value="1">mobile</option>
					<option value="2">pc</option>
					<option value="3">console</option>
				</select> 
			</td>
		</tr>
		</table>
		<input type="submit" value="update">
	</form></div>
</body>
</html>