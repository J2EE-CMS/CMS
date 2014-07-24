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
			th {width:50px;}
			input {width:120px;}
			td {width:50px;}
		</style>
	</head>
	<body>
		<ul style="background-color:black" class="nav nav-tabs">
			<li><a href="#"><strong>新增课程管理审批</strong></a></li>
			<li><a href="#">查询</a></li>
			<li><a href="#">审批</a></li>
			<li><a href="#">导出</a></li>	
			<li class="pull-right"><a href="home">返回</a></li> 
		</ul>
		<div class="table-responsive">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th class="text-center">总课程号</th>
						<th class="text-center">院系课程号</th>
						<th class="text-center">课程中文名</th>
						<th class="text-center">课程英文名</th>
						<th class="text-center">原开设单位</th>
						<th class="text-center">先修课程</th>
					</tr>
				</thead>
				<tbody class="text-center">
					<tr>
						<td><input type="text" name="c_number" style="width:100px"/></td>
						<td><input type="text" name="s_number" style="width:100px"/></td>
						<td><input type="text" name="ch_name" style="width:120px"/></td>
						<td><input type="text" name="en_name" style="width:100px"/></td>
						<td><input type="text" name="place" style="width:100px"/></td>
						<td><input type="text" name="prerequisite" /></td>
					</tr>
				</tbody>
			</table>
		</div>
		<p align="center">
			<button type="button" onclick="findall()">查询</button>
			<button type="button" onclick="modify()">审批</button>
			<button type="button" onclick="delete()">导出</button>
		</p>
		<div class="table-responsive">
			<table class="table table-hover table-bordered">
				<thead>
					<tr>
						<th class="text-center">审批状态</th>
						<th class="text-center">总课程号</th>
						<th class="text-center">院系课程号</th>
						<th class="text-center">课程中文名</th>
						<th class="text-center">课程英文名</th>
						<th class="text-center">原开设单位</th>
						<th class="text-center">先修课程</th>
					</tr>
				</thead>
				<tbody class="text-center">
					<tr>
						<td>已通过</td>
						<td>总课程号1</td>
						<td>院系课程号1</td>
						<td>课程中文名1</td>
						<td>课程英文名1</td>
						<td>原开设单位1</td>
						<td>先修课程1</td>
					</tr>
					<tr>
						<td>未通过</td>
						<td>总课程号2</td>
						<td>院系课程号2</td>
						<td>课程中文名2</td>
						<td>课程英文名2</td>
						<td>原开设单位2</td>
						<td>先修课程2</td>
					</tr>
				</tbody>
			</table>
		</div>
	</body>
</html>