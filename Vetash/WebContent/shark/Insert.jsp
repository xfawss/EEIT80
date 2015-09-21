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
<h2>新增</h2>

<form action="/Vetash/Customers" method="POST">
	customerName<br>
	<input type="text" name="customerName" value="CMA"><span>${errMsgs.customerName}</span><br>
	<p>${errMsgs.result}</p>
	customerTel<br>
	<input type="text" name="customerTel" value="0911111111"><span>${errMsgs.customerTel}</span><br>
	<p>${errMsgs.result}</p>
	customerLine<br>
	<input type="text" name="customerLine" value="cmaLine"><br>
	customerFb<br>
	<input type="text" name="customerFb" value="cma@iii.edu.org"><br>
	customerMail<br>
	<input type="text" name="customerMail" value="cma@gmail.com"><br>
	customerAddr<br>
	<input type="text" name="customerAddr" value="台北市大安路一段366號"><span>${errMsgs.customerAddr}</span><br>
	<p>${errMsgs.result}</p>
	customerNote<br>
	<input type="text" name="customerNote" value="馬老師"><br>
	<br>
	<input type="hidden" name="action" value=Insert >
	<input type="submit" value="Insert">
</form>
<a href="index.jsp">index</a>
<c:if test="${not empty Insert}">
<h3>Insert Product Table Success: ${Insert} row deleted </h3>
<table border="1">
	<tr><td>customerName</td><td>${beans.customerName}</td></tr>
	<tr><td>customerTel</td><td>${beans.customerTel}</td></tr>
	<tr><td>customerLine</td><td>${beans.customerLine}</td></tr>
	<tr><td>customerFb</td><td>${beans.customerFb}</td></tr>
	<tr><td>customerMail</td><td>${beans.customerMail}</td></tr>
	<tr><td>customerAddr</td><td>${beans.customerAddr}</td></tr>
	<tr><td>customerNote</td><td>${beans.customerNote}</td></tr>
</table>

</c:if>




</body>
</html>