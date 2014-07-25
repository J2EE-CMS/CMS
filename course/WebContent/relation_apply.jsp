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
	      	#win{filter:alpha(opacity=80);opacity:0.80;position:absolute;left:20%;top:50%;z-index:1002;margin:-100px -100px 0;border:4px #000 solid;background:#FFF;display:none;}
	      	#fade{-moz-opacity:0.50;filter:alpha(opacity=50);opacity:0.50;width:100%;height:100%;position:fixed;left:0%;top:0%;background-color:#f5f5f5;z-index:1001;display:none;}
	      	#bg thead{background-color:green;}
	      	#win thead{background-color:yellow;}
		</style>
		
	</head>
	
	<body>
		<div id="bg">
			<ul style="background-color:black" class="nav nav-tabs">
				<li><a href="#"><strong>新增课程申请</strong></a></li>
				<li><a href="javascript:void(0);" onclick="Winopen('ADD')">新增</a></li>
				<li><a href="javascript:void(0);" onclick="Winopen('MODIFY')">修改</a></li>
				<li><a href="javascript:void(0);" onclick="Winopen('QUERY')">修改</a></li>
				<li><a href="javascript:void(0);" onclick="Winopen('DELETE')">删除</a></li>
				<li><a href="#">导出</a></li>	
				<li><a href="#">提交</a></li>	
				<li class="pull-right"><a href="home">返回</a></li> 
			</ul>
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
	    <div id="win">
			<form id="precourseform" >
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
		var $=function(id)
		{
			return document.getElementById(id);
		}
	
		function Winopen(str)
		{
			var win=new WinSize();
			var Tip=$("fade");
			Tip.style.width=win.W+"px";
			Tip.style.height=win.H+"px";
			$("fade").style.display="block";
			$("win").style.display="block";
			if(str=='ADD'){
				$("wincommit").onclick=addRelation;
			}
			if(str=='MODIFY'){
				$("wincommit").onclick=modifyRelation;
			}
			if(str=='QUERY'){
				$("wincommit").onclick=queryRelation;
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
</html>