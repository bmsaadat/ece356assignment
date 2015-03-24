<%-- 
    Document   : index
    Created on : Jan 7, 2015, 8:49:53 AM
    Author     : behrozsaadat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/signin.css" rel="stylesheet">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
    <div class="container">

        <h1 ><ul>Hospital Management System</ul></h1>

      <form class="form-signin" action="LoginServlet" method="POST">
    <%  String error_message_flag = request.getParameter("error_message_flag"); 
          if(error_message_flag != null && error_message_flag.equals("1"))
          {
              %>
                <p class="bg-danger">Invalid Login!</p>
              <%
          }
      %>
        <h3 >Sign-in:</h3>
        <label for="inputUsername" class="sr-only">Username</label>
        <input id="inputUsername" class="form-control" placeholder="Username" name="user_name" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required name="password">
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        

            </form>
          </div> <!-- /container -->
       </body>
      </html>

