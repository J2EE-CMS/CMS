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
		<style>
	      	#bg{background-color:#8FB0D1;position:relative;}
	      	#win{filter:alpha(opacity=80);opacity:0.80;position:absolute;left:20%;top:30%;z-index:1002;margin:-100px -100px 0;border:4px #000 solid;background:#FFF;display:none;}
	      	#fade{-moz-opacity:0.50;filter:alpha(opacity=50);opacity:0.50;width:100%;height:100%;position:fixed;left:0%;top:0%;background-color:#f5f5f5;z-index:1001;display:none;}
	      	#bg thead{background-color:green;}
	      	#win thead{background-color:yellow;}
	      	select{width:120px}
	    </style>
	</head>
	<body>
	<div id="bg">
			<ul style="background-color:black" class="nav nav-tabs">
				<li><a href="#"><strong>新增课程申请</strong></a></li>
				<li><a href="javascript:void(0);" onclick="Winopen('ADD')">新增</a></li>
				<li><a href="javascript:void(0);" onclick="Winopen('MODIFY')">修改</a></li>
				<li><a href="javascript:void(0);" onclick="Winopen('QUERY')">查询</a></li>
				<li><a href="javascript:void(0);" onclick="OutputToExcel()">导出</a></li>
				<li><a href="javascript:void(0);" onclick="Winopen('DELETE')">删除</a></li>
				<li><a href="javascript:void(0);" onclick="Winopen('COMMIT')">提交</a></li>	
				<li class="pull-right"><a href="home">返回</a></li> 
			</ul>
			<table id="show" class="table table-hover table-bordered">
				<thead>
		            <tr>
		            	<th class="text-center">ID</th>
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
		            	<th class="text-center">状态</th>
					</tr>
	            </thead>
	            <tbody class="text-center">
		            <s:iterator value="courseapplys" var="courseapply">
		                <tr>
		                	<td><s:property value="#courseapply.id"/></td>
		                    <td><s:property value="#courseapply.c_course_name"/></td>
		                    <td><s:property value="#courseapply.institute_course"/></td>
		                    <td><s:property value="#courseapply.e_course_name"/></td>
		                    <td><s:property value="#courseapply.brief_course_name"/></td>
		                    <td><s:property value="#courseapply.faculty"/></td>
		                    <td><s:property value="#courseapply.credit"/></td>
		                    <td><s:property value="#courseapply.subtypemodule.id"/></td>
		                    <td><s:property value="#courseapply.subtype.id"/></td>
		                    <td><s:property value="#courseapply.coursetype.id"/></td>
		                    <td><s:property value="#courseapply.course_time"/></td>
		                    <td><s:property value="#courseapply.course_time_info"/></td>
		                    <td><s:property value="#courseapply.course_info"/></td>
		                    <td><s:property value="#courseapply.course_head"/></td>
		                    <td><s:property value="#courseapply.degree"/></td>
		                	<td><s:property value="#courseapply.status"/></td>
		                </tr>
		        	</s:iterator>
				</tbody>
			</table>
		</div>
		<div id="win" class="table-responsive">
			<form id="courseaaplyform" >
					<table id="cin" class="table table-bordered">
						<thead>
				            <tr>
				            	<th class="text-center">ID</th>
				                <th class="text-center">课程中文名</th>
				            	<th class="text-center">院系课程号</th>
								<th class="text-center">课程英文名</th>
								<th class="text-center">课程简称</th>
							</tr>
						</thead>
		            	<tbody class="text-center">
							<tr>
								<td><input id="caid" type="text" name="courseapply.id"></td>
								<td><input id="cacn" type="text" name="courseapply.c_course_name"></td>
								<td><input id="caic" type="text" name="courseapply.institute_course"></td>
								<td><input id="caen" type="text" name="courseapply.e_course_name"></td>
								<td><input id="cabn" type="text" name="courseapply.brief_course_name"/></td>
							</tr>
						</tbody>
						<thead>
				            <tr>
								<th class="text-center">开设单位</th>
								<th class="text-center">学分</th>						
								<th class="text-center">课程细类模块</th>
								<th class="text-center">课程细类</th>
								<th class="text-center">课程类别</th>
							</tr>
						</thead>
		            	<tbody class="text-center">
							<tr>
								<td><input id="caf" type="text" name="courseapply.faculty"></td>
								<td><input id="cac" type="text" name="courseapply.credit"></td>
								<td><input id="catm" type="text" name="courseapply.sub_course_type_module"></td>
								<td><input id="cast" type="text" name="courseapply.sub_course_type"></td>
								<td><input id="cact" type="text" name="courseapply.course_type"></td>
							</tr>
						</tbody>
						<thead>
							<tr>
								<th class="text-center">总学时</th>
								<th class="text-center">总学时描述</th>
								<th class="text-center">简介</th>
								<th class="text-center">课程负责人</th>
								<th class="text-center">是否学位课</th>
				            </tr>
		            	</thead>
						<tbody>
							<tr>
								<td><input type="text" name="courseapply.course_time"/></td>
								<td><input type="text" name="courseapply.course_time_info"></td>
								<td><input type="text" name="courseapply.course_info"></td>
								<td><input type="text" name="courseapply.course_head"></td>
								<td>
									<select name="courseapply.degree" class="form-control">
										<option value="学位课">学位课</option>
										<option value="非学位课">非学位课</option>
									</select>
								</td>
							</tr>
						</tbody>
					</table>
				<p align="center">
					<input type="submit" id="wincommit" name="wincommit" value="确认" />
					<input type="submit" name="wincancle" value="取消"/>
				</p>
				<p align="center" id="em" ></p>
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
					$(this).find("input").val(null);
				});
				$("#caid").focus();
				$("#caid:text").select();
				document.getElementById("wincommit").onclick=addCourseapply;
			}
			if(str=='MODIFY'){
				var cid = $("#caid").val();
				if(cid != ""){
					$("#caid").attr("readonly","true");
					$("#caic").focus();
					$("#caic:text").select();
				}	
				else{
					$("#caid").focus();
					$("#caid:text").select();
				}
				document.getElementById("wincommit").onclick=modifyCourseapply;
			}
			if(str=='QUERY'){
				document.getElementById("wincommit").onclick=queryCourseapply;
			}
	
			if(str=='DELETE'){
				var cid = $("#caid").val();
				if(cid != ""){
					$("#cin td").each(function(i){
						$(this).find("input").attr("readonly","true");
					});
				}
				else{
					$("#caid").focus();
					$("#caid:text").select();
				}
				document.getElementById("wincommit").onclick=deleteCourseapply;
			}

			if(str=='COMMIT'){
				var cid = $("#caid").val();
				if(cid != ""){
					$("#cin td").each(function(i){
						$(this).find("input").attr("readonly","true");
					});
				}
				else{
					$("#caid").focus()
					$("#caid:text").select();
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
		
		var EVal;
		function checkValidate(){
			$("#em").text("");
			/*
			if($.trim($("#caid").val())==""){
				EVal = "ID不能为空";
				$("#caid").focus();
				$("#caid:text").select();
				$("#em").text(EVal);
				$("#em").css("color","red");
				return false;
			}
			else{
				if(isNaN($("#caid").val())){
					EVal = "ID必须为数字";
					$("#caid").focus();
					$("#caid:text").select();
					$("#em").text(EVal);
					$("#em").css("color","red");
					return false;
				}
				if($("#caid").val()<=0){
					EVal = "ID必须大于0";
					$("#caid").focus();
					$("#caid:text").select();
					$("#em").text(EVal);
					$("#em").css("color","red");
					return false;
				}
			}
			*/
			if($.trim($("#caic").val())==""){
				EVal = "院系课程号不能为空";
				$("#caic").focus();
				$("#caic:text").select();
				$("#em").text(EVal);
				$("#em").css("color","red");
				return false;
			}
			else{
				if(isNaN($("#caic").val())){
					EVal = "院系课程号必须为数字";
					$("#caic").focus();
					$("#caic:text").select();
					$("#em").text(EVal);
					$("#em").css("color","red");
					return false;
				}
				if($("#caic").val()<=0){
					EVal = "院系课程号必须大于0";
					$("#caic").focus();
					$("#caic:text").select();
					$("#em").text(EVal);
					$("#em").css("color","red");
					return false;
				}
			}
			if($.trim($("#cac").val())==""){
				EVal = "学分不能为空";
				$("#cac").focus();
				$("#cac:text").select();
				$("#em").text(EVal);
				$("#em").css("color","red");
				return false;
			}
			else{
				if(isNaN($("#cac").val())){
					EVal = "学分必须为数字";
					$("#cac").focus();
					$("#cac:text").select();
					$("#em").text(EVal);
					$("#em").css("color","red");
					return false;
				}
				if($("#cac").val()<=0){
					EVal = "学分必须大于0";
					$("#cac").focus();
					$("#cac:text").select();
					$("#em").text(EVal);
					$("#em").css("color","red");
					return false;
				}
			}
		}
		
		function addCourseapply()
		{
			if(checkValidate()!=false){
				var myform=document.forms[0];
				myform.action="courseapply_addCourseapply";
				myform.method="post";
				myform.submit();
			}
			else{
				return false;
			}
		}
		
		function modifyCourseapply()
		{
			if(checkValidate()!=false){
				var myform=document.forms[0];
				myform.action="courseapply_modifyCourseapply";
				myform.method="post";
				myform.submit();
			}
			else{
				return false;
			}
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
		
		function modifycommitCourseapply()
		{
			var myform=document.forms[0];
			myform.action="courseapply_modifycommitCourseapply";
			myform.method="post";
			myform.submit();
		}
		
		function OutputToExcel()
		{
			var myform=document.forms[0];
			myform.action="courseapply_QueryCourseapplyOutputToExcel";
			myform.method="post";
			myform.submit();
		}
	</script>
</html>