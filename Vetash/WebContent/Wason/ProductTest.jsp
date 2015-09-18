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

<a href="<%=path %>/product?action=1select">getAll</a><br/>
<a href="<%=path %>/product?productName=1&action=select">selectByName</a><br/>
<a href="<%=path %>/product?productType=1&action=select">selectType</a><br/>
<a href="<%=path %>/product?productId=1&action=select">selectByID</a><br/>
<a href="<%=path %>/product?productType=1&action=select">selectType</a><br/>
<hr>

<p>insert</p>
<form action="/Vetash/model" method="post">
	id<br>
	<input type="text" name="productId" >
	<span>${errMsg.productId}</span>
	type<br>
	<input type="text" name="productType" >
	<span>${errMsg.productType}</span>
	productName<br>
	<input type="text" name="productName" >
	<span>${errMsg.productName}</span>
	productPrice<br>
	<input type="text" name="productPrice" >
	<span>${errMsg.productPrice}</span>
	productImgPath<br>
	<input type="text" name="productImgPath" >
	<span>${errMsg.productImgPath}</span>
	productNote<br>
	<input type="text" name="productNote" >
	<span>${errMsg.productNote}</span>
	<br>
	<input type="hidden" name="action" value="insert">
	<input type="submit" name="action" value="insert"><br>
</form>

</body>
</html>