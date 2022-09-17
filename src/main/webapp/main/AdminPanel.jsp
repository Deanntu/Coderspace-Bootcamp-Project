<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
if(!(session.getAttribute("username").equals("admin"))){
	response.sendRedirect("Home.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="inventory/AddProduct.jsp">AddProduct</a>
<a href="inventory/AddCategory.jsp">AddCategory</a>
<br/>
<button onclick="window.location.href='Home.jsp';">
      Home
</button>
</body>
</html>