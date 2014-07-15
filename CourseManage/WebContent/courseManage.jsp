<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<script type="text/javascript">
	//var myfrom=document.getElementById("myform1");

	
	function addCourse()
	{
		var myform=document.forms[0];
		myform.action="course/addCourse_success";
		myform.method="post";
		myform.submit();
	}
	
	function modifyCourse()
	{
		var myform=document.forms[0];
		myform.action="course/modifyCourse_success";
		myform.method="post";
		myform.submit();
	}
	
	function deleteCourse()
	{
		var myform=document.forms[0];
		myform.action="course/deleteCourse_success";
		myform.method="post";
		myform.submit();
	}
	
	function queryCourse()
	{
		var myform=document.forms[0];
		myform.action="course/queryCourse_success";
		myform.method="post";
		myform.submit();
	}
</script>
</head>
<body>
<form id="myform1" >
             课程id:<input type="text" name="cos.id" />
	院系课程号:<input type="text" name="cos.institute_course" />
              课程中文名:<input type="text" name="cos.c_course_name" />
	课程英文名:<input type="text" name="cos.e_course_name" /><br />
	课程简称:<input type="text" name="cos.brief_course_name" />
	开设单位:<input type="text" name="cos.faculty" />
	学分:<input type="text" name="cos.credit"/><br />
	课程类型:<input type="text" name="cos.course_type" />
	课程细类:<input type="text" name="cos.sub_course_type" />
	课程细类模块:<input type="text" name="cos.sub_course_type_module" /><br />
	学时:<input type="text" name="cos.course_time" />
	学时备注:<input type="text" name="cos.course_time_info" />
	课程负责人:<input type="text" name="cos.course_head" /><br />
	<% String time = new java.sql.Timestamp(System.currentTimeMillis()).toString();%>
	审批时间:<input type="text" name="cos.approval_time" value="<%=time%>"/>
	审批状态:<input type="text" name="cos.status" />
	是否学士学位:（医科选填）:<input type="text" name="cos.degree" /><br />
	课程备注:<input type="text" name="cos.course_info" />
	备注:<input type="text" name="cos.info"/>
	<input type="button" name="btnadd" onclick="addCourse()" value="增加" />
	<input type="button" name="btnmodify" onclick="modifyCourse()" value="修改" />
	<input type="button" name="btndel" onclick="deleteCourse()" value="删除"  />
	<input type="button" name="btnquery" onclick="queryCourse()" value="查询"  />
	
	<pre>
	 ------ 查询------
	  查询条件字段：总课程号、院系课程号、课程中文名称、课程英文名称、课程简称、原开设单位、学分、审批状态、课程类型、
	  操作时间>=、操作时间<=，任意一项或多项中填入或选择需要查询的内容。
	 ------修改------
	 选中课程，可修改字段包括：课程中文名称、课程英文名称、课程简称、原开设单位、学分、总学时、总学时备注、课程类型、备注。
	 ------删除------
	 查询出需要删除的课程如课程已被开课计划、教学计划、实施计划、选课使用，则不可删除
	 ------新增------
	 管理员填写字段：课程中文名称、课程英文名称、课程简称、开设单位、学分、总学时、总学时备注、课程类型、周学时、课程门类、
	 课程简介、先修课程（另一录入界面）、课程负责人、是否学位课(医科选填)、备注。
              系统自动判断是否已有相同课程中文名称和课程英文名称，如果有同名记录，提示有同名，管理员调整输入 
	</pre>
 </form>
</body>
</html>