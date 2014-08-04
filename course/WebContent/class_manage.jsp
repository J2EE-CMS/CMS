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
		
		<style>
	      	#bg{background-color:#8FB0D1;position:relative;}
	      	#win{filter:alpha(opacity=80);opacity:0.80;position:absolute;left:20%;top:30%;z-index:1002;margin:-100px -100px 0;border:4px #000 solid;background:#FFF;display:none;}
	      	#fade{-moz-opacity:0.50;filter:alpha(opacity=50);opacity:0.50;width:100%;height:100%;position:fixed;left:0%;top:0%;background-color:#f5f5f5;z-index:1001;display:none;}
	      	#bg thead{background-color:green;}
	      	#win thead{background-color:yellow;}
		</style>
		
	</head>
	
	<body>
		<div id="bg">
			<ul style="background-color:black" class="nav nav-tabs">
				<li><a href="#"><strong>课程库管理</strong></a></li>
				<li><a href="javascript:void(0);" onclick="Winopen('ADD')">新增</a></li>
				<li><a href="javascript:void(0);" onclick="Winopen('MODIFY')">修改</a></li>
				<li><a href="javascript:void(0);" onclick="Winopen('QUERY')">查询</a></li>
				<li><a href="javascript:void(0);" onclick="Winopen('DELETE')">删除</a></li>
				<li><a href="javascript:void(0);" onclick="OutputToExcel()">导出</a></li>
				<li class="pull-right"><a href="home">返回</a></li> 	       
			</ul>
			<table id="show" class="table table-hover table-bordered">
	            <thead>
		            <tr>
		            	<th class="text-center">序号</th>
		                <th class="text-center">课程中文名</th>
		            	<th class="text-center">院系课程号</th>
						<th class="text-center">课程英文名</th>
						<th class="text-center">课程简称</th>
						<th class="text-center">开设单位</th>
						<th class="text-center">学分</th>						
						<th class="text-center">课程细类模块</th>
						<th class="text-center">课程细类</th>
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
		                	<td><s:property value="#cos.id"/></td>
		                    <td><s:property value="#cos.c_course_name"/></td>
		                    <td><s:property value="#cos.institute_course"/></td>
		                    <td><s:property value="#cos.e_course_name"/></td>
		                    <td><s:property value="#cos.brief_course_name"/></td>
		                    <td><s:property value="#cos.faculty"/></td>
		                    <td><s:property value="#cos.credit"/></td>
		                    <td><s:property value="#cos.subtypemodule.id"/></td>
		                    <td><s:property value="#cos.subtype.id"/></td>
		                    <td><s:property value="#cos.coursetype.id"/></td>
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
		<div id="win">
			<form id="courseform" >
				<table id="cin" class="table table-bordered">
					<thead>
			            <tr>
			            	<th class="text-center">序号</th>
			                <th class="text-center">课程中文名</th>
			            	<th class="text-center">院系课程号</th>
							<th class="text-center">课程英文名</th>
							<th class="text-center">课程简称</th>
							<th class="text-center">开设单位</th>
						</tr>
					</thead>
	            	<tbody class="text-center">
						<tr>
							<td><input id="pk" type="text" name="cos.id"></td>
							<td><input type="text" name="cos.c_course_name"></td>
							<td><input id="ic" type="text" name="cos.institute_course"></td>
							<td><input type="text" name="cos.e_course_name"></td>
							<td><input type="text" name="cos.brief_course_name"/></td>
							<td><input type="text" name="cos.faculty"></td>
						</tr>
					</tbody>
					<thead>
			            <tr>
							<th class="text-center">学分</th>						
							<th class="text-center">课程细类模块</th>
							<th class="text-center">课程细类</th>
							<th class="text-center">课程类别</th>
							<th class="text-center">总学时</th>
						</tr>
					</thead>
	            	<tbody class="text-center">
						<tr>
							<td><input type="text" name="cos.credit"></td>
							<td><input type="text" name="cos.sub_course_type_module"></td>
							<td><input type="text" name="cos.sub_course_type"></td>
							<td><input type="text" name="cos.course_type"/></td>
							<td><input type="text" name="cos.course_time"></td>
						</tr>
					</tbody>
					<thead>
						<tr>
							<th class="text-center">总学时描述</th>
							<th class="text-center">简介</th>
							<th class="text-center">课程负责人</th>
							<th class="text-center">是否学位课</th>
							<th class="text-center">备注</th>
			            </tr>
	            	</thead>
					<tbody>
						<tr>
							<td><input type="text" name="cos.course_time_info"></td>
							<td><input type="text" name="cos.course_info"></td>
							<td><input type="text" name="cos.course_head"/></td>
							<td><input type="text" name="cos.degree"></td>
							<td><input type="text" name="cos.info"></td>
						</tr>
					</tbody>
				</table>
				<p align="center">
					<input type="submit" id="wincommit" name="wincommit" value="确认" />
					<input type="submit" name="wincancle" value="取消"/>
				</p>
			</form>
	    </div>
		<div id="fade"></div>
	</body>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript">
		var preId;
		
		$(document).ready(function(){
			$("#show tr:gt(0)").click(function(){
				//this是html对象，$(this)是jquery对象
				mychange(this);
				//this.hidden = "hidden";
				var line = [];
				$(this).children("td").each(function(i){
					var c = $(this).text();
					line.push(c);
				});
				$("#cin td").each(function(i){
					$(this).find("input").val(line[i]);
				});
			});
	
			
		});
		
		function mychange(nId){
			if(preId){
				$(preId).css("background-color","#8FB0D1");
			}
			if(nId){
				if(nId==preId){
					preId = null;
					return ;
				}
				$(nId).css("background-color","yellow");
				preId = nId;
			}		
		}
		function Winopen(str)
		{
			//var win=new WinSize();
			var Tip=document.getElementById("fade");
			//Tip.style.width=win.W+"px";
			//Tip.style.height=win.H+"px";
			Tip.style.display="block";
			document.getElementById("win").style.display="block";
			if(str=='ADD'){
				$("#cin td").each(function(i){
					$(this).find("input").val("");
				});
				$("#pk").focus();
				document.getElementById("wincommit").onclick=addCourse;
			}
			if(str=='MODIFY'){
				var cid = $("#pk").val();
				if(cid != ""){
					$("#pk").attr("readonly","true");
					$("#ic").focus();
				}	
				else{
					$("#pk").focus();
				}
				document.getElementById("wincommit").onclick=modifyCourse;
			}
			if(str=='QUERY'){
				document.getElementById("wincommit").onclick=queryCourse;
			}
	
			if(str=='DELETE'){
				var cid = $("#pk").val();
				if(cid != ""){
					$("#cin td").each(function(i){
						$(this).find("input").attr("readonly","true");
					});
				}
				else{
					$("#pk").focus();
				}
				document.getElementById("wincommit").onclick=deleteCourse;
			}
			
			if(str=='COMMIT'){
				var cid = $("#pk").val();
				if(cid != ""){
					$("#cin td").each(function(i){
						$(this).find("input").attr("readonly","true");
					});
				}
				else{
					$("#pk").focus();
				}
				document.getElementById("wincommit").onclick=modifycommitCourseapply;
			}
		}
	
		function WinSize() //函数：获取尺寸
		{
			var winWidth = 0;
			var winHeight = 0;
			if (window.innerWidth)
				winWidth = window.innerWidth;
			else if ((document.body) && (document.body.clientWidth))
				winWidth = document.body.clientWidth;
			if (window.innerHeight)
				winHeight = window.innerHeight;
			else if ((document.body) && (document.body.clientHeight))
				winHeight = document.body.clientHeight;
			if (document.documentElement  && document.documentElement.clientHeight
				&& document.documentElement.clientWidth)
			{
				winHeight = document.documentElement.clientHeight;
				winWidth = document.documentElement.clientWidth;
			}
			return{"W":winWidth,"H":winHeight}
		}
	
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
			myform.action="course_queryCourse";
			myform.method="post";
			myform.submit();
		}
		function OutputToExcel()
		{
			var myform=document.forms[0];
			myform.action="course_QueryCourseapplyOutputToExcel";
			myform.method="post";
			myform.submit();
		}
	</script>
</html>
