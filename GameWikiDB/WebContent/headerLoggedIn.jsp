<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

/* Change the link color to #111 (black) on hover */
li a:hover {
  background-color: #80A2E7;
}
</style>

<ul>
  <li><a class ="active" href="index.jsp">Home</a></li>
  
 <li> <a href="logout.jsp">Logout</a></li>
  <li><a href="games">Games</a></li>
    <li><a href="user_profile">Profile</a></li>
    <li><a href="user_logs">Logs</a></li>
</ul>
<meta charset="ISO-8859-1">

</head>
<body>

</body>
</html>