<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html >
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<!--禁止缩放，适合设备尺寸-->
		<meta name="viewport" content="width=device-width, 
									   initial-scle=1.0,
									   maximum-scale=1.0,
									   user-scalable=no">
		<link href="css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
	<div class="container">
			<div class="row ">
				<div class="center-block">
					<form action="login" method="post" style="margin:80px" class="form-horizontal" role="form">
						<div class="form-group">
							 <label for="inputUserName3" class="col-sm-offset-2 col-sm-2 control-label">用户名：</label>
							<div class="col-sm-4">
								<input type="text" name="user.name" class="form-control" id="inputUserName3">
							</div>
						</div>
						<div class="form-group">
							 <label for="inputPassword3" class="col-sm-offset-2 col-sm-2 control-label">密码：</label>
							<div class="col-sm-4">
								<input type="password" name="user.password" class="form-control" id="inputPassword3">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-4 col-sm-10">
								<div class="checkbox">
									 <label><input type="checkbox"> 记住我</label>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-4 col-sm-10">
								 <button type="submit" class="btn btn-default">登录</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>