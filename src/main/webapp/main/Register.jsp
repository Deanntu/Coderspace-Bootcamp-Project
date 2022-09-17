<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1" import="com.deanntu.user.entity.User, com.deanntu.user.manager.UserManager" %>
<%
String username="";
String password="";
String password2="";
String message="";
String address="";
UserManager userManager = new UserManager();
if(request.getParameter("login") != null){
	username= request.getParameter("username");
	password= request.getParameter("password");
	password2= request.getParameter("password2");
	if(!password.equals(password2)) {
		message="passwords must be equal";
		
	}else{
		if(userManager.findByUserName(username)==null) {
			User user = new User();
			user.setUserName(username);
			user.setUserPassword(password);
			user.setAddress(address);
			boolean isCreated = userManager.create(user);
			if(isCreated){
				message= "user created and stored";
			}else{
			message= "user created but not stored";
			}
		}else{
			message= "username already taken";
		}
	}
	
}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
<form action="Register.jsp" method="POST">
		username: <input type="text" name="username" value="<%=username%>"><br /> <br />
		password: <input	type="password" name="password" value="<%=password%>"> <br /><br />
		password: <input	type="password" name="password2" value="<%=password2%>"> <br /><br />
		adress: <input type="text" name = "address" value="<%=address %>"><br /><br />
		<input	type="submit" value="register" name="login"><br /><br />
</form>
<button onclick="window.location.href='Login.jsp';">
      Login
    </button>
 
</body>
<button onclick="window.location.href='Home.jsp';">
      Home
</button>
<%=message%><br />
</html>