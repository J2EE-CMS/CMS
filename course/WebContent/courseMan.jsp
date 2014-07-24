<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<script type="text/javascript">
			//var myfrom=document.getElementById("myform1");
		
			function addCourse()
			{
				var myform=document.forms[0];
				myform.action="course/course_addCourse";
				myform.method="post";
				myform.submit();
			}
			
			function modifyCourse()
			{
				var myform=document.forms[0];
				myform.action="course/course_modifyCourse";
				myform.method="post";
				myform.submit();
			}
			
			function deleteCourse()
			{
				var myform=document.forms[0];
				myform.action="course/course_deleteCourse";
				myform.method="post";
				myform.submit();
			}
	
			function findCourse()
			{
				var myform=document.forms[0];
				myform.action="course/course_queryCourse";
				myform.method="post";
				myform.submit();
			}
		</script>
	</head>
	
	<body>
		<form id="courseform" >
			<table>
				<tr>
					<th>课程名称</th>
					<th>开设单位</th>
					<th>总学时</th>
					<th>是否学位课</th>
				</tr>
				<tr>
					<td><input type="text" name="course.name"></td>
					<td><input type="text" name="course.place"></td>
					<td><input type="text" name="course.time"></td>
					<td><input type="text" name="course.isDegree"/></td>
				</tr>
			</table>
			<input type="submit" name="courseadd" value="添加" onclick="addCourse()" >
			<input type="submit" name="coursemodify" value="修改" onclick="modifyCourse()" >
			<input type="submit" name="coursedelete" value="删除" onclick="deleteCourse()" >
			<input type="submit" name="coursefind" value="查询" onclick="findCourse()" >
		</form>
		<table border="1" width="100%" bgcolor="#CCCCFF">
            <tr>
                <th>课程名称</th>
				<th>开设单位</th>
				<th>总学时</th>
				<th>是否学位课</th>
            </tr>
            
            <s:iterator value="foundCourse">
            	<tr> 
			        <td><s:property value="name"/></td> 
			        <td><s:property value="place"/></td>
			        <td><s:property value="time"/></td> 
			        <td><s:property value="isDegree"/></td>
		    	</tr>
            </s:iterator>
			
	    </table>	
	    
		<form action="course/showallcourse" method="post" >
			<input type="submit" value="show">
		</form>
		
		<table border="1" width="100%" bgcolor="#CCCCFF">
            <tr>
                <th>课程名称</th>
				<th>开设单位</th>
				<th>总学时</th>
				<th>是否学位课</th>
            </tr>
            <!-- 
            <s:iterator value="allCourse">
            	<tr> 
			        <td><s:property value="name"/></td> 
			        <td><s:property value="place"/></td>
			        <td><s:property value="time"/></td> 
			        <td><s:property value="isDegree"/></td>
		    	</tr>
            </s:iterator>
			-->
	        
            <s:iterator value="allCourse" var="course">
                <tr>
                    <td><s:property value="#course.name"/></td>
                    <td><s:property value="#course.place"/></td>
                    <td><s:property value="#course.time"/></td>
                    <td><s:property value="#course.isDegree"/></td>
                </tr>
            </s:iterator>
            
        </table>	
	</body>
</html>
