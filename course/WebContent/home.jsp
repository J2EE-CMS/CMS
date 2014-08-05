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
		<!--
		<style>
	      	body {background-color:yellow;}
	    </style>
		-->
	</head>
	<body>
		<ul style="background-color:black" class="nav nav-tabs">
			<li><a href="#"><strong>课程管理</strong></a></li>
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">
				课程类别 <b class="caret"></b>
				</a>
				<ul class="dropdown-menu">
					<li><a href="type_manage">类别管理</a></li>
					<li><a href="detail_type">课程细类</a></li>
					<li><a href="detail_module">细类模块</a></li>
				</ul>
			</li>
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">培养类别 <b class="caret"></b>
				</a>
				<ul class="dropdown-menu">
					<li><a href="training_class">课程类别与培养类别对应</a></li>
				</ul>
			</li>
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">课程库 <b class="caret"></b>
				</a>
				<ul class="dropdown-menu">
					<li><a href="class_manage">课程库管理</a></li>
					<li><a href="class_apply">新增课程申请</a></li>
					<li><a href="class_check">新增课程审批</a></li>
				</ul>
			</li>
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">
				先修关系 <b class="caret"></b>
				</a>
				<ul class="dropdown-menu">
					<li><a href="relation_apply">先修关系申请</a></li>
					<li><a href="relation_check">先修关系审批</a></li>
				</ul>
			</li>
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">用户 <b class="caret"></b>
				</a>
				<ul class="dropdown-menu">
					<li><a href="user_manage">用户管理</a></li>
				</ul>
			</li>
			<li class="pull-right"><a href="login">退出</a></li> 
		</ul>
		<p align="center" style="margin:80px; font-size:24px">欢迎登录！</p>
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>
