<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
	<title>orderlist</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
	<script src="semantic/dist/semantic.min.js"></script>
	<link rel="stylesheet" type="text/css" href="semantic/dist/semantic.min.css">
	<!-- additional -->
	<style>
		*{
			/* border: 1px solid green; */
		}
		body{
			background-color: rgb(253,253,247);
		}
		.pure{
			margin: 0px !important;
			padding: 0px !important;
		}
		.purePaded{
			margin: 0px !important;
		}
		.cursorPointer{
			cursor:pointer;
		}
		.theMenu{
			height: 6%;
			width: 100%;
			margin: 0px !important;
			padding: 0px !important;
			position: absolute;
		}
		.theMenuPlaceholder{
			height: 8vh;
		}
	</style>
	<style type=text/css>
		body{
			font-family: "微軟正黑體", "Microsoft JhengHei" !important;
		}
		h1{
			font-family: "微軟正黑體", "Microsoft JhengHei" !important;
		}
	</style>
</head>
<body>
	<div class="middle aligned row theMenu">
		<div class="three wide column"></div>
		<div class="nine wide middle aligned column">
		</div>
		<div class="four wide middle aligned column">
		</div>
	</div>
	<div class="ui grid container">
		<div class="row theMenuPlaceholder"></div>
		<div class="row thePage"><!-- thePage -->
			<div class="ui stackable grid container">
				<div class="row">
					<div class="left floated left aligned ten wide column">
						<h5 class="sectionSubTitle">Order</h5>
						<h1 class="sectionTitle">
							訂單查詢
						</h1>
						<hr>
					</div>
				</div>

				<div class="row">
					<div class="column">
						<div class="ui center aligned grid container">
							<div class="ten wide left aligned column">
								<h4 class="ui dividing header">訂單資訊</h4>
								<div class="ui divided list">
									<div class="item">
										<div class="content">
											<div class="header">編號</div>
											${MerchantTradeNo}
										</div>
									</div>
									<div class="item">
										<div class="content">
											<div class="header">日期</div>
											${MerchantTradeDate}
										</div>
									</div>
									<div class="item">
										<div class="content">
											<div class="header">價格</div>
											${TotalAmount}
										</div>
									</div>
									<div class="item">
										<div class="content">
											<div class="header">預計到貨日</div>
											${joystick.deliveryDate}
										</div>
									</div>
								</div>

								<h4 class="ui dividing header">購買資訊</h4>
								<div class="ui divided list">
									<div class="item">
										<div class="content">
											<div class="header">電話</div>
											${joystick.customerTel}
										</div>
									</div>
									<div class="item">
										<div class="content">
											<div class="header">收貨種類</div>
											${joystick.receiveType}
										</div>
									</div>
									<div class="item">
										<div class="content">
											<div class="header">收件地址</div>
											${joystick.customerAddr}
										</div>
									</div>
									<div class="item">
										<div class="content">
											<div class="header">收件備註</div>
											${joystick.receiveNotes}
										</div>
									</div>
									<div class="item">
										<div class="content">
											<div class="header">訂單備註</div>
											${joystick.orderNotes}
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="two column row">
					<div class="right aligned column">
						<button class="ui circular red icon button" id="backBtn">
							<i class="reply icon"></i>
						</button>
					</div>
					<div class="left aligned column">
						<button class="ui green button" id="allpayBtn" >
							前往歐付寶結帳&nbsp;&nbsp;
							<i class="share icon"></i>
						</button>
					</div>
				</div>

				<div class="row">
					<div class="ui grid container" style="margin-bottom:0px;">
						<div class="bottom aligned center aligned column">
							Vetash Copyright © 2015, all rights reserved.
						</div>
					</div>
				</div>
				<form action="http://payment-stage.allpay.com.tw/Cashier/AioCheckOut" method="post" class="ui form allpayForm" style="display:none">
					<input type="text"  name="MerchantID" value="${MerchantID}" /><br/>
					<input type="text"  name="MerchantTradeNo" value="${MerchantTradeNo}" /><br/>
					<input type="text"  name="MerchantTradeDate" value="${MerchantTradeDate}" /><br/>
					<input type="text"  name="PaymentType" value="${PaymentType}" /><br/>
					<input type="text" name="TotalAmount" value="${TotalAmount}" /><br/>
					<input type="text" name="TradeDesc" value="${TradeDesc}" /><br/>
					<input type="text" name="ItemName" value="${ItemName}" /><br/>
					<input type="text" name="ReturnURL" value="${ReturnURL}" /><br/>
					<input type="text" name="ChoosePayment" value="${ChoosePayment}" /><br/>
					<input type="text" name="IgnorePayment" value="${IgnorePayment}" /><br/>
					<input type="text" name="ClientBackURL" value="${ClientBackURL}" /><br/>
					<input type="text" name="CheckMacValue" value="${CheckMacValue}" /><br/>
				</form>

			</div>
		</div>
	</div>

</body>
<script>
	

	$("#allpayBtn").click(function(){
		$(".allpayForm").form('submit');
	});

	$('#backBtn').popup({
		title:'回訂製首頁'
	});

	$('#backBtn').click(function(){
		location.assign("./front_custom_intro.html");
	});

</script>
</html>