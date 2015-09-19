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
<form action="<%=path %>/image"  method="POST">
	imageName<br>
	<input type="text" name="name" value="${param.name}"><br>
	imagePath<br>
	<input type="text" name="path" value="${param.path}"><br>
	imageCategoryId<br>
	<input type="text" name="imgCategoryId" value="${param.imgCategoryId}"><br>
	<input type="hidden" name="action" value="insert">
	<input type="submit" name="action" value="insert"><br>
</form>
<hr>

<p>update</p>
<form action="<%=path %>/image" method="POST"><br>
	imageName<br>
	<input type="text" name="name" value="${param.name}"><br>
	imageId<br>
	<input type="text" name="imageId" value="${param.imageId}"><br>	
	<input type="hidden" name="action" value="update">
	<input type="submit" name="action" value="update"><br>
</form>
<hr>

<p>delete</p>
<form action="<%=path %>/image" method="POST">
	imageId
	<input type="text" name="imageId" value="${param.imageId}">
	<input type="hidden" name="action" value="delete">
	<input type="submit" value="delete"><br>
</form>
<hr>

</body>
</html>