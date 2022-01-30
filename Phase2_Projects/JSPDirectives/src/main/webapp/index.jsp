<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.directives.Employee"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Employee Info</h1>
	<jsp:useBean id="emp" class="com.directives.Employee"></jsp:useBean>
	<jsp:setProperty property="empno" name="emp" value="101" />
	<jsp:setProperty property="empname" name="emp" value="Amit" />
	<jsp:getProperty property="empno" name="emp" />
	<jsp:getProperty property="empname" name="emp" />
</body>
</html>