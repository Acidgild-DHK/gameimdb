<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logs</title>
</head>
<body>
	<form>
		<input type="text" name="game">
		<input type="text" name="time">
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
		<textarea rows="5" col="70" name="review">
		Write a review.
		</textarea>
		<select name="platform">
			<option value="1">mobile</option>
			<option value="2">pc</option>
			<option value="3">console</option>
		</select>
	</form>
</body>
</html>