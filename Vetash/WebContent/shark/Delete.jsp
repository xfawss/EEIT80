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
<h2>刪除</h2>


<form action="./Customers" method="POST">
	<input type="text" name="customerTel" value="0911111111"><br><span>${errMsgs.customerTel}</span><br>
	<p>${errMsgs.result}</p>
	<input type="hidden" name="action" value="Delete">
	<input type="submit" value="delete">
	<a href="index.jsp">index</a>
</form>

<c:if test="${not empty delete}">
<h3>Delete Product Table Success : ${delete} row deleted</h3>

</c:if>
</body>
</html>