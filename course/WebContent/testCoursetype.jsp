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

	
	function addCoursetype()
	{
		var myform=document.forms[0];
		myform.action="addCoursetype_success";
		myform.method="post";
		myform.submit();
	}
	
	function modifyCoursetype()
	{
		var myform=document.forms[0];
		myform.action="modifyCoursetype_success";
		myform.method="post";
		myform.submit();
	}
	
	function deleteCoursetype()
	{
		var myform=document.forms[0];
		myform.action="deleteCoursetype_success";
		myform.method="post";
		myform.submit();
	}
	


</script>
</head>
<body>
<form id="myform1" >
	id(测试用)：<input type="text" name="coursetype.id" >
	性质：<input type="text" name="coursetype.quality" >
	是否需要重考：<input type="text" name="coursetype.reexamine" />
	是否需要重修:<input type="text" name="coursetype.retake" />
	课程类别：<input type="text" name="coursetype.type" />	
	课程类别码：<input type="text" name="coursetype.typecore" />
	
	<br/>
	
	<input type="button" name="btnadd" onclick="addCoursetype()" value="增加" />
	<input type="button" name="btnadd" onclick="modifyCoursetype()" value="修改" />
	<input type="button" name="btnadd" onclick="deleteCoursetype()" value="删除" />
	
	
	
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
				<th class="text-center">typecore</th>
				<th class="text-center">type</th>
				<th class="text-center">quality</th>
				<th class="text-center">reexamine</th>
				<th class="text-center">retake</th>
				</tr>
				</thead>
				<tbody class="text-center">
					<s:iterator value="courses" var="coursetype">
					<tr>
						<td><s:property value="#coursetype.id"/></td>
						<td><s:property value="#coursetype.typecore"/></td>
						<td><s:property value="#coursetype.type"/></td>
						<td><s:property value="#coursetype.quality"/></td>
						<td><s:property value="#coursetype.reexamine"/></td>
						<td><s:property value="#coursetype.retake"/></td>
					</tr>
					</s:iterator>
				</tbody>
			</table>	
		</div>
	</body>
</html>