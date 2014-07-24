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
		
			function addPreCourse()
			{
				var myform=document.forms[0];
				myform.action="precourse_addPreCourse";
				myform.method="post";
				myform.submit();
			}
			
			function modifyPreCourse()
			{
				var myform=document.forms[0];
				myform.action="precourse_modifyPreCourse";
				myform.method="post";
				myform.submit();
			}
			
			function deletePreCourse()
			{
				var myform=document.forms[0];
				myform.action="precourse_deletePreCourse";
				myform.method="post";
				myform.submit();
			}
	
			function queryPreCourse()
			{
				var myform=document.forms[0];
				myform.action="precourse_queryPreCourse";
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
			<li><a href="#"><strong>新增课程申请</strong></a></li>
			<li><a href="#">新增</a></li>
			<li><a href="#">修改</a></li>
			<li><a href="#">删除</a></li>
			<li><a href="#">查询</a></li>
			<li><a href="#">导出</a></li>	
			<li><a href="#">提交</a></li>	
			<li class="pull-right"><a href="home">返回</a></li> 
		</ul>
		<form id="courseform" >
			<table class="table table-bordered">
				<thead>
		            <tr>
		            	<th class="text-center">课程号</th>
						<th class="text-center">关系</th>
						<th class="text-center">运算符</th>
					</tr>
				</thead>
            	<tbody class="text-center">
					<tr>
						<td><input type="text" name="course"></td>
						<td><input type="text" name="relationString"></td>
						<td><input type="text" name="op"></td>
					</tr>
				</tbody>
			</table>
			<input type="submit" name="precourseadd" value="添加" onclick="addPreCourse()" >
			<input type="submit" name="precoursemodify" value="修改" onclick="modifyPreCourse()" >
			<input type="submit" name="precoursedelete" value="删除" onclick="deletePreCourse()" >
			<input type="submit" name="precoursequery" value="查询" onclick="queryPreCourse()" >
		</form>
	    <div class="table-responsive">
			<table class="table table-hover table-bordered">
				<thead>
					<tr>
						<th class="text-center">课程号</th>
						<th class="text-center">先修关系</th>
					</tr>
				</thead>
				<tbody class="text-center">
					<s:iterator value="" var="">
		                <tr>
		                    <td><s:property value=""/></td>
		                    <td><s:property value=""/></td>
		                </tr>
		        	</s:iterator>
				</tbody>
			</table>
		</div>
	</body>
</html>