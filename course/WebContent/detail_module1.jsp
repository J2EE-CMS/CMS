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
		
			function addSubtypemodule()
			{
				var myform=document.forms[0];
				myform.action="subtypemodule_addSubtypemodule";
				myform.method="post";
				myform.submit();
			}
			
			function modifySubtypemodule()
			{
				var myform=document.forms[0];
				myform.action="subtypemodule_modifySubtypemodule";
				myform.method="post";
				myform.submit();
			}
			
			function deleteSubtypemodule()
			{
				var myform=document.forms[0];
				myform.action="subtypemodule_deleteSubtypemodule";
				myform.method="post";
				myform.submit();
			}
	
			function querySubtypemodule()
			{
				var myform=document.forms[0];
				myform.action="subtypemodule_querySubtypemodule";
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
			<li><a href="#"><strong>细类模块管理</strong></a></li>
			<li><a href="#">新增</a></li>
			<li><a href="#">修改</a></li>
			<li><a href="#">删除</a></li>
			<li><a href="#">查询</a></li>	
			<li class="pull-right"><a href="home">返回</a></li> 
		</ul>
		<form id="subtypemoduleform" >
			<table class="table table-bordered">
				<thead>
					<tr>
						<th class="text-center">课程类别细类模块号</th>
						<th class="text-center">课程类别细类模块名称</th>
						<th class="text-center">课程类别细类码</th>
						<th class="text-center">课程类别细类名称</th>
						<th class="text-center">版本号</th>
						<th class="text-center">所属课程类别</th>
						<th class="text-center">是否公共细类</th>
					</tr>
				</thead>
				<tbody class="text-center">
					<tr>
						<td><input type="text" name="subtypemodule.id" style="width:100px"/></td>
						<td><input type="text" name="subtypemodule.module_name" style="width:100px"/></td>
						<td><input type="text" name="subtypemodule.subtype_code" style="width:100px"/></td>
						<td><input type="text" name="subtypemodule.subtype_name" style="width:100px"/></td>
						<td><input type="text" name="subtypemodule.course_type" style="width:100px"/></td>
						<td><input type="text" name="subtypemodule.version" style="width:100px"/></td>
						<td><input type="text" name="subtypemodule.public_subtype" style="width:100px"/></td>
						<!-- 
						<td>
							<input type="radio" name="reexam" value="exam" />是<br>
							<input type="radio" name="reexam" value="nexam" />否
						</td> 
						-->
					</tr>
				</tbody>
			</table>
		
			<input type="submit" name="subtypemoduleadd" value="添加" onclick="addSubtypemodule()" >
			<input type="submit" name="subtypemodulemodify" value="修改" onclick="modifySubtypemodule()" >
			<input type="submit" name="subtypemoduledelete" value="删除" onclick="deleteSubtypemodule()" >
		</form>
		<div class="table-responsive">
			<table class="table table-hover table-bordered">
				<thead>
					<tr>
						<th class="text-center">课程类别细类模块号</th>
						<th class="text-center">课程类别细类模块名称</th>
						<th class="text-center">课程类别细类码</th>
						<th class="text-center">课程类别细类名称</th>
						<th class="text-center">版本号</th>
						<th class="text-center">所属课程类别</th>
						<th class="text-center">是否公共细类</th>
					</tr>
				</thead>
				<tbody class="text-center">
					<s:iterator value="allsubtypemodules" var="subtypemodule">
		                <tr>
		                    <td><s:property value="#subtypemodule.id"/></td>
		                    <td><s:property value="#subtypemodule.module_name"/></td>
		                    <td><s:property value="#subtypemodule.subtype_code"/></td>
		                    <td><s:property value="#subtypemodule.subtype_name"/></td>
		                    <td><s:property value="#subtypemodule.course_type"/></td>
		                    <td><s:property value="#subtypemodule.version"/></td>
		                    <td><s:property value="#subtypemodule.public_subtype"/></td>
		                </tr>
		        	</s:iterator>
				</tbody>
			</table>
		</div>
	</body>
</html>