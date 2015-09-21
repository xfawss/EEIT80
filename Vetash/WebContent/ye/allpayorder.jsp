<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="http://payment.allpay.com.tw/Cashier/AioCheckOut" method="post">
			廠商編號<input type="text"  name="MerchantID" /><br/>
			訂單編號:<input type="text"  name="MerchantTradeNo" /><br/>
			訂單日期:<input type="text"  name="MerchantTradeDate" /><br/>
			交易類型:<input type="text"  name="PaymentType" /><br/>
			金額 : <input type="text" name="TotalAmount" /><br/>
			描述 : <input type="text" name="TradeDesc" /><br/>
			商品 : <input type="text" name="ItemName" /><br/>
			<input type="text" name="ReturnURL" /><br/>
			<input type="text" name="ChoosePayment" /><br/>
			<input type="text" name="IgnorePayment" /><br/>
			<input type="text" name="ClientBackURL" /><br/>
			<input type="text" name="CheckMacValue" /><br/>
			<input type="submit" value="send" />
	</form>
</body>
</html>