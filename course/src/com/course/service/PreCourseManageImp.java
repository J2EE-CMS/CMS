package com.course.service;

import java.util.List;

import javax.annotation.Resource;

import com.course.dao.IPreCourseDao;
import com.course.entity.Course;
import com.course.entity.PreCourse;

public class PreCourseManageImp implements IPreCourseManage{

	@Resource 
	private IPreCourseDao preCourseDao;
	
	@Override
	public void addPreCourse(PreCourse pcos) {
		preCourseDao.addPreCourse(pcos);
	}

	//@Override
	//public void modifyPreCourse(PreCourse pcos) {
	//	preCourseDao.modifyPreCourse(pcos);
	//}

	@Override
	public void deletePreCourse(Course cos) {
		preCourseDao.deletePreCourse(cos);
	}

	@Override
	public List<PreCourse> queryPreCourse(Course cos) {
		return preCourseDao.queryPreCourse(cos);
	}
	

}
