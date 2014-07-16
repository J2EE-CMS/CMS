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
		
			function addCourse()
			{
				var myform=document.forms[0];
				myform.action="course_addCourse";
				myform.method="post";
				myform.submit();
			}
			
			function modifyCourse()
			{
				var myform=document.forms[0];
				myform.action="course_modifyCourse";
				myform.method="post";
				myform.submit();
			}
			
			function deleteCourse()
			{
				var myform=document.forms[0];
				myform.action="course_deleteCourse";
				myform.method="post";
				myform.submit();
			}
	
			function findCourse()
			{
				var myform=document.forms[0];
				myform.action="course_findCourse";
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
			<li><a href="#"><strong>课程库管理</strong></a></li>
			<li><a href="#">新增</a></li>
			<li><a href="#">修改</a></li>
			<li><a href="#">删除</a></li>
			<li><a href="#">查询</a></li>
			<li><a href="#">导出</a></li>		       
		</ul>
		<form id="courseform" >
			<table class="table table-bordered">
				<thead>
		            <tr>
		                <th class="text-center">课程名称</th>
						<th class="text-center">开设单位</th>
						<th class="text-center">总学时</th>
						<th class="text-center">是否学位课</th>
		            </tr>
            	</thead>
            	<tbody class="text-center">
					<tr>
						<td><input type="text" name="course.name"></td>
						<td><input type="text" name="course.place"></td>
						<td><input type="text" name="course.time"></td>
						<td><input type="text" name="course.isDegree"/></td>
					</tr>
				</tbody>
			</table>
			<input type="submit" name="courseadd" value="添加" onclick="addCourse()" >
			<input type="submit" name="coursemodify" value="修改" onclick="modifyCourse()" >
			<input type="submit" name="coursedelete" value="删除" onclick="deleteCourse()" >
			<input type="submit" name="coursefind" value="查询" onclick="findCourse()" >
		</form>
		<table  class="table table-hover table-bordered">
			<thead>
	            <tr>
	                <th class="text-center">课程名称</th>
					<th class="text-center">开设单位</th>
					<th class="text-center">总学时</th>
					<th class="text-center">是否学位课</th>
	            </tr>
            </thead>
            <tbody class="text-center">
	            <s:iterator value="foundCourse" var="course">
		                <tr>
		                    <td><s:property value="#course.name"/></td>
		                    <td><s:property value="#course.place"/></td>
		                    <td><s:property value="#course.time"/></td>
		                    <td><s:property value="#course.isDegree"/></td>
		                </tr>
		            </s:iterator>
			</tbody>
	    </table>	
	    
		<form action="showallcourse" method="post" >
			<input type="submit" value="show">
		</form>
		<div class="table-responsive">
			<table class="table table-hover table-bordered">
	            <thead>
		            <tr>
		                <th class="text-center">课程名称</th>
						<th class="text-center">开设单位</th>
						<th class="text-center">总学时</th>
						<th class="text-center">是否学位课</th>
		            </tr>
	            </thead>
	            <tbody class="text-center">
		            <s:iterator value="allCourse" var="course">
		                <tr>
		                    <td><s:property value="#course.name"/></td>
		                    <td><s:property value="#course.place"/></td>
		                    <td><s:property value="#course.time"/></td>
		                    <td><s:property value="#course.isDegree"/></td>
		                </tr>
		            </s:iterator>
	            </tbody>
	        </table>	
	    </div>
	</body>
</html>
