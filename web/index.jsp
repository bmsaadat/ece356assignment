<%-- 
    Document   : index
    Created on : Jan 7, 2015, 8:49:53 AM
    Author     : behrozsaadat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Lab 1</h1>
        <ul>
            <li><a href="user_data_form.jsp">Exercise 2: Enter, save, display data</a></li>
            <li><a href="DBTestServlet">Exercise 3: Connect to the database</a></li>
            <li><a href="DoctorProfileServlet?hideInformation=0">View Own Doctor Profile</a></li>
            <li><a href="DoctorProfileServlet?hideInformation=1">Patient Views Doctor Profile</a></li>
        </ul>

        <h1>Please login:</h1>
        <form action="LoginServlet" method="POST">
            Username: <input type="text" name="user_name"><br />
            Password: <input type="password" name="password" />
            <input type="submit" value="Submit" /><br /> 
        </form>
    </body>
</html>
