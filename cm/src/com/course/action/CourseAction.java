package com.course.action;

import javax.annotation.Resource;
import java.util.*;

import com.course.entity.Course;
import com.course.service.ICourseManage;

public class CourseAction {
	
	private Course course;
	List<Course> allCourse;
	List<Course> foundCourse;
	
	@Resource
	private ICourseManage courseManage;

	public ICourseManage getCourseManage(){
		return courseManage;
	}
	
	public void setCourseManage(ICourseManage courseManage){
		this.courseManage = courseManage;
	}
	
	public Course getCourse(){
		return course;
	}
	
	public void setCourse(Course course){
		this.course = course;
	}
	
	public List<Course> getAllCourse(){
		return allCourse;
	}
	
	public List<Course> getFoundCourse(){
		return foundCourse;
	}
	
	public String addCourse(){
		courseManage.addCourse(course);
		return "success";
	}
	
	public String modifyCourse(){
		courseManage.modifyCourse(course);
		return "success";
	}
	
	public String deleteCourse(){
		courseManage.deleteCourse(course);
		return "success";
	}
	
	public String findCourse(){
		foundCourse = courseManage.findCourse(course);
		return "success";
	}
	
	public String findAllCourse(){
		allCourse = courseManage.findAllCourse();
		return "showallcourse";
	}
	
}

