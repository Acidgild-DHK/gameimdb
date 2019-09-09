<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Game</title>
</head>
<body>
	<form action="game_add" method="post">
		<table style="width: 50%">
			<tr>
				<td>Game Title</td>
				<td><input type="text" name="game_title"></td>
			</tr>
			<tr>
				<td>Publisher</td>
				<td><input type="text" name="publisher"></td>
			</tr>
			<tr>
				<td>Release Date</td>
				<td><input type="text" name="release_date"></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><input type="text" name="description"></td>
			</tr>
			<tr>
				<td>ESRB</td>
				<td><input type="text" name="esrb"></td>
			</tr>
			<tr>
				<td>Genre</td>
				<td><input type="text" name="genre"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Add Game"></td>
			</tr>
		</table>
	</form>
</body>
</html>