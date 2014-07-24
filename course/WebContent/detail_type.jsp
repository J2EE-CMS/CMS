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
		<script type="text/javascript">
		
			function addSubtype()
			{
				var myform=document.forms[0];
				myform.action="subtype_addSubtype";
				myform.method="post";
				myform.submit();
			}
			
			function modifySubtype()
			{
				var myform=document.forms[0];
				myform.action="subtype_modifySubtype";
				myform.method="post";
				myform.submit();
			}
			
			function deleteSubtype()
			{
				var myform=document.forms[0];
				myform.action="subtype_deleteSubtype";
				myform.method="post";
				myform.submit();
			}
	
			function querySubtypes()
			{
				var myform=document.forms[0];
				myform.action="subtype_querySubtypes";
				myform.method="post";
				myform.submit();
			}
		</script>
		<style>
	      	body {background-color:yellow;}
	      	thead {background-color:green;}
	    </style>
	</head>
	<body>
		<ul style="background-color:black" class="nav nav-tabs">
			<li><a href="#"><strong>课程细类管理</strong></a></li>
			<li><a href="#">新增</a></li>
			<li><a href="#">修改</a></li>
			<li><a href="#">删除</a></li>
			<li><a href="#">查询</a></li>	
			<li class="pull-right"><a href="home">返回</a></li> 
		</ul>
		<form id="subtypeform" >
			<table class="table table-bordered">
				<thead>
					<tr>
						<th class="text-center">课程类别细类码</th>
						<th class="text-center">课程类别细类名称</th>
						<th class="text-center">所属课程类别</th>
						<th class="text-center">序号</th>
						<th class="text-center" >是否公共细类</th>
						<th class="text-center">设立单位</th>
					</tr>
				</thead>
				<tbody class="text-center">
					<tr>
						<!-- 
						<td>
							<select style="width:80px">
								<option>公必</option>
								<option>专必</option>
								<option>公选</option>
								<option>专选</option>
							</select>
						</td> 
						<td>
							<input type="radio" name="reexam" value="exam" />是<br>
							<input type="radio" name="reexam" value="nexam" />否
						</td> 
						-->
						<td><input type="text" name="subtype.subtypecode" style="width:100px"/></td>
						<td><input type="text" name="subtype.subtypename" style="width:100px"/></td>
						<td><input type="text" name="subtype.belongtotype" /></td>
						<td><input type="text" name="subtype.id" style="width:100px"/></td>
						<td><input type="text" name="subtype.ispublicsubtype" style="width:100px"/></td>
						<td><input type="text" name="subtype.department" style="width:100px"/></td>
						
					</tr>
				</tbody>
			</table>
		</form>
		<input type="submit" name="subtypeadd" value="添加" onclick="addSubtype()" >
		<input type="submit" name="subtypemodify" value="修改" onclick="modifySubtype()" >
		<input type="submit" name="subtypedelete" value="删除" onclick="deleteSubtype()" >
		<input type="submit" name="subtypequery" value="查询" onclick="querySubtypes()" >
		
		
		<div class="table-responsive">
			<table class="table table-hover table-bordered">
				<thead>
					<tr>
						<th class="text-center">课程类别细类码</th>
						<th class="text-center">课程类别细类名称</th>
						<th class="text-center">所属课程类别</th>
						<th class="text-center">序号</th>
						<th class="text-center" >是否公共细类</th>
						<th class="text-center">设立单位</th>
					</tr>
				</thead>
				<tbody class="text-center">
					<s:iterator value="subtypeList" var="subtype">
		                <tr>
		                    <td><s:property value="#subtype.subtypecode"/></td>
		                    <td><s:property value="#subtype.subtypename"/></td>
		                    <td><s:property value="#subtype.belongtotype"/></td>
		                    <td><s:property value="#subtype.id"/></td>
		                    <td><s:property value="#subtype.ispublicsubtype"/></td>
		                    <td><s:property value="#subtype.department"/></td>
		                </tr>
		        	</s:iterator>
				</tbody>
			</table>
		</div>
		
		
	</body>
</html>