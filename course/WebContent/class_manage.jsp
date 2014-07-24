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
	
			function queryCourse()
			{
				var myform=document.forms[0];
				myform.action="course/course_queryCourse";
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
			<li class="pull-right"><a href="home">返回</a></li> 	       
		</ul>
		<form id="courseform" >
			<table class="table table-bordered">
				<thead>
		            <tr>
		            	<th class="text-center">院系课程号</th>
		                <th class="text-center">课程中文名</th>
						<th class="text-center">课程英文名</th>
						<th class="text-center">课程简称</th>
						<th class="text-center">开设单位</th>
						<th class="text-center">学分</th>						
						<th class="text-center">课程细类模块</th>
						<th class="text-center">课程细类</th>
					</tr>
				</thead>
            	<tbody class="text-center">
					<tr>
						<td><input type="text" name="cos.institute_course"></td>
						<td><input type="text" name="cos.c_course_name"></td>
						<td><input type="text" name="cos.e_course_name"></td>
						<td><input type="text" name="cos.brief_course_name"/></td>
						<td><input type="text" name="cos.faculty"></td>
						<td><input type="text" name="cos.credit"></td>
						<td><input type="text" name="cos.sub_course_type_module"></td>
						<td><input type="text" name="cos.sub_course_type"></td>
					</tr>
				</tbody>
				<thead>
					<tr>
						<th class="text-center">课程类别</th>
						<th class="text-center">总学时</th>
						<th class="text-center">总学时描述</th>
						<th class="text-center">简介</th>
						<th class="text-center">课程负责人</th>
						<th class="text-center">是否学位课</th>
						<th class="text-center">备注</th>
		            </tr>
            	</thead>
				<tbody>
					<tr>
						<td><input type="text" name="cos.course_type"/></td>
						<td><input type="text" name="cos.course_time"></td>
						<td><input type="text" name="cos.course_time_info"></td>
						<td><input type="text" name="cos.course_info"></td>
						<td><input type="text" name="cos.course_head"/></td>
						<td><input type="text" name="cos.degree"></td>
						<td><input type="text" name="cos.info"></td>
					</tr>
				</tbody>
			</table>
			<input type="submit" name="courseadd" value="添加" onclick="addCourse()" >
			<input type="submit" name="coursemodify" value="修改" onclick="modifyCourse()" >
			<input type="submit" name="coursedelete" value="删除" onclick="deleteCourse()" >
			<input type="submit" name="coursequery" value="查询" onclick="queryCourse()" >
		</form>
	    
		<div class="table-responsive">
			<table class="table table-hover table-bordered">
	            <thead>
		            <tr>
		            	<th class="text-center">院系课程号</th>
		                <th class="text-center">课程中文名</th>
						<th class="text-center">课程英文名</th>
						<th class="text-center">课程简称</th>
						<th class="text-center">开设单位</th>
						<th class="text-center">学分</th>						
						<th class="text-center">课程细类模块</th>
						<th class="text-center">课程细类</th>
					</tr>
	            </thead>
	            <tbody class="text-center">
		            <s:iterator value="allCourse" var="cos">
		                <tr>
		                    <td><s:property value="#cos.institute_course"/></td>
		                    <td><s:property value="#cos.c_course_name"/></td>
		                    <td><s:property value="#cos.e_course_name"/></td>
		                    <td><s:property value="#cos.brief_course_name"/></td>
		                    <td><s:property value="#cos.faculty"/></td>
		                    <td><s:property value="#cos.credit"/></td>
		                    <td><s:property value="#cos.sub_course_type_module"/></td>
		                    <td><s:property value="#cos.sub_course_type"/></td>
		                </tr>
		        	</s:iterator>
				</tbody>
				<thead>
		            <tr>
						<th class="text-center">课程类别</th>
						<th class="text-center">总学时</th>
						<th class="text-center">总学时描述</th>
						<th class="text-center">简介</th>
						<th class="text-center">课程负责人</th>
						<th class="text-center">是否学位课</th>
						<th class="text-center">备注</th>
		            </tr>
	            </thead>
				<tbody class="text-center">
	            	<s:iterator value="allCourse" var="cos">
	                	<tr>
		                    <td><s:property value="#cos.course_type"/></td>
		                    <td><s:property value="#cos.course_time"/></td>
		                    <td><s:property value="#cos.course_time_info"/></td>
		                    <td><s:property value="#cos.course_info"/></td>
		                    <td><s:property value="#cos.course_head"/></td>
		                    <td><s:property value="#cos.degree"/></td>
		                    <td><s:property value="#cos.info"/></td>
		                </tr>
		            </s:iterator>
	            </tbody>
	        </table>	
	    </div>
	</body>
</html>
