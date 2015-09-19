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

<a href="<%=path %>/imgCategory?action=select">selectAll</a><br/>
<a href="<%=path %>/imgCategory?imgCategoryId=2&action=select">selectById(2)</a><br/>
<hr>

<p>Insert</p>
<form action="<%=path %>/imgCategory"  method="POST">
	imgCategoryName<br>
	<input type="text" name="imgCategoryName" value="${param.name}"><br>
	<input type="hidden" name="action" value="insert">
	<input type="submit" name="action" value="insert"><br>
</form>
<hr>

<p>update</p>
<form action="<%=path %>/imgCategory" method="POST"><br>
	imgCategoryName<br>
	<input type="text" name="imgCategoryName" value="${param.name}"><br>
	imgCategoryId<br>
	<input type="text" name="imgCategoryId" value="${param.id}"><br>
	<input type="hidden" name="action" value="update">
	<input type="submit" name="action" value="update"><br>
</form>
<hr>

<p>delete</p>
<form action="<%=path %>/imgCategory" method="POST"><br>
	imgCategoryId<br>
	<input type="text" name="imgCategoryId" value="${param.id}"><br>	
	<input type="hidden" name="action" value="delete">
	<input type="submit" value="delete"><br>
</form>

</body>
</html>