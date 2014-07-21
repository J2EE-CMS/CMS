package com.course.service;

import com.course.entity.Course;

public interface ICourseManage {
	public void addCourse(Course cos);
	public void modifyCourse(Course cos);
	public void deleteCourse(Course cos);
	public void queryCourse(Course cos);
}
