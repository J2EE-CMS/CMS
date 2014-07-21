<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<!--禁止缩放，适合设备尺寸-->
		<meta name="viewport" content="width=device-width, 
									   initial-scle=1.0,
									   maximum-scale=1.0,
									   user-scalable=no">
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<style>
	      	body {background-color:yellow;}
	      	thead {background-color:green;}
	    </style>
	</head>
	<body>
		<ul style="background-color:black" class="nav nav-tabs">
			<li><a href="#"><strong>培养类别管理</strong></a></li>
			<li><a href="#">修改</a></li>
			<li><a href="#">查询</a></li>
			<li class="pull-right"><form action="home.jsp"><input style="background-color:yellow; width:60px; height:40px" type="submit" value="返回"/></form></li>       
		</ul>
		<div class="table-responsive">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th class="text-center">年级</th>
						<th class="text-center">培养类别</th>
						<th class="text-center">课程类别</th>
					</tr>
				</thead>
				<tbody class="text-center">
					<tr>
						<td><input type="text" name="grade" /></td>
						<td>
							<select class="col-md-12">
								<option>主修</option>
								<option>双专业</option>
								<option>双学位</option>
								<option>辅修</option>
							</select>
						</td>
						<td>
							<select class="col-md-12">
								<option>公必</option>
								<option>专必</option>
								<option>公选</option>
								<option>专选</option>
								<option>双选</option>
								<option>双必</option>
								<option>实践</option>
								<option>辅修</option>
								<option>任选</option>
								<option>必选</option>
							</select>
						</td>						
					</tr>
				</tbody>
			</table>
		</div>
		<div align="center">
			<button type="button" onclick="findall()">查询</button>
			<button type="button" onclick="modify()">修改</button>
		</div>
		<div class="table-responsive">
			<table class="table table-hover table-bordered">
				<thead>
					<tr>
						<th class="text-center">年级</th>
						<th class="text-center">培养类别</th>
						<th class="text-center">课程类别</th>
					</tr>
				</thead>
				<tbody class="text-center">
					<tr>
						<td>年纪1</td>
						<td>培养类别1</td>
						<td>课程类别1</td>
					</tr>
					<tr>
						<td>年纪2</td>
						<td>培养类别2</td>
						<td>课程类别2</td>
					</tr>
				</tbody>
			</table>
		</div>
	</body>
</html>