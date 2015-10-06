<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
	<title>order</title>
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
							訂購
						</h1>
						<hr>
					</div>
				</div>

				<div class="row">
					<div class="column">
						<div class="ui center aligned grid container">
							<div class="ten wide left aligned column">
								<form class="ui form" id="orderForm" action="/Vetash/orderSelect" method="post">
									<h4 class="ui dividing header">購買者資訊</h4>
									<div class="two fields">
										<div class="required field">
											<label>姓名</label>
											<input type="text" name="customerName">
										</div>
										<div class="required field">
											<label>電話</label>
											<input type="text" name="customerTel">
										</div>
									</div>
									<div class="field">
										<label>E-mail</label>
										<input type="text" name="customerMail">
									</div>
									<div class="two fields">
										<div class="field">
											<label>Line</label>
											<input type="text" name="customerLine">
										</div>
										<div class="field">
											<label>FB</label>
											<input type="text" name="customerFb">
										</div>
									</div>
									<h4 class="ui dividing header">收件資訊</h4>
									<div class="two fields">
										<div class="required field">
											<label>收件方式</label>
											<div class="ui selection dropdown">
												<input name="receiveType" type="hidden">
												<i class="dropdown icon"></i>
												<div class="default text">請選擇收件方式</div>
												<div class="menu">
													<div class="item" data-value="便利商店取貨">便利商店取貨</div>
													<div class="item" data-value="宅配">宅配</div>
													<div class="item" data-value="自取">自取</div>
												</div>
											</div>
										</div>
										<div class="required field">
											<label>收件地址</label>
											<input type="text" name="customerAddr" placeholder="若為便利商店取貨請填寫門市名稱。">
										</div>
									</div>
									<div class="two fields">
										<div class="field">
											<label>收件資訊</label>
											<textarea name="receiveNotes" cols="20" rows="5" placeholder="可填寫收件人、收件時間等資訊。"></textarea>
										</div>
										<div class="field">
											<label>訂單備註</label>
											<textarea name="orderNotes" cols="20" rows="5" placeholder="若有其他事情必須與通知公館，可填寫於此欄位">${joystick.orderNotes}</textarea>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="center aligned column">
						<button class="ui green button submitBtn">
							送出訂單
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

			</div>
		</div>
	</div>

</body>
<script>

	$('.submitBtn').click(function(){
		 $('#orderForm').form('submit');
		/*$('#orderForm').form('validate form');*/
	});

	$('#orderForm .dropdown').dropdown({
		onChange:function(){
			if("自取"===$('#orderForm input[name="receiveType"]').val()){
				$('#orderForm input[name="customerAddr"]').val("自取");
			}
		}
	})

	/*action="/Vetash/order" method="post"*/
	$('#orderForm').form({
		inline:true,
		fields:{
			customerName: {
				identifier: 'customerName',
				rules: [
				{
					type   : 'empty',
					prompt : '請輸入姓名'
				}
				]
			},
			customerTel: {
				identifier: 'customerTel',
				rules: [
				{
					type   : 'empty',
					prompt : '請輸入電話'
				},
				{
					type   : 'regExp[/\\+?\\d{1,4}-?(\\d{4,15})(#\\d{1,5}){0,1}/]',
					prompt : '輸入資料錯誤，電話號碼不能有中文或英文，如:02-27450475#123'

				}
				]
			},
			customerMail: {
				identifier: 'customerMail',
				optional: true,
				rules: [
				{
					type   : 'email',
					prompt : 'E-mail格式不正確'
				}
				]
			},
			customerAddr: {
				identifier: 'customerAddr',
				rules: [
				{
					type   : 'empty',
					prompt : '請輸入收件地址'
				}
				]
			}
		}
	});

	$('#backBtn').popup({
		title:'回公館快打'
	});

</script>
</html>