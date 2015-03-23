<%-- 
    Document   : patientLoggedInView
    Created on : 22-Mar-2015, 10:55:58 AM
    Author     : Sabashan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ece356.UserData"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <title>JSP Page</title>
    </head>
    <body>
        <%
            if(session.getAttribute("userData") == null){
                response.sendRedirect("index.jsp");
                return; 
            }
        %>
        <%! UserData user;%>
        <% user = (UserData) session.getAttribute("userData"); %>
        <div class="container">
            <h2 class="page-header"><%= user.getFirstName()%> <%= user.getLastName()%></h2>
            <div class="well center-block">
                <a href="doctorSearchView.jsp"><button type="button" class="btn btn-primary btn-lg btn-block">Search for Doctor</button></a>
                <br>
                <a href="patientSearchView.jsp"><button type="button" class="btn btn-primary btn-lg btn-block">Search For Patients</button></a>
                <br>
                <a href="FriendshipViewStatus"><button type="button" class="btn btn-primary btn-lg btn-block">View Friend Requests</button></a>
            </div>
        </div>
    </body>
</html>
