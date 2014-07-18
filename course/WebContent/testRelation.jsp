<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@  taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>

<script type="text/javascript">
	//var myfrom=document.getElementById("myform1");

	
	function addRelation()
	{
		var myform=document.forms[0];
		myform.action="addRelation_success";
		myform.method="post";
		myform.submit();
	}
	
	function modifyRelation()
	{
		var myform=document.forms[0];
		myform.action="modifyRelation_success";
		myform.method="post";
		myform.submit();
	}
	
	function findByGrade()
	{
		var myform=document.forms[0];
		myform.action="findByGrade_success";
		myform.method="post";
		myform.submit();
	}

</script>
</head>
<body>
<form id="myform1" >
	id(测试用)：<input type="text" name="relation.id" >
	grade：<input type="text" name="relation.grade" >
	devtype：<input type="text" name="relation.devtype" />
	type:<input type="text" name="relation.type" />
	
	<br/>
	
	<input type="button" name="btnadd" onclick="addRelation()" value="增加" />
	<input type="button" name="btnadd" onclick="modifyRelation()" value="修改" />
	<input type="button" name="btnadd" onclick="findByGrade()" value="根据年级查询" />
	
	
	
	
	<br/>
	</form>
	<!-- 
	<form action="getAllCoursetypes_success" method="post" >
		<input type="submit" value="查询所有结果">
	</form> 
	-->
	<div class="table-responsive">
		<table class="table table-hover table-bordered">
			<thead>
				<tr>
				<th class="text-center">id</th>
				<th class="text-center">grade</th>
				<th class="text-center">devtype</th>
				<th class="text-center">type</th>
				</tr>
				</thead>
				<tbody class="text-center">
					<s:iterator value="relations" var="relation">
					<tr>
						<td><s:property value="#relation.id"/></td>
						<td><s:property value="#relation.grade"/></td>
						<td><s:property value="#relation.devtype"/></td>
						<td><s:property value="#relation.type"/></td>
					</tr>
					</s:iterator>
				</tbody>
			</table>	
		</div>
	</body>
</html>