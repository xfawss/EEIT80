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
			框體:<input type="text"  name="Housing" value="${joystick.housing}" /><br/>
			搖桿:<input type="text"  name="Rocker" value="${joystick.rocker}" /><br/>
			L1:<input type="text"  name="L1" value="${joystick.l1}" /><br/>
			L2:<input type="text" name="L2" value="${joystick.l2}" /><br/>
			R1:<input type="text" name="R1" value="${joystick.r1}" /><br/>
			R2:<input type="text" name="R2" value="${joystick.r2}" /><br/>
			◎:<input type="text" name="O" value="${joystick.o}" /><br/>
			X:<input type="text" name="X" value="${joystick.x}" /><br/>
			◇:<input type="text" name="Square" value="${joystick.square}" /><br/>
			△:<input type="text" name="Triangle" value="${joystick.triangle}" /><br/>
			start:<input type="text" name="Start" value="${joystick.start}" /><br/>
			select:<input type="text" name="Selecter" value="${joystick.selecter}" /><br/>
			touch鍵:<input type="text" name="Touch" value="${joystick.touch}" /><br/>
			面板圖片:<input type="text" name="CoverImg" value="${joystick.coverImg}" /><br/>
			機板:<input type="text" name="Board" value="${joystick.board}" /><br/>
			折扣碼:<input type="text" name="Coupon" value="${joystick.coupon}" /><br/>
			電話:<input type="text" name="CustomerTel" value="${joystick.customerTel}" ><br>
			收貨種類:<input type="text" name="ReceiveType" value="${joystick.receiveType}" ><br>
			住址:<input type="text" name="CustomerAddr" value="${joystick.customerAddr}" ><br>
			收件備註:<textarea name="ReceiveNotes" cols="20" rows="5" >${joystick.receiveNotes}</textarea><br>
			訂單備註:<textarea name="OrderNotes" cols="20" rows="5" >${joystick.orderNotes}</textarea><br>
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