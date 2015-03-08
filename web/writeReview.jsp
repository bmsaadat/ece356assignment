<%-- 
    Document   : writeReview
    Created on : Mar 7, 2015, 8:19:32 PM
    Author     : behrozsaadat
--%>
<%@page import="ece356.DoctorData"%>

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
        
        <h1>Write Review</h1>
        <%= doctorData.getFirstName()%>
    </body>
</html>
