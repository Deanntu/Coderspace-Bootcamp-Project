<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "com.deanntu.inventory.manager.* ,
    com.deanntu.inventory.entity.*, java.util.*" %>
<%
ProductManager pm = new ProductManager();
List<Product> productList = pm.list(); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product List</title>
</head>
<body>
	<%
	for(Product p:productList){
	%>
	<a><%=p.toPublishAdmin()%></a> <br/>
	<%}%>
<form action="ProductDetail.jsp"method="POST">

</form>
	
</body>
</html>