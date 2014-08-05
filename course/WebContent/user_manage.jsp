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
	      	#win{filter:alpha(opacity=80);opacity:0.80;position:absolute;top:30%;z-index:1002;border:4px #000 solid;background:#FFF;display:none;}
	      	#fade{-moz-opacity:0.50;filter:alpha(opacity=50);opacity:0.50;width:100%;height:100%;position:fixed;left:0%;top:0%;background-color:#f5f5f5;z-index:1001;display:none;}
	      	#bg thead{background-color:green;}
	      	#cin thead{background-color:yellow;}
	    </style>
	</head>
	<body>
		<div id="bg">
			<ul style="background-color:black" class="nav nav-tabs">
				<li><a href="#"><strong>用户管理</strong></a></li>
				<li><a href="javascript:void(0);" onclick="Winopen('ADD')">新增</a></li>
				<li><a href="javascript:void(0);" onclick="Winopen('MODIFY')">修改</a></li>
		<!-- 	<li><a href="javascript:void(0);" onclick="Winopen('QUERY')">查询</a></li>   -->
				<li><a href="javascript:void(0);" onclick="Winopen('DELETE')">删除</a></li>
				<li class="pull-right"><a href="home">返回</a></li> 
			</ul>
			<table id="show" class="table table-hover table-bordered">
				<thead>
					<tr>
						<th class="text-center">ID</th>
						<th class="text-center">用户名</th>
						<th class="text-center">密码</th>
						<th class="text-center">角色</th>
					</tr>
				</thead>
				<tbody class="text-center">
					<s:iterator value="userList" var="user">
		                <tr>
		                    <td><s:property value="#user.id"/></td>
		                    <td><s:property value="#user.name"/></td>
		                    <td><s:property value="#user.password"/></td>
		                    <td><s:property value="#user.role"/></td>
		                </tr>
		        	</s:iterator>
				</tbody>
			</table>
		</div>
		
		<div id="win" >
			<form id="userform" >
				<table id="cin" class="table table-bordered">
					<thead>
						<tr>
							<th class="text-center">ID</th>
							<th class="text-center">用户名</th>
							<th class="text-center">密码</th>
							<th class="text-center">角色</th>
							
						</tr>
					</thead>
					<tbody class="text-center">
						<tr>
							<td><input type="text" id="pk" name="user.id" /></td>
							<td><input type="text" id="stc" name="user.name"/></td>
							<td><input type="text" name="user.password" /></td>
							<td><input type="text" name="user.role" /></td>
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
					$(this).find("input").val(null);
				});
				$("#pk").focus();
				document.getElementById("wincommit").onclick=addUser;
			}
			if(str=='MODIFY'){
				var cid = $("#pk").val();
				if(cid != ""){
					$("#pk").attr("readonly","true");
					$("#stc").focus();
				}	
				else{
					$("#pk").focus();
				}
				document.getElementById("wincommit").onclick=modifyUser;
			}
			if(str=='QUERY'){
				document.getElementById("wincommit").onclick=queryUser;
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
				document.getElementById("wincommit").onclick=deleteUser;
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
	
		function addUser()
		{
			var myform=document.forms[0];
			myform.action="user_addUser";
			myform.method="post";
			myform.submit();
		}
		
		function modifyUser()
		{
			var myform=document.forms[0];
			myform.action="user_modifyUser";
			myform.method="post";
			myform.submit();
		}
		
		function deleteUser()
		{
			var myform=document.forms[0];
			myform.action="user_deleteUser";
			myform.method="post";
			myform.submit();
		}

		function queryUser()
		{
			var myform=document.forms[0];
			myform.action="user_queryUsers";
			myform.method="post";
			myform.submit();
		}
	</script>
</html>