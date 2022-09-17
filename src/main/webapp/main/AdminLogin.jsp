<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
String username="";
String password="";
String message="";
session.setAttribute("username","");
if(request.getParameter("login") != null){
	username= request.getParameter("username");
	password= request.getParameter("password");
		if ("admin".equals(password) && "admin".equals(username)){
			session.setAttribute("username","admin");
			response.sendRedirect("AdminPanel.jsp");
		}else{
			message="Password invalid!";
		}
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<form action="AdminLogin.jsp" method="POST">
username: <input type="text" name="username" value="<%=username%>"><br /> <br />
password: <input	type="password" name="password" value="<%=password%>"> <br /><br />
<input	type="submit" value="login" name="login"><br /><br />

</form>
<button onclick="window.location.href='Home.jsp';">
      Home
</button>
<br/>
<%=message%><br/> 
</body>
</html>