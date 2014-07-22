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
		
			function addCoursetype()
			{
				var myform=document.forms[0];
				myform.action="coursetype_addCoursetype";
				myform.method="post";
				myform.submit();
			}
			
			function modifyCoursetype()
			{
				var myform=document.forms[0];
				myform.action="coursetype_modifyCoursetype";
				myform.method="post";
				myform.submit();
			}
			
			function deleteCoursetype()
			{
				var myform=document.forms[0];
				myform.action="coursetype_deleteCoursetype";
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
			<li><a href="#"><strong>课程类别管理</strong></a></li>
			<li><a href="#">新增</a></li>
			<li><a href="#">修改</a></li>
			<li><a href="#">删除</a></li>
			<li><a href="#">导出</a></li>	
			<li class="pull-right"><form action="home.jsp"><input style="background-color:yellow; width:60px; height:40px" type="submit" value="返回"/></form></li>       
		</ul>
		<form id="coursetypeform" >
			<table class="table table-bordered">
				<thead>
					<tr>
						<th class="text-center">课程类别码</th>
						<th class="text-center">课程类别</th>
						<th class="text-center">课程性质</th>
						<th class="text-center">序号</th>
						<th class="text-center">是否需要重考</th>
						<th class="text-center">是否需要重修</th>
					</tr>
				</thead>
				<tbody class="text-center">
					<tr>
						<td><input type="text" name="coursetype.typecore" /></td>
						<td><input type="text" name="coursetype.type" /></td>
						<td><input type="text" name="coursetype.quality" /></td>
						<td><input type="text" name="coursetype.id" /></td>
						<td><input type="text" name="coursetype.reexamine" /></td>
						<td><input type="text" name="coursetype.retake" /></td>
						<!-- 
						<td>
							<select class="col-md-12">
								<option>公必</option>
								<option>专必</option>
								<option>公选</option>
								<option>专选</option>
							</select>
						</td>
						<td>
							<input type="radio" name="reexam" value="exam" />重考<br>
							<input type="radio" name="reexam" value="nexam" />不重考
						</td> 			
						<td>
							<input type="radio" name="relearn" value="learn" />重修<br>
							<input type="radio" name="relearn" value="nlearn" />不重修
						</td>
						-->		
					</tr>
				</tbody>
			</table>
		</form>
		<input type="submit" name="coursetypeadd" value="添加" onclick="addCoursetype()" >
		<input type="submit" name="coursetypemodify" value="修改" onclick="modifyCoursetype()" >
		<input type="submit" name="coursetypedelete" value="删除" onclick="deleteCoursetype()" >
		<div class="table-responsive">
			<table class="table table-hover table-bordered">
				<thead>
					<tr>
						<th class="text-center">课程类别码</th>
						<th class="text-center">课程类别</th>
						<th class="text-center">课程性质</th>
						<th class="text-center">序号</th>
						<th class="text-center">是否需要重考</th>
						<th class="text-center">是否需要重修</th>
					</tr>
				</thead>
				<tbody class="text-center">
					<s:iterator value="coursetypes" var="coursetype">
		                <tr>
		                    <td><s:property value="#coursetype.typecore"/></td>
		                    <td><s:property value="#coursetype.type"/></td>
		                    <td><s:property value="#coursetype.quality"/></td>
		                    <td><s:property value="#coursetype.id"/></td>
		                    <td><s:property value="#coursetype.reexamine"/></td>
		                    <td><s:property value="#coursetype.retake"/></td>
		                </tr>
		        	</s:iterator>
				</tbody>
			</table>
		</div>
	</body>
</html>