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
		</style>
	</head>
	<body>
		<div id="bg">
			<ul style="background-color:black" class="nav nav-tabs">
				<li><a href="#"><strong>新增先修关系审批</strong></a></li>
				<li><a href="javascript:void(0);" onclick="Winopen('MODIFY')">审批</a></li>
				<li><a href="javascript:void(0);" onclick="Winopen('QUERY')">查询</a></li>
				<li><a href="#">导出</a></li>	
				<li class="pull-right"><a href="home">返回</a></li> 
			</ul>
			<table id="show" class="table table-hover table-bordered">
				<thead>
					<tr>
						<th class="text-center">审批状态</th>
						<th class="text-center">总课程号</th>
						<th class="text-center">院系课程号</th>
						<th class="text-center">课程中文名</th>
						<th class="text-center">课程英文名</th>
						<th class="text-center">原开设单位</th>
						<th class="text-center">先修课程</th>
					</tr>
				</thead>
				<tbody class="text-center">
					<tr>
						<td>已通过</td>
						<td>总课程号1</td>
						<td>院系课程号1</td>
						<td>课程中文名1</td>
						<td>课程英文名1</td>
						<td>原开设单位1</td>
						<td>先修课程1</td>
					</tr>
					<tr>
						<td>未通过</td>
						<td>总课程号2</td>
						<td>院系课程号2</td>
						<td>课程中文名2</td>
						<td>课程英文名2</td>
						<td>原开设单位2</td>
						<td>先修课程2</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div id="win" class="table-responsive">
			<table id="cin" class="table table-bordered">
				<thead>
					<tr>
						<th class="text-center">总课程号</th>
						<th class="text-center">院系课程号</th>
						<th class="text-center">课程中文名</th>
						<th class="text-center">课程英文名</th>
						<th class="text-center">原开设单位</th>
						<th class="text-center">先修课程</th>
					</tr>
				</thead>
				<tbody class="text-center">
					<tr>
						<td><input id="pk" type="text" name="c_number" style="width:100px"/></td>
						<td><input id="ic" type="text" name="s_number" style="width:100px"/></td>
						<td><input type="text" name="ch_name" style="width:120px"/></td>
						<td><input type="text" name="en_name" style="width:100px"/></td>
						<td><input type="text" name="place" style="width:100px"/></td>
						<td><input type="text" name="prerequisite" /></td>
					</tr>
				</tbody>
			</table>
			<p align="center">
				<input type="submit" id="wincommit" name="wincommit" value="确认" />
				<input type="submit" name="wincancle" value="取消"/>
			</p>
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
				$("#pk").focus();
				//document.getElementById("wincommit").onclick=add;
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
				//document.getElementById("wincommit").onclick=modify;
			}
			if(str=='QUERY'){
				//document.getElementById("wincommit").onclick=query;
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
				//document.getElementById("wincommit").onclick=delete;
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
		
	</script>
</html>