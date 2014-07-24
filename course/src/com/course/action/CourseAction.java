package com.course.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.course.entity.Course;
import com.course.service.ICourseManage;
import com.opensymphony.xwork2.ActionSupport;

public class CourseAction extends ActionSupport {
	private Course cos;
	private Date begin_time, end_time;
	private List<Course> allCourse;

	@Resource
	private ICourseManage courseManage;

	public List<Course> getAllCourse() {
		return allCourse;
	}

	public void setAllCourse(List<Course> allCourse) {
		this.allCourse = allCourse;
	}

	public Date getBegin_time() {
		return begin_time;
	}

	public void setBegin_time(Date begin_time) {
		this.begin_time = begin_time;
	}

	public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}

	public Course getCos() {
		return cos;
	}

	public void setCos(Course cos) {
		this.cos = cos;
	}

	public ICourseManage getCourseManage() {
		return courseManage;
	}

	public void setCourseManage(ICourseManage courseManage) {
		this.courseManage = courseManage;
	}

	public String addCourse() {
		System.out.println("-------CourseAction.addCourse------");
		courseManage.addCourse(cos);
		return "success";
	}

	public String modifyCourse() {
		System.out.println("-------CourseAction.modifyCourse------");
		courseManage.modifyCourse(cos);
		return "success";
	}

	public String deleteCourse() {
		System.out.println("-------CourseAction.deleteCourse------");
		courseManage.deleteCourse(cos);
		return "success";
	}

	public String queryCourse() {
		System.out.println("-------courseAction.queryCourse------");
		allCourse = courseManage.queryCourse(cos, begin_time, end_time);
		return "success";
	}

	public String findAllCourse() {
		System.out.println("-------courseAction.findAllCourse------");
		allCourse = courseManage.findAllCourse();
		return "allcourse";
	}

}
