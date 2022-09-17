<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1" import="com.deanntu.user.manager.* , com.deanntu.user.entity.*" %>
<%
String username="";
String password="";
String message="";
UserManager userManager = new UserManager();
if(request.getParameter("login") != null){
	username= request.getParameter("username");
	password= request.getParameter("password");
	User user = userManager.findByUserName(username);
	if(user!= null) {
		if (user.getUserPassword().equals(password) ){
			session.setAttribute("username",username);
			response.sendRedirect("Home.jsp");
		}else{
			message="Password invalid!";
		}
	}else{
		message="User not found!";
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
<form action="Login.jsp" method="POST">
		username: <input type="text" name="username" value="<%=username%>"><br /> <br />
		password: <input	type="password" name="password" value="<%=password%>"> <br /><br />
		<input	type="submit" value="login" name="login"><br /><br />
</form>
<%=message%><br />
<button onclick="window.location.href='Home.jsp';">
      Home
</button>
</body>

</html>