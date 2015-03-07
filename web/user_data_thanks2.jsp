<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
<head>
<title>Form 1</title>
</head>
<body>
<h2>User data remains in session.</h2>

<jsp:useBean id="userData" class="ece356.UserData" scope="session"/>

Name: <%= userData.getUserName() %><br/>
Colour: <%= userData.getFavColour() %><br/>

<p>
<a href="index.jsp">Start over</a>

</body>
</html>