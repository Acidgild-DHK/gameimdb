<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
<%@include file="WEB-INF/Style.css"%>
</style>
<meta charset="ISO-8859-1">
<title>User Log</title>
<% request.getRequestDispatcher("/headerLoggedIn.jsp").include(request, response); 
String err=(String)request.getAttribute("error");
if(err!=null && !err.isEmpty()) {
	out.println("<h1>"+ err+"</h1>");
}
%>
</head>
<body>
<div>
	<form align="center" action="user_add_log" method="post">
		<table align="center">
		<tr>
			<td> Game Title</td>
			<td>
				<input type="text" name="game" required>
			</td> 
		</tr>
		
		<tr>
			<td>Time Played</td> 
			<td><input type="number" name="time" required min="0"> </td>
		</tr>
		
		<tr>
			<td> Rating </td>
			<td> 
				<select name="rating" required>
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
				<textarea rows="5" col="200" name="review" required></textarea>
			</td>
		 </tr>
		 
		<tr>
			<td> Platform Played </td>
			<td> 
				<select name="platform" required>
					<option value="1">mobile</option>
					<option value="2">pc</option>
					<option value="3">console</option>
				</select> 
			</td>
		</tr>
		</table>
		<input type="submit" value="add">
	</form>
	</div>
</body>
</html>