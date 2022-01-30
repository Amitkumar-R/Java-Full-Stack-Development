<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
</head>
<body>
	<%
		if(request.getParameter("error") != null)
			out.println("<b>Session has expired or invalid</b>");
	%>
	
	<form action="login.jsp" method="post">
		Name: <input name="name" name="name"><br>
		Password: <input type="password" name="pwd"><br>
		<input type="submit" value="Submit">
	</form>
</body>
</html>