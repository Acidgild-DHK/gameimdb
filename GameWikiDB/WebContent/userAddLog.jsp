<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
<%@include file="WEB-INF/Style.css"%>
</style>
<script src="scripts/add-log-validation.js">

</script>
<meta charset="ISO-8859-1">
<title>Game Site</title>
<%

	request.getSession().setAttribute("valid", "");
	request.getRequestDispatcher("validLogin.jsp").include(request, response);

	String val = (String) request.getSession().getAttribute("valid");
	if (val != null && val.equals("false")) {
		return;
	}
%>
</head>
<body>
<h2>Add Log</h2>
	<div>
		<%
			String err = (String) request.getAttribute("error");
			if (err != null) {
				out.println("<h2>" + err + "</h2>");
			}
		%>
		<form name= "logForm" align="center" action="user_add_log" onSubmit="return formValidation()" method="post">
			<table align="center">
				<tr>
					<td>Game Title</td>
					<td><input type="text" name="game" ></td>
				</tr>

				<tr>
					<td>Time Played</td>
					<td><input type="number" name="time">
					</td>
				</tr>

				<tr>
					<td>Rating</td>
					<td><select name="rating" required>
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
					</select></td>
				</tr>

				<tr>
					<td>Review</td>
					<td><textarea rows="5" col="200" name="review"></textarea>
					</td>
				</tr>

				<tr>
					<td>Platform Played</td>
					<td><select name="platform" required>
							<option value="1">mobile</option>
							<option value="2">pc</option>
							<option value="3">console</option>
					</select></td>
				</tr>
			</table>
			<input type="submit" value="add">
		</form>
	</div>
</body>
</html>