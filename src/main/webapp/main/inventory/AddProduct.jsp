<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.deanntu.inventory.entity.* , com.deanntu.inventory.manager.*" %>
<%
if(!(session.getAttribute("username").equals("admin"))){
	response.sendRedirect("Home.jsp");
}
String productName="";
long productID=0;
long salesPrice=0;
long categoryID=0;
String message ="";
ProductManager pm = new ProductManager();
CategoryManager cm = new CategoryManager();
if(request.getParameter("add") != null){
	
	productName= request.getParameter("productname");
	productID= Integer.parseInt(request.getParameter("productid"));
	salesPrice= Integer.parseInt(request.getParameter("salesprice"));
	categoryID = Integer.parseInt(request.getParameter("categoryid"));
	if(pm.find(productID) != null) {
		message="This Product ID already used, please go to Update Product to change!";
		
	}else{
		if(cm.find(categoryID)!=null){
			Product product = new Product();
			product.setProductName(productName);
			product.setProductID(productID);
			product.setSalesPrice(salesPrice);
			product.setCategoryID(categoryID);
			boolean isCreated = pm.insert(product);
			if(isCreated){
				message= "Product added and stored.";
			}else{
			message= "Product added but cannot stored please connect to your service provider.";
			}
		}
		else{
			message= "Category with given Category ID is not exist please go to Add Category to create!";
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
<form action="AddProduct.jsp">
		Product Name: <input type="text" name="productname" value="<%=productName%>"><br /> <br />
		Product ID: <input	type="text" name="productid" value="<%=productID%>"> <br /><br />
		Sales Price: <input	type="text" name="salesprice" value="<%=salesPrice%>"> <br /><br />
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