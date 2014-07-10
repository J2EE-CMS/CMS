<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
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
		myform.action="coursetype/modifyCoursetype_success";
		myform.method="post";
		myform.submit();
	}
	
	function deleteCoursetype()
	{
		var myform=document.forms[0];
		myform.action="coursetype/deleteCoursetype_success";
		myform.method="post";
		myform.submit();
	}
	
	

</script>
</head>
<body>
<form id="myform1" >
	性质：<input type="text" name="coursetype.quality" >
	是否需要重考：<input type="radio" name="coursetype.reexamine" />是<input type="radio" name="coursetype.reexamine" />否
	
	是否需要重修:<input type="text" name="coursetype.retake" />
	课程类别：<input type="text" name="coursetype.type" />	
	课程类别码：<input type="text" name="coursetype.typecore" />
	<input type="button" name="btnadd" onclick="addCoursetype()" value="增加" />
 </form>
</body>
</html>