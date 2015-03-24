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
    <% DoctorData doctorData = (DoctorData) session.getAttribute("docData"); %>
    <% String str = request.getParameter("index"); %>
    <% int index = index = Integer.parseInt(str);%>
    <% String hideInformation = (String) session.getAttribute("patientViewingDoctor"); %>
    <body>
            <%
                if(session.getAttribute("userData") == null){
                    response.sendRedirect("index.jsp");
                    return; 
                }
            %>
        
        <div class="container">  
            <%@ include file="logout.jsp" %>
            <form action="DoctorProfileServlet?doctor=<%= docusername%>" method="post">
                  <button class="btn btn-default pull-left" type="submit" data-toggle="modal">Back to Profile</button>
            </form>
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
            <% ReviewData nextReview; %>
            <% ReviewData prevReview; %>
            <% if (index < 0 || index + 1 == doctorData.getReviewList().size()) { %>
            <% prevReview = null; %> 
            <% } else { %>
            <% prevReview = doctorData.getReviewList().get(index + 1); %>
            <% } %>
            <% if (index <= 0) { %>
            <% nextReview = null; %>
            <% } else { %>
            <% nextReview = doctorData.getReviewList().get(index - 1); %>
            <% } %>
            <%
                if (nextReview != null) {
            %>

            <a href="doctorReviewView.jsp?docname=<%= nextReview.getDoctorUsername()%>&patientname=<%= nextReview.getPatientUsername()%>&date=<%= nextReview.getDate()%>
               &rating=<%= nextReview.getRating()%>&comment=<%= nextReview.getComment()%>&index=<%= doctorData.getReviewList().indexOf(nextReview)%>">
                <button class="btn btn-default pull-right" type="submit" data-toggle="modal">Next Review</button></a>
                <% } %>
                <%
                    if (prevReview != null) {
                %>
            <a href="doctorReviewView.jsp?docname=<%= prevReview.getDoctorUsername()%>&patientname=<%= prevReview.getPatientUsername()%>&date=<%= prevReview.getDate()%>
               &rating=<%= prevReview.getRating()%>&comment=<%= prevReview.getComment()%>&index=<%= doctorData.getReviewList().indexOf(prevReview)%>">
                <button class="btn btn-default pull-left" type="submit" data-toggle="modal">Previous Review</button></a>
                <% }%>
        </div>
    </body>
</html>
