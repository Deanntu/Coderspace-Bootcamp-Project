<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%
session.removeAttribute("username");
response.sendRedirect("Home.jsp");
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout</title>
</head>
<body>
Logging out
</body>
</html>