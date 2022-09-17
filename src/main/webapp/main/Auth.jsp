<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
String admin = "";
String pass = "";
boolean auth = false;
if(request.getParameter("username") != null){
	admin = request.getParameter("username");
	pass = request.getParameter("password");

}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGINING</title>
</head>
<body>
<% 	if(admin == "admin" && pass == "admin"){
		auth = true;
	}
%>
<%=auth %>
<%	if (auth == true) {
    response.sendRedirect("AdminPanel"); // Redirects to http://example.com/context/home after succesful login.
} else {
    request.setAttribute("error", "Unknown login, please try again."); // Set error.
    request.getRequestDispatcher("AdminLogin.jsp").forward(request, response); // Forward to same page so that you can display error.
}
%>
<form action="Home.jsp" method = "POST"></form>
</body>
</html>