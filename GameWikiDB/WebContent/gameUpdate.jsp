<%@ page import="model.Game" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Game Update</title>
<style type="text/css">
<%@include file="WEB-INF/Style.css"%>
</style>
</head>
<body>
<%
request.getRequestDispatcher("validLogin.jsp").include(request,response);
	
	String val=(String)request.getSession().getAttribute("valid");
	if(val!=null && val.equals("false")) {
		return;
	}
	request.getRequestDispatcher("/game_retriever").include(request, response);
	Game game = (Game) request.getAttribute("game");
	
	%>
<br/>
<h2>Insert</h2>
<div>
<form action="game_update" method="post">
<input type="hidden" name="gameId" value="<%=game.getGameID() %>">
<table style="width:50%">
	<tr>
		<td>Game Title</td>
		<td><input type="text" name="game_title" 
		<% 
			if(game.getGameName() != null){
				out.print("value='" + game.getGameName() + "'");
			} 
		%> 
		disabled = "true"></td>
	</tr>
	<tr>
		<td>Publisher</td>
		<td><input type="text" name="publisher"
		<% 
			if(game.getPublisher() != null){
				out.print("value='" + game.getPublisher() + "'");
			} 
		%> 
		 ></td>
	</tr>
	<tr>
		<td>Release Date</td>
		<td><input type="text" name="release_date" 
			<% 
			if(game.getReleaseDate() != null){
				out.print("value='" + game.getReleaseDateString() + "'");
			} 
		%>
		></td>
	</tr>
	<tr>
		<td>Description</td>
		<td><input type="text" name="description" 
			<% 
			if(game.getDescription() != null){
				out.print("value='" + game.getDescription() + "'");
			} 
		%>
		></td>
	</tr>
	<tr>
		<td>ESRB</td>
		<td><input type="text" name="esrb" 
			<% 
			if(game.getEsrb() != null){
				out.print("value='" + game.getEsrb() + "'");
			} 
		%>
		></td>
	</tr>
	<tr>
		<td>Genre</td>
		<td><input type="text" name="genre" 
			<% 
			if(game.getGenre() != null){
				out.print("value='" + game.getGenre() + "'");
			} 
		%>
		></td>
	</tr>
	<tr>
				<td>Platforms</td>
				<td>
					<input type="checkbox" name="platforms" value="mobile">Mobile<br/>
					<input type="checkbox" name="platforms" value="pc">PC<br/>
					<input type="checkbox" name="platforms" value="console">Console<br/>
				</td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="Update Game"></td>
	</tr>
</table>
</form>
</div>
</body>
</html>