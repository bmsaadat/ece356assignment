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
        <title>Doctor Search</title>
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
            <h2 class="page-header">Search For Doctors: </h2>
            <form id="searchPatients" action="DoctorSearchServlet" method="POST">
                <div class="form-group">
                    <label for="firstname">First Name</label>
                    <input type="text" class="form-control" name="firstname" placeholder="First Name">
                </div>
                <div class="form-group">
                    <label for="middleinitial">Middle Initial</label>
                    <input type="text" class="form-control" name="middleinitial" placeholder="Middle Initial">
                </div>                
                <div class="form-group">
                    <label for="lastname">Last Name</label>
                    <input type="text" class="form-control" name="lastname" placeholder="Last Name">
                </div>
                <div class="form-group">
                    <label for="gender">Gender</label>  
                    <select name = "gender">
                        <option value=""></option>
                        <option value="male">male</option>
                        <option value="female">female</option>
                   </select> 
                </div>
                <div class="form-group">
                    <label for="workAddress">Work Address</label>
                    <div class="row">
                      <div class="col-md-2">Street Number</div>
                      <div class="col-md-2">Street Name</div>
                      <div class="col-md-2">Unit Number</div>
                      <div class="col-md-2">City</div>
                      <div class="col-md-2">State</div>
                      <div class="col-md-2">Postal Code</div>
                    </div>     
                    <div class="row">
                      <div class="col-md-2"><input type="text" class="form-control" name="streetNumber" placeholder="Street Number"></div>
                      <div class="col-md-2"><input type="text" class="form-control" name="streetName" placeholder="Street Name"></div>
                      <div class="col-md-2"><input type="text" class="form-control" name="unitNumber" placeholder="Unit Number"></div>
                      <div class="col-md-2"><input type="text" class="form-control" name="city" placeholder="City"></div>
                      <div class="col-md-2"><input type="text" class="form-control" name="state" placeholder="State"></div>
                      <div class="col-md-2"><input type="text" class="form-control" name="postalCode" placeholder="Postal Code"></div>
                    </div>  
                </div>
                <div class="form-group">
                    <label for="specialization">Specialization</label>
                    <input type="text" class="form-control" name="specialization" placeholder="Specialization">
                </div>               
                <div class="form-group">
                    <label for="yearsLicensed">Min Years Licensed</label>
                    <input type="text" class="form-control" name="yearsLicensed" placeholder="Years Licensed">
                </div>       
                <div class="form-group">
                    <label for="avgStars">Min Average Rating </label>
                    <select name = "avgStars">
                        <option value="">0</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                   </select> 
                </div> 
                <div class="form-group">
                    <label for="reviewByFriends">Reviewed by Friend</label><br>
                    <input type="radio" name="reviewByFriends" value="yes">Yes<br>
                    <input type="radio" name="reviewByFriends" value="no">No<br>
                </div> 
                <div class="form-group">
                    <label for="reviewKeyword">Review Keyword</label>
                    <input type="text" class="form-control" name="reviewKeyword" placeholder="Review Keyword">
                </div> 
                <button type="submit" form="searchPatients" class="btn btn-default">Submit</button>
            </form>
        </div>
    </body>
</html>
