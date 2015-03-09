<%--
    Document   : patientProfileView
    Created on : Mar 9, 2015, 11:55:00 AM
    Author     : behrozsaadat
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="ece356.PatientData"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Patient Search Results</title>
    </head>
    <body>
        <div class="container">  
            <h2 class="page-header">Search Results: </h2>
            
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
                    <%! ArrayList<PatientData> patientList;%>
                    <% patientList = (ArrayList<PatientData>) request.getAttribute("patientList"); %>
                    <% for (PatientData patient : patientList) {%>
                    
                    <tr>
                        <td>
                            <a href="index.jsp">
                        <button class="btn btn-default btn-sm" type="submit" data-toggle="modal">Add Friend</button></a></a>
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
                            <%= patient.getLastReviewDate()%>
                        </td>
                    </tr>
                    
                    <% }%>
                </tbody>
            </table>
            
            
        </div>
    </body>
</html>
