package com.course.service;

import java.util.Date;
import java.util.List;

import com.course.entity.Course;

public interface ICourseManage {
	public boolean addCourse(Course cos);

	public boolean modifyCourse(Course cos);

	public void deleteCourse(Course cos);

	// public void queryCourse(Course cos);
	public List<Course> findAllCourse();

	public List<Course> queryCourse(Course cos, Date begin_time, Date end_time);
}
