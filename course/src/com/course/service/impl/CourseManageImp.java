package com.course.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.course.dao.ICourseDao;
import com.course.entity.Course;
import com.course.service.ICourseManage;

public class CourseManageImp implements ICourseManage {

	@Resource
	private ICourseDao courseDao;

	public ICourseDao getCourseDao() {
		return courseDao;
	}

	public void setCourseDao(ICourseDao courseDao) {
		this.courseDao = courseDao;
	}

	@Override
	public boolean addCourse(Course cos) {
		System.out.println("------CourseManageImp.addCourse------");
		if(courseDao.addCourse(cos)){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public boolean modifyCourse(Course cos) {
		System.out.println("------CourseManageImp.modifyCourse------");
		if(courseDao.modifyCourse(cos)){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public void deleteCourse(Course cos) {
		System.out.println("------CourseManageImp.deleteCourse------");
		courseDao.deleteCourse(cos);
	}

	@Override
	public List<Course> queryCourse(Course cos, Date begin_time, Date end_time) {
		System.out.println("------CourseManageImp.queryCourse------");
		return courseDao.queryCourse(cos, begin_time, end_time);
	}

	@Override
	public List<Course> findAllCourse() {
		System.out.println("------CourseManageImp.findAllCourse------");
		return courseDao.findAllCourse();
	}

}
