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
			廠商編號<input type="text"  name="MerchantID" value=${requestScope.MerchantID} /><br/>
			訂單編號:<input type="text"  name="MerchantTradeNo" value=${requestScope.MerchantTradeNo} /><br/>
			訂單日期:<input type="text"  name="MerchantTradeDate" value=${param.MerchantTradeDate} /><br/>
			交易類型:<input type="text"  name="PaymentType" value=${requestScope.PaymentType} /><br/>
			金額 : <input type="text" name="TotalAmount" value=${requestScope.TotalAmount} /><br/>
			描述 : <input type="text" name="TradeDesc" value=${requestScope.TradeDesc} /><br/>
			商品 : <input type="text" name="ItemName" value=${requestScope.ItemName} /><br/>
			<input type="text" name="ReturnURL" value=${requestScope.ReturnURL} /><br/>
			<input type="text" name="ChoosePayment" value=${requestScope.ChoosePayment} /><br/>
			<input type="text" name="IgnorePayment" value=${requestScope.IgnorePayment} /><br/>
			<input type="text" name="ClientBackURL" value=${requestScope.ClientBackURL} /><br/>
			<input type="text" name="CheckMacValue" value=${requestScope.CheckMacValue} /><br/>
			<input type="submit" value="send" />
	</form>

</body>
</html>