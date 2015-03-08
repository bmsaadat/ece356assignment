<%-- 
    Document   : doctorReviewView
    Created on : Mar 7, 2015, 7:32:47 PM
    Author     : abhisheksisodia
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
        <title>DoctorReviewView</title>
    </head>
    <% String docusername = request.getParameter("docname"); %>   
    <% String patientusername = request.getParameter("patientname"); %>
    <% String date = request.getParameter("date"); %>
    <% String comment = request.getParameter("comment"); %>
    <% String rating = request.getParameter("rating"); %>  
    <% String reviewID = request.getParameter("reviewid"); %>
    <% DoctorData doctorData = (DoctorData) session.getAttribute("docData");%>
    <body>
       <div class="container">  
        <h2 class="page-header">Review: </h2>
        <dl class="dl-horizontal">
          <dt>Doctor: </dt>
          <dd><%= docusername%></dd>
          <dt>Reviewed By: </dt>
          <dd><%= patientusername%></dd>
          <dt>Date: </dt>
          <dd><%= date%></dd>
          <dt>Rating: </dt>
          <dd><%= rating%></dd>
          <dt>Comment: </dt>
          <dd><%= comment%></dd>
          <dt>reviewID: </dt>
          <dd><%= reviewID%></dd>
        </dl>
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
                            <a href="doctorReviewView.jsp?docname=<%= review.getDoctorUsername()%>&patientname=<%= review.getPatientUsername()%>&date=<%= review.getDate()%>
                            &rating=<%= review.getRating()%>&comment=<%= review.getComment()%>&reviewid=<%= review.getReviewId()%>">
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
     </div>
    </body>
</html>
