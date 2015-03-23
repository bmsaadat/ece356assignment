<%-- 
    Document   : patientViewRequests
    Created on : Mar 13, 2015, 11:52:42 AM
    Author     : abhisheksisodia
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="ece356.UserData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pending Friend Requests</title>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Patient Search Results</title>

        <script src="http://code.jquery.com/jquery-latest.js">
        </script>
        <script>
            $(document).ready(function () {
                $('.addButton').click(function (event) {

                    var username = event.target.id;
                    $.get('patientAddFriendServlet', {user: username}, function (responseText) {
                        alert(responseText);
                    });
                });
            });
        </script>

    </head>
</head>
<%! ArrayList<UserData> userData;%>
<% userData = (ArrayList<UserData>) request.getAttribute("userData");
    if (session.getAttribute("userData") == null) {
        response.sendRedirect("index.jsp");
            return;
        }%>

<body>
    <div class="container">  
        <%@ include file="logout.jsp" %>
        <h2 class="page-header">Pending Friend Requests</h2>
        <table class="table">
            <thead>
                <tr>
                    <th>
                        Username
                    </th>
                    <th>
                        Email Address
                    </th>
                    <th>
                        Respond
                    </th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (UserData user : userData) {
                %>

                <tr>
                    <td><%= user.getUserName()%></td> 
                    <td><%= user.getEmailAddress()%></td> 
                    <td>
                        <button id="<%= user.getUserName()%>" class="btn btn-default btn-sm addButton" type="submit" data-toggle="modal">Accept</button>
                    </td>
                </tr>


                <%
                    }
                %>
            </tbody>
        </table>
    </div>
</body>
</html>
