package com.coursemanage.action;

import java.util.List;

import com.coursemanage.entity.Courseapply;
import com.coursemanage.service.ICourseapplyManage;

public class CourseapplyAction {
	private Courseapply courseapply;
	
	private ICourseapplyManage courseapplyManage;
	
	List<Courseapply> courseapplys;

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
		courseapplys = courseapplyManage.queryAllCourseapply();
		return "success";
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
