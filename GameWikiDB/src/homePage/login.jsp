<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String st=(String)request.getAttribute("error");

if(st!=null ) {

	if(st.equals("empty")) {	
		out.print("<h2>Error logging in</h2><br>");
	}
	else if(st.equals("failed")) {
		out.print("<h2>That combination of username/password did not work</h2><br>");
	}
	else if(st.equals("Password too long")) {
		out.print("<h2>Password longer than 25 characters</h2><br>");
	}
	else if(st.equals("no user")) {
		out.print(" <h2>No user found by that username </h2><br>");
	}
}
RequestDispatcher rd1=request.getRequestDispatcher("header.jsp");
rd1.include(request,response);
%>
<form action="LoginServ" method="post">
<table style"width:50%">
<tr><td>Username</td>
<td><input type="text" name="username"></td></tr>

<tr><td>Password</td>
<td><input type="password" name="password" ></td></tr>


</table>
<input type="submit" value="Login" />
</form>
</body>
</html>