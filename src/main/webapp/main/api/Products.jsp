<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "com.deanntu.inventory.manager.* ,
    com.deanntu.inventory.entity.*, java.util.*" %>
<%
long categoryID=1;
if(request.getParameter("categoryID") != null){
	categoryID = Integer.parseInt(request.getParameter("categoryID"));
}
ProductManager pm = new ProductManager();
List<Product> productList = pm.listByCategoryID(categoryID);
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
<title>Products</title>
</head>
<body>
<form action= "Product.jsp" method="POST">
<%
	for(Product product: productList){
		String productName = product.getProductName();
		long productID = product.getProductID();
		long salesPrice = product.getSalesPrice();
		String info = "Product.jsp?productID="+productID;
%>
<a href= <%=info%>> <%=productName%> </a> <br/>
<%}%>
</form>
<button onclick="window.location.href='../api/Categories.jsp';" >
      Back
</button>
<button onclick="window.location.href='../Home.jsp';">
      Home
</button>
</body>
</html>