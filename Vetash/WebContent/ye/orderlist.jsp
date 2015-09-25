<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="" method="post">
			框體:<input type="text"  name="housing" value="${joystick.housing}" /><br/>
			搖桿:<input type="text"  name="rocker" value="${joystick.rocker}" /><br/>
			L1:<input type="text"  name="l1" value="${joystick.l1}" /><br/>
			L2:<input type="text" name="l2" value="${joystick.l2}" /><br/>
			R1:<input type="text" name="r1" value="${joystick.r1}" /><br/>
			R2:<input type="text" name="r2" value="${joystick.r2}" /><br/>
			◎:<input type="text" name="o" value="${joystick.o}" /><br/>
			X:<input type="text" name="x" value="${joystick.x}" /><br/>
			◇:<input type="text" name="square" value="${joystick.square}" /><br/>
			△:<input type="text" name="triangle" value="${joystick.triangle}" /><br/>
			start:<input type="text" name="start" value="${joystick.start}" /><br/>
			select:<input type="text" name="selecter" value="${joystick.selecter}" /><br/>
			touch鍵:<input type="text" name="touch" value="${joystick.touch}" /><br/>
			面板圖片:<input type="text" name="coverImg" value="${joystick.coverImg}" /><br/>
			機板:<input type="text" name="board" value="${joystick.board}" /><br/>
			折扣碼:<input type="text" name="coupon" value="${joystick.coupon}" /><br/>
			電話:<input type="text" name="customerTel" value="${joystick.customerTel}" ><br>
			收貨種類:<input type="text" name="receiveType" value="${joystick.receiveType}" ><br>
			住址:<input type="text" name="customerAddr" value="${joystick.customerAddr}" ><br>
			收件備註:<textarea name="receiveNotes" cols="20" rows="5" >${joystick.receiveNotes}</textarea><br>
			訂單備註:<textarea name="orderNotes" cols="20" rows="5" >${joystick.orderNotes}</textarea><br>
		</form>		
<hr>

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