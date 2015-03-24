<%--
    Document   : patientProfileView
    Created on : Mar 9, 2015, 11:55:00 AM
    Author     : behrozsaadat
--%>
<%@page import="ece356.FriendShipStatus"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ece356.PatientData"%>
<%@page import="ece356.UserData"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Patient Search Results</title>
        
         <script src="http://code.jquery.com/jquery-latest.js">   
        </script>
        <script>
            $(document).ready(function() {                        
                $('.addButton').click(function(event) {  
                    
                    var username=event.target.id;
                 $.get('patientAddFriendServlet',{user:username},function(responseText) { 
                        //alert(responseText);
                        location.reload();
                    });
                });
            });
        </script>
        
    </head>
    <body>
        <%
            if(session.getAttribute("userData") == null){
                response.sendRedirect("index.jsp");
                return; 
            }
        %>
        
        <div class="container">  
        <%@ include file="logout.jsp" %>
            <h2 class="page-header">Search Results: </h2>
            <%! ArrayList<PatientData> patientList;%>
            <table class="table">
                <thead>
                    <tr>
                        <th></th>
                        <th>
                            Username
                        </th>
                        <th>
                            Home Address
                        </th>
                        <th>
                            Number of Reviews Written
                        </th>
                        <th>
                            Date of Last Review
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <% patientList = (ArrayList<PatientData>) request.getAttribute("patientList"); %>
                    <% for (PatientData patient : patientList) {%>
                    <% if( patient.getUserName().equals( ( (UserData) session.getAttribute("userData") ).getUserName())) {
                        continue;
                        }
                    %>
                    <tr>
                        <td>
                            <% if(patient.getFriendShipStatusWithLoggedInUser() == FriendShipStatus.NOT_FRIENDS) { %>
                                <button id="<%= patient.getUserName() %>" class="btn btn-default btn-sm addButton" type="submit" data-toggle="modal">Add Friend</button>
                            <% } else if (patient.getFriendShipStatusWithLoggedInUser() == FriendShipStatus.ALREADY_FRIENDS) { %>
                                Friends
                            <% } else { %>
                                Request Sent
                            <% } %>
                        </td>
                        <td>
                            <%= patient.getUserName()%>
                        </td>
                        <td>
                            <%= patient.getCity()%>, <%= patient.getState()%>
                        </td>
                        <td>
                            <%= patient.getNumberOfReviews()%>
                        </td>
                        <td>
                            <% if(patient.getLastReviewDate() != null) { %>
                            <%= patient.getLastReviewDate()%>
                            <% } %>
                        </td>
                    </tr>
                    
                    <% }%>
                </tbody>
            </table>
            
            <% if(patientList.isEmpty()) { %>
            <div class="well center-block">
                Sorry no results were found for this search.
            </div>
            <% } %>
            
        </div>
    </body>
</html>
