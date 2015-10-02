<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
	<title>Vetash Custom Joystick Backend Login</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script src="semantic/dist/semantic.min.js"></script>
	<link rel="stylesheet" type="text/css" href="semantic/dist/semantic.min.css">
	<!-- additional -->
	<style type=text/css>
		body{
			font-family: "微軟正黑體", "Microsoft JhengHei" !important;
		}
		h1{
			font-family: "微軟正黑體", "Microsoft JhengHei" !important;
		}
	</style>
</head>
<body style="background-color:#EDEDED;">
	<div class="ui middle aligned center aligned grid" style="height:100%">
		<div class="column" style="max-width:450px">
			<img src="images/logo_l.png" class="ui centered image" style="margin-bottom:15px">
			<form class="ui large form" action="./accessback" method="post" id="login">
				<div class="ui stacked segment">
					<div class="field">
						<div class="ui left icon input">
							<i class="user icon"></i>
							<input name="account" placeholder="user" type="text">
							<input name="task" value="login" type="hidden">
						</div>
					</div>
					<div class="field">
						<div class="ui left icon input">
							<i class="lock icon"></i>
							<input name="password" placeholder="Password" type="password">
						</div>
					</div>
					<div class="ui fluid large blue submit button">Login</div>
				</div>
				<div class="ui negative message" style="display:none">登入失敗</div>
			</form>
		</div>
</div>
</body>
<script type="text/javascript">

	var isLoginSuccess = "${isLoginSuccess}";

	if("false"===isLoginSuccess){
		$('#login .negative.message').show();
	} else{
		$('#login .negative.message').hide();
	}

	$('#login').form({
		inline:true,
		fields:{
			account: {
				identifier: 'account',
				rules: [
				{
					type   : 'empty',
					prompt : '請輸入帳號'
				}
				]
			},
			password: {
				identifier: 'password',
				rules: [
				{
					type   : 'empty',
					prompt : '請輸入密碼'
				}
				]
			}
		}
	});

	$('body .submit.button').click(function(){
		$('#login').form('submit');
	});
</script>
</html>