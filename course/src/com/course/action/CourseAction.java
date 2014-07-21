package com.course.action;

import javax.annotation.Resource;
import java.util.*;

import com.course.entity.Course;
import com.course.service.ICourseManage;
import com.opensymphony.xwork2.ActionSupport;

public class CourseAction extends ActionSupport {
	private Course cos;
	List<Course> allCourse;
	
	@Resource  
	private ICourseManage courseManage;
	
	public Course getCos() {
		return cos;
	}
	public void setCos(Course cos) {
		this.cos = cos;
	}
	public List<Course> getAllCourse(){
		return allCourse;
	}
	
	public ICourseManage getCourseManage() {
		return courseManage;
	}

	public void setCourseManage(ICourseManage courseManage) {
		this.courseManage = courseManage;
	}
	
	public String addCourse()
	{
		System.out.println("-------CourseAction.addCourse------");
		courseManage.addCourse(cos);
		return "success";
	}
	
	public String modifyCourse()
	{
		System.out.println("-------CourseAction.modifyCourse------");
		courseManage.modifyCourse(cos);
		return "success";
	}
	
	public String deleteCourse()
	{
		System.out.println("-------CourseAction.deleteCourse------");
		courseManage.deleteCourse(cos);
		return "success";
	}
	
	public String queryCourse()
	{
		System.out.println("-------courseAction.queryCourse------");
		courseManage.queryCourse(cos);
		return "success";
	}
	
	public String findAllCourse(){
		allCourse = courseManage.findAllCourse();
		return "allcourse";
	}
}
