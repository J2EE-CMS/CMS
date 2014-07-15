package com.course.service;

import javax.annotation.Resource;
import java.util.List;

import com.course.dao.ICourseDao;
import com.course.entity.Course;

public class CourseManageImp implements ICourseManage{
	
	@Resource
	private ICourseDao courseDao;
	
	public ICourseDao getCourseDao(){
		return courseDao;
	}
	
	public void setCourseDao(ICourseDao courseDao){
		this.courseDao = courseDao;
	}
	
	@Override
	public void addCourse(Course course){
		courseDao.addCourse(course);
	}
	
	@Override
	public void modifyCourse(Course course){
		courseDao.modifyCourse(course);
	}
	
	@Override
	public void deleteCourse(Course course){
		courseDao.deleteCourse(course);
	}
	
	public List<Course> findCourse(Course course){
		return courseDao.findCourse(course);
	}
	
	public List<Course> findAllCourse(){
		return courseDao.findAllCourse();
	}
}
