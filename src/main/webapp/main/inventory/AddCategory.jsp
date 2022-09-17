<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.deanntu.inventory.entity.* , com.deanntu.inventory.manager.*" %>
<%
if(session.getAttribute("username")!= "admin"){
	response.sendRedirect("../Home.jsp");
}
String categoryName="";
long categoryID=0;
String message ="";
CategoryManager cm = new CategoryManager();
if(request.getParameter("add") != null){
	categoryName= request.getParameter("categoryname");
	categoryID = Integer.parseInt(request.getParameter("categoryid"));
	if(categoryID > 0 && !(categoryName.equals(""))){
		if(cm.find(categoryID)!=null){
			message= "Category with given Category ID is already exists. Please use Update Category!";
		}
		else{
			Category category = new Category();
			category.setCategoryID(categoryID);
			category.setCategoryName(categoryName);
			cm.insert(category);
			boolean isCreated = cm.insert(category);
			if(isCreated){
				message= "Category created and stored.";
			}else{
			message= "Crategory created but cannot stored please connect to your service provider.";
			}
		}
	}
}
	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="AddCategory.jsp">
		Category Name: <input type="text" name="categoryname" value="<%=categoryName%>"><br /> <br />
		Category ID: <input	type="text" name="categoryid" value="<%=categoryID%>"> <br /><br />
		<input	type="submit" value="Add Item" name="add"><br /><br />
</form>
<button onclick="window.location.href='../Home.jsp';">
      Home
</button>
<button onclick="window.location.href='../AdminPanel.jsp';">
      Admin Panel
</button>
<%=message %>
</body>
</html>