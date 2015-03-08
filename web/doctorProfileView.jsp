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
    <link href="css/bootstrap.min.css" rel="stylesheet">

    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%! String patientViewingProfile;%>
    <%! DoctorData doctorData;%>
    <% doctorData = (DoctorData) request.getAttribute("doctorData");%>
    <% patientViewingProfile = (String) request.getAttribute("patientViewingDoctor");%>
    <body>
       <div class="container">  
        <%
            if (doctorData != null) {
        %>
        
        <% 
            if (patientViewingProfile.equals("1")) {  
                doctorData.setEmailAddress(null);
            }
        %>
        
        <h1>Dr. <%= doctorData.getFirstName()%> <%= doctorData.getMiddleInitial()%>. <%= doctorData.getLastName()%></h1>
        <h2 class="page-header">General Information: </h2>
        
        <dl class="dl-horizontal">
  <dt>Gender: </dt>
  <dd><%= doctorData.getGender()%></dd>
  
  <dt>Years Licensed: </dt>
  <dd><%= doctorData.getYearsLicensed()%></dd>
  
  <dt>Average Rating: </dt>
  <dd><%= doctorData.getAverageRating()%></dd>
  <%
            if (doctorData.getEmailAddress() != null) {
        %>
  <dt>Email Address </dt>
  <dd><%= doctorData.getEmailAddress()%></dd>
  <% } %>
</dl>
        
        
        
        <h2 class="page-header"> Work Addresses </h2>
        <table class="table">
            <thead>
            <tr>
                <th>
                    Street
                </th>
                <th>
                    City
                </th>
                <th>
                    Province
                </th>
                <th>
                    Postal Code
                </th>
            </tr>
            </thead>
            <tbody>
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
            </tbody>
        </table>

        <h2 class="page-header"> Areas of Specialization </h2>
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
        <h2 class="page-header">Reviews
        
        <% 
            if (patientViewingProfile.equals("1")) {
        %>
        <button class="btn btn-default pull-right" type="submit">Write Review</button>
        <% 
            }
        %>
        </h2>
        <table class="table">
            <thead>
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
            </thead>
            <tbody>
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
            </tbody>
        </table>
        
        
        
        
        
        
        
        <%
            }
        %>
       </div>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
