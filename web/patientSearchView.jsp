<%-- 
    Document   : patientSearchView
    Created on : Mar 9, 2015, 12:16:13 PM
    Author     : behrozsaadat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Patient Search</title>
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
            <h2 class="page-header">Search For Patients: </h2>
            <form id="searchPatients" action="PatientSearchServlet" method="POST">
                <div class="form-group">
                    <label for="username">User Name:</label>
                    <input type="text" class="form-control" name="username" placeholder="Enter username">
                </div>
                <div class="form-group">
                    <label for="province">Province:</label>
                    <input type="text" class="form-control" name="state" placeholder="Enter province">
                </div>
                <div class="form-group">
                    <label for="city">City:</label>
                    <input type="text" class="form-control" name="city" placeholder="Enter city">
                </div>                
                <button type="submit" form="searchPatients" class="btn btn-default">Submit</button>
            </form>
        </div>
    </body>
</html>
