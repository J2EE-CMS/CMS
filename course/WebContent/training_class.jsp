<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
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
        <script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script type="text/javascript">
		
			function addRelation()
			{
				var myform=document.forms[0];
				myform.action="relation_addRelation";
				myform.method="post";
				myform.submit();
			}
			
			function modifyRelation()
			{
				var myform=document.forms[0];
				myform.action="relation_modifyRelation";
				myform.method="post";
				myform.submit();
			}
			
			function deleteRelation()
			{
				var myform=document.forms[0];
				myform.action="relation_deleteRelation";
				myform.method="post";
				myform.submit();
			}
	
			function queryRelation()
			{
				var myform=document.forms[0];
				myform.action="relation_queryRelation";
				myform.method="post";
				myform.submit();
			}
		</script>
		
		<style>
	      	thead {background-color:green;}
		</style>
		
	</head>
	
	<body>
		<ul style="background-color:black" class="nav nav-tabs">
			<li><a href="#"><strong>培养类别管理</strong></a></li>
			<li><a href="#">修改</a></li>
			<li><a href="#">查询</a></li>
			<li class="pull-right"><a href="home">返回</a></li> 
		</ul>
		<form id="courseform" >
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
						<td><input type="text" name="relation.grade"></td>
						<td><input type="text" name="relation.devtype"></td>
						<td><input type="text" name="relation.type"></td>
					</tr>
				</tbody>
			</table>
			<input type="submit" name="relationadd" value="添加" onclick="addRelation()" >
			<input type="submit" name="relationmodify" value="修改" onclick="modifyRelation()" >
			<input type="submit" name="relationquery" value="修改" onclick="queryRelation()" >
		</form>
	    
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
					<s:iterator value="relations" var="relation">
		                <tr>
		                    <td><s:property value="#relation.grade"/></td>
		                    <td><s:property value="#relation.devtype"/></td>
		                    <td><s:property value="#relation.type"/></td>
		                </tr>
		        	</s:iterator>
				</tbody>
			</table>
		</div>
	</body>
</html>