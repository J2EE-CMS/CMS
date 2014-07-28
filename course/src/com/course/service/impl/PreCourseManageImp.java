package com.course.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.course.dao.IPreCourseDao;
import com.course.entity.Course;
import com.course.entity.PreCourse;
import com.course.service.IPreCourseManage;

public class PreCourseManageImp implements IPreCourseManage {

	@Resource
	private IPreCourseDao preCourseDao;

	@Override
	public void addPreCourse(PreCourse pcos) {
		preCourseDao.addPreCourse(pcos);
	}

	// @Override
	// public void modifyPreCourse(PreCourse pcos) {
	// preCourseDao.modifyPreCourse(pcos);
	// }

	@Override
	public void deletePreCourse(Course cos) {
		preCourseDao.deletePreCourse(cos);
	}

	@Override
	public List<PreCourse> queryPreCourse(Course cos) {
		return preCourseDao.queryPreCourse(cos);
	}

	@Override
	public List<PreCourse> queryAllPreCourseRelations() {
		return preCourseDao.queryAllPreCourseRelations();
	}

}
