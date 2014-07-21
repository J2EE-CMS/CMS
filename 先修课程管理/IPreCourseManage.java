package com.coursemanage.service;

import java.util.List;

import com.coursemanage.entity.Course;
import com.coursemanage.entity.PreCourse;

public interface IPreCourseManage {
	public void addPreCourse(PreCourse pcos);
	//public void modifyPreCourse(PreCourse pcos);
	public void deletePreCourse(Course cos);
	public List<PreCourse> queryPreCourse(Course cos);
}
