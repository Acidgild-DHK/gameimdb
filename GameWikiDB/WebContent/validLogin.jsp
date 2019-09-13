<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Game Site</title>
</head>
<body>
<% 
Boolean log=false;
if(request.getSession().getAttribute("login")!=null) {
	log=(Boolean)request.getSession().getAttribute("login");
}

RequestDispatcher rd1;
if(log!=null && log) {
	request.getRequestDispatcher("headerLoggedIn.jsp").include(request,response);
	
}
else {
	request.getRequestDispatcher("invalidAccess.jsp").include(request,response);
	request.getSession().setAttribute("valid", "false");
	return;
}
	//request.getRequestDispatcher("/headerLoggedIn.jsp").include(request, response); 
	
%>
</body>
</html>