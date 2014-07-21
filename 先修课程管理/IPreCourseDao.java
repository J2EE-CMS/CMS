package com.coursemanage.dao;

import java.util.List;

import com.coursemanage.entity.Course;
import com.coursemanage.entity.PreCourse;

public interface IPreCourseDao {
	public void addPreCourse(PreCourse pcos);
//	public void modifyPreCourse(PreCourse pcos);
	public void deletePreCourse(Course cos);
	public List<PreCourse> queryPreCourse(Course cos);

}
