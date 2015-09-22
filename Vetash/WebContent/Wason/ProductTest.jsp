<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%String path = request.getContextPath(); %>

<a href="<%=path %>/products?action=select">getAll</a><br/>
<a href="<%=path %>/products?productName=三合按鈕&action=select">selectByName</a><br/>
<a href="<%=path %>/products?productType=按鍵&action=select">selectByType</a><br/>
<a href="<%=path %>/products?productId=ID1&action=select">selectByID</a><br/>
<a href="<%=path %>/products?productId=ID1&action=select1">selectCostById</a><br/>
<hr>


<p>insert</p>
<form action="/Vetash/products" method="post">
	
	<input type="text" name="productId" >
	<span>${errMsg.productId}</span>id<br>
	
	<input type="text" name="productType" >
	<span>${errMsg.productType}</span>type<br>
	
	<input type="text" name="productName" >
	<span>${errMsg.productName}</span>productName<br>
	
	<input type="text" name="productPrice" >
	<span>${errMsg.productPrice}</span>productPrice<br>
	
	<input type="text" name="productImgPath" >
	<span>${errMsg.productImgPath}</span>productImgPath<br>
	
	<input type="text" name="productNote" >
	<span>${errMsg.productNote}</span>productNote<br>
	<br>
	<input type="hidden" name="action" value="insert">
	<input type="submit" name="action" value="insert"><br>
</form>

<p>update</p>
<form action="/Vetash/products" method="post">
	
	<input type="text" name="productId" >
	<span>${errMsg.productId}</span>id<br>	
	
	<input type="text" name="productName" >
	<span>${errMsg.productName}</span>productName<br>
	
	<input type="text" name="productPrice" >
	<span>${errMsg.productPrice}</span>productPrice<br>
	
	<input type="text" name="productImgPath" >
	<span>${errMsg.productImgPath}</span>productImgPath<br>
	
	<input type="text" name="productNote" >
	<span>${errMsg.productNote}</span>productNote<br>
	<br>
	<input type="hidden" name="action" value="update">
	<input type="submit" name="action" value="update"><br>
</form>

<p>delete</p>
<form action="/Vetash/products" method="post">
	
	<input type="text" name="productId" >
	<span>${errMsg.productId}</span>id<br>	
	<br>
	<input type="hidden" name="action" value="delete">
	<input type="submit" name="action" value="delete"><br>
</form>
</body>
</html>