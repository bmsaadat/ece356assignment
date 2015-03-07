<%-- 
    Document   : doctorProfileView
    Created on : Mar 7, 2015, 2:48:40 PM
    Author     : behrozsaadat
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="ece356.DoctorData"%>
<%@page import="ece356.WorkAddressData"%>
<%@page import="ece356.ReviewData"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <%! DoctorData doctorData;%>
    <% doctorData = (DoctorData) request.getAttribute("doctorData");%>
    <body>
        <%
            if (doctorData != null) {
        %>
        <h1><%= doctorData.getFirstName()%> <%= doctorData.getMiddleInitial()%>. <%= doctorData.getLastName()%></h1>
        <h2>General Information: </h2>
        <p>Gender: <%= doctorData.getGender()%></p>   
        <p>Years Licensed: <%= doctorData.getYearsLicensed()%></p>   
        <p>Average Rating: <%= doctorData.getAverageRating()%></p>
        
        <%
            if (doctorData.getEmailAddress() != null) {
        %>
        <p>Email Address: <%= doctorData.getEmailAddress()%></p>  
        
        <% } %>
        <br>
        <h2> Work Addresses </h2>
                <table cellspacing="20">

        <%
            for (WorkAddressData workAddress : doctorData.getWorkAddressList()) {
        %>
        
        <tr>
          <td><%= workAddress.getStreetNumber()%> <%= workAddress.getStreetName()%>
              <% if (workAddress.getUnitNumber() != null) { %>
              , Unit <%= workAddress.getUnitNumber()%>
              <% } %>
          </td>
          <td><%= workAddress.getCity()%></td> 
          <td><%= workAddress.getState()%></td> 
          <td><%= workAddress.getPostalCode()%></td> 

        </tr>
              
        
        <%
            }
        %>
        </table>

        <h2> Areas of Specialization </h2>
        <ul>
        <%
            for (String specialization : doctorData.getSpecializationList()) {
        %>
        <li>
            <%= specialization%>
        </li>
        <%
            }
        %>
        </ul>
        <br>
        <h2>Reviews</h2>
        
        <table cellspacing="20">
            <tr>
                <th>
                    Date
                </th>
                <th>
                    Rating
                </th>
                <th>
                    Reviewed By
                </th>
            </tr>
        
        <%
            for (ReviewData review : doctorData.getReviewList()) {
        %>
        
        <tr>
            <td>
                <a href="google.ca">
                <%= review.getDate()%>
                </a>
            </td>
            <td>
                <%= review.getRating()%>
            </td>
            <td>
                <%= review.getPatientUsername()%>
            </td>
        </tr>
        <%
            }
        %>
        </table>
        
        
        <%
            }
        %>
        
        
    </body>
</html>
