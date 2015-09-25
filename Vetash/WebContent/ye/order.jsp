<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/Vetash/order" method="post">
姓名:<input type="text" name="customerName" value="${customerName}" ><br>
電話:<input type="text" name="customerTel" value="${joystick.customerTel}" ><br>
E-mail:<input type="text" name="customerMail" value="${customerMail}" ><br>
Line:<input type="text" name="customerLine" value="${customerLine}" ><br>
FB:<input type="text" name="customerFb" value="${customerFb}" ><br>
收貨種類:<select name="receiveType" id="receiveType" >
	<option value="Store">店家</option>
	<option value="Home">宅配</option>
</select>
<br>

住址:<input type="text" name="customerAddr" value="${joystick.customerAddr}" ><br>
收件備註:<textarea name="receiveNotes" cols="20" rows="5" >${joystick.receiveNotes} </textarea><br>
訂單備註:<textarea name="orderNotes" cols="20" rows="5" >${joystick.orderNotes}</textarea><br>
<input type="reset" value="清除"><input type="submit" value="send">

</body>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script>!window.jQuery && document.write("<script src='Scripts/jquery-2.1.4.min.js'><\/script>")</script>

	<script type="text/javascript">
		(function($){
			$("#receiveType").val("${joystick.receiveType}");
	    }(jQuery))
	</script>




</html>