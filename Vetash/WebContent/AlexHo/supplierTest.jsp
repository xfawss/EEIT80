<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SupplierTest</title>
</head>
<body>

<%String path = request.getContextPath(); %>

<a href="<%=path %>/suppliers?action=select">selectAll</a><br/>
<a href="<%=path %>/suppliers?supplierTel=0933685100&action=select">selectByTel(0974002547)</a><br/>
<a href="<%=path %>/suppliers?supplierName=K&action=select">selectByName(k)</a><br/>
<hr>

<p>Insert</p>
<form action="/Vetash/suppliers" method="POST">
	supplierName<br>
	<input type="text" name="supplierName" value="馬家庄搖桿商"><br>
	supplierTax<br>
	<input type="text" name="supplierTax" value="36954752"><br>
	supplierContact<br>
	<input type="text" name="supplierContact" value="馬老師"><br>
	supplierTel<br>
	<input type="text" name="supplierTel" value="${param.tel}"><br>
	supplierAddr<br>
	<input type="text" name="supplierAddr" value="cma@gmail.com"><br>
	supplierAcct<br>
	<input type="text" name="supplierAcct" value="017-316552356101">
	<br>
	supplierDate<br>
	<input type="text" name="supplierDate" value="2015-03-05"><br>
	supplierNote<br>
	<input type="text" name="supplierNote" value="馬老師很帥很幽默">
	<br>
	<input type="hidden" name="action" value="insert">
	<input type="submit" name="action" value="insert"><br>
</form>
<hr>

<p>update</p>
<form action="/Vetash/suppliers" method="POST"><br>
	supplierName<br>
	<input type="text" name="supplierName" value="馬"><br>
	supplierTax<br>
	<input type="text" name="supplierTax" value="36954752"><br>
	supplierContact<br>
	<input type="text" name="supplierContact" value="馬老師"><br>
	supplierTel<br>
	<input type="text" name="supplierTel" value="${param.tel}"><br>
	supplierAddr<br>
	<input type="text" name="supplierAddr" value="cma@gmail.com"><br>
	supplierAcct<br>
	<input type="text" name="supplierAcct" value="017-316552356101">
	<br>
	supplierDate<br>
	<input type="text" name="supplierDate" value="2015-03-05"><br>
	supplierNote<br>
	<input type="text" name="supplierNote" value="馬老師很帥很幽默">
	<br>
	id<br>
	<input type="text" name="supplierId" value="${param.id}">
	<br>
	<input type="hidden" name="action" value="update">
	<input type="submit" name="action" value="update"><br>
</form>
<hr>

<p>delete</p>
<form action="/Vetash/suppliers" method="POST">
	supplierId
	<input type="text" name="supplierId" value="${param.id}">
	<input type="hidden" name="action" value="delete">
	<input type="submit" value="delete"><br>
</form>


</body>
</html>