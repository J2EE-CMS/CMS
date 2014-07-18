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
	
	
	
	
	<br/>
	</form>
 
	<form action="findByGrade_success" method="post" >
		<input type="submit" value="根据年级查询">
	</form> 
	
		<table class="table table-hover table-bordered">
<thead>
<tr>
<th class="text-center">课程名称</th>
<th class="text-center">开设单位</th>
<th class="text-center">总学时</th>
<th class="text-center">是否学位课</th>
<th class="text-center">课程英文名称</th>
<th class="text-center">课程简称</th>
<th class="text-center">学分</th>
</tr>
</thead>
            <tbody class="text-center">
<s:iterator value="foundCourse" var="course">
<tr>
<td><s:property value="#course.name"/></td>
<td><s:property value="#course.place"/></td>
<td><s:property value="#course.time"/></td>
<td><s:property value="#course.isDegree"/></td>
<td><s:property value="#course.enName"/></td>
<td><s:property value="#course.sName"/></td>
<td><s:property value="#course.score"/></td>
</tr>
</s:iterator>
</tbody>
<thead>

 
</table>	
	
	</body>
</html>