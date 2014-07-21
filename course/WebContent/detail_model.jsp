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
			<li><a href="#"><strong>细类模块管理</strong></a></li>
			<li><a href="#">新增</a></li>
			<li><a href="#">修改</a></li>
			<li><a href="#">删除</a></li>
			<li><a href="#">查询</a></li>	
			<li class="pull-right"><form action="home.jsp"><input style="background-color:yellow; width:60px; height:40px" type="submit" value="返回"/></form></li>         
		</ul>
		<div class="table-responsive">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th class="text-center">课程类别细类码</th>
						<th class="text-center">课程类别细类名称</th>
						<th class="text-center">课程类别细类模块号</th>
						<th class="text-center">课程类别细类模块名称</th>
						<th class="text-center">版本号</th>
						<th class="text-center">所属课程类别</th>
						<th class="text-center">是否公共细类</th>
					</tr>
				</thead>
				<tbody class="text-center">
					<tr>
						<td><input type="text" name="code" style="width:100px"/></td>
						<td><input type="text" name="name" style="width:100px"/></td>
						<td><input type="text" name="model_number" style="width:100px"/></td>
						<td><input type="text" name="model_name" style="width:100px"/></td>
						<td><input type="text" name="version" style="width:100px"/></td>
						<td><input type="text" name="belong" style="width:100px"/></td>
						<td>
							<input type="radio" name="reexam" value="exam" />是<br>
							<input type="radio" name="reexam" value="nexam" />否
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<p align="center">
			<button type="button" onclick="add()">添加</button>
			<button type="button" onclick="findall()">查询</button>
			<button type="button" onclick="modify()">修改</button>
			<button type="button" onclick="delete()">删除</button>
			<input type="submit"/><a href="home.jsp">返回</a>
		</p>
		<div class="table-responsive">
			<table class="table table-hover table-bordered">
				<thead>
					<tr>
						<th class="text-center">课程类别细类码</th>
						<th class="text-center">课程类别细类名称</th>
						<th class="text-center">课程类别细类模块号</th>
						<th class="text-center">课程类别细类模块名称</th>
						<th class="text-center">版本号</th>
						<th class="text-center">所属课程类别</th>
						<th class="text-center">是否公共细类</th>
					</tr>
				</thead>
				<tbody class="text-center">
					<tr>
						<td>课程类别细类码1</td>
						<td>课程类别细类名称1</td>
						<td>课程类别细类模块号1</td>
						<td>课程类别细类模块名称1</td>
						<td>版本号1</td>
						<td>所属课程类别1</td>
						<td>是</td>
					</tr>
					<tr>
						<td>课程类别细类码2</td>
						<td>课程类别细类名称2</td>
						<td>课程类别细类模块号2</td>
						<td>课程类别细类模块名称2</td>
						<td>版本号2</td>
						<td>所属课程类别2</td>
						<td>否</td>
					</tr>
				</tbody>
			</table>
		</div>
	</body>
</html>