<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "com.deanntu.inventory.manager.* ,
    com.deanntu.inventory.entity.*, java.util.*" %>
<%
	CategoryManager cm = new CategoryManager();
	List<Category> categories= cm.list();
	
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
</style>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Categories</title>
</head>
<body>
<%for(Category c: categories){ 
	String href = "Products.jsp?categoryID="+c.getCategoryID();
	String output = c.getCategoryName();
%>
	<a href = <%=href %>><%=output %></a><br />
<%} %>
<button onclick="window.location.href='../Home.jsp';">
      Home
</button>
</body>
</html>