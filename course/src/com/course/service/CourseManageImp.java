package com.course.service;

import javax.annotation.Resource;
import java.util.*;
import com.course.dao.ICourseDao;
import com.course.entity.Course;

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
	public void addCourse(Course cos) {
		System.out.println("------CourseManageImp.addCourse------");
		courseDao.addCourse(cos);
	}

	@Override
	public void modifyCourse(Course cos) {
		System.out.println("------CourseManageImp.modifyCourse------");
		courseDao.modifyCourse(cos);
	}


	@Override
	public void deleteCourse(Course cos) {
		System.out.println("------CourseManageImp.deleteCourse------");
		courseDao.deleteCourse(cos);
	}

	@Override
	public void queryCourse(Course cos) {
		System.out.println("------CourseManageImp.queryCourse------");
		courseDao.queryCourse(cos);
	}
	public List<Course> findAllCourse(){
		return courseDao.findAllCourse();
	}
}
