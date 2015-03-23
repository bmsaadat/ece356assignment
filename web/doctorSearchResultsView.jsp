<%-- 
    Document   : doctorSearchResultsView
    Created on : 22-Mar-2015, 1:39:48 PM
    Author     : Sabashan
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="ece356.DoctorData"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Doctor Search Results</title>
        <script src="http://code.jquery.com/jquery-latest.js"></script>
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
            
            <table class="table">
                <thead>
                    <tr>
                        <th>
                            First Name
                        </th>
                        <th>
                           Middle Initial
                        </th>
                        <th>
                           Last Name
                        </th>
                        <th>
                            Gender
                        </th>
                        <th>
                            Average Star Rating 
                        </th>
                        <th>
                            Number of Reviews
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <%! ArrayList<DoctorData> doctorList;%>
                    <% doctorList = (ArrayList<DoctorData>) request.getAttribute("doctorList"); %>
                    <% for (DoctorData doctor : doctorList) {%>
                    
                    <tr>
                        <td>
                            <%= doctor.getFirstName() %>
                        </td>
                        <td>
                            <%= doctor.getMiddleInitial()%>
                        </td>                        
                        <td>
                            <%= doctor.getLastName()%>
                        </td>
                        <td>
                            <%= doctor.getGender()%>
                        </td>
                        <td>
                            <%= doctor.getAverageRating()%>
                        </td>
                        <td>
                            <%= doctor.getNumberOfReviews()%>
                        </td>
                    </tr>
                    
                    <% }%>
                </tbody>
            </table>
        </div>
    </body>
</html>