<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>更新</h2>
<form action="./Customers" method="POST">
	customerName<br>
	<input type="text" name="customerName" value="CMA"><br><span>${errMsgs.customerName}</span><br>
	<p>${errMsgs.result}</p>
	customerTel<br>
	<input type="text" name="customerTel" value="0911111111"><br><span>${errMsgs.customerTel}</span><br>
	<p>${errMsgs.result}</p>
	customerLine<br>
	<input type="text" name="customerLine" value="cmaLine"><br>
	customerFb<br>
	<input type="text" name="customerFb" value="cma@iii.edu.org"><br>
	customerMail<br>
	<input type="text" name="customerMail" value="cma@gmail.com"><br>
	customerAddr<br>
	<input type="text" name="customerAddr" value="台北市大安路一段366號"><br><span>${errMsgs.customerAddr}</span><br>
	<p>${errMsgs.result}</p>
	customerNote<br>
	<input type="text" name="customerNote" value="馬老師"><br>
	<br>
	<input type="hidden" name="action" value="Update">
	<input type="submit" value="update">
</form>

<c:if test="${not empty Update}">
<h3>Update Product Table Success</h3>
<table border="1">
	<tr><td>Id</td><td>${Update.id}</td></tr>
	<tr><td>Name</td><td>${Update.name}</td></tr>
	<tr><td>Price</td><td>${Update.price}</td></tr>
	<tr><td>Make</td><td>${Update.make}</td></tr>
	<tr><td>Expire</td><td>${Update.expire}</td></tr>
</table>

</c:if>
</body>
</html>