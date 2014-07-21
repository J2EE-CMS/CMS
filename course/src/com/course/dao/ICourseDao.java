package com.course.dao;

import com.course.entity.Course;

public interface ICourseDao {
	public void AddCourse(Course cos);
	public void modifyCourse(Course cos);
	public void deleteCourse(Course cos);
	public void queryCourse(Course cos);
}
