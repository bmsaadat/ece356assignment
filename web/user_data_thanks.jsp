<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
<head>
<title>Form 1</title>
</head>
<body>
<h2>Thank you for entering your user data.</h2>

<jsp:useBean id="userData" class="ece356.UserData" scope="session"/>

Name: <%= userData.getUserName() %><br/>
Colour: <%= userData.getFavColour() %><br/>

<p>
<a href="user_data_thanks2.jsp">Continue</a>

</body>
</html>