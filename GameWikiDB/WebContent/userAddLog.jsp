<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Log</title>
<% request.getRequestDispatcher("/headerLoggedIn.jsp").include(request, response); %>
</head>
<body>
	<form action="user_add_log" method="post">
		<table style="width:50%">
		<tr>
			<td> Game Title</td>
			<td>
				<input type="text" name="game" >
			</td> 
		</tr>
		
		<tr>
			<td>Time Played</td> 
			<td><input type="text" name="time" > </td>
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
				<textarea rows="5" col="200" name="review"></textarea>
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
		<input type="submit" value="add">
	</form>
</body>
</html>