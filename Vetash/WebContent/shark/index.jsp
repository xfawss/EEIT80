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
<h2>查詢</h2>

<Form Action="/Vetash/Customers" method="GET">

		<select name="cust">
				<option value="customerTel">customerTel</option>
				<option value="customerName">customerName</option>
				<option value="customerFb">customerFb</option>
				<option value="customerLine">customerLine</option>
				<option value="customerMail">customerMail</option>
				<option value="customerAddr">customerAddr</option>
				<option value="customerNote">customerNote</option>
		</select>


				輸入電話:<INPUT TYPE="text" NAME="customerTel" >  <BR>      
				輸入姓名:<INPUT TYPE="text" NAME="customerName" > <BR>
				輸入fb:<INPUT TYPE="text" NAME="customerFb" >  <BR>
				輸入line:<INPUT TYPE="text" NAME="customerLine" > <BR>
				輸入mail:<INPUT TYPE="text" NAME="customerMail" >  <BR>
				輸入addr:<INPUT TYPE="text" NAME="customerAddr"> <BR>
				輸入note:<INPUT TYPE="text" NAME="customerNote" >  <BR>          
				
			<a href="/Vetash/shark/Insert.jsp">insert</a>				
			<a href="/Vetash/shark/Update.jsp">Update</a>
			<a href="/Vetash/shark/Delete.jsp">Delete</a>
				
				<input type="submit" value="提交"  />
</Form>
</body>
</html>