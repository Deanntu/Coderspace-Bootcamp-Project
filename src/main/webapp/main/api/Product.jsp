<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "com.deanntu.inventory.manager.*, com.deanntu.cart.entity.*, com.deanntu.cart.manager.* ,
    com.deanntu.inventory.entity.*, java.util.*" %>
<%
String productsBack = "";
long productID = 0;
if(request.getParameter("productID") != null){
	productID = Integer.parseInt(request.getParameter("productID"));
}
ProductManager pm = new ProductManager();
Product product = pm.find(productID);
productsBack = "window.location.href='../api/Products.jsp?categoryID="+productID+"';";
String info = product.toPublish();
%>
<%
long quantity = 0;
Cart cart = new Cart();
CartProduct cp = new CartProduct();
String message = "";
if(request.getParameter("addProduct") != null){
	quantity =  Integer.parseInt(request.getParameter("quantity"));
	
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
</style>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Product</title>
</head>
<body>
<p>Product Name: <%=product.getProductName() %><p/>
<p>Price: <%=product.getSalesPrice() %> <p/>
<form method="POST">
	Quantity: <input type="text" name="Quantity:" value="<%=quantity%>">
	<input	type="submit" value="Add to Cart" name="addToCart"><br /><br />
	<%=message%><br />
</form>
<button onclick= <%=productsBack%>>
      Back
</button>
<button onclick="window.location.href='../Home.jsp';">
      Home
</button>

</body>
</html>
