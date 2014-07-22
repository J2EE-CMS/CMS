package com.course.action;

import java.util.*;

import javax.annotation.Resource;

import com.course.entity.Courseapply;
import com.course.service.ICourseapplyManage;
import com.opensymphony.xwork2.ActionSupport;

public class CourseapplyAction extends ActionSupport{
	private Courseapply courseapply;
	List<Courseapply> courseapplys;
	
	@Resource
	private ICourseapplyManage courseapplyManage;
	

	public Courseapply getCourseapply() {
		return courseapply;
	}

	public void setCourseapply(Courseapply courseapply) {
		this.courseapply = courseapply;
	}

	public ICourseapplyManage getCourseapplyManage() {
		return courseapplyManage;
	}

	public void setCourseapplyManage(ICourseapplyManage courseapplyManage) {
		this.courseapplyManage = courseapplyManage;
	}
	
	public List<Courseapply> getCourseapplys() {
		return courseapplys;
	}

	public void setCourseapplys(List<Courseapply> courseapplys) {
		this.courseapplys = courseapplys;
	}
	
	
	public String addCourseapply (){
		courseapplyManage.addCourseapply(courseapply);
		return "success";
	}
	
	public String modifyCourseapply(){
		courseapplyManage.modifyCourseapply(courseapply);
		return "success";
	}
	
	public String deleteCourseapply(){
		courseapplyManage.deleteCourseapply(courseapply);
		return "success";
	}
	
	public String queryAllCourseapply(){
		courseapplys = new ArrayList<Courseapply>();
		courseapplys = courseapplyManage.queryAllCourseapply();
		return "allcourseapply";
	}

	
	public String commitCourseapply(){
		courseapplyManage.commitCourseapply(courseapply);
		return "success";
	}
	
	
	public String queryAllCourseapproval(){
		courseapplys = courseapplyManage.queryAllCourseapproval();
		return "success";
	}
	
	public String approvalCourseapply(){
		courseapplyManage.approvalCourseapply(courseapply);
		return "success";
	}
	
}
