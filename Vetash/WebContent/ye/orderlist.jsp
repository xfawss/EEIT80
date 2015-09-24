<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="http://payment-stage.allpay.com.tw/Cashier/AioCheckOut" method="post">
			廠商編號<input type="text"  name="MerchantID" value="${MerchantID}" /><br/>
			訂單編號:<input type="text"  name="MerchantTradeNo" value="${MerchantTradeNo}" /><br/>
			訂單日期:<input type="text"  name="MerchantTradeDate" value="${MerchantTradeDate}" /><br/>
			交易類型:<input type="text"  name="PaymentType" value="${PaymentType}" /><br/>
			金額 : <input type="text" name="TotalAmount" value="${TotalAmount}" /><br/>
			描述 : <input type="text" name="TradeDesc" value="${TradeDesc}" /><br/>
			商品 : <input type="text" name="ItemName" value="${ItemName}" /><br/>
			<input type="text" name="ReturnURL" value="${ReturnURL}" /><br/>
			<input type="text" name="ChoosePayment" value="${ChoosePayment}" /><br/>
			<input type="text" name="IgnorePayment" value="${IgnorePayment}" /><br/>
			<input type="text" name="ClientBackURL" value="${ClientBackURL}" /><br/>
			<input type="text" name="CheckMacValue" value="${CheckMacValue}" /><br/>
			<input type="submit" value="send" id="submit"/>
	</form>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script>!window.jQuery && document.write("<script src='Scripts/jquery-2.1.4.min.js'><\/script>")</script>

	<script type="text/javascript">
		(function($){
			$("#submit").click(function(){
				$.get("/Vetash/orderChecked")
			})
	    }(jQuery))
	</script>
	
</body>
</html>