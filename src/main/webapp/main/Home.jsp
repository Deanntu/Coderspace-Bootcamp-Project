<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%if (session.getAttribute("logout") != null){
	session.removeAttribute("username");

}
	 %>
<style>
button{
	background-color:rgb(124,124,124);
	border-style: none;
	border-radius: 20px;
	padding: 5px;	
	color: white;
	cursor: pointer;
}
button:hover{
	box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
}
input{
	background-color:rgb(124,124,124);
	border-style: none;
	border-radius: 20px;
	padding: 5px;	
	color: white;
	cursor: pointer;
}
input:hover{
	box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
}
</style>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<button onclick="window.location.href='../main/api/Categories.jsp';">
      Categories
</button>
<%
if (session.getAttribute("username") != null){
	if (session.getAttribute("username").equals("admin")){
	%>
<button onclick="window.location.href='AdminPanel.jsp';">
      Admin Panel
</button>
<button onclick="window.location.href='Logout.jsp';">
     Logout
</button>


<%}}else{ %>
<button onclick="window.location.href='Login.jsp';">
      Login
</button>
<button onclick="window.location.href='Register.jsp';">
      Register
</button>

<%} %>

</body>
</html>