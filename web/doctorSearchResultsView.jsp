<%-- 
    Document   : doctorSearchResultsView
    Created on : 22-Mar-2015, 1:39:48 PM
    Author     : Sabashan
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="ece356.DoctorData"%>
<%@page import="ece356.UserData"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Doctor Search Results</title>
        <script src="http://code.jquery.com/jquery-latest.js"></script>
    </head>
    <% UserData user = (UserData) session.getAttribute("userData"); %>
    <body>
        <%
            if (user == null) {
                response.sendRedirect("index.jsp");
                return;
            }
        %>
        
        <%
            if(!user.getUserType().equals("patient")){
                response.sendRedirect("AccessDenied.jsp");
                return; 
            }
        %>

        <div class="container">  
            <%@ include file="logout.jsp" %>
            <h2 class="page-header">Search Results: </h2>
            <%! ArrayList<DoctorData> doctorList;%>

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
                        <th>
                            Action
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <% doctorList = (ArrayList<DoctorData>) request.getAttribute("doctorList"); %>
                    <% for (DoctorData doctor : doctorList) {%>

                    <tr>
                        <td>
                            <%= doctor.getFirstName()%>
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
                        <td>
                            <a href="DoctorProfileServlet?doctor=<%=doctor.getUserName()%>">View Profile </a>
                        </td>
                    </tr>

                    <% }%>
                </tbody>
            </table>
            <% if (doctorList.isEmpty()) { %>
            <div class="well center-block">
                Sorry no results were found for this search.
            </div>
            <% }%>
        </div>
    </body>
</html>