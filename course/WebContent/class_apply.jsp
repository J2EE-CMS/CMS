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
		
			function addCourseapply()
			{
				var myform=document.forms[0];
				myform.action="courseapply_addCourseapply";
				myform.method="post";
				myform.submit();
			}
			
			function modifyCourseapply()
			{
				var myform=document.forms[0];
				myform.action="courseapply_modifyCourseapply";
				myform.method="post";
				myform.submit();
			}
			
			function deleteCourseapply()
			{
				var myform=document.forms[0];
				myform.action="courseapply_deleteCourseapply";
				myform.method="post";
				myform.submit();
			}
			
			function queryCourseapply()
			{
				var myform=document.forms[0];
				myform.action="courseapply_queryCourseapply";
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
		<form id="courseaaplyform" >
			<div class="table-responsive">
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
						</tr>
					</thead>
	            	<tbody class="text-center">
						<tr>
							<td><input type="text" name="courseapply.institute_course_id"></td>
							<td><input type="text" name="courseapply.c_course_name"></td>
							<td><input type="text" name="courseapply.e_course_name"></td>
							<td><input type="text" name="courseapply.brief_course_name"/></td>
							<td><input type="text" name="courseapply.faculty"></td>
							<td><input type="text" name="courseapply.credit"></td>
							<td><input type="text" name="courseapply.sub_course_type_module"></td>
						</tr>
					</tbody>
					<thead>
						<tr>
							<th class="text-center">课程细类</th>
							<th class="text-center">课程类别</th>
							<th class="text-center">总学时</th>
							<th class="text-center">总学时描述</th>
							<th class="text-center">简介</th>
							<th class="text-center">课程负责人</th>
							<th class="text-center">是否学位课</th>
			            </tr>
	            	</thead>
					<tbody>
						<tr>
							<td><input type="text" name="courseapply.sub_course_type"></td>
							<td><input type="text" name="courseapply.course_type"/></td>
							<td><input type="text" name="courseapply.course_time"></td>
							<td><input type="text" name="courseapply.course_time_info"></td>
							<td><input type="text" name="courseapply.course_info"></td>
							<td><input type="text" name="courseapply.course_head"/></td>
							<td><input type="text" name="courseapply.degree"></td>
						</tr>
					</tbody>
				</table>
			</div>
			<input type="submit" name="courseapplyadd" value="添加" onclick="addCourseapply()" >
			<input type="submit" name="courseapplymodify" value="修改" onclick="modifyCourseapply()" >
			<input type="submit" name="courseapplydelete" value="删除" onclick="deleteCourseapply()" >
			<input type="submit" name="courseapplyquery" value="查询" onclick="queryCourseapply()" >
		</form>
		<!--  
		<div id="found" class="table-responsive">
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
					</tr>
	            </thead>
	            <tbody class="text-center">
		            <s:iterator value="courseapplys" var="courseapply">
		                <tr>
		                    <td><s:property value="#courseapply.institute_course_id"/></td>
		                    <td><s:property value="#courseapply.c_course_name"/></td>
		                    <td><s:property value="courseapply.e_course_name"/></td>
		                    <td><s:property value="#courseapply.brief_course_name"/></td>
		                    <td><s:property value="#ccourseapply.aculty"/></td>
		                    <td><s:property value="#courseapply.credit"/></td>
		                    <td><s:property value="#courseapply.sub_course_type_module"/></td>
		                </tr>
		        	</s:iterator>
				</tbody>
				<thead>
		            <tr>
						<th class="text-center">课程细类</th>
						<th class="text-center">课程类别</th>
						<th class="text-center">总学时</th>
						<th class="text-center">总学时描述</th>
						<th class="text-center">简介</th>
						<th class="text-center">课程负责人</th>
						<th class="text-center">是否学位课</th>
		            </tr>
	            </thead>
				<tbody class="text-center">
	            	<s:iterator value="courseapplys" var="courseapply">
	                	<tr>
		                    <td><s:property value="#courseapply.sub_course_type"/></td>
		                    <td><s:property value="#courseapply.course_type"/></td>
		                    <td><s:property value="#courseapply.course_time"/></td>
		                    <td><s:property value="#courseapply.course_time_info"/></td>
		                    <td><s:property value="#courseapply.course_info"/></td>
		                    <td><s:property value="#courseapply.course_head"/></td>
		                    <td><s:property value="#courseapply.degree"/></td>
		                </tr>
		            </s:iterator>
	            </tbody>
			</table>
		</div>
		-->
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
					</tr>
	            </thead>
	            <tbody class="text-center">
		            <s:iterator value="courseapplys" var="courseapply">
		                <tr>
		                    <td><s:property value="#courseapply.institute_course_id"/></td>
		                    <td><s:property value="#courseapply.c_course_name"/></td>
		                    <td><s:property value="courseapply.e_course_name"/></td>
		                    <td><s:property value="#courseapply.brief_course_name"/></td>
		                    <td><s:property value="#ccourseapply.aculty"/></td>
		                    <td><s:property value="#courseapply.credit"/></td>
		                    <td><s:property value="#courseapply.sub_course_type_module"/></td>
		                </tr>
		        	</s:iterator>
				</tbody>
				<thead>
		            <tr>
						<th class="text-center">课程细类</th>
						<th class="text-center">课程类别</th>
						<th class="text-center">总学时</th>
						<th class="text-center">总学时描述</th>
						<th class="text-center">简介</th>
						<th class="text-center">课程负责人</th>
						<th class="text-center">是否学位课</th>
		            </tr>
	            </thead>
				<tbody class="text-center">
	            	<s:iterator value="courseapplys" var="courseapply">
	                	<tr>
		                    <td><s:property value="#courseapply.sub_course_type"/></td>
		                    <td><s:property value="#courseapply.course_type"/></td>
		                    <td><s:property value="#courseapply.course_time"/></td>
		                    <td><s:property value="#courseapply.course_time_info"/></td>
		                    <td><s:property value="#courseapply.course_info"/></td>
		                    <td><s:property value="#courseapply.course_head"/></td>
		                    <td><s:property value="#courseapply.degree"/></td>
		                </tr>
		            </s:iterator>
	            </tbody>
			</table>
		</div>
	</body>
</html>