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
			<li><a href="#"><strong>新增课程申请</strong></a></li>
			<li><a href="#">新增</a></li>
			<li><a href="#">修改</a></li>
			<li><a href="#">删除</a></li>
			<li><a href="#">查询</a></li>
			<li><a href="#">导出</a></li>	
			<li><a href="#">提交</a></li>	
			<li class="pull-right"><form action="home.jsp"><input style="background-color:yellow; width:60px; height:40px" type="submit" value="返回"/></form></li>  	       
		</ul>
		<div class="table-responsive">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th class="text-center">课程中文名称</th>
						<th class="text-center">课程英文名称</th>
						<th class="text-center">课程简称</th>
						<th class="text-center">开设单位</th>
						<th class="text-center">学分</th>
						<th class="text-center">总学时</th>
						<th class="text-center">总学时备注</th>
					</tr>
				</thead>
				<tbody class="text-center">
					<tr>
						<td><input type="text" name="ch_name" /></td>
						<td><input type="text" name="en_name" /></td>
						<td><input type="text" name="s_name" /></td>
						<td><input type="text" name="place" /></td>
						<td><input type="text" name="score" /></td>
						<td><input type="text" name="t_time" /></td>
						<td><input type="text" name="t_time_desc" /></td>
						<!--
						<td>
							<select class="col-md-12">
								<option>公必</option>
								<option>专必</option>
								<option>公选</option>
								<option>专选</option>
							</select>
						</td>
						-->
					</tr>
				</tbody>
				<thead>
					<tr>
						<th class="text-center">课程类型</th>
						<th class="text-center">周学时</th>
						<th class="text-center">课程门类</th>
						<th class="text-center">课程简介</th>
						<th class="text-center">先修课程</th>
						<th class="text-center">课程负责人</th>
						<th class="text-center">是否学位课</th>
					</tr>
				</thead>
				<tbody class="text-center">
					<tr>
						<td><input type="text" name="type" /></td>
						<td><input type="text" name="w_time" /></td>
						<td><input type="text" name="category" /></td>
						<td><input type="text" name="introduce" /></td>
						<td><input type="text" name="prerequisite" /></td>
						<td><input type="text" name="manager" /></td>
						<td>
							<input type="radio" name="reexam" value="exam" />是<input type="radio" name="reexam" value="nexam" />否
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<p align="center">
			<button type="button" onclick="add()">添加</button>
			<button type="button" onclick="modify()">修改</button>
			<button type="button" onclick="Delete()">删除</button>
			<button type="button" onclick="findall()">查询</button>
			<button type="button" onclick="submit()">提交</button>
		</p>
		<div class="table-responsive">
			<table class="table table-hover table-bordered">
				<thead>
					<tr>
						<th class="text-center">审批状态</th>
						<th class="text-center">课程中文名称</th>
						<th class="text-center">课程英文名称</th>
						<th class="text-center">课程简称</th>
						<th class="text-center">开设单位</th>
						<th class="text-center">学分</th>
						<th class="text-center">总学时</th>
						<th class="text-center">总学时备注</th>
					</tr>
				</thead>
				<tbody class="text-center">
					<tr>
						<td>已通过</td>
						<td>课程中文名称1</td>
						<td>课程英文名称1</td>
						<td>课程简称1</td>
						<td>开设单位1</td>
						<td>学分1</td>
						<td>总学时1</td>
						<td>总学时备注1</td>
					</tr>
					<tr>
						<td>未通过</td>
						<td>课程中文名称2</td>
						<td>课程英文名称2</td>
						<td>课程简称2</td>
						<td>开设单位2</td>
						<td>学分2</td>
						<td>总学时2</td>
						<td>总学时备注2</td>
					</tr>
				</tbody>
				<thead>
					<tr>
						<th class="text-center">课程类型</th>
						<th class="text-center">周学时</th>
						<th class="text-center">课程门类</th>
						<th class="text-center">课程简介</th>
						<th class="text-center">先修课程</th>
						<th class="text-center">课程负责人</th>
						<th class="text-center">是否学位课</th>
					</tr>
				</thead>
				<tbody class="text-center">
					<tr>
						<td>课程类型1</td>
						<td>周学时1</td>
						<td>课程门类1</td>
						<td>课程简介1</td>
						<td>先修课程1</td>
						<td>课程负责人1</td>
						<td>是</td>
					</tr>
					<tr>
						<td>课程类型2</td>
						<td>周学时2</td>
						<td>课程门类2</td>
						<td>课程简介2</td>
						<td>先修课程2</td>
						<td>课程负责人2</td>
						<td>是</td>
					</tr>
				</tbody>
				<!--
				<thead>
					<tr>
						<th class="text-center">审批状态</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>已通过</td>
					</tr>
					<tr>
						<td>未通过</td>
					</tr>
				</tbody>
				-->
			</table>
		</div>
	</body>
</html>