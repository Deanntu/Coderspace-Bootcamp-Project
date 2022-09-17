<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "com.deanntu.inventory.manager.* ,
    com.deanntu.inventory.entity.*, java.util.*" %>
<%
CategoryManager cm = new CategoryManager();
List<Category> categoryList = cm.list(); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category List</title>
</head>
<body>
	<%
	for(Category c:categoryList){
	%>
	<a><%=c.toPublish()%></a> <br/>
	<%
	}
	%>
</body>
</html>