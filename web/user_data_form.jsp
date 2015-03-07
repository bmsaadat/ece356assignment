<%-- 
    Document   : user_data_form
    Created on : Jan 7, 2015, 8:52:46 AM
    Author     : behrozsaadat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>User Data Form</h1>
        <form action="UserDataServlet" method="POST">
            what is your name? <input type="text" name="username" value="" />
            <br>
            what is your favourite colour? <select name="usercolour">
                <option>Red</option>
                <option>Blue</option>
            </select>
            <br>
            <input type="submit" value="Submit" />
        </form>
    </body>
</html>
