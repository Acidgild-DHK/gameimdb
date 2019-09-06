<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
 <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% request.getRequestDispatcher("/headerLoggedIn.jsp").include(request, response); %>
<table width="700px" align="center"
               style="border:1px solid #000000;">
            <tr>
                <td colspan=8 align="center"
                    style="background-color:teal">
                    <b>Search through Games</b></td>
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
                if (request.getAttribute("Search") != null) {
                    ArrayList al = (ArrayList) request.getAttribute("Search");
                    System.out.println(al);
                    Iterator itr = al.iterator();
                    while (itr.hasNext()) {

                    ArrayList searcher = (ArrayList) itr.next();
            %>
            <tr>
                <td><%=searcher.get(0)%></td>
                <td><%=searcher.get(1)%></td>
                <td><%=searcher.get(2)%></td>
                <td><%=searcher.get(3)%></td>
                <td><%=searcher.get(4)%></td>
                <td><%=searcher.get(5)%></td>
                <td><%=searcher.get(6)%></td>
                <td><%=searcher.get(7)%></td>
            </tr>
            <%
                    }
                }
            %>
            <tr>
                <td colspan=4 align="center"
                    style="background-color:#eeffee"><b>No Record Found..</b></td>
            </tr>
        </table>
</body>
</html>