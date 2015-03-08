<%-- 
    Document   : doctorReviewView
    Created on : Mar 7, 2015, 7:32:47 PM
    Author     : abhisheksisodia
--%>
<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
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
    <% ArrayList<ReviewData> reviews = doctorData.getReviewList(); %>
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
        </dl>
        <% boolean nextReview = false; %>
        <% boolean prevReview = false; %>
                    <%
                        for (ReviewData review : doctorData.getReviewList()) {
                    %>
                    <% SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                       Date currentReviewDate = format.parse(request.getParameter("date")); %>
                    <%
                        if (!nextReview) {
                    %>
                    <%
                        if (currentReviewDate.before(review.getDate())) {
                    %>
                        <a href="doctorReviewView.jsp?docname=<%= review.getDoctorUsername()%>&patientname=<%= review.getPatientUsername()%>&date=<%= review.getDate()%>
                            &rating=<%= review.getRating()%>&comment=<%= review.getComment()%>">
                        <button class="btn btn-default pull-right" type="submit" data-toggle="modal">Next Review</button></a></a>
                        <% nextReview = true; %>
                    <%
                        }
                    %>
                    <%
                        }
                    %>
                    <%
                        if (!prevReview) {
                    %>
                    <%
                        if ((currentReviewDate.after(review.getDate()))) {
                    %>
                        <a href="doctorReviewView.jsp?docname=<%= review.getDoctorUsername()%>&patientname=<%= review.getPatientUsername()%>&date=<%= review.getDate()%>
                            &rating=<%= review.getRating()%>&comment=<%= review.getComment()%>">
                        <button class="btn btn-default pull-left" type="submit" data-toggle="modal">Previous Review</button></a>
                        <% prevReview = true; %>
                    <% 
                        }
                    %> 
                    <%
                        }
                    %>
                    <%
                        }
                    %>
     </div>
    </body>
</html>
