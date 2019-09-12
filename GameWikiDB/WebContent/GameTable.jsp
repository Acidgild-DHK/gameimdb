<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Games Table</title>
</head>
<body>

<% request.getRequestDispatcher("validLogin.jsp").include(request,response);

String val=(String)request.getSession().getAttribute("valid");
if(val!=null && val.equals("false")) {
	return;
} %>
<table width="700px" align="center"
               style="border:1px solid #000000;">
            <tr>
                <td colspan=8 align="center"
                    style="background-color:teal">
                    <b>Games Table</b></td>
            </tr>
            <tr style="background-color:lightgrey;">
                <td><b>ID</b></td>
                <td><b>PUBLISHER</b></td>
                <td><b>RELEASE DATE</b></td>
                <td><b>DESCRIPTION</b></td>
                <td><b>AVERAGE RATING</b></td>
                <td><b>GENRE</b></td>
                <td><b>NAME</b></td>
                <td><b>USER RATING</b></td>
            </tr>
            <%
            if (request.getAttribute("gTable") != null) {
                ArrayList al = (ArrayList) request.getAttribute("gTable");
                Iterator itr = al.iterator();
                while (itr.hasNext()) {
                ArrayList stuff = (ArrayList) itr.next();
            %>
            <tr>
                <td><%=stuff.get(0)%></td>
                <td><%=stuff.get(1)%></td>
                <td><%=stuff.get(2)%></td>
                <td><%=stuff.get(3)%></td>
                <td><%=stuff.get(4)%></td>
                <td><%=stuff.get(5)%></td>
                <td><%=stuff.get(6)%></td>
                <td><%=stuff.get(7)%></td>
            </tr>
            <%
            }
                }%>
        </table>
</body>
</html>